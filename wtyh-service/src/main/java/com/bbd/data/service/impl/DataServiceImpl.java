package com.bbd.data.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.data.domain.ColumnDO;
import com.bbd.data.domain.TableDO;
import com.bbd.data.mapper.TableDataMapper;
import com.bbd.data.service.DataService;

/**
* 
* @author Ian.Su
* @since 2016年8月8日 下午3:33:43
*/
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private TableDataMapper tableDataMapper;
	
	@Override
	public List<TableDO> tables() {
		return tableDataMapper.tables();
	}

	
	@Override
	public List<ColumnDO> queryColumn(String tableName) {
		
		return tableDataMapper.queryColumn(tableName);
	}



	@Override
	public List<Map<String, Object>> getTableData(String tableName, Integer page, Integer rows) {
		page = (page == null || page < 1 ? 1 : page);
		rows = (rows == null ? 15 : rows);
		return tableDataMapper.getTableData(tableName,page*rows-rows,rows);
	}



	
	@Override
	public int countTableData(String tableName) {
		
		return tableDataMapper.countTableData(tableName);
	}


	

	@Override
	public void updateTableData(String tableName, String idField, String updateField,Integer idValue , String value) {
		
		tableDataMapper.updateTableData(tableName,idField,  updateField,idValue ,  value);
	}

}
