package com.bbd.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bbd.data.domain.ColumnDO;
import com.bbd.data.domain.TableDO;

/**
* 
* @author Ian.Su
* @since 2016年8月8日 下午3:28:16
*/
public interface TableDataMapper {
	
	List<TableDO> tables();
	
	List<ColumnDO> queryColumn(String tableName);

	List<Map<String, Object>> getTableData( @Param(value="tableName") String tableName,
											@Param(value="value") String value,
											@Param(value="mode") String mode,
											@Param(value="field") String field,
											@Param(value="start") Integer start, 
											@Param(value="rows") Integer rows);

	

	int countTableData(@Param(value="tableName") String tableName,
						@Param(value="value") String value,
						@Param(value="mode") String mode,
						@Param(value="field") String field);

	void updateTableData(@Param(value="tableName") String tableName, 
							@Param(value="idField") String idField, 
							@Param(value="updateField") String updateField, 
							@Param(value="idValue") Integer idValue ,
							@Param(value="value") String value);

}
