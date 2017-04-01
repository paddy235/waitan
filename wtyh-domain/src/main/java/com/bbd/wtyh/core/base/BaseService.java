package com.bbd.wtyh.core.base;

import com.bbd.wtyh.core.entity.Pagination;

import java.util.List;

/**
 * 基础业务接口
 *
 * @author Created by LiYao on 2017-03-03 22:37.
 */
public interface BaseService {

	/**
	 * 根据条件查询一条，不支持实体类包含子类的
	 *
	 * @param clazz
	 * @param where
	 * @return
	 */
	<T> T selectOne(Class<T> clazz, String where);

	/**
	 * 根据条件查询全部，不支持实体类包含子类的
	 *
	 * @param clazz
	 * @param where
	 * @return
	 */
	<T> List<T> selectAll(Class<T> clazz, String where);

	/**
	 * 根据ID查询，不支持实体类包含子类的
	 *
	 * @param clazz
	 * @param id
	 * @return
	 */
	<T> T selectById(Class<T> clazz, Object id);

	/**
	 * 根据条件查询全部（分页），实体类包含子类的不支持
	 *
	 * @param clazz
	 *            实体类对象
	 * @param pagination
	 *            分页组件
	 * @param where
	 *            查询条件
	 * @return
	 */
	<T> List<T> selectByPage(Class<T> clazz, Pagination<T> pagination, String where);

	/**
	 * 插入一条数据
	 *
	 * @param obj
	 * @param <T>
	 * @return
	 */
	<T> int insert(T obj);

	/**
	 * 插入多条数据,目前只支持Mysql数据库
	 *
	 * @param list
	 * @param <T>
	 * @return
	 */
	<T> int insertList(List<T> list);

	/**
	 * 删除一个实体类
	 *
	 * @param obj
	 */
	<T> int delete(T obj);

	/**
	 * 更新一个实体（null或""字段除外） 根据ID更新。
	 *
	 * @param obj
	 * @return
	 */
	<T> int update(T obj);

	/**
	 * 执行一个insert/update/delete SQL语句。不支持SELECT<br>
	 * 
	 * @param sql
	 *            支持?占位符
	 * @param param
	 * @return
	 */
	int executeCUD(String sql, Object... param);
}
