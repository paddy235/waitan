package com.bbd.wtyh.core.base;

import com.bbd.wtyh.core.dao.GeneralMapper;
import com.bbd.wtyh.core.entity.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 基础业务接口实现类
 *
 * @author Created by LiYao on 2017-03-03 22:38.
 */
public class BaseServiceImpl implements BaseService {

	@Autowired
	private GeneralMapper generalMapper;

	@Override
	public <T> T selectOne(Class<T> clazz, String where) {
		List<T> list = this.selectAll(clazz, where);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public <T> T selectById(Class<T> clazz, Object id) {
		if (id == null) {
			return null;
		}
		List<T> list = generalMapper.baseSelectById(clazz, id);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public <T> List<T> selectAll(Class<T> clazz, String where) {
		return generalMapper.baseSelectAll(clazz, where);
	}

	@Override
	public <T> List<T> selectByPage(Class<T> clazz, Pagination pagination, String where) {
		return generalMapper.baseSelectByPage(clazz, pagination, where);
	}

	@Override
	public <T> int insert(T obj) {
		return generalMapper.insert(obj);
	}

	@Override
	public <T> int insertList(List<T> list) {
		return generalMapper.insertList(list);
	}

	@Override
	public <T> int delete(T obj) {
		return generalMapper.delete(obj);
	}

	@Override
	public <T> int update(T obj) {
		return generalMapper.update(obj);
	}

	@Override
	public int executeCUD(String sql, Object... param) {
		if (sql.toUpperCase().trim().startsWith("INSERT")) {
			return generalMapper.executeInsert(sql, param);
		}
		if (sql.toUpperCase().trim().startsWith("UPDATE")) {
			return generalMapper.executeUpdate(sql, param);
		}
		if (sql.toUpperCase().trim().startsWith("DELETE")) {
			return generalMapper.executeDelete(sql, param);
		}
		throw new IllegalArgumentException("非法的insert/update/delete语句");
	}
}
