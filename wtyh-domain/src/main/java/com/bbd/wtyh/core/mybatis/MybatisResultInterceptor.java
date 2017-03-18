package com.bbd.wtyh.core.mybatis;

import com.bbd.wtyh.core.utils.ReflectUtil;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Mybatis 查询结果集处理拦截器
 * 
 * @author Created by LiYao on 2017-03-03 22:38.
 */
@Intercepts({ @Signature(method = "handleResultSets", type = ResultSetHandler.class, args = { Statement.class }) })
public class MybatisResultInterceptor implements Interceptor {

	private static Logger logger = LoggerFactory.getLogger(MybatisResultInterceptor.class);
	// 需要拦截处理的方法
	private String[] interceptMethods = { "baseSelectAll", "baseSelectByPage", "baseSelectById" };

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		ResultSetHandler resultSetHandler = (ResultSetHandler) invocation.getTarget();
		MappedStatement mappedStatement = (MappedStatement) ReflectUtil.getFieldValue(resultSetHandler, "mappedStatement");
		// 方法全限定名
		if (null == mappedStatement) {
			return invocation.proceed();
		}
		String mappedId = mappedStatement.getId();

		if (null == mappedId) {
			return invocation.proceed();
		}
		// 方法简写名称
		mappedId = mappedId.substring(mappedId.lastIndexOf(".") + 1, mappedId.length());
		// 不处理未配置的方法
		if (!Arrays.asList(interceptMethods).contains(mappedId)) {
			return invocation.proceed();
		}

		DefaultParameterHandler defaultParameterHandler = (DefaultParameterHandler) ReflectUtil.getFieldValue(resultSetHandler,
				"parameterHandler");
		if (null == defaultParameterHandler) {
			return invocation.proceed();
		}
		Map<?, ?> map = (Map<?, ?>) defaultParameterHandler.getParameterObject();
		Class<?> pojo = (Class<?>) map.get("clazz");
		Field[] fields = pojo.getDeclaredFields();
		Statement statement = (Statement) invocation.getArgs()[0]; // 取得方法的参数Statement
		ResultSet rs = statement.getResultSet(); // 取得结果集
		List<Object> list = new ArrayList<>();
		while (rs.next()) {
			Object obj = pojo.newInstance();
			for (Field f : fields) {
				if (null != f.getAnnotation(Id.class) || null != f.getAnnotation(Column.class)) {
					Type clazz = f.getGenericType();
					Object o;
					String fieldName = f.getName();
					if (null != f.getAnnotation(Column.class)) {
						Column col = f.getAnnotation(Column.class);
						String cn = col.name();
						if (cn.trim().length() > 0) {
							fieldName = cn;
						}
					}
					if (clazz.equals(int.class)) {
						o = rs.getInt(fieldName);
					} else if (clazz.equals(Date.class)) {
						o = rs.getTimestamp(fieldName);
					} else {
						o = rs.getObject(fieldName);
					}
					ReflectUtil.setFieldValue(obj, f.getName(), o);
				}
			}
			list.add(obj);
		}
		return list;
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
	public void setInterceptMethods(String... interceptMethods) {
		this.interceptMethods = interceptMethods;
	}
}
