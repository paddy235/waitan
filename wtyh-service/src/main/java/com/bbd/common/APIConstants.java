package com.bbd.common;

import java.util.HashMap;
import java.util.Map;

public class APIConstants {
	
	//存储rediskey  附件路径 该key由"公司名_att_客户端名"组成，例如"中国银行_att_pingan"显示为平安终端的中国银行附件
	public static final String redis_attPath = "_att_";
	//存储rediskey 公司信息统计
	public static final String redis_cds = "_cds";
	//存储rediskey  YED使用动态套系数据  静态图谱
	public static final String redis_relation_LinksDataJTTP ="_relation_linksData_jttp";
	//动态关联方     套系层次
	public static final int show_relation_A = 2;
	//动态关联方     套系层次
	public static final int show_relation_E = 3;
	//动态关联方     接口请求编码
	public static final String show_charset = "UTF-8";
	//基本资料_工商注册资料 suffix key 
	public static final String redis_bd_gszczl = "_bd_gszczl";
	//基本资料_管理层信息redis key suffix
	public static final String redis_bd_glcqk = "_bd_glcqk";
	//基本资料_股东信息redis key suffix
	public static final String redis_bd_gdxx = "_bd_gdxx";
	//基本资料_诉讼信息 suffix key 
	public static final String redis_bd_ssjl = "_bd_ssjl";
	//基本资料_失信被执行人 suffix key 
	public static final String redis_bd_sxbzx = "_bd_sxbzx";
	//基本资料_开庭公告 suffix key 
	public static final String redis_bd_ktgg = "_bd_ktgg";
	//基本资料_被执行 suffix key 
	public static final String redis_bd_bzx = "_bd_bzx";
	
	//企业信息表名
	public static final String COMPANYINFO_QYXX = "qyxx";
	//诉讼记录
	public static final String COMPANYINFO_SSJL = "zgcpwsw";
	//失信被执行
	public static final String COMPANYINFO_SXBZX = "dishonesty";
	//被执行
	public static final String COMPANYINFO_BZX = "zhixing";
	//开庭公告
	public static final String COMPANYINFO_KTGG = "ktgg";
	//查询类型
	public static final String SEARCHTYPE_SEARCH = "search";
	public static final String SEARCHTYPE_DETAIL = "detail";
	//Api fields
	public static final String FIELD_NAME = "名称";
	//访问token
	public static final String ACCESS_TOKEN = "273601cbd4ef2c358ab728025cb23e33";
	public static Map<String,String> EnterpriseDataMap = new HashMap<String,String>();
	public static Map<String,String> ShareholderDataMap = new HashMap<String,String>();
	static 
	{
		EnterpriseDataMap.put("注册号", "registId");
		EnterpriseDataMap.put("名称", "name");
		EnterpriseDataMap.put("类型", "type");
		EnterpriseDataMap.put("法定代表人", "representative");
		EnterpriseDataMap.put("注册资本", "capital");
		EnterpriseDataMap.put("成立日期", "buildDate");
		EnterpriseDataMap.put("住所", "position");
		EnterpriseDataMap.put("营业期限自", "operatorPeriodStart");
		EnterpriseDataMap.put("营业期限至", "operatorPeriodEnd");
		EnterpriseDataMap.put("经营范围", "businessScope");
		EnterpriseDataMap.put("登记机关", "registation");
		EnterpriseDataMap.put("核准日期", "approveDate");
		EnterpriseDataMap.put("登记状态", "registStatus");
		//股东信息
		ShareholderDataMap.put("股东", "shareholderName");
		ShareholderDataMap.put("股东类型", "shareholderType");
		
		ShareholderDataMap.put("姓名", "shareholderName");
		ShareholderDataMap.put("投资人类型", "shareholderType");
		
		ShareholderDataMap.put("投资人", "shareholderName");
		
		ShareholderDataMap.put("出资人", "shareholderName");//阿里巴巴传媒（北京）有限公司 
		ShareholderDataMap.put("出资人类型", "shareholderType");
		
		ShareholderDataMap.put("股东/发起人", "shareholderName");//苏宁电器集团有限公司
		ShareholderDataMap.put("股东/发起人类型", "shareholderType");
		
		ShareholderDataMap.put("发起人", "shareholderName");//苏宁电器集团有限公司
		ShareholderDataMap.put("发起人类型", "shareholderType");
		
		ShareholderDataMap.put("合伙人", "shareholderName");//苏宁电器集团有限公司
		ShareholderDataMap.put("合伙人类型", "shareholderType");
		
		ShareholderDataMap.put("名称", "shareholderName");//苏宁电器集团有限公司
		ShareholderDataMap.put("类型", "shareholderType");
	}
	
	public static Map<String, String> ManangementInfoDataMap = new HashMap<String, String>(2);
	static {
		ManangementInfoDataMap.put("姓名", "name");
		ManangementInfoDataMap.put("职务", "job");
		ManangementInfoDataMap.put("出资人", "name");
		ManangementInfoDataMap.put("出资人类型", "job");
	}
	
	public static Map<String, String> LawsuitRecordDataMap = new HashMap<String, String>(11);
	static {
		LawsuitRecordDataMap.put("案号", "caseNo");
		LawsuitRecordDataMap.put("案由", "caseReason");
		LawsuitRecordDataMap.put("裁判日期", "refereeDate");
		LawsuitRecordDataMap.put("起诉方当事人", "prosecutionPerson");
		LawsuitRecordDataMap.put("起诉方其他相关人", "prosecutionOther");
		LawsuitRecordDataMap.put("被诉方当事人", "defendantPerson");
		LawsuitRecordDataMap.put("被诉方其他相关人", "defendantOther");
		LawsuitRecordDataMap.put("案件结果", "caseResult");
		LawsuitRecordDataMap.put("审理法院", "trialCourt");
		LawsuitRecordDataMap.put("法院方当事人", "courtPerson");
		LawsuitRecordDataMap.put("适用法条", "applicableLaw");
	}
	
	public static Map<String, String> DishonestPersonsDataMap = new HashMap<String, String>(4);
	static {
		DishonestPersonsDataMap.put("执行法院", "executiveCourt");
		DishonestPersonsDataMap.put("案号", "documentNo");
		DishonestPersonsDataMap.put("发布时间", "releaseTime");
		DishonestPersonsDataMap.put("执行依据文号", "executiveNo");
	}
	
	
	public static Map<String, String> ExecutedDataMap = new HashMap<String, String>(6);
	static {
		ExecutedDataMap.put("被执行人姓名/名称", "executedName");
		ExecutedDataMap.put("身份证号码/组织机构代码", "iDNumber");
		ExecutedDataMap.put("执行法院", "executiveCourt");
		ExecutedDataMap.put("立案时间", "filingTime");
		ExecutedDataMap.put("案号", "documentNo");
		ExecutedDataMap.put("执行标的", "executiveSubject");
	}
	
	//开庭公告
	public static Map<String, String> KtggDataMap = new HashMap<String, String>(4);
	static {
		KtggDataMap.put("时间", "courtTime");
		KtggDataMap.put("当事人", "person");
		KtggDataMap.put("案号", "caseNo");
		KtggDataMap.put("案由", "caseReason");
	}
	
}
