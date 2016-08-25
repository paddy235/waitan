package com.bbd.wtyh.service.impl.relation;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.common.relation.APIConstants;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.web.relationVO.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component("basicDataService")
public class BasicDataService {
	private static Logger log = LoggerFactory.getLogger(BasicDataService.class);
	@Autowired
	private RedisDAO redisDAO;
	@Autowired
	private BasicDataContainerService basicDataContainerService;
	@Autowired
	private LawsuitRecordService lawsuitRecordService;
	
	public BasicDataVO queryBasicData(String companyName) {

		BasicDataVO basicData = new BasicDataVO();
		EnterpriseDataVO enterpriseData = this.get_gszczl_Data(companyName);
		basicData.setEnterpriseData(enterpriseData);
		List<ShareholderDataVO> shareholderDatas =  this.get_gdxx_Data(companyName);
		basicData.setShareholderDatas(shareholderDatas);
		Map<String, List<ManagementInfoVO>> map = this.get_glcqk_Data(companyName);
		// 董事VO
		List<ManagementInfoVO> dsvo =  map.get("dsvo");
		// 监事VO
		List<ManagementInfoVO> jsvo = map.get("jsvo");
		// 高级管理人员VO
		List<ManagementInfoVO> jlvo = map.get("jlvo");
		basicData.setDsvo(dsvo);
		basicData.setJsvo(jsvo);
		basicData.setJlvo(jlvo);
		return basicData;
	}

	//工商注册资料
	public EnterpriseDataVO get_gszczl_Data(String companyName)
	{
		String gszczl_key = companyName+ APIConstants.redis_bd_gszczl;
		String gszczl_value = redisDAO.getString(gszczl_key);
		EnterpriseDataVO enterpriseData = new EnterpriseDataVO() ;
		if(gszczl_value!=null)
		{
			JSONObject jsonObject = JSONObject.fromObject(gszczl_value);
			enterpriseData =  (EnterpriseDataVO) JSONObject.toBean(jsonObject, EnterpriseDataVO.class);
		} else
		{
			try {
				enterpriseData = basicDataContainerService.getEnterpriseData(companyName);
				if(enterpriseData!=null)
				{
					String value = JSONObject.fromObject(enterpriseData).toString();
					redisDAO.addString(gszczl_key, value, Constants.cacheDay);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}

		}
		return enterpriseData;
	}

	//股东情况
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ShareholderDataVO> get_gdxx_Data(String companyName)
	{
		//股东信息
		List<ShareholderDataVO> shareholderDatas = new ArrayList<ShareholderDataVO>();
		String gdxx_key = companyName +APIConstants.redis_bd_gdxx;
		String gdxx_value = redisDAO.getString(gdxx_key);
		if(gdxx_value!=null)
		{
			JSONArray jsonArray = JSONArray.fromObject(gdxx_value);
			shareholderDatas =  JSONArray.toList(jsonArray, ShareholderDataVO.class);
		} else
		{
			try {
				shareholderDatas = basicDataContainerService.getShareholderData(companyName);
				if(shareholderDatas!=null)
				{
					String value = JSONArray.fromObject(shareholderDatas).toString();
					redisDAO.addString(gdxx_key, value, Constants.cacheDay);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}

		}
		return shareholderDatas;
	}

	//管理层情况
	public Map<String, List<ManagementInfoVO>> get_glcqk_Data(String companyName)
	{
		Map<String, List<ManagementInfoVO>> map = new HashMap<String, List<ManagementInfoVO>> ();
		String glcqk_key = companyName+APIConstants.redis_bd_glcqk;
		String glcqk_value = redisDAO.getString(glcqk_key);
		if(glcqk_value!=null)
		{
			JSONArray jsonArray = JSONArray.fromObject(glcqk_value);
			map = basicDataContainerService.handleBaxxResultJson(jsonArray);
		} else
		{
			JSONArray baxxResult  = null;
			try {
				baxxResult = basicDataContainerService.getBaxxData(companyName);
				if(baxxResult!=null)
				{
					map = basicDataContainerService.handleBaxxResultJson(baxxResult);
					redisDAO.addString(glcqk_key, baxxResult.toString(), Constants.cacheDay);
				}
			} catch (Exception e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}

		}
		return map;
	}


	public String companyDataStatistics(String companyName)
	{

		String cds_key = companyName + APIConstants.redis_cds + "-" + companyName;
		String cds_value = redisDAO.getString(cds_key);
		if(cds_value!=null)
		{
			return cds_value;
		}else
		{
			BasicDataVO basicData = queryBasicData(companyName);
			String capital = basicData.getEnterpriseData().getCapital();
			String registStatus = basicData.getEnterpriseData().getRegistStatus();
			CompanyDataStatisticsVO companyDataStatistics = new CompanyDataStatisticsVO();
			companyDataStatistics.setCapital(capital);
			companyDataStatistics.setRegistation(registStatus);
			List<ShareholderDataVO> shareholderDatas = basicData.getShareholderDatas();
			int naturalPersonShareholders = 0;
			int legalPersonShareholders = 0;
			for(ShareholderDataVO shareholderData :shareholderDatas)
			{
				if("自然人股东".equals(shareholderData.getShareholderType()))
				{
					++naturalPersonShareholders;
				}else
				{
					++legalPersonShareholders;
				}
			}
			companyDataStatistics.setNaturalPersonShareholders(naturalPersonShareholders +"");
			companyDataStatistics.setLegalPersonShareholders(legalPersonShareholders+"");
			String cdsJson = JSONObject.fromObject(companyDataStatistics).toString();
			redisDAO.addString(cds_key, cdsJson, Constants.cacheDay);
			return cdsJson;
		}

	}

	@SuppressWarnings("rawtypes")
	public RelatedCompanyVO queryrelatedCompanyData(String companyName) {
		RelatedCompanyVO relatedCompany = new RelatedCompanyVO();
		BasicDataVO basicData = new BasicDataVO();
		EnterpriseDataVO enterpriseData = this.get_gszczl_Data(companyName);
		basicData.setEnterpriseData(enterpriseData);
		List<ShareholderDataVO> shareholderDatas =  this.get_gdxx_Data(companyName);
		basicData.setShareholderDatas(shareholderDatas);
		Map<String, List<ManagementInfoVO>> map = this.get_glcqk_Data(companyName);
		List<ManagementInfoVO> dsvo = new ArrayList<ManagementInfoVO>();
		List<ManagementInfoVO> jsvo = new ArrayList<ManagementInfoVO>();
		List<ManagementInfoVO> jlvo = new ArrayList<ManagementInfoVO>();
		// 董事VO
		dsvo =  map.get("dsvo");
		// 监事VO
		jsvo = map.get("jsvo");
		// 高级管理人员VO
		jlvo = map.get("jlvo");
		basicData.setDsvo(dsvo);
		basicData.setJsvo(jsvo);
		basicData.setJlvo(jlvo);
		relatedCompany.setBasicData(basicData);                                                     
		Map<String, List> resultList = new HashMap<String, List>();
		int lawsuitCount = 0;
		try {
			resultList = lawsuitRecordService.getLawsuitRecord(companyName, true, false, false,false);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		if(resultList.get("ssjl")!=null)
		{
			lawsuitCount = resultList.get("ssjl").size();
		}
		relatedCompany.setLawsuitCount(lawsuitCount);
		relatedCompany.setBuyFlag(true);

		return relatedCompany;
	}
	
}
