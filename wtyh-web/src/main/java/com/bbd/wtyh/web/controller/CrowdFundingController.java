package com.bbd.wtyh.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.wangDaiAPI.CrowdFundingStatisticsDTO;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.service.CrowdFundingService;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.PieChartBean;
import com.bbd.wtyh.web.ResponseBean;


/**
* 众筹监测
* @author Ian.Su
* @since 2016年8月11日 下午3:32:26
*/
@Controller
@RequestMapping("/crowdFunding")
public class CrowdFundingController {
	
	
	@Autowired
	private CrowdFundingService crowdFundingSer;
	
	
	
	/**
	* 业务类型分布
	*
	* @param   
	* @return ResponseBean
	*/
	@RequestMapping("/distribute")
	@ResponseBody
	public ResponseBean distribute(){
		
		
		PieChartBean<String, NameValuePair> p = new PieChartBean<>();

		Map<String, String> map = crowdFundingSer.lastMonthType(Constants.CROWD_DISTRIBUTE);
		
		if(map == null){
			return ResponseBean.successResponse(p);
		}
		for (String key : map.keySet()) {
			p.getLegend().add(key);
			p.getSeries().add(new BasicNameValuePair(key , "" + map.get(key)  ));
		}

		return ResponseBean.successResponse(p);
	}
	
	
	
	/**
	* 上海各类众筹平台新增项目数
	*
	* @param   
	* @return ResponseBean
	*/
	@RequestMapping("/newlyProject")
	@ResponseBody
	public ResponseBean newlyProject(){
		
		HistogramBean<String, String> hb = new HistogramBean<>();

		Map<String, String> map = crowdFundingSer.lastMonthType(Constants.CROWD_NEWLY_PROJECT);
		
		if(map == null){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(Calendar.MONTH+"月上海各类众筹平台新增项目数");
		for (String key : map.keySet()) {
			hb.getxAxis().add(key);
			hb.getseries().add(map.get(key));
		}

		return ResponseBean.successResponse(hb);
	}
	
	
	
	/**
	* 上海各类众筹平台新增项目投资人次
	*
	* @param   
	* @return ResponseBean
	*/
	@RequestMapping("/newlyPeople")
	@ResponseBody
	public ResponseBean newlyPeople(){
		
		HistogramBean<String, String> hb = new HistogramBean<>();

		Map<String, String> map = crowdFundingSer.lastMonthType(Constants.CROWD_NEWLY_PEOPLE);
		
		if(map == null){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(Calendar.MONTH+"月上海各类众筹平台新增项目投资人次");

		for (String key : map.keySet()) {
			hb.getxAxis().add(key);
			hb.getseries().add(map.get(key));
		}

		return ResponseBean.successResponse(hb);
	}
	
	
	
	/**
	* 上海各类众筹平台新增项目数的成功筹资金额
	*
	* @return ResponseBean
	*/
	@RequestMapping("/newlyAmount")
	@ResponseBody
	public ResponseBean newlyAmount(){
		
		HistogramBean<String, String> hb = new HistogramBean<>();

		Map<String, String> map = crowdFundingSer.lastMonthType(Constants.CROWD_NEWLY_AMOUNT);
		
		if(map == null){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(Calendar.MONTH+"月上海各类众筹平台新增项目数的成功筹资金额");

		for (String key : map.keySet()) {
			hb.getxAxis().add(key);
			hb.getseries().add(map.get(key));
		}

		return ResponseBean.successResponse(hb);
	}
	
	
	
	
	/**
	* 平台基本情况，平台运营情况
	*
	* @param   
	* @return ResponseBean
	*/
	@RequestMapping("/allCompanys")
	@ResponseBody
	public ResponseBean allCompanys(){
	
		List<CrowdFundingCompanyDO> list = crowdFundingSer.allCompanys();
		
		return ResponseBean.successResponse(list==null?new ArrayList<>():list);
	}

	/**
	 *
	 *
	 * @param
	 * @return ResponseBean
	 */
	@RequestMapping("/queryCompany")
	@ResponseBody
	public ResponseBean queryCompany(@RequestParam String keyword){

		List<String> list = crowdFundingSer.queryCompany(keyword);

		return ResponseBean.successResponse(list==null?new ArrayList<>():list);
	}
	
}
