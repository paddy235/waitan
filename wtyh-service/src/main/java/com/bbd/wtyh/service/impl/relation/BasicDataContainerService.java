package com.bbd.wtyh.service.impl.relation;

import com.bbd.wtyh.common.relation.APIConstants;
import com.bbd.wtyh.common.relation.Constants;
import com.bbd.wtyh.util.relation.StringUtils;
import com.bbd.wtyh.web.relationVO.EnterpriseDataVO;
import com.bbd.wtyh.web.relationVO.ManagementInfoVO;
import com.bbd.wtyh.web.relationVO.ShareholderDataVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component("basicDataContainerService")
public class BasicDataContainerService extends ApiContainerService{
	
	private static Logger log = LoggerFactory.getLogger(BasicDataContainerService.class);
	
	@Value("${" + Constants.SEARCH_API_COMPANY_URL + "}")
	private String url;
	
	public EnterpriseDataVO getEnterpriseData(String companyName) throws Exception{
		EnterpriseDataVO enterpriseData = new EnterpriseDataVO();
		String  [] params = new String [] {"注册号","名称","类型","法定代表人","注册资本","成立日期",
				"住所","营业期限自","营业期限至","经营范围","登记机关","核准日期","登记状态"};
		String enterpriseDataJson = apiContainerServicePost(url, APIConstants.COMPANYINFO_QYXX, companyName,
				APIConstants.FIELD_NAME,APIConstants.SEARCHTYPE_DETAIL,Constants.DATA_VERSION
				,params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8],params[9],params[10],params[11],params[12]);
		log.info(companyName + "API接口 工商s基本资料返回数据为：" + enterpriseDataJson);
		if(!StringUtils.isNotNullOrEmpty(enterpriseDataJson))
		{
			throw new Exception("API 工商基本资料请求超时 ，返回数据为空");
		}
		if(!checkData(enterpriseDataJson))
		{
			throw new Exception("API 工商基本资料请求数据异常");
		}
		String enterpriseData_rdata = getRdata(enterpriseDataJson);
		log.info(companyName + "工商基本资料 取得RDATA数据为：" + enterpriseData_rdata);
		if(enterpriseData_rdata==null)
		{
			JSONObject jsonObject = JSONObject.fromObject(enterpriseData);
			enterpriseData =  (EnterpriseDataVO) JSONObject.toBean(jsonObject, EnterpriseDataVO.class);
			return enterpriseData;
		}
		String enterpriseData_result = translateJsonKey(enterpriseData_rdata,APIConstants.EnterpriseDataMap);
		JSONObject jsonObject = JSONArray.fromObject(enterpriseData_result).getJSONObject(0);
		enterpriseData =  (EnterpriseDataVO) JSONObject.toBean(jsonObject, EnterpriseDataVO.class);
		return enterpriseData;
	}

	public JSONArray getBaxxData(String companyName)throws Exception {
		JSONArray baxxResult = null;
		String baxxJson = apiContainerServicePost(url, APIConstants.COMPANYINFO_QYXX, companyName,
				APIConstants.FIELD_NAME, APIConstants.SEARCHTYPE_DETAIL,Constants.DATA_VERSION, "baxx");
		log.info(companyName + "API接口 备案信息返回数据为：" + baxxJson);
		if(!StringUtils.isNotNullOrEmpty(baxxJson))
		{
			throw new Exception("API 备案信息请求超时 ，返回数据为空");
		}
		if(!checkData(baxxJson))
		{
			throw new Exception("API 备案信息 请求数据异常");
		}
		String baxx_rdata = getRdata(baxxJson);
		log.info(companyName + "备案信息 取得RDATA数据为：" + baxx_rdata);
		if(baxx_rdata==null)
		{
			return null;
		}
		String baxx_result = translateJsonKey(baxx_rdata,APIConstants.ManangementInfoDataMap);
		JSONArray jsonArray = JSONArray.fromObject(baxx_result);
		if (jsonArray.size() > 0) {
			baxxResult = JSONArray.fromObject(JSONObject.fromObject(jsonArray.get(0)).get("baxx"));
		}
			
		return baxxResult;
	}
	
	/**
	 * 管理信息---处理baxx详细的信息结果，（通用方法，API取出时使用，Redis取出json时直接使用这一部分）
	 * 
	 * @param baxxResult
	 * @return
	 */
	public Map<String, List<ManagementInfoVO> > handleBaxxResultJson(JSONArray baxxResult) {
		Map<String, List<ManagementInfoVO>> result = new HashMap<String, List<ManagementInfoVO>>();
		// 董事VO
		List<ManagementInfoVO> dsvo = new ArrayList<ManagementInfoVO>();
		// 监事VO
		List<ManagementInfoVO> jsvo = new ArrayList<ManagementInfoVO>();
		// 高级管理人员VO
		List<ManagementInfoVO> jlvo = new ArrayList<ManagementInfoVO>();
		for (Object object : baxxResult) {
			// {"姓名":"林炳添","职务":"监事"}
			JSONObject info = JSONObject.fromObject(object);
			if(!info.containsKey("job"))
			{
				continue;
			}else
			{
				String job = info.get("job").toString();
				if (job.contains("董事")||job.contains("股东"))
					dsvo.add((ManagementInfoVO) JSONObject.toBean(info, ManagementInfoVO.class));
				if (job.contains("监事"))
					jsvo.add((ManagementInfoVO) JSONObject.toBean(info, ManagementInfoVO.class));
				if (job.contains("经理")||job.contains("其他")||job.contains("负责人")||job.contains("代表"))
					jlvo.add((ManagementInfoVO) JSONObject.toBean(info, ManagementInfoVO.class));
			}
		}
		result.put("dsvo", dsvo);
		result.put("jsvo", jsvo);
		result.put("jlvo", jlvo);

		return result;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ShareholderDataVO> getShareholderData(String companyName) throws Exception {
		List<ShareholderDataVO> shareholderDatas = new ArrayList<ShareholderDataVO>();
		String shareholderJson = apiContainerServicePost(url, APIConstants.COMPANYINFO_QYXX, companyName,
				APIConstants.FIELD_NAME, APIConstants.SEARCHTYPE_DETAIL,Constants.DATA_VERSION, "gdxx");
		log.info(companyName + "API接口 股东信息返回数据为：" + shareholderJson);
		if(!StringUtils.isNotNullOrEmpty(shareholderJson))
		{
			throw new Exception("API 股东信息请求超时 ，返回数据为空");
		}
		if(!checkData(shareholderJson))
		{
			throw new Exception("API 股东信息请求数据异常");
		}
		String shareholder_rdata = getRdata(shareholderJson);
		log.info(companyName + "股东信息 取得RDATA数据为：" + shareholder_rdata);
		if(shareholder_rdata==null)
		{
			return shareholderDatas;
		}
		String shareholder_result = translateJsonKey(shareholder_rdata,APIConstants.ShareholderDataMap);
		JSONArray jsonArray = JSONArray.fromObject(shareholder_result).getJSONObject(0).getJSONArray("gdxx");
		shareholderDatas =  JSONArray.toList(jsonArray, ShareholderDataVO.class);
		return shareholderDatas;
	}
}
