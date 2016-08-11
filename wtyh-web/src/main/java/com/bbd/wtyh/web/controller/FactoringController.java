package com.bbd.wtyh.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbd.wtyh.domain.CommercialFactoringStatisticDO;
import com.bbd.wtyh.domain.CompanyAndRiskDO;
import com.bbd.wtyh.domain.dto.XAxisSeriesBarLineDTO;
import com.bbd.wtyh.domain.dto.XAxisSeriesLinesDTO;
import com.bbd.wtyh.service.FactoringService;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.LineChartBean;
import com.bbd.wtyh.web.ResponseBean;

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
	* @param   
	* @return Object
	*/
	@RequestMapping("/totalBalance")
	@ResponseBody
	public Object totalBalance(){
		
		List<CommercialFactoringStatisticDO> facList = facSer.companyCountByYear();

		XAxisSeriesBarLineDTO<Integer,Integer> dto = new XAxisSeriesBarLineDTO<>();
		
		for (CommercialFactoringStatisticDO bean : facList) {
			dto.getxAxis().add(bean.getYear());
			dto.getSeries().getBar().add(bean.getTotalAmout());
			dto.getSeries().getLine().add(bean.getBalance());
		}
		
		return ResponseBean.successResponse(dto);
		
	}
	
	
	

	/**
	* 国内商业保理和国际商业保理业务额
	*
	* @param   
	* @return Object
	*/
	@RequestMapping("/insideOutside")
	@ResponseBody
	public Object insideOutside(){
		
		List<CommercialFactoringStatisticDO> facList = facSer.companyCountByYear();
		
		@SuppressWarnings("unchecked")
		XAxisSeriesLinesDTO<Integer,Integer> dto = new XAxisSeriesLinesDTO<>(
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
	* @param   
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
	
	
	
	
	
}
