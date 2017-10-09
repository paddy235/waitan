package com.bbd.wtyh.web.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbd.wtyh.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.domain.third.yuqing.ImportRecordDO;
import com.bbd.wtyh.service.third.yuqing.ThirdYuQingService;
import com.bbd.wtyh.web.ResponseBean;

/**
 * 第三方舆情，前台接口
 *
 * @author Created by LiYao on 2017-10-09 9:19.
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/third-yuqing")
public class ThirdYuQingController {

    private static Logger logger = LoggerFactory.getLogger(ThirdYuQingController.class);

    @Value("${wtyh.admin.ip}")
    private String adminServerIp;

    @Autowired
    private ThirdYuQingService thirdYuQingService;

    @RequestMapping("/record-list")
    @ResponseBody
    public Object findImportRecord() {
        return ResponseBean.successResponse(thirdYuQingService.findImportRecord(null, null, null));
    }

    @RequestMapping("/download")
    public void download(@RequestParam Integer recordId, HttpServletRequest request, HttpServletResponse response) {

        ImportRecordDO recordDO = thirdYuQingService.selectById(ImportRecordDO.class, recordId);
        if (recordDO == null) {
            String result = JSON.toJSONString(ResponseBean.errorResponse("没有对应的记录!"));
            responseWriteString(result.getBytes(), response);
            return;
        }
        requestFromBrowser(recordDO, request, response);
    }

    private void responseWriteString(byte[] msg, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try (OutputStream outputStream = response.getOutputStream()) {
            outputStream.write(msg);
            outputStream.flush();
        } catch (IOException e) {
            logger.error("response 回写发生异常：", e);
        }
    }

    private void responseWriteFile(byte[] file, String fileName, HttpServletRequest request, HttpServletResponse response) {
        String charsetName;
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.toUpperCase().contains("MSIE")) {
            charsetName = "GBK";
        } else {
            charsetName = "UTF-8";
        }
        response.setContentType("multipart/form-data");
        try (OutputStream outputStream = response.getOutputStream()) {
            String downloadName = new String(fileName.getBytes(charsetName), "ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\""); // 设定输出文件头

            outputStream.write(file);
            outputStream.flush();
        } catch (Exception e) {
            logger.error("response 回写发生异常：", e);
        }
    }

    private void requestFromBrowser(ImportRecordDO recordDO, HttpServletRequest request, HttpServletResponse response) {
        String fileName = recordDO.getFileName();
        try {
            byte[] bytes = thirdYuQingService.download(recordDO);

            if (bytes == null || bytes.length <= 0) {
                getFileFromAdmin(recordDO, request, response);
                return;
            }
            responseWriteFile(bytes, fileName, request, response);
        } catch (Exception e) {
            logger.error("下载文件【{}】失败：服务器报错!", fileName, e);
        }
    }

    private void getFileFromAdmin(ImportRecordDO recordDO, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = adminServerIp + "/third-yuqing/download.do?isWeb=true&recordId=" + recordDO.getId();
        ResponseBean responseBean = HttpUtil.get(url, false, ResponseBean.class);
        if (!responseBean.isSuccess()) {
            responseWriteString(JSON.toJSONString(responseBean).getBytes(), response);
            return;
        }
        byte[] bytes = Base64.getDecoder().decode(responseBean.getContent().toString());
        String fileName = responseBean.getMsg().toString();

        try (ByteArrayInputStream input = new ByteArrayInputStream(bytes)) {
            thirdYuQingService.saveYuQingFile(recordDO.getId(), fileName, input);
        }
        responseWriteFile(bytes, fileName, request, response);
    }

}
