package com.bbd.wtyh.core.mybatis;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-05 14:22.
 */
public class MyBatisUtil {

	/**
	 * The constant KEY_ID_COLUMN.
	 */
	public static final String KEY_ID_COLUMN = "@_idColumn-_";
	/**
	 * The constant KEY_ID_FIELD.
	 */
	public static final String KEY_ID_FIELD = "@_idField-_";

	/**
	 * 用于新增时属性与字段映射缓存 <br>
	 * Map&lt;Class, Map&lt;ColumnName, FiledName>><br>
	 */
	private static Map<Class<?>, Map<String, String>> insertColumnMap = new HashMap<>();

	/**
	 * 用于新增时属性与字段映射 <br>
	 * Map中定义了特殊Key:@_idField-_，代表obj中的ID字段名称<br>
	 *
	 * @param obj
	 *            the obj
	 * @return Map &lt;ColumnName, FiledName>
	 * @throws Exception
	 *             the exception
	 */
	public static <T> Map<String, String> insertColumns(T obj) throws Exception {
		Map<String, String> columnMap = insertColumnMap.get(obj.getClass());
		if (columnMap == null) {
			columnMap = new HashMap<>();
		} else {
			if (!columnMap.isEmpty()) {
				return columnMap;
			}
		}

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Transient.class)) {
				continue;
			}
			if (field.isAnnotationPresent(Id.class)) {
				if (field.get(obj) == null) {
					continue;
				}
				columnMap.put(KEY_ID_FIELD, field.getName());
			}
			columnMap.put(getColumnName(field), field.getName());
		}
		insertColumnMap.put(obj.getClass(), columnMap);
		return columnMap;
	}

	/**
	 * 用于新增时属性与字段映射（null或""字段除外） <br>
	 * Map中定义了特殊Key:@_idField-_，代表obj中的ID字段名称<br>
	 * Map中定义了特殊Key:@_idColumn-_，代表obj中的ID字段名称对应的数据库字段名称
	 *
	 * @param obj
	 *            the obj
	 * @return Map &lt;ColumnName, FiledName>
	 * @throws Exception
	 *             the exception
	 */
	public static <T> Map<String, String> updateColumns(T obj) throws Exception {
		Map<String, String> columnMap = new HashMap<>();
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Transient.class)) {
				continue;
			}
			if (field.isAnnotationPresent(Id.class)) {
				columnMap.put(KEY_ID_COLUMN, getColumnName(field));
				columnMap.put(KEY_ID_FIELD, field.getName());
				continue;
			}

			Object value = field.get(obj);
			if (value == null || "".equals(value)) {
				continue;
			}
			columnMap.put(getColumnName(field), field.getName());
		}

		return columnMap;
	}

	private static String getColumnName(Field field) {
		Column column = field.getAnnotation(Column.class);
		if (column != null && !"".equals(column.name().trim())) {
			return column.name();
		}
		return field.getName();
	}

}
