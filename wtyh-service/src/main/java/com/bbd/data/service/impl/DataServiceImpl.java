package com.bbd.data.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger log = LoggerFactory.getLogger(getClass());

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
	public List<Map<String, Object>> getTableData(String tableName,String value,String mode,String field, Integer page, Integer rows) {
		page = (page == null || page < 1 ? 1 : page);
		rows = (rows == null ? 15 : rows);
		if("like".equals(mode)){
			value = "%"+StringUtils.trimToEmpty(value)+"%";
		}
		return tableDataMapper.getTableData(tableName, value, mode, field,page*rows-rows,rows);
	}



	
	@Override
	public int countTableData(String tableName,String value,String mode,String field) {
		if("like".equals(mode)){
			value = "%"+StringUtils.trimToEmpty(value)+"%";
		}
		return tableDataMapper.countTableData(tableName, value, mode, field);
	}


	

	@Override
	public void updateTableData(String tableName, String idField, String updateField,Integer idValue , String value) {

		tableDataMapper.updateTableData(tableName, idField, updateField, idValue, value);

	}

	@Override
	public List<Map<String, Object>> getCredit(String companyName) {

		List<String> list = tableDataMapper.getCredit(companyName);

		Gson gson = new Gson();
		List<Map<String,Object>> maps = new ArrayList<>();
		for (String str:list) {
			log.info(str);
			Map<String, Object> map = gson.fromJson(str,new TypeToken<Map<String, Object>>(){}.getType());
			maps.add(map);
		}

		return maps;

	}


}
