package com.bbd.wtyh.util;

import com.bbd.wtyh.domain.vo.DynamicRiskIndexVO;
import com.bbd.wtyh.domain.vo.RelationDataIndexVO;
import com.bbd.wtyh.domain.vo.RelationDataVO;
import org.springframework.util.CollectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelationDataUtils {

	/**
	 * 组装关联方比较结果
	 * @param current
	 * @param compare
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static RelationDataVO compareRelationData(RelationDataIndexVO current , RelationDataIndexVO compare) throws UnsupportedEncodingException{
		RelationDataVO vo = new RelationDataVO();

		if (current == null || compare == null) {
			return vo;
		}
		vo.setCrtRelationPersonNum(current.getRelationPersonNum());
		vo.setCpeRelationPersonNum(compare.getRelationPersonNum());
		
		vo.setCrtCompanyPersonNum(current.getCompanyPersonNum());
		vo.setCpeCompanyPersonNum(compare.getCompanyPersonNum());
		
		vo.setCrtChildCompanyNum(current.getChildCompanyNum());
		vo.setCpeChildCompanyNum(compare.getChildCompanyNum());
		
		vo.setCrtOnePersonNum(current.getOnePersonNum());
		vo.setCpeOnePersonNum(compare.getOnePersonNum());
		
		vo.setCrtOneCompanyNum(current.getOneCompanyNum());
		vo.setCpeOneCompanyNum(compare.getOneCompanyNum());
		
		vo.setCrtTwoPersonNum(current.getTwoPersonNum());
		vo.setCpeTwoPersonNum(compare.getTwoPersonNum());
		
		vo.setCrtTwoCompanyNum(current.getTwoCompanyNum());
		vo.setCpeTwoCompanyNum(compare.getTwoCompanyNum());
		
		vo.setCrtThreePersonNum(current.getThreePersonNum());
		vo.setCpeThreePersonNum(compare.getThreePersonNum());
		
		vo.setCrtThreeCompanyNum(current.getThreeCompanyNum());
		vo.setCpeThreeCompanyNum(compare.getThreeCompanyNum());
		
		//比较两个月份子公司明细（子公司增加数量，子公司减少数量）
		String crtChildCompanyDetail = current.getChildCompanyDetail();
		String[] crtChildCompanyDetailList = crtChildCompanyDetail.split("\\|");
		String cpeChildCompanyDetail = compare.getChildCompanyDetail();
		String[] cpeChildCompanyDetailList = cpeChildCompanyDetail.split("\\|");
		Map<String ,List<String>> map0 =  compare(crtChildCompanyDetailList,cpeChildCompanyDetailList);
		vo.setAddChildCompany(map0.get("add"));
		vo.setDecreaseChildCompany(map0.get("decrease"));
		
		//比较两个月一度法人明细(一度法人增加明细，一度法人减少明细)
		String crtOneCompanyDetail = current.getOneCompanyDetail();
		String[] crtOneCompanyDetailList = crtOneCompanyDetail.split("\\|");
		String cpeOneCompanyDetail = compare.getOneCompanyDetail();
		String[] cpeOneCompanyDetailList = cpeOneCompanyDetail.split("\\|");
		Map<String ,List<String>> map1 =  compare(crtOneCompanyDetailList,cpeOneCompanyDetailList);
		vo.setAddOneCompany(map1.get("add"));
		vo.setDecreaseOneCompany(map1.get("decrease"));
		
		//比较两个月二度法人明细(二度法人增加明细，二度法人减少明细)
		String crtTwoCompanyDetail = current.getTwoCompanyDetail();
		String[] crtTwoCompanyDetailList = crtTwoCompanyDetail.split("\\|");
		String cpeTwoCompanyDetail = compare.getTwoCompanyDetail();
		String[] cpeTwoCompanyDetailList = cpeTwoCompanyDetail.split("\\|");
		Map<String ,List<String>> map2 =  compare(crtTwoCompanyDetailList,cpeTwoCompanyDetailList);
		vo.setAddTwoCompany(map2.get("add"));
		vo.setDecreaseTwoCompany(map2.get("decrease"));
		
		//比较两个月三度法人明细(三度法人增加明细，三度法人减少明细)
		String crtThreeCompanyDetail = current.getThreeCompanyDetail();
		String[] crtThreeCompanyDetailList = crtThreeCompanyDetail.split("\\|");
		String cpeThreeCompanyDetail = compare.getThreeCompanyDetail();
		String[] cpeThreeCompanyDetailList = cpeThreeCompanyDetail.split("\\|");
		Map<String ,List<String>> map3 =  compare(crtThreeCompanyDetailList,cpeThreeCompanyDetailList);
		vo.setAddThreeCompany(map3.get("add"));
		vo.setDecreaseThreeCompany(map3.get("decrease"));
		
		//比较两个月一度自然人明细(一度自然人增加明细，一度自然人减少明细)
		String crtOnePersonDetail = current.getOnePersonDetail();
		String[] crtOnePersonDetailList = crtOnePersonDetail.split("\\|");
		String cpeOnePersonDetail = compare.getOnePersonDetail();
		String[] cpeOnePersonDetailList = cpeOnePersonDetail.split("\\|");
		Map<String ,List<String>> map4 =  compare(crtOnePersonDetailList,cpeOnePersonDetailList);
		vo.setAddOnePerson(map4.get("add"));
		vo.setDecreaseOnePerson(map4.get("decrease"));
		
		//比较两个月二度自然人明细(二度自然人增加明细，二度自然人减少明细)
		String crtTwoPersonDetail = current.getTwoPersonDetail();
		String[] crtTwoPersonDetailList = crtTwoPersonDetail.split("\\|");
		String cpeTwoPersonDetail = compare.getTwoPersonDetail();
		String[] cpeTwoPersonDetailList = cpeTwoPersonDetail.split("\\|");
		Map<String ,List<String>> map5 =  compare(crtTwoPersonDetailList,cpeTwoPersonDetailList);
		vo.setAddTwoPerson(map5.get("add"));
		vo.setDecreaseTwoPerson(map5.get("decrease"));

		//比较两个月三度自然人明细(三度自然人增加明细，三度自然人减少明细)
		String crtThreePersonDetail = current.getThreePersonDetail();
		String[] crtThreePersonDetailList = crtThreePersonDetail.split("\\|");
		String cpeThreePersonDetail = compare.getThreePersonDetail();
		String[] cpeThreePersonDetailList = cpeThreePersonDetail.split("\\|");
		Map<String ,List<String>> map6 =  compare(crtThreePersonDetailList,cpeThreePersonDetailList);
		vo.setAddThreePerson(map6.get("add"));
		vo.setDecreaseThreePerson(map6.get("decrease"));
		
		//关联方增加自然人(将一二三度自然人增加总数相加)
		List<String> arp = new ArrayList<String>();
		arp.addAll(map6.get("add"));
		arp.addAll(map5.get("add"));
		arp.addAll(map4.get("add"));
		arp = dealStringList(arp);
		vo.setAddRelationPerson(arp);
		
		//关联方减少自然人(将一二三度自然人减少总数相加)
		List<String> drp = new ArrayList<String>();
		drp.addAll(map6.get("decrease"));
		drp.addAll(map5.get("decrease"));
		drp.addAll(map4.get("decrease"));
		drp = dealStringList(drp);
		vo.setDecreaseRelationPerson(drp);
		
		//关联方增加法人(将一二三度法人增加总数相加)
		List<String> acp = new ArrayList<String>();
		acp.addAll(map3.get("add"));
		acp.addAll(map2.get("add"));
		acp.addAll(map1.get("add"));
		acp = dealStringList(acp);
		vo.setAddCompanyPerson(acp);
		
		//关联方减少法人(将一二三度法人减少总数相加)
		List<String> dcp = new ArrayList<String>();
		dcp.addAll(map3.get("decrease"));
		dcp.addAll(map2.get("decrease"));
		dcp.addAll(map1.get("decrease"));
		dcp = dealStringList(dcp);
		vo.setDecreaseCompanyPerson(dcp);
		
		return vo;
	}
	
	private static final String EMPTY = "无";
	
	private static List<String> dealStringList(List<String> list) {
		if (!CollectionUtils.isEmpty(list)) {
			boolean isNone = true;
			for (String s : list) {
				if (!EMPTY.equals(s)) {
					isNone = false;
				}
			}
			if (!isNone) {
				/* 清除集合中的“无” */
				List<String> newList = new ArrayList<>();
				for (String s : list) {
					if (!EMPTY.equals(s)) {
						newList.add(s);
					}
				}
				return newList;
			} else {
				/* 保留一个“无” */
				list.clear();
				list.add(EMPTY);
			}
		}
		return list;
	}
	
	/**
	 * 提取比较增加或减少的公共方法
	 * @param compare_1
	 * @param compare_2
	 * @return
	 */
	public static Map<String ,List<String>> compare(String[] compare_1,String[] compare_2 )
	{
		Map<String,String> map1 = new HashMap<String,String>();
		Map<String,String> map2 = new HashMap<String,String>();
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> add = new ArrayList<String>();
		List<String> decrease = new ArrayList<String>();
		for(int i=0;i<compare_1.length;i++)
		{
			map1.put(compare_1[i], null);
		}
		for(int i=0;i<compare_2.length;i++)
		{
			map2.put(compare_2[i], null);
		}
		for(int i=0;i<compare_1.length;i++)
		{
			if(!map2.containsKey(compare_1[i]))
			{
				decrease.add(compare_1[i]);
			}
		}
		for(int i=0;i<compare_2.length;i++)
		{
			if(!map1.containsKey(compare_2[i]))
			{
				add.add(compare_2[i]);
			}
		}
		map.put("add", add);
		map.put("decrease", decrease);
		return map;
	
	}

	/**
	 * 比较利益一致行动法人
	 * @param vo
	 * @param current
	 * @param compare
	 * @return
	 */
	public static RelationDataVO addAgreeActionProp(RelationDataVO vo, DynamicRiskIndexVO current, DynamicRiskIndexVO compare) {
		if (current == null || compare == null) {
			return vo;
		}
		vo.setCrtAgreeActNum(current.getAgreeActNum());
		vo.setCpeAgreeActNum(compare.getAgreeActNum());
		String crtAgreeComDet = current.getAgreeComDet();
		String[] crtAgreeComDetList = crtAgreeComDet.split("\\|");
		String cpeAgreeComDet = compare.getAgreeComDet();
		String[] cpeAgreeComDetList = cpeAgreeComDet.split("\\|");
		Map<String ,List<String>> map =  compare(crtAgreeComDetList,cpeAgreeComDetList);
		vo.setAddAgreeComDet(map.get("add"));
		vo.setDecreaseAgreeComDet(map.get("decrease"));
		return vo;
	}

}
