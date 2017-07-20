package com.bbd.bgo.web.controller;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.ImgDO;
import com.bbd.wtyh.domain.ParkDO;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;
import com.bbd.wtyh.service.ImgService;
import com.bbd.wtyh.service.shiro.ParkMgtService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Arrays;
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
    @Autowired
    private ParkMgtService parkMgtService;

    /**
     * 上海所有行政区
     * @return
     */
    @RequestMapping("/areaList")
    @ResponseBody
    public ResponseBean areaList(){
        List<Map<String, Object>> list = ShanghaiAreaCode.getAndUpdateList(false);
        return  ResponseBean.successResponse(list);
    }

    /**
     * 园区列表
     * @return
     */
    @RequestMapping("/parkList")
    @ResponseBody
    public ResponseBean parkList(){
        List<ParkDO> list = parkMgtService.queryParkList();
        return  ResponseBean.successResponse(list);
    }

    /**
     * 园区楼宇列表
     * @param parkId 园区ID
     * @return
     */
    @RequestMapping("/queryParkAndBuilding")
    @ResponseBody
    public ResponseBean queryParkAndBuilding(String parkId){
        List<ParkAndBuildingVO> list = parkMgtService.queryParkAndBuilding(parkId);
        return  ResponseBean.successResponse(list);
    }

    /**
     * 园区楼宇企业数量
     * @param parkId 园区ID
     * @return
     */
    @RequestMapping("/queryBuildingCompanyNumber")
    @ResponseBody
    public ResponseBean queryBuildingCompanyNumber(String parkId){
        List<ParkAndBuildingVO> list = parkMgtService.queryBuildingCompanyNumber(parkId);
        return  ResponseBean.successResponse(list);
    }

    /**
     * 删除企业
     * @param companyList 企业ID列表
     * @return
     */
    @RequestMapping("/delCompanyByCompanyId")
    @ResponseBody
    public ResponseBean delCompanyByCompanyId(String[] companyList){
//        List<String> companyNameList = new ArrayList<>();
//
//        String[] companyName = companyList.split(",");
//        for (String s:companyName) {
//            if(!StringUtils.isEmpty(s)){
//                companyNameList.add(s);
//            }
//        }

        parkMgtService.delCompanyByCompanyId(Arrays.asList(companyList));
        return  ResponseBean.successResponse("OK");
    }

    /**
     * 上传图片
     * @param request
     * @param picType 1：园区 2：楼宇
     * @param parkId 园区ID
     * @param buildingId 楼宇ID
     * @param user 用户名
     * @return
     */
    @RequestMapping("/upLoadPic")
    public @ResponseBody ResponseBean upLoadPic(HttpServletRequest request,
                                                @RequestParam Integer picType,
                                                @RequestParam Integer parkId, Integer buildingId,
                                                @RequestParam String user) {
        try {
            File f = new File(request.getSession().getServletContext().getRealPath("/") + "/data/img/park/hpq.png");
            if (f.exists()) {
                ImgDO img = new ImgDO();
                InputStream ins = new FileInputStream(f);
                img.setPic(IOUtils.toByteArray(ins));
                img.setPicName(f.getName());
                img.setPicType(1);
                img.setPicUrl(PARK_DIR + f.getName());
                img.setPicType(picType);
                if(!StringUtils.isEmpty(picType) && picType == 1){
                    img.setPicParkId(parkId);
                }else if (!StringUtils.isEmpty(picType) && picType == 2){
                    img.setPicParkId(parkId);
                    img.setPicBuildingId(buildingId);
                }
                img.setCreateBy(user);

                int id = imgService.addImage(img);
                System.out.println("当前id：" + id);
                ins.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse(e.getMessage());
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
