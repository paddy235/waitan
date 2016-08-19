package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.SysAnalyzeDO;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.SysAnalyzeService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.resources.CollationData_en;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 地区相关接口
 */
@Controller
@RequestMapping("/area/")
public class AreaController {
	
	@Autowired
	private AreaService areaService;

	/**
	 * 获取父节点下面的数据
	 * 比如属于上海市的所有区 parentId:104
	 * @param areaId
	 * @return
     */
	@RequestMapping(value = "getAreaByParentId.do")
	@ResponseBody
	public ResponseBean getAreaByParentId(Integer areaId) {
		List<AreaDO> list = areaService.selectByParentId(areaId);
		Set<String> areaSet = new LinkedHashSet<>();
		if (!CollectionUtils.isEmpty(list)) {
			for (AreaDO areaDO : list) {
				areaSet.add(areaDO.getName());
			}
		}
		return ResponseBean.successResponse(areaSet);
	}

}
