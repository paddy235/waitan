package com.bbd.bgo.web.controller;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbd.wtyh.excel.utils.ExportExcelUtil;

/**
 * 下载
 *
 * @author Created by LiYao on 2017-04-17 14:11.
 */
@Controller
@RequestMapping("/download")
public class DownloadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadController.class);

	@RequestMapping("/download-excel")
	public void downloadExcel(@RequestParam String name, HttpServletResponse response) {
		String path = ExportExcelUtil.dealWithExportPath("");

		InputStream in = null;
		OutputStream out = null;
		File file = null;
		try {
			name = URLDecoder.decode(name, "UTF-8");

			file = new File(path + name);

			response.setCharacterEncoding("UTF-8");

			if (!file.exists()) {
				out = response.getOutputStream();
				out.write("导出文件失败!".getBytes("GB2312"));
				LOGGER.error("导出文件【{}】失败：文件不存在", name);
				return;
			}
			String filename = new String(name.getBytes("GB2312"), "ISO-8859-1");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

			in = new FileInputStream(file);
			out = response.getOutputStream();
			byte[] b = new byte[1024 * 10];
			int length;
			while ((length = in.read(b)) > 0) {
				out.write(b, 0, length);
			}

		} catch (IOException e) {
			LOGGER.error("导出文件【{}】失败：服务器报错!{}", name, e);
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				// e.printStackTrace();
			}
			if (file != null) {
				file.delete();
			}
		}

	}

}
