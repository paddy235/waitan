package com.bbd.bgo.web.controller;

import java.util.Set;

import com.bbd.wtyh.service.DistrictCodeService;
import com.bbd.wtyh.service.impl.DistrictCodeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger log = LoggerFactory.getLogger(DistrictCodeController.class);

	@Autowired
	private DistrictCodeService districtCodeService;

	@RequestMapping("/import.do")
	@ResponseBody
	public Object importCode() {
		try {
			return ResponseBean.successResponse( districtCodeService.ImportDistrictCode() );
		} catch (Exception e) {
			log.error( e.getMessage() );
			return ResponseBean.errorResponse("服务器内部错误。");
		}
	}

}
