package com.bbd.bgo.web.controller;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.domain.ImgDO;
import com.bbd.wtyh.domain.query.NaturalPersonQuery;
import com.bbd.wtyh.service.ImgService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Barney on 2017/7/6.
 */
@Controller
@RequestMapping("/park-mgt")
public class ParkMgtController {

    private static final String PARK_DIR = "/data/img/park/";
    @Autowired
    private ImgService imgService;

    //上海所有行政区
    @RequestMapping("/areaList")
    @ResponseBody
    public ResponseBean areaList(){
        List<Map<String, Object>> list = ShanghaiAreaCode.getAndUpdateList(false);
        return  ResponseBean.successResponse(list);
    }

    @RequestMapping("/test1")
    public @ResponseBody ResponseBean test1(HttpServletRequest request) {
        try {
            File f = new File(request.getSession().getServletContext().getRealPath("/") + "/data/img/park/hpq.png");
            if (f.exists()) {
                ImgDO img = new ImgDO();
                InputStream ins = new FileInputStream(f);
                img.setPic(IOUtils.toByteArray(ins));
                img.setPicName(f.getName());
                img.setPicType(1);
                img.setPicUrl(PARK_DIR + f.getName());
                img.setCreateBy("testUser");

                int id = imgService.addImage(img);
                System.out.println("当前id：" + id);
                ins.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseBean.successResponse("hello world");
    }

    @RequestMapping("/test2")
    public @ResponseBody ResponseBean test2(HttpServletRequest request) {
        ImgDO img = imgService.queryImgById(1);
        File f = new File(request.getSession().getServletContext().getRealPath("/") + PARK_DIR + img.getPicName());
        FileOutputStream fos = null;

        try {
            if (f.exists())
                f.delete();
            fos = new FileOutputStream(f);
            int len = 0;
            byte[] buf = new byte[1024];
            InputStream ins = new ByteArrayInputStream(img.getPic());
            while ((len = ins.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ResponseBean.successResponse("hello world");
    }

}
