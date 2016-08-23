package com.bbd.wtyh.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.bbd.wtyh.util.CalculateUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bbd.wtyh.domain.CrowdFundingCompanyDO;
import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;
import com.bbd.wtyh.domain.NvDO;
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
		
		List<NvDO> cfbs = crowdFundingSer.lastMonthData();
		
		if(CollectionUtils.isEmpty(cfbs)){
			return ResponseBean.successResponse(p);
		}
		
		
		for (NvDO nvDO : cfbs) {
			String name = nvDO.getName();
			name = "1".equals(nvDO.getName())?"公益型":"2".equals(name)?"综合型":"3".equals(name)?"权益型":"股权型";
			p.getLegend().add(name);
			p.getSeries().add(new BasicNameValuePair(name , ""+nvDO.getValue()  ));
			
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
		
		HistogramBean<String, Integer> hb = new HistogramBean<>();
		
		List<CrowdFundingStatisticsDO> list = crowdFundingSer.lastMonthType();
		
		if(CollectionUtils.isEmpty(list)){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(list.get(0).getMonth()+"月上海各类众筹平台新增项目数");
		for (CrowdFundingStatisticsDO bean : list) {
			hb.getxAxis().add(bean.getTypeCN());
			hb.getseries().add(bean.getProjectNumber());
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
		
		HistogramBean<String, Float> hb = new HistogramBean<>();
		
		List<CrowdFundingStatisticsDO> list = crowdFundingSer.lastMonthType();
		
		if(CollectionUtils.isEmpty(list)){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(list.get(0).getMonth()+"月上海各类众筹平台新增项目投资人次");
		for (CrowdFundingStatisticsDO bean : list) {
			hb.getxAxis().add(bean.getTypeCN());
			hb.getseries().add(bean.getPeopleNumber());
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
		
		HistogramBean<String, Float> hb = new HistogramBean<>();
		
		List<CrowdFundingStatisticsDO> list = crowdFundingSer.lastMonthType();
		
		if(CollectionUtils.isEmpty(list)){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(list.get(0).getMonth()+"月上海各类众筹平台新增项目数的成功筹资金额");
		for (CrowdFundingStatisticsDO bean : list) {
			hb.getxAxis().add(bean.getTypeCN());
			hb.getseries().add(bean.getAmount());
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
	
}
