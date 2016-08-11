package com.bbd.wtyh.web.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.domain.CrowdFundingBusinessStatisticsDO;
import com.bbd.wtyh.domain.CrowdFundingStatisticsDO;
import com.bbd.wtyh.service.CrowdFundingService;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.PieChartBean;
import com.bbd.wtyh.web.ResponseBean;

/**
* 
* @author Ian.Su
* @since 2016年8月11日 下午3:32:26
*/
@Controller
@RequestMapping("/crowdFunding")
public class CrowdFundingController {
	
	
	@Autowired
	private CrowdFundingService crowdFundingSer;
	
	
	@RequestMapping("/distribute")
	@ResponseBody
	public ResponseBean distribute(){
		
		
		PieChartBean<String, NameValuePair> p = new PieChartBean<>();
		
		CrowdFundingBusinessStatisticsDO cfbs = crowdFundingSer.lastMonthData();
		
		if(cfbs == null){
			return ResponseBean.successResponse(p);
		}
		
		
		p.setLegend(Arrays.asList("公益型","综合型","权益型","股权型"));
		p.getSeries().add(new BasicNameValuePair("公益型", ""+(cfbs.getPublicWelfareType()==null?0:cfbs.getPublicWelfareType())));
		p.getSeries().add(new BasicNameValuePair("综合型", ""+(cfbs.getSynthesizingType()==null?0:cfbs.getSynthesizingType())));
		p.getSeries().add(new BasicNameValuePair("权益型", ""+(cfbs.getEquityType()==null?0:cfbs.getEquityType())));
		p.getSeries().add(new BasicNameValuePair("股权型", ""+(cfbs.getProfitType()==null?0:cfbs.getProfitType())));
		
		return ResponseBean.successResponse(p);
	}
	
	
	@RequestMapping("/newlyProject")
	@ResponseBody
	public ResponseBean newlyProject(){
		
		HistogramBean<String, Integer> hb = new HistogramBean<>();
		
		List<CrowdFundingStatisticsDO> list = crowdFundingSer.lastMonthType();
		
		if(list == null){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(list.get(0).getMonth()+"月上海各类众筹平台新增项目数");
		for (CrowdFundingStatisticsDO bean : list) {
			hb.getxAxis().add(bean.getTypeCN());
			hb.getseries().add(bean.getProjectNumber());
		}
		return ResponseBean.successResponse(hb);
	}
	
	
	
	@RequestMapping("/newlyPeople")
	@ResponseBody
	public ResponseBean newlyPeople(){
		
		HistogramBean<String, Float> hb = new HistogramBean<>();
		
		List<CrowdFundingStatisticsDO> list = crowdFundingSer.lastMonthType();
		
		if(list == null){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(list.get(0).getMonth()+"月上海各类众筹平台新增项目投资人次");
		for (CrowdFundingStatisticsDO bean : list) {
			hb.getxAxis().add(bean.getTypeCN());
			hb.getseries().add(bean.getPeopleNumber());
		}
		return ResponseBean.successResponse(hb);
	}
	
	
	@RequestMapping("/newlyAmount")
	@ResponseBody
	public ResponseBean newlyAmount(){
		
		HistogramBean<String, Float> hb = new HistogramBean<>();
		
		List<CrowdFundingStatisticsDO> list = crowdFundingSer.lastMonthType();
		
		if(list == null){
			return ResponseBean.successResponse(hb);
		}
		hb.setTitle(list.get(0).getMonth()+"月上海各类众筹平台新增项目数的成功筹资金额");
		for (CrowdFundingStatisticsDO bean : list) {
			hb.getxAxis().add(bean.getTypeCN());
			hb.getseries().add(bean.getAmount());
		}
		return ResponseBean.successResponse(hb);
	}
	
	
	
	@RequestMapping("/companyInfo")
	@ResponseBody
	public ResponseBean companyInfo(){
		
		HistogramBean<String, Float> hb = new HistogramBean<>();
		
		//List<CrowdFundingStatisticsDO> list = crowdFundingSer.companyInfo();
		
		
		return ResponseBean.successResponse(hb);
	}
	
}
