package com.bbd.data.service;

import java.util.List;
import java.util.Map;

import com.bbd.data.domain.ColumnDO;
import com.bbd.data.domain.TableDO;

/**
* 
* @author Ian.Su
* @since 2016年8月8日 下午3:24:18
*/
public interface DataService {
	
	
	/**
	* 获取所有的表信息
	*
	* @return List<TableDO>
	*/
	List<TableDO> tables();
	
	
	
	/**
	* 根据表名获取列信息
	* @param  tableName 表名 
	* @return List<ColumnDO>
	*/
	List<ColumnDO> queryColumn(String tableName);



	
	/**
	* getTableData
	*
	* @param tableName 要查询的表
	* @param page 页码
	* @param rows 每页行数
	* @return List<Map<String,Object>>
	*/
	List<Map<String, Object>> getTableData(String tableName,String value,String mode,String field, Integer page, Integer rows);



	
	/**
	* 统计表记录数
	*
	* @param  tableName 表名
	* @return int
	*/
	int countTableData(String tableName,String value,String mode,String field);



	
	/**
	* 修改表数据
	*
	* @param  tableName 表名
	* @param  idField   主键
	* @param  updateField  要修改的字段
	* @param  value     要修改的值
	* @return void
	*/
	void updateTableData(String tableName, String idField, String updateField,Integer idValue , String value);


	/**
	 * 根据公司名称查询信用数据
	 *
	 * @param  companyName  公司名称
	 * @return List<Map<String,Object>>
	 */
    Map<String,Object> getCredit(String companyName);
}
