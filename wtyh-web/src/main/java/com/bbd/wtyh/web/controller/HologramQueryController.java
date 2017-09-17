package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.InvestigationInfoDO;
import com.bbd.wtyh.domain.bbdAPI.*;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.service.InvestigationInfoService;
import com.bbd.wtyh.util.DateUtils;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
	public ResponseBean outlineMsg(@RequestParam(required = true) String company,String bbdQyxxId) {
		Map<String, Object> result = hologramQueryService.outlineMsg(company,bbdQyxxId);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 新闻舆情
	 *
	 * @return
	 */
	@RequestMapping("/newsConsensus")
	@ResponseBody
	public ResponseBean newsConsensus(@RequestParam(required = true) String company,String bbdQyxxId) {
		Object result = hologramQueryService.newsConsensusList(company,bbdQyxxId);
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
	public ResponseBean businessInfo(@RequestParam(required = true) String company,String bbdQyxxId) {
		Map<String, Object> result = hologramQueryService.businessInfo(company,bbdQyxxId);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-股东高管
	 *
	 * @return
	 */
	@RequestMapping("/shareholdersSenior")
	@ResponseBody
	public ResponseBean shareholdersSenior(@RequestParam(required = true) String company,String bbdQyxxId) {
		Map<String,List> result=new HashMap();
		Map<String,Set<String>> resultKey=new HashMap();
		Map<String, List> shareholderSenior = hologramQueryService.shareholdersSenior(company,bbdQyxxId);
		List<Map> rList = (List)(shareholderSenior.get("gdxx"));
		if(rList!=null) {
			for (Map map : rList) {
				Object obj = map.get("shareholder_name");
				if (obj != null) {
					String name = (String) obj;
					String type = (String) map.get("shareholder_type");
					if (resultKey.containsKey(name)) {
						Set typeSet = resultKey.get(name);
						typeSet.add(type);
						resultKey.put(name, typeSet);
					} else {
						Set typeSet = new HashSet();
						typeSet.add(type);
						resultKey.put(name, typeSet);
					}
				}
			}
		}
		rList =(List)(shareholderSenior.get("baxx"));
		if(rList!=null) {
			for(Map map:rList){
				Object obj=map.get("name");
				if(obj!=null){
					String name=(String)obj;
					String type =(String)map.get("position");
					if(resultKey.containsKey(name)){
						Set typeSet=resultKey.get(name);
						typeSet.add(type);
						resultKey.put(name,typeSet);
					}else{
						Set typeSet=new HashSet();
						typeSet.add(type);
						resultKey.put(name,typeSet);
					}
				}
			}
		}
		List<Map<String,String>>list=new ArrayList<>();
		for(String key:resultKey.keySet()){
			Set<String> set=resultKey.get(key);
			StringBuffer sb=new StringBuffer();
			int i=0;
			for(String str:set){
				i++;
				if(str==null){
					continue;
				}
				sb.append(str);
				if(i<set.size()){
					sb.append("/");
				}
			}
			Map map=new HashMap();
			map.put(key,sb.toString());
			list.add(map);
		}
		result.put("baxxAndGdxx",list);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 开庭公告
	 *
	 * @return
	 */
	@RequestMapping("/openCourtAnnouncement")
	@ResponseBody
	public ResponseBean openCourtAnnouncement(@RequestParam(required = true) String company,
											  @RequestParam(required = true) Integer page,
											  @RequestParam(required = true) Integer pageSize,
											  String bbdQyxxId ) {
		OpenCourtAnnouncementDO result = hologramQueryService.openCourtAnnouncement1(company,bbdQyxxId,page,pageSize);
		//数据平台超时,返回null,会对前端取results的JS有影响
		if(null==result){
			result=new OpenCourtAnnouncementDO();
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
	public ResponseBean judgeDoc(@RequestParam(required = true) String company,
								 @RequestParam(required = true) Integer page,
								 @RequestParam(required = true) Integer pageSize,
								 String bbdQyxxId) {
		JudgeDocDO result = hologramQueryService.judgeDoc1(company,bbdQyxxId,page,pageSize);
		if(null==result){
			result=new JudgeDocDO();
		}
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 被执行人
	 *
	 * @return
	 */
	@RequestMapping("/debtor")
	@ResponseBody
	public ResponseBean debtor(@RequestParam(required = true) String company,
							   @RequestParam(required = true) Integer page,
							   @RequestParam(required = true) Integer pageSize,
							   String bbdQyxxId) {
		DebtorDO result = hologramQueryService.debtor(company,bbdQyxxId,page,pageSize);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 失信被执行人
	 *
	 * @return
	 */
	@RequestMapping("/noCreditDebtor")
	@ResponseBody
	public ResponseBean noCreditDebtor(@RequestParam(required = true) String company,
									   @RequestParam(required = true) Integer page,
									   @RequestParam(required = true) Integer pageSize,
									   String bbdQyxxId) {
		NoCreditDebtorDO result = hologramQueryService.noCreditDebtor(company,bbdQyxxId,page,pageSize);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-诉讼记录 - 法院公告
	 *
	 * @return
	 */
	@RequestMapping("/courtAnnouncement")
	@ResponseBody
	public ResponseBean courtAnnouncement(@RequestParam(required = true) String company,
										  @RequestParam(required = true) Integer page,
										  @RequestParam(required = true) Integer pageSize,
										  String bbdQyxxId) {
		CourtAnnouncementDO result = hologramQueryService.courtAnnouncement(company,bbdQyxxId,page,pageSize);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-招聘信息 - 招聘人数指数
	 *
	 * @return
	 */
	@RequestMapping("/recruitPeopleNumber")
	@ResponseBody
	public ResponseBean recruitPeopleNumber(@RequestParam(required = true) String company, @RequestParam(required = false) String timeTag,
                                            String bbdQyxxId) {
		RecruitPeopleNumberDO result = hologramQueryService.recruitPeopleNumber(company,bbdQyxxId, timeTag);
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
			@RequestParam(required = false) String timeTag,String bbdQyxxId) {
		RecruitPeopleDistributeDO result = hologramQueryService.recruitPeopleDistribute(company,bbdQyxxId, timeTag);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情-招聘信息 - 薪酬分布
	 *
	 * @return
	 */
	@RequestMapping("/recruitPeopleSalary")
	@ResponseBody
	public ResponseBean recruitPeopleSalary(@RequestParam(required = true) String company, @RequestParam(required = false) String timeTag
                                            ,String bbdQyxxId) {
		RecruitPeopleSalaryDO result = hologramQueryService.recruitPeopleSalary(company,bbdQyxxId, timeTag);
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
									  @RequestParam(required = true) Integer pageSize,
                                      String bbdQyxxId) {
		PatentDO result = hologramQueryService.getPatentData(company,bbdQyxxId,page,pageSize);
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
	public ResponseBean tabbInvestigationInfo(InvestigationInfoDO investigationInfoDO,
											  @RequestParam(required = true) String recorder, HttpServletRequest request ) throws Exception {
		investigationInfo.saveInvestigationInfo( investigationInfoDO, recorder );
		UserLogRecord.record("排查信息上报", Operation.Type.INFO_REPORT, Operation.Page.informationReport,
				Operation.System.front, request);
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
	public ResponseBean infoStatistics(@RequestParam String company,String bbdQyxxId) throws Exception {
		Map<String, Integer> result = new HashMap<>();
		//股东高管
		Set set=new HashSet();
		Map<String, List> shareholderSenior = hologramQueryService.shareholdersSenior(company,bbdQyxxId);
		List<Map> rList = (List)(shareholderSenior.get("gdxx"));
		if(rList!=null){
			for(Map map:rList){
				Object obj=map.get("shareholder_name");
				if(obj!=null) {
					String name = (String) obj;
					set.add(name);
				}
			}
		}
		rList =(List)(shareholderSenior.get("baxx"));
		if(rList!=null){
			for(Map map:rList){
				Object obj=map.get("name");
				if(obj!=null){
					String name=(String)obj;
					set.add(name);
				}

			}
		}
		result.put( "shareholderSeniorTotal", set.size() );
		//诉讼记录
		Integer lawsuitTotal =0;
		OpenCourtAnnouncementDO loc = hologramQueryService.openCourtAnnouncement1(company,bbdQyxxId,null,null);
		Integer openCourtNum =( null==loc ? 0 : loc.getTotal() ); //加上开庭公告数
		result.put("lawsuitTotal_openCourt" ,openCourtNum);
		lawsuitTotal +=openCourtNum;
		JudgeDocDO jd= hologramQueryService.judgeDoc1(company,bbdQyxxId,null,null);
		Integer judgeDocNum= ( null ==jd ? 0 : jd.getTotal() ); //加上裁判文书数
		result.put("lawsuitTotal_judgeDoc" ,judgeDocNum);
		lawsuitTotal +=judgeDocNum;
		DebtorDO de = hologramQueryService.debtor(company,bbdQyxxId,null,null);
		Integer debtorNum = ( null ==de ? 0 : de.getTotal() ); //加上被执行人
		result.put("lawsuitTotal_debtor" ,debtorNum);
		lawsuitTotal +=debtorNum;
		NoCreditDebtorDO ncd = hologramQueryService.noCreditDebtor(company,bbdQyxxId,null,null);
		Integer noCreditDebtorNum = ( null ==ncd ? 0 : ncd.getTotal() ); //加上失信被执行人
		result.put("lawsuitTotal_noCreditDebtor" ,noCreditDebtorNum);
		lawsuitTotal +=noCreditDebtorNum;
		CourtAnnouncementDO ca = hologramQueryService.courtAnnouncement(company,bbdQyxxId,null,null);
		Integer courtAnnouncementNum = ( null ==ca ? 0 : ca.getTotal() ); //加上法院公告
		result.put("lawsuitTotal_courtAnnouncement" ,courtAnnouncementNum);
		lawsuitTotal +=courtAnnouncementNum;
		result.put("lawsuitTotal" ,lawsuitTotal);
		//加入专利信息
		PatentDO pd = hologramQueryService.getPatentData(company,bbdQyxxId,1,200000000);
		Integer patentTotal = ( null ==pd ? 0 : pd.getTotal() ); //专利信息
		result.put( "patentTotal", patentTotal );
		//加入排查信息总数
		Map<String, Object> mp = investigationInfo.listInvestigationInfo( 1,0,null,
				null, company, null, null, null);
		Integer investigationTotal =((Long)(mp.get("listTotalNum"))).intValue();
		result.put( "investigationTotal", null ==investigationTotal ? 0 : investigationTotal );
		return ResponseBean.successResponse(result);
	}


	/**
	 * 企业信息详情--股东高管结果统计
	 *
	 * @return
	 */
	@RequestMapping("/countShareholder.do")
	@ResponseBody
	public ResponseBean countShareholder(@RequestParam String company,String bbdQyxxId) throws Exception {
		Map<String, Integer> result = new HashMap<>();
		//股东高管
		Set set=new HashSet();
		Map<String, List> shareholderSenior = hologramQueryService.shareholdersSenior(company,bbdQyxxId);
		List<Map> rList = (List)(shareholderSenior.get("gdxx"));
		if(rList!=null) {
			for (Map map : rList) {
				Object obj = map.get("shareholder_name");
				if (obj != null) {
					String name = (String) obj;
					set.add(name);
				}
			}
		}
		rList =(List)(shareholderSenior.get("baxx"));
		if(rList!=null) {
			for (Map map : rList) {
				Object obj = map.get("name");
				if (obj != null) {
					String name = (String) obj;
					set.add(name);
				}

			}
		}
		result.put( "shareholderSeniorTotal", set.size() );
		return ResponseBean.successResponse(result);
	}
	/**
	 * 企业信息详情--诉讼记录结果统计
	 *
	 * @return
	 */
	@RequestMapping("/countLitigation.do")
	@ResponseBody
	public ResponseBean countLitigation(@RequestParam String company,String bbdQyxxId) throws Exception {
		//诉讼记录
		Map<String, Integer> result = new HashMap<>();
		Integer lawsuitTotal =0;
		OpenCourtAnnouncementDO loc = hologramQueryService.openCourtAnnouncement1(company,bbdQyxxId,null,null);
		Integer openCourtNum =( null==loc ? 0 : loc.getTotal() ); //加上开庭公告数
		result.put("lawsuitTotal_openCourt" ,openCourtNum);
		lawsuitTotal +=openCourtNum;
		JudgeDocDO jd= hologramQueryService.judgeDoc1(company,bbdQyxxId,null,null);
		Integer judgeDocNum= ( null ==jd ? 0 : jd.getTotal() ); //加上裁判文书数
		result.put("lawsuitTotal_judgeDoc" ,judgeDocNum);
		lawsuitTotal +=judgeDocNum;
		DebtorDO de = hologramQueryService.debtor(company,bbdQyxxId,null,null);
		Integer debtorNum = ( null ==de ? 0 : de.getTotal() ); //加上被执行人
		result.put("lawsuitTotal_debtor" ,debtorNum);
		lawsuitTotal +=debtorNum;
		NoCreditDebtorDO ncd = hologramQueryService.noCreditDebtor(company,bbdQyxxId,null,null);
		Integer noCreditDebtorNum = ( null ==ncd ? 0 : ncd.getTotal() ); //加上失信被执行人
		result.put("lawsuitTotal_noCreditDebtor" ,noCreditDebtorNum);
		lawsuitTotal +=noCreditDebtorNum;
		CourtAnnouncementDO ca = hologramQueryService.courtAnnouncement(company,bbdQyxxId,null,null);
		Integer courtAnnouncementNum = ( null ==ca ? 0 : ca.getTotal() ); //加上法院公告
		result.put("lawsuitTotal_courtAnnouncement" ,courtAnnouncementNum);
		lawsuitTotal +=courtAnnouncementNum;
		result.put("lawsuitTotal" ,lawsuitTotal);
		return ResponseBean.successResponse(result);
	}

	/**
	 * 企业信息详情--专利信息统计
	 *
	 * @return
	 */
	@RequestMapping("/countPatent.do")
	@ResponseBody
	public ResponseBean countPatent(@RequestParam String company ,String bbdQyxxId) throws Exception {
		//加入专利信息
		Map<String, Integer> result = new HashMap<>();
		PatentDO pd = hologramQueryService.getPatentData(company,bbdQyxxId,1,200000000);
		Integer patentTotal = ( null ==pd ? 0 : pd.getTotal() ); //专利信息
		result.put( "patentTotal", patentTotal );
		return ResponseBean.successResponse(result);
	}
	/**
	 * 企业信息详情--排查信息统计
	 *
	 * @return
	 */
	@RequestMapping("/countInvestigation.do")
	@ResponseBody
	public ResponseBean countInvestigation(@RequestParam String company) throws Exception {
		//加入排查信息总数
		Map<String, Integer> result = new HashMap<>();
		Map<String, Object> mp = investigationInfo.listInvestigationInfo( 1,0,null,
				null, company, null, null, null);
		Integer investigationTotal =((Long)(mp.get("listTotalNum"))).intValue();
		result.put( "investigationTotal", null ==investigationTotal ? 0 : investigationTotal );
		return ResponseBean.successResponse(result);
	}

}
