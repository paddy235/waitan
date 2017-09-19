package com.bbd.wtyh.service.impl.relation;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.common.relation.APIConstants;
import com.bbd.wtyh.dao.P2PImageDao;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.service.RelationDataService;
import com.bbd.wtyh.util.relation.StringUtils;
import com.bbd.wtyh.web.relationVO.EnterpriseDataVO;
import com.bbd.wtyh.web.relationVO.ManagementInfoVO;
import com.bbd.wtyh.web.relationVO.ShareholderDataVO;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component("basicDataContainerService")
public class BasicDataContainerService extends ApiContainerService{
	
	private static Logger log = LoggerFactory.getLogger(BasicDataContainerService.class);

	@Autowired
	private P2PImageDao p2PImageDao;
	@Autowired
	private RelationDataService relationDataService;
	
	public EnterpriseDataVO getEnterpriseData(String companyName) throws Exception{
		EnterpriseDataVO enterpriseData = new EnterpriseDataVO();
		BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(companyName, null);

		if (baseDataDO != null) {
			List<BaseDataDO.Results> results = baseDataDO.getResults();
			if (!CollectionUtils.isEmpty(results)) {
				BaseDataDO.Jbxx jbxx = results.get(0).getJbxx();
				if (jbxx != null) {
					enterpriseData.setRegistId(jbxx.getRegno());
					enterpriseData.setName(jbxx.getCompany_name());
					enterpriseData.setType(jbxx.getCompany_type());
					enterpriseData.setRepresentative(jbxx.getFrname());
					enterpriseData.setCapital(jbxx.getRegcap());
					enterpriseData.setBuildDate(jbxx.getEsdate());
					enterpriseData.setPosition(jbxx.getAddress());
					enterpriseData.setOperatorPeriodStart(jbxx.getOpenfrom());
					enterpriseData.setOperatorPeriodEnd(jbxx.getOpento());
					enterpriseData.setBusinessScope(jbxx.getOperate_scope());
					enterpriseData.setRegistation(jbxx.getRegorg());
					enterpriseData.setApproveDate(jbxx.getApproval_date());
					enterpriseData.setRegistStatus(jbxx.getEnterprise_status());
				}
			}
		}

		return enterpriseData;
	}

	public JSONArray getBaxxData(String companyName)throws Exception {
		JSONArray baxxResult = null;
		BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(companyName, null);
		if (baseDataDO != null) {
			List<BaseDataDO.Results> results = baseDataDO.getResults();
			if (!CollectionUtils.isEmpty(results)) {
				List<BaseDataDO.Baxx> jbxx = results.get(0).getBaxx();
				baxxResult = JSONArray.fromObject(jbxx);
			}
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

		BaseDataDO baseDataDO = p2PImageDao.baseInfoBBDData(companyName, null);
		if (baseDataDO != null) {
			List<BaseDataDO.Results> results = baseDataDO.getResults();
			if (!CollectionUtils.isEmpty(results)) {
				List<BaseDataDO.Gdxx> gdxxList = results.get(0).getGdxx();
				if (!CollectionUtils.isEmpty(gdxxList)) {
					for (BaseDataDO.Gdxx gdxx : gdxxList) {
						ShareholderDataVO shareholderDataVO = new ShareholderDataVO();
						shareholderDataVO.setShareholderName(gdxx.getShareholder_name());
						shareholderDataVO.setShareholderType(gdxx.getShareholder_type());
						shareholderDatas.add(shareholderDataVO);
					}
				}
			}
		}

		return shareholderDatas;
	}
}
