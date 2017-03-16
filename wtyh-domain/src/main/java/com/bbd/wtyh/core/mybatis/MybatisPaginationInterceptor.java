package com.bbd.wtyh.core.mybatis;

import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.core.utils.ReflectUtil;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * Mybatis分页拦截组件
 *
 * @author Created by LiYao on 2017-03-04 21:16.
 */
@Intercepts({ @Signature(method = "prepare", type = StatementHandler.class, args = { Connection.class }) })
public class MybatisPaginationInterceptor implements Interceptor {

	private static Logger logger = LoggerFactory.getLogger(MybatisPaginationInterceptor.class);
	private String databaseType;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
		StatementHandler delegate = (StatementHandler) ReflectUtil.getFieldValue(handler, "delegate");
		if (null == delegate) {
			return invocation.proceed();
		}
		BoundSql boundSql = delegate.getBoundSql();
		// 拿到传入的参数分页实体类
		Object obj = boundSql.getParameterObject();
		Object pagParme = obj;
		boolean isPaging = false;

		if (obj instanceof Map<?, ?>) {
			Map<?, ?> paramMap = (Map<?, ?>) obj;
			for (Map.Entry<?, ?> entry : paramMap.entrySet()) {
				Object val = entry.getValue();
				if (val instanceof Pagination<?>) {
					pagParme = val;
					isPaging = true;
					break;
				}
			}
		}

		if (obj instanceof Pagination<?> || isPaging) {
			Pagination<?> pagination = (Pagination<?>) pagParme;
			// 拦截到的prepare方法参数是一个Connection对象
			Connection connection = (Connection) invocation.getArgs()[0];
			// 获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
			String sql = boundSql.getSql();
			this.setTotalRecord(sql, connection, pagination);
			// 获取分页Sql语句
			String pageSql = this.getPageSql(pagination, sql);
			// 利用反射设置当前BoundSql对应的sql属性为我们建立好的分页Sql语句
			ReflectUtil.setFieldValue(boundSql, "sql", pageSql);

		}

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		System.out.println(properties.getProperty("databaseType"));
	}

	@SuppressWarnings("unused")
	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	/**
	 * 给当前的参数对象page设置总记录数
	 * 
	 * @param originalSql
	 * @param connection
	 * @param page
	 */
	private void setTotalRecord(String originalSql, Connection connection, Pagination<?> page) {

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			String countSql = "SELECT COUNT(*) AS TOTAL FROM (" + originalSql + ") AS A";
			preparedStatement = connection.prepareStatement(countSql);
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				int totalRecord = rs.getInt("TOTAL");
				page.setTotalCount(totalRecord);
			}
		} catch (SQLException e) {
			logger.error("", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				logger.error("", e);
			}
		}
	}

	/**
	 * 根据page对象获取对应的分页查询Sql语句，这里只做了两种数据库类型，Mysql和Oracle 其它的数据库都 没有进行分页
	 *
	 * @param page
	 *            分页对象
	 * @param sql
	 *            原sql语句
	 * @return
	 */
	private String getPageSql(Pagination<?> page, String sql) {
		StringBuffer sqlBuffer = new StringBuffer(sql);
		if ("mysql".equalsIgnoreCase(databaseType)) {
			return getMysqlPageSql(page, sqlBuffer);
		} else if ("oracle".equalsIgnoreCase(databaseType)) {
			return getOraclePageSql(page, sqlBuffer);
		}
		return sqlBuffer.toString();
	}

	/**
	 * 获取Mysql数据库的分页查询语句
	 *
	 * @param page
	 *            分页对象
	 * @param sqlBuffer
	 *            包含原sql语句的StringBuffer对象
	 * @return Mysql数据库分页语句
	 */
	private String getMysqlPageSql(Pagination<?> page, StringBuffer sqlBuffer) {
		int offset = (page.getPageIndex() - 1) * page.getPageSize();
		sqlBuffer.append(" LIMIT ").append(offset).append(",").append(page.getPageSize());
		return sqlBuffer.toString();
	}

	/**
	 * 获取Oracle数据库的分页查询语句
	 *
	 * @param page
	 *            分页对象
	 * @param sqlBuffer
	 *            包含原sql语句的StringBuffer对象
	 * @return Oracle数据库的分页查询语句
	 */
	private String getOraclePageSql(Pagination<?> page, StringBuffer sqlBuffer) {
		int offset = (page.getPageIndex() - 1) * page.getPageSize() + 1;
		sqlBuffer.insert(0, "SELECT U.*, ROWNUM r FROM (").append(") U WHERE ROWNUM < ").append(offset + page.getPageSize());
		sqlBuffer.insert(0, "SELECT * FROM (").append(") WHERE r >= ").append(offset);
		return sqlBuffer.toString();
	}
}
