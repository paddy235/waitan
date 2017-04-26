package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.InvestigationInfoDO;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.service.InvestigationInfoService;
import com.bbd.wtyh.util.DateUtils;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 企业全息信息查询平台控制层
 *
 * @author wangchenge
 * @since 2016.08.09
 */
@Controller
@RequestMapping("/hologram")
public class HologramQueryController {

	@Autowired
	private HologramQueryService hologramQueryService;

	/**
	 * 信息查询平台搜索
	 *
	 * @return
	 */
	@RequestMapping("/search")
	@ResponseBody
	@LogRecord(logMsg = "企业全息信息搜索，关键字：%s", params = { "company" }, page = Operation.Page.hologram, type = Operation.Type.query)
	public ResponseBean search(@RequestParam(required = true) String company, @RequestParam(defaultValue = "0") int page_no,
			@RequestParam(defaultValue = "4") int page_size) {
		SearchComanyDO result = hologramQueryService.search(company, page_no, page_size);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 信息查询平台导航栏
	 *
	 * @return
	 */
	@RequestMapping("/guidance")
	@ResponseBody
	public ResponseBean guidance(String company) {
		Map<String, Object> result = hologramQueryService.guidance(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业概要信息
	 *
	 * @return
	 */
	@RequestMapping("/outlineMsg")
	@ResponseBody
	@LogRecord(logMsg = "浏览【%s】全息页面", params = { "company" }, page = Operation.Page.hologram)
	public ResponseBean outlineMsg(@RequestParam(required = true) String company) {
		Map<String, Object> result = hologramQueryService.outlineMsg(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 新闻舆情
	 *
	 * @return
	 */
	@RequestMapping("/newsConsensus")
	@ResponseBody
	public ResponseBean newsConsensus(@RequestParam(required = true) String company) {
		Object result = hologramQueryService.newsConsensusList(company);
		//数据平台舆情超时,返回null,会对前端取results的JS有影响
		if(null==result){
			Map map=new HashMap();
			map.put("results",new ArrayList());
			return ResponseBean.successResponse(map);
		}
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-工商信息
	 *
	 * @return
	 */
	@RequestMapping("/businessInfo")
	@ResponseBody
	public ResponseBean businessInfo(@RequestParam(required = true) String company) {
		Map<String, Object> result = hologramQueryService.businessInfo(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-股东高管
	 *
	 * @return
	 */
	@RequestMapping("/shareholdersSenior")
	@ResponseBody
	public ResponseBean shareholdersSenior(@RequestParam(required = true) String company) {
		Map<String, List> result = hologramQueryService.shareholdersSenior(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 开庭公告
	 *
	 * @return
	 */
	@RequestMapping("/openCourtAnnouncement")
	@ResponseBody
	public ResponseBean openCourtAnnouncement(@RequestParam(required = true) String company) {
		List<OpenCourtAnnouncementDO.Results> result = hologramQueryService.openCourtAnnouncement(company);
		//数据平台超时,返回null,会对前端取results的JS有影响
		if(null==result){
			result=new ArrayList();
		}
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 裁判文书
	 *
	 * @return
	 */
	@RequestMapping("/judgeDoc")
	@ResponseBody
	public ResponseBean judgeDoc(@RequestParam(required = true) String company) {
		List<JudgeDocDO.Results> result = hologramQueryService.judgeDoc(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 被执行人
	 *
	 * @return
	 */
	@RequestMapping("/debtor")
	@ResponseBody
	public ResponseBean debtor(@RequestParam(required = true) String company) {
		DebtorDO result = hologramQueryService.debtor(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 失信被执行人
	 *
	 * @return
	 */
	@RequestMapping("/noCreditDebtor")
	@ResponseBody
	public ResponseBean noCreditDebtor(@RequestParam(required = true) String company) {
		NoCreditDebtorDO result = hologramQueryService.noCreditDebtor(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 法院公告
	 *
	 * @return
	 */
	@RequestMapping("/courtAnnouncement")
	@ResponseBody
	public ResponseBean courtAnnouncement(@RequestParam(required = true) String company) {
		CourtAnnouncementDO result = hologramQueryService.courtAnnouncement(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-招聘信息 - 招聘人数指数
	 *
	 * @return
	 */
	@RequestMapping("/recruitPeopleNumber")
	@ResponseBody
	public ResponseBean recruitPeopleNumber(@RequestParam(required = true) String company, @RequestParam(required = false) String timeTag) {
		RecruitPeopleNumberDO result = hologramQueryService.recruitPeopleNumber(company, timeTag);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-招聘信息 - 招聘人员分布
	 *
	 * @return
	 */
	@RequestMapping("/recruitPeopleDistribute")
	@ResponseBody
	public ResponseBean recruitPeopleDistribute(@RequestParam(required = true) String company,
			@RequestParam(required = false) String timeTag) {
		RecruitPeopleDistributeDO result = hologramQueryService.recruitPeopleDistribute(company, timeTag);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-招聘信息 - 薪酬分布
	 *
	 * @return
	 */
	@RequestMapping("/recruitPeopleSalary")
	@ResponseBody
	public ResponseBean recruitPeopleSalary(@RequestParam(required = true) String company, @RequestParam(required = false) String timeTag) {
		RecruitPeopleSalaryDO result = hologramQueryService.recruitPeopleSalary(company, timeTag);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业标签
	 *
	 * @return
	 */
	@RequestMapping("/tag")
	@ResponseBody
	public ResponseBean tag(@RequestParam(required = true) String company) {
		CompanyDO result = hologramQueryService.tag(company);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-专利信息
	 *
	 * @return
	 */
	@RequestMapping("/patentData")
	@ResponseBody
	public ResponseBean getPatentData(@RequestParam(required = true) String company,
									  @RequestParam(required = true) Integer page,
									  @RequestParam(required = true) Integer pageSize) {
		PatentDO result = hologramQueryService.getPatentData(company,page,pageSize);
		return ResponseBean.successResponse(result);
	}


	@Autowired
	private InvestigationInfoService investigationInfo;

	/**
	 * 企业信息详情-排查信息录入
	 * (by cgj)
	 * @return
	 *
	 */
	@RequestMapping("/tabbInvestigationInfo.do")
	@ResponseBody
	public ResponseBean tabbInvestigationInfo( InvestigationInfoDO investigationInfoDO,
											   @RequestParam(required = true) String recorder ) throws Exception {
		investigationInfo.saveInvestigationInfo( investigationInfoDO, recorder );
		return ResponseBean.successResponse("OK");
	}
	/**
	 * 企业信息详情-列出排查信息
	 * (by cgj)
	 * @return
	 *
	 */
	@RequestMapping("/listInvestigationInfo.do")
	@ResponseBody
	public ResponseBean listInvestigationInfo(@RequestParam(required = true) int pageSize, Integer pageNumber,
											  String orderBy, Integer companyId, String companyName, String recorder,
											  String beginTime, String endTime) throws Exception {
		Map<String, Object> mp = investigationInfo.listInvestigationInfo( pageSize, pageNumber, orderBy,
				companyId, companyName, recorder, DateUtils.stringToDate(beginTime), DateUtils.stringToDate(endTime) );
		return ResponseBean.successResponse(mp);
	}

	/**
	 * 企业信息详情--查询结果统计
	 *
	 * @return
	 */
	@RequestMapping("/infoStatistics.do")
	@ResponseBody
	public ResponseBean infoStatistics(@RequestParam String company) throws Exception {
		Map<String, Integer> result = new HashMap<>();
		//股东高管
		Map<String, List> shareholderSenior = hologramQueryService.shareholdersSenior(company);
		Integer shareholderSeniorTotal = ((List)(shareholderSenior.get("gdxx"))).size();
		shareholderSeniorTotal += ((List)(shareholderSenior.get("baxx"))).size();
		result.put( "shareholderSeniorTotal", shareholderSeniorTotal );
		//诉讼记录
		List<OpenCourtAnnouncementDO.Results> loc = hologramQueryService.openCourtAnnouncement(company);
		Integer lawsuitTotal =loc.size(); //加上开庭公告数
		List<JudgeDocDO.Results> jd= hologramQueryService.judgeDoc(company);
		lawsuitTotal += jd.size(); //加上裁判文书数
		DebtorDO de = hologramQueryService.debtor(company);
		lawsuitTotal += de.getTotal(); //加上被执行人
		NoCreditDebtorDO ncd = hologramQueryService.noCreditDebtor(company);
		lawsuitTotal += ncd.getTotal(); //加上失信被执行人
		CourtAnnouncementDO ca = hologramQueryService.courtAnnouncement(company);
		lawsuitTotal += ca.getTotal(); //加上法院公告
		result.put("lawsuitTotal" ,lawsuitTotal);
		//加入专利信息
		PatentDO pd = hologramQueryService.getPatentData(company,1,200000000);
		Integer patentTotal = pd.getTotal(); //专利信息
		result.put( "patentTotal", patentTotal );
		//加入排查信息总数
		Map<String, Object> mp = investigationInfo.listInvestigationInfo( 1,0,null,
				null, company, null, null, null);
		Integer investigationTotal =((Long)(mp.get("listTotalNum"))).intValue();
		result.put( "investigationTotal", null ==investigationTotal?0:investigationTotal );
		return ResponseBean.successResponse(result);
	}

}
