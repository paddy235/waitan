package com.bbd.wtyh.report.service.impl;

import com.bbd.higgs.utils.DateUtils;
import com.bbd.wtyh.report.service.ScreenCaptureService;
import com.bbd.wtyh.report.service.WordReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLEncoder;
import java.util.Date;

/**
 * Created by cgj on 2017/6/14.
 */
public class WordReportServiceImpl implements WordReportService {

    private static Logger logger = LoggerFactory.getLogger(WordReportServiceImpl.class);

    @Autowired
    private ScreenCaptureService phantomSer;


/*    private void fun(void) {
        captureImg(req, "pdfMaps?companyId="
                + URLEncoder.encode(raCompanyPO.getId(), "utf8") + "&degree=2&province=" +URLEncoder.encode(province, "utf8"),
                "780px*850px");

        captureImg(request, "pdfRadar?company="
                + URLEncoder.encode(raCompanyPO.getCompany(), "utf8") + "&keyValue=" + URLEncoder.encode(keyValue.get(i), "utf8"),
                "600px*500px");

    }*/


    //截图工具
    /**
     * 截屏
     **/
    private String captureImg(HttpServletRequest re, String url, String size) {
        //"./phantomjs rasterize.js https://www.baidu.com c.png A4"
        String plugin = getImgPath(re, "/sysplugins/./phantomjs");
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            plugin = getImgPath(re, "/sysplugins/phantomjs.exe");
        }
        String js = getImgPath(re, "/sysplugins/rasterize.js");
        String img = "/";
        if (os.contains("windows")) {
            img = getImgPath(re, img) + "/temp/" + DateUtils.format(new Date(), "yyyyMMddHHmmss") + System.nanoTime() + ".png";
        } else {
            img = "/usr/local/tomcat/shareDir/generateImg/" + DateUtils.format(new Date(), "yyyyMMddHHmmss") + System.nanoTime() + ".png";
        }

        String basePath = "http://" + re.getServerName() + ":" + re.getServerPort() + re.getContextPath() + "/";

        url = basePath + url;

        logger.info(url);

        File pluginFile = new File(plugin);
        if (!pluginFile.canExecute()) {
            pluginFile.setExecutable(true);
        }

        if (!phantomSer.exec(plugin, js, url, img, size)) {
            return null;
        }
        return img;
    }

    /**
     * 获取路径
     */
    private String getImgPath(HttpServletRequest re, String path) {
        return re.getSession().getServletContext().getRealPath(path);
    }
}
