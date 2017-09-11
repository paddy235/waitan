package com.bbd.wtyh.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.excel.utils.ExportExcelUtil;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.report.service.WordReportService;
import com.bbd.wtyh.sys.controller.DownloadController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import javax.servlet.http.HttpServletResponse;

/**
 * word报告文档导出
 *  Created by cgj on 2017-5-25
 */
@Controller
@RequestMapping("/reportDocx/")
public class ReportDocxController {
	
	@Autowired
	private WordReportService wordReportService;

	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadController.class);

	//  这个代码不能支持IE浏览器的下载，火狐或谷歌下工作正常
	@LogRecord(logMsg = "导出“%s”的企业全息报告", params = {"companyName"}, page = Operation.Page.hologram,
			type = Operation.Type.REPORT_EXPORT, after = true, before = false)
	@RequestMapping( value = "download-noIE.do" )
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
			return  new ResponseEntity( rstMap.get("fileBytes"), headers, HttpStatus.CREATED ) ;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseBean.errorResponse("服务器异常！");
		}
	}

	@LogRecord(logMsg = "导出“%s”的企业全息报告", params = {"companyName"}, page = Operation.Page.hologram,
			type = Operation.Type.REPORT_EXPORT, after = true, before = false)
	@RequestMapping( value = "download.do" )
	public void downloadFile(HttpServletRequest request,
							   HttpServletResponse response,
							   @RequestParam String companyName )  {
		OutputStream out = null;
		try {
			String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
			String areaCode = (String) request.getSession().getAttribute("area");
			Map<String, Object> rstMap = wordReportService.reportExport(companyName, loginName, areaCode);

			companyName =(String) rstMap.get("fileName");
			response.setCharacterEncoding("UTF-8");
			String userAgent = request.getHeader("User-Agent");
			String filename;
			if (userAgent.toUpperCase().contains("MSIE")) {
				filename = new String(companyName.getBytes("GBK"), "ISO-8859-1");
			} else {
				filename = new String(companyName.getBytes("UTF-8"), "ISO-8859-1");
			}
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
			byte[] fileBytes =(byte[]) rstMap.get("fileBytes");
			out = response.getOutputStream();
			out.write(fileBytes, 0, fileBytes.length);
		} catch (Exception e) {
			LOGGER.error("导出文件【{}】失败：服务器报错!{}", companyName, e);
		} finally {
			try {
				if( null != out ) {
					out.close();
				}

			} catch (Exception e) {}
		}
	}

	@LogRecord(logMsg = "导出“%s”的企业全息报告", params = {"companyName"}, page = Operation.Page.hologram,
			type = Operation.Type.REPORT_EXPORT, after = true, before = false)
	@RequestMapping( value = "get-file-url.do" )
	@ResponseBody
	public Object getFileUrl(HttpServletRequest request,
							 HttpServletResponse response,
							 @RequestParam String companyName )  {
		FileOutputStream outputStream = null;
		ResponseBean responseBean;
		try {
			String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
			String areaCode = (String) request.getSession().getAttribute("area");
			Map<String, Object> rstMap = wordReportService.reportExport(companyName, loginName, areaCode);

			companyName =(String) rstMap.get("fileName");
			String path = ExportExcelUtil.dealWithExportPath(null);
			File directory = new File( path );
			directory.mkdirs();
			File file = new File(path + companyName);
			file.createNewFile();
			outputStream = new FileOutputStream(file);
			byte[] fileBytes =(byte[]) rstMap.get("fileBytes");
			outputStream.write(fileBytes);
			String url ="/download/download-excel.do?name=" +URLEncoder.encode(companyName, "UTF-8");
			responseBean = ResponseBean.successResponse ( url );
		} catch (Exception e) {
			LOGGER.error("导出文件【{}】失败：服务器报错!{}", companyName, e);
			responseBean = ResponseBean.errorResponse("error.");
		} finally {
			try {
				if( null != outputStream ) {
					outputStream.close();
				}
			} catch (Exception e) {}
		}
		return	responseBean;
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
		return ResponseBean.successResponse("test is ok.");
	}

}
