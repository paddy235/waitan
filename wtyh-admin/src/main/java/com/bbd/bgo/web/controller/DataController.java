package com.bbd.bgo.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.data.domain.ColumnDO;
import com.bbd.data.domain.TableDO;
import com.bbd.data.service.DataService;
import com.bbd.wtyh.web.ResponseBean;

/**
 * 后台表数据管理接口
 * 
 * @author Ian.Su
 * @since 2016年8月5日 上午11:55:20
 */
@Controller
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private DataService dataService;

	/**
	 * 跳转到显示表的页面
	 * 
	 * @return String
	 */
	@RequestMapping("/showTables")
	public String showTables() {

		return "geo/showTables";
	}
	
	/**
	 * 获取所有表
	 * 
	 * @return Object
	 */
	@RequestMapping("/tables")
	@ResponseBody
	public Object tables() {
		
		Map<String,Object> map = new HashMap<>();
		
		List<TableDO> list = dataService.tables();
		
		map.put("total", list.size() );

		map.put("rows", list);
		
		return map;
	}
	
	
	
	/**
	 * 分页获取数据
	 * 
	 * @return Object
	 */
	@RequestMapping("/goTableData")
	public Object goTableData(@RequestParam String tableName,HttpServletRequest request) {
		
		List<ColumnDO> list = dataService.queryColumn(tableName);
		
		request.setAttribute("columns", list);
		
		return "geo/showData";
	}
	
	
	
	/**
	 * 分页获取数据
	 * 
	 * @return Object
	 */
	@RequestMapping("/getTableData")
	@ResponseBody
	public Object getTableData(@RequestParam String tableName,Integer page,Integer rows) {
		
		Map<String,Object> map = new HashMap<>();
		
		

		List<Map<String,Object>> list = dataService.getTableData(tableName, page, rows);
		
		int total = dataService.countTableData(tableName);
		
		map.put("total", total);
		
		map.put("rows" , list );
		
		return map;
	}

	
	
	/**
	 * 修改数据
	 * 
	 * @return Object
	 */
	@RequestMapping("/updateTableData")
	@ResponseBody
	public Object updateTableData(@RequestParam String tableName,
								  @RequestParam String value,
								  @RequestParam String updateField,
								  @RequestParam String idField,
								  @RequestParam Integer idValue
			                      ) {
		
		dataService.updateTableData(tableName,idField,updateField,idValue,value);
		
		return ResponseBean.successResponse("true");
		
	}
	
	
}
