package com.bbd.bgo.web.controller;

import java.util.Set;

import com.bbd.wtyh.service.DistrictCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bbd.wtyh.web.ResponseBean;

/**
 * Created by cgj on 2017/8/1.
 */
@Controller
@RequestMapping("/DistrictCode")
public class DistrictCodeController {

	@Autowired
	private DistrictCodeService districtCodeService;

	@RequestMapping("/import.do")
	@ResponseBody
	public Object flushAll() {
		return ResponseBean.successResponse( districtCodeService.ImportDistrictCode() );
	}

}
