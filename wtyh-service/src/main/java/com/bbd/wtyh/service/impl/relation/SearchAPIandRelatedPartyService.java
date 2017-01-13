package com.bbd.wtyh.service.impl.relation;


import com.bbd.wtyh.util.relation.ListUtils;
import com.bbd.wtyh.web.relationVO.CompanyDataStatisticsVO;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchAPIandRelatedPartyService {
	
	@Resource 
    private BasicDataService basicDataService;

	/**
	 * 动态关联方 目标公司数据基本信息
	 * 
	 * @param origCompanyName
	 * @param tarCompanyName
	 * @param lineList
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public CompanyDataStatisticsVO relatedPartyStatistics(String origCompanyName, String tarCompanyName, List lineList) throws Exception {
		CompanyDataStatisticsVO vo = new CompanyDataStatisticsVO();
		String data = basicDataService.companyDataStatistics(tarCompanyName);
		JSONObject json = JSONObject.fromObject(data);
		vo = (CompanyDataStatisticsVO) JSONObject.toBean(json, CompanyDataStatisticsVO.class);
		vo.setSubsidiarys(this.statisticsData(lineList, origCompanyName).get(SUB_COMPANY));
		vo.setNaturalPersonNode(this.statisticsData(lineList, origCompanyName).get(NATURE_PERSON));
		vo.setLegalPersonNodes(this.statisticsData(lineList, origCompanyName).get(LEGAL_PERSON));
		
		return vo;
	}
	
	private static final String LEGAL_PERSON = "LEGAL_PERSON"; // 法人
	private static final String NATURE_PERSON = "NATURE_PERSON"; // 自然人
	private static final String SUB_COMPANY = "SUB_COMPANY"; // 子公司
	
	/**
	 * 统计数据
	 * 
	 * @param lineList
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Map<String, String> statisticsData(List lineList, String companyName) {
		Map<String, String> map = new HashMap<String, String>();
		Integer legalPerson = 0;
		Integer naturePerson = 0;
		Integer subCompany = 0;
		if (ListUtils.isNotEmpty(lineList)) {
			for (Object obj : lineList) {
				RelationDiagramVO.LineVO vo = (RelationDiagramVO.LineVO) obj;
				if (null != vo) {
					if (vo.getType().contains("法人")) {
						legalPerson++;
					}
					if (vo.getType().contains("自然人")) {
						naturePerson++;
					}
					if (vo.getOrig().equals(companyName) && "1".equals(vo.getTarLevel())) {
						subCompany++;
					}
				}
			}
			map.put(LEGAL_PERSON, legalPerson.toString());
			map.put(NATURE_PERSON, naturePerson.toString());
			map.put(SUB_COMPANY, subCompany.toString());
		}
		return map;
	}

}
