package com.bbd.bgo.web.controller;

import com.bbd.bgo.service.task.PlatUpdateTaskService;
import com.bbd.bgo.service.task.SystemDataUpdateService;
import com.bbd.wtyh.service.RelationDataService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 数据同步
 * 
 * @author tracy zhou
 * @since 2016/8/20
 */
@Controller
@RequestMapping("/syncData/")
public class SyncDataController {

	// @Autowired
	// private SyncDataService syncDataService;
	@Autowired
	private RelationDataService relationDataService;

	@RequestMapping(value = "receiveFileData.do")
	@ResponseBody
	public ResponseBean receiveFileData(MultipartFile file) {
		// try {
		// syncDataService.receiveFileData(file);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return ResponseBean.successResponse("写入成功");
	}

	@RequestMapping(value = "getNewestDataVersion.do")
	@ResponseBody
	public String getNewestDataVersion() {
		return relationDataService.getNewestDataVersion();
	}

	@Autowired
	private SystemDataUpdateService systemDataUpdateService;

	@RequestMapping("systemDataUpdateService.do")
	@ResponseBody
	public ResponseBean systemDataUpdateServiceDo() {
		systemDataUpdateService.updateCompanyTableAreaIdAndAddress();
		return ResponseBean.successResponse("运行成功！");
	}
	@Autowired
	private PlatUpdateTaskService platUpdateTaskService;

	@RequestMapping("platUpdateServiceDo.do")
	@ResponseBody
	public ResponseBean platUpdateServiceDo() {
		platUpdateTaskService.updatePlat();
		return ResponseBean.successResponse("运行成功！");
	}
}
