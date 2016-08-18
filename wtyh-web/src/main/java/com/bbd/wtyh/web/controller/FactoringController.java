package com.bbd.wtyh.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
import com.bbd.wtyh.domain.CompanyAndRiskDO;
import com.bbd.wtyh.domain.CompanyCountDO;
import com.bbd.wtyh.service.FactoringService;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.LineChartBean;
import com.bbd.wtyh.web.PieChartBean;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesLinesBean;

/**
* 商业保理
* @author Ian.Su
* @since 2016年8月10日 下午3:09:46
*/
@RestController
@RequestMapping("/factoring")
public class FactoringController {
	
	@Autowired
	private FactoringService facSer;
	
	
	
	
	/**
	* 在沪商业保理企业数量
	* @return Object
	*/
	@RequestMapping("/companys")
	@ResponseBody
	public Object companys(){
		
		List<CommercialFactoringStatisticDO> facList = facSer.companyCountByYear();
		
		LineChartBean<Integer, Integer> line = new LineChartBean<>();
		
		for (CommercialFactoringStatisticDO bean : facList) {
			line.getxAxis().add(bean.getYear());
			line.getseries().add(bean.getCompanyNumber());
		}
		
		return ResponseBean.successResponse(line);
		
	}
	
	
	
	/**
	* 全市商业保理业务总额及融资余额
	*
	* @return Object
	*/
	@RequestMapping("/totalBalance")
	@ResponseBody
	public Object totalBalance(){
		
		List<CommercialFactoringStatisticDO> facList = facSer.companyCountByYear();

		XAxisSeriesBarLineBean<Integer,Integer> dto = new XAxisSeriesBarLineBean<>();
		
		for (CommercialFactoringStatisticDO bean : facList) {
			dto.getxAxis().add(bean.getYear());
			dto.getSeries().getBar().add(bean.getTotalAmout());
			dto.getSeries().getLine().add(bean.getBalance());
		}
		
		return ResponseBean.successResponse(dto);
		
	}
	
	
	

	/**
	* 国内商业保理和国际商业保理业务额
	* @return Object
	*/
	@RequestMapping("/insideOutside")
	@ResponseBody
	public Object insideOutside(){
		
		List<CommercialFactoringStatisticDO> facList = facSer.companyCountByYear();
		
		@SuppressWarnings("unchecked")
		XAxisSeriesLinesBean<Integer,Integer> dto = new XAxisSeriesLinesBean<>(
													new ArrayList<Integer>(),
													new ArrayList<Integer>());
		
		for (CommercialFactoringStatisticDO bean : facList) {
			dto.getxAxis().add(bean.getYear());
			dto.getSeries()[0].add(bean.getDomestic());
			dto.getSeries()[1].add(bean.getInternational());
		}
		
		return ResponseBean.successResponse(dto);
		
	}
	
	
	/**
	* 全市商业保理资产总额
	*
	* @return Object
	*/
	@RequestMapping("/total")
	@ResponseBody
	public Object total(){
		
		List<CommercialFactoringStatisticDO> facList = facSer.companyCountByYear();
		
		HistogramBean<Integer,Integer> bean = new HistogramBean<>();
		
		for (CommercialFactoringStatisticDO data : facList) {
			bean.getxAxis().add(data.getYear());
			bean.getseries().add(data.getTotalAmout());
		}
		
		return ResponseBean.successResponse(bean);
		
	}
	
	
	/**
	* 商业保理企业名单
	*
	* @return Object
	*/
	@RequestMapping("/queryCompanys")
	@ResponseBody
	public Object queryFactoringCompanys(){
		
		List<CompanyAndRiskDO> facList = facSer.queryFactoringCompanys();
		
		return ResponseBean.successResponse(facList);
		
	}
	
	
	
	
	/**
	* 企业类型分布
	*
	* @return Object
	*/
	@RequestMapping("/distribute")
	@ResponseBody
	public Object distribute(){
		
		PieChartBean<String, Integer> pie = new PieChartBean<>();
		
		List<Map<String,Object>> list = facSer.distribute();
		
		if(CollectionUtils.isEmpty(list)){
			return ResponseBean.successResponse(pie);
		}
		
		for (Map<String,Object> nv : list) {
			pie.getLegend().add( nv.get("name").toString() );
			pie.getSeries().add(Integer.parseInt(""+nv.get("value")));
		}
		
		return ResponseBean.successResponse(pie);
		
	}
	
	
	
	/**
	* 商业保理地域分布
	*
	* @return Object
	*/
	@RequestMapping("/geogDistribute")
	@ResponseBody
	public Object geogDistribute(){
		
		HistogramBean<String, Integer> chart = new HistogramBean<>();
		
		List<Map<String,Object>> list = facSer.geogDistribute();
		
		if(CollectionUtils.isEmpty(list)){
			return ResponseBean.successResponse(chart);
		}
		
		for (Map<String,Object> nv : list) {
			chart.getxAxis().add( nv.get("name").toString() );
			chart.getseries().add(Integer.parseInt(""+nv.get("value")));
		}
		
		return ResponseBean.successResponse(chart);
		
	}
	
	
	
	/**
	* 商业保理在沪企业数量、全市商业保理企业注册资本总额 综合接口
	*
	* @return Object
	*/
	@RequestMapping("/countCapitalBySeason")
	@ResponseBody
	public Object countCapitalBySeason(){
		
		LineChartBean<String, Object> line = new LineChartBean<>();
		
		HistogramBean<String, Object> hist = new HistogramBean<>();
		hist.setTitle("全市商业保理企业注册资本总额");
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("line", line);
		map.put("histogram", hist);
		
		List<CompanyCountDO> list = facSer.countCapitalBySeason();
		
		if (CollectionUtils.isEmpty(list)) {
			return ResponseBean.successResponse(map);
		}
		
		for (CompanyCountDO cdo : list) {
			line.getxAxis().add(cdo.getName());
			line.getseries().add(cdo.getCount());
			hist.getxAxis().add(cdo.getName());
			hist.getseries().add(cdo.getSum());
		}
		
		return ResponseBean.successResponse(map);
	}
	
	
}
