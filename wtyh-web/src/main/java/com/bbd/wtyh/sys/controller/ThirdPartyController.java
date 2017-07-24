package com.bbd.wtyh.sys.controller;

import com.bbd.wtyh.service.LogInfoService;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.web.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * 日志信息维护
 * 
 * @author sunliming
 * @since 2017/03/20
 */
@RestController
@RequestMapping("/third-party")
public class ThirdPartyController {

	@Autowired
	private LogInfoService logInfoService;
	private Logger logger = LoggerFactory.getLogger(ThirdPartyController.class);

	@RequestMapping("/exportLogFile")
	@ResponseBody
	public Long exportLogFile(@RequestParam String date, @RequestParam Long counts, HttpSession session) {
		logger.info("日志文件处理(exportLogFile.do)开始");
		Long tempCounts = (null == counts) ? new Long(1L) : counts;
		Long result = logInfoService.exportLogFileToDataBase(date, tempCounts);
		logger.info("日志文件处理(exportLogFile.do)结束");
		return result;
	}

	@RequestMapping("/get-ip")
	@ResponseBody
	public Object test() {
		try {
			InetAddress addr = Inet4Address.getLocalHost();
			Map<String, Object> map = new HashMap<>();
			map.put("ip", addr.getHostAddress());
			map.put("host", addr.getHostName());
			return ResponseBean.successResponse(map);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ResponseBean.successResponse(null);
	}

}
