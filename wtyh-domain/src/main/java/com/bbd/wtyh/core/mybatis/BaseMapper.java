package com.bbd.wtyh.core.mybatis;

import com.bbd.wtyh.core.entity.Pagination;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 通用 增、删、改、查 Mapper接口
 *
 * @author Created by LiYao on 2017-03-03 22:40.
 */
public interface BaseMapper {

	/**
	 * 根据条件查询全部，不支持实体类包含子类的
	 *
	 * @param clazz
	 * @param where
	 * @return
	 */
	@SelectProvider(type = CRUDTemplate.class, method = "select")
	<T> List<T> baseSelectAll(@Param("clazz") Class<T> clazz, @Param("where") String where);

	/**
	 * 根据ID查询实体类
	 *
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SelectProvider(type = CRUDTemplate.class, method = "selectById")
	<T> List<T> baseSelectById(@Param("clazz") Class<T> clazz, @Param("id") Object id);

	/**
	 * 根据条件查询全部（分页），实体类包含子类的不支持
	 *
	 * @param pagination
	 *            分页组件
	 * @param clazz
	 *            实体类对象
	 * @param where
	 *            查询条件
	 * @return
	 */
	@SelectProvider(type = CRUDTemplate.class, method = "select")
	<T> List<T> baseSelectByPage(@Param("clazz") Class<T> clazz, @Param("pagination") Pagination<T> pagination, @Param("where") String where);

	/**
	 * 插入一条数据
	 * 
	 * @param obj
	 * @return
	 */
	@InsertProvider(type = CRUDTemplate.class, method = "insert")
	@Options(useGeneratedKeys = true)
	<T> int insert(T obj);

	/**
	 * 插入多条数据
	 *
	 * @param list
	 * @return
	 */
	@InsertProvider(type = CRUDTemplate.class, method = "insertList")
	<T> int insertList(@Param("list") List<T> list);

	/**
	 * 删除一个实体类
	 *
	 * @param obj
	 */
	@DeleteProvider(type = CRUDTemplate.class, method = "delete")
	<T> int delete(T obj);

	/**
	 * 更新一个实体（null或""字段除外） 根据ID更新。
	 *
	 * @param obj
	 * @return
	 */
	@UpdateProvider(type = CRUDTemplate.class, method = "update")
	<T> int update(T obj);
}
