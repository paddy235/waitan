package com.bbd.bgo.web.controller;

import com.alibaba.fastjson.JSON;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.third.yuqing.ImportRecordDO;
import com.bbd.wtyh.exception.ExceptionHandler;
import com.bbd.wtyh.service.third.yuqing.ThirdYuQingService;
import com.bbd.wtyh.web.ResponseBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Base64;
import java.util.Date;

/**
 * 第三方舆情，后台接口
 *
 * @author Created by LiYao on 2017-10-09 9:19.
 */
@SuppressWarnings("unused")
@Controller
@RequestMapping("/third-yuqing")
public class ThirdYuQingController {

    private static Logger logger = LoggerFactory.getLogger(ThirdYuQingController.class);

    @Autowired
    private ThirdYuQingService thirdYuQingService;

    @RequestMapping("/record-list")
    @ResponseBody
    public Object findImportRecord(String fileName, String startDate, String endDate) {
        return ResponseBean.successResponse(thirdYuQingService.findImportRecord(fileName, startDate, endDate));
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ResponseBean upload(@RequestParam("file") CommonsMultipartFile multipartFile, Date yuqingTime, HttpServletRequest request) {

        String originalFilename = multipartFile.getOriginalFilename();

        String createBy = "";
        Object obj = request.getSession().getAttribute(Constants.SESSION.loginName);
        if (obj != null) {
            createBy = obj.toString();
        }

        try (InputStream input = multipartFile.getInputStream()) {
            thirdYuQingService.upload(originalFilename, yuqingTime, createBy, multipartFile.getSize(), input);
        } catch (Exception e) {
            logger.error("导入第三方舆情文件服务器异常：", e);
            return ExceptionHandler.handlerException(e);
        }
        return ResponseBean.successResponse("导入成功");
    }

    @RequestMapping("/modify")
    @ResponseBody
    public ResponseBean modify(@RequestParam Integer recordId, @RequestParam Date yuqingTime, HttpServletRequest request) {
        String updateBy = "";
        Object obj = request.getSession().getAttribute(Constants.SESSION.loginName);
        if (obj != null) {
            updateBy = obj.toString();
        }
        ImportRecordDO recordDO = new ImportRecordDO();
        recordDO.setId(recordId);
        recordDO.setYuqingTime(yuqingTime);
        recordDO.setUpdateBy(updateBy);
        recordDO.setUpdateDate(new Date());
        thirdYuQingService.update(recordDO);
        return ResponseBean.successResponse("修改成功");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseBean delete(@RequestParam Integer recordId) {
        try {
            thirdYuQingService.delete(recordId);
        } catch (Exception e) {
            return ExceptionHandler.handlerException(e);
        }
        return ResponseBean.successResponse("删除成功");
    }

    @RequestMapping("/download")
    public void download(@RequestParam Integer recordId, boolean isWeb, HttpServletRequest request, HttpServletResponse response) {

        ImportRecordDO recordDO = thirdYuQingService.selectById(ImportRecordDO.class, recordId);
        if (recordDO == null) {
            String result = JSON.toJSONString(ResponseBean.errorResponse("没有对应的记录!"));
            responseWriteString(result.getBytes(), response);
            return;
        }
        if (isWeb) {
            requestFromWeb(recordDO, response);
        } else {
            requestFromBrowser(recordDO, request, response);
        }
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

    /**
     * 如果是从前台发来的下载请求。因为需要将各种信息返回，则将文件base64编码后已字符串的形式发送。统一格式
     * 
     * @param recordDO
     * @param response
     */
    private void requestFromWeb(ImportRecordDO recordDO, HttpServletResponse response) {
        String fileName = recordDO.getFileName();
        try {
            byte[] bytes = thirdYuQingService.download(recordDO);
            if (bytes == null || bytes.length <= 0) {
                String result = JSON.toJSONString(ResponseBean.errorResponse("文件不存在，可能已被删除!"));
                responseWriteString(result.getBytes(), response);
                return;
            }
            String str = Base64.getEncoder().encodeToString(bytes);
            ResponseBean responseBean = ResponseBean.successResponse(str);
            responseBean.setMsg(fileName);
            String result = JSON.toJSONString(responseBean);
            responseWriteString(result.getBytes(), response);
        } catch (Exception e) {
            logger.error("下载文件【{}】失败：服务器报错!", fileName, e);
            String result = JSON.toJSONString(ResponseBean.errorResponse("下载文件失败：服务器异常!"));
            responseWriteString(result.getBytes(), response);
        }
    }

    private void requestFromBrowser(ImportRecordDO recordDO, HttpServletRequest request, HttpServletResponse response) {
        String fileName = recordDO.getFileName();
        try {
            byte[] bytes = thirdYuQingService.download(recordDO);
            if (bytes == null || bytes.length <= 0) {
                String result = JSON.toJSONString(ResponseBean.errorResponse("文件不存在，可能已被删除!"));
                responseWriteString(result.getBytes(), response);
                return;
            }
            responseWriteFile(bytes, fileName, request, response);
        } catch (Exception e) {
            logger.error("下载文件【{}】失败：服务器报错!", fileName, e);
        }
    }

}
