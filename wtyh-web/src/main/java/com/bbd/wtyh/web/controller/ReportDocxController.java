package com.bbd.wtyh.web.controller;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.report.service.WordReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.web.ResponseBean;

import javax.servlet.http.HttpServletRequest;

/**
 * word报告文档导出
 *  Created by cgj on 2017-5-25
 */
@Controller
@RequestMapping("/reportDocx/")
public class ReportDocxController {
	
	@Autowired
	private WordReportService wordReportService;


	@RequestMapping( value = "download.do" )
	@ResponseBody
	public Object downloadFile(HttpServletRequest request,
                               @RequestParam String companyName )  {
        //Subject currentUser = SecurityUtils.getSubject(); currentUser.getSession().getAttribute(Constants.SESSION.loginName);
		try {
		    String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
		    String areaCode = (String) request.getSession().getAttribute("area");
			Map<String, Object> rstMap = wordReportService.reportExport(companyName, loginName, areaCode);
			HttpHeaders headers = new HttpHeaders();
			String downloadFilename = new String(((String) rstMap.get("fileName")).getBytes("UTF-8"),
					"iso-8859-1");
			headers.setContentDispositionFormData("attachment", downloadFilename);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return  new ResponseEntity( rstMap.get("fileBytes"), headers, HttpStatus.CREATED ) ; /*ResponseEntity<byte[]>*/
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常！");
		}
	}

	@RequestMapping( value = "test.do" )
	@ResponseBody
	public ResponseBean getAreaByParentId() {
		//InputStream aa = WordReportService.class.getResourceAsStream("/docx/template/shanghai-company-anti-fraud-template.docx");
		URL aaa = WordReportService.class.getResource("/docx/template/shanghai-company-anti-fraud-template1.docx");
		//byte [] te = new byte[100];
		/*try {
			int aar = aa.read(te);
			aar ++;
		} catch (Exception e) {}*/
		return ResponseBean.successResponse(null);
	}

}
