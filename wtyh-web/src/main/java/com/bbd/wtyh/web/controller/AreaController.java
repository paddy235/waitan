package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		//产品提出要排序，不读库的方式，写死
		List<String> list = Lists.newArrayList("浦东新区","黄浦区","静安区","徐汇区",
												"长宁区","普陀区","虹口区","杨浦区",
												"宝山区","闵行区","嘉定区","金山区",
												"松江区","青浦区","奉贤区","崇明县");
		return ResponseBean.successResponse(list);
	}

}
