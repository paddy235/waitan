package com.bbd.bgo.web.controller;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.UserLogRecord;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.mapper.AreaMapper;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.ImgService;
import com.bbd.wtyh.service.shiro.ParkMgtService;
import com.bbd.wtyh.util.WtyhHelper;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.io.IOUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

/**
 * Created by Barney on 2017/7/6.
 */
@Controller
@RequestMapping("/park-mgt")
public class ParkMgtController {

    @Autowired
    private ImgService imgService;
    @Autowired
    private ParkMgtService parkMgtService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AreaMapper areaMapper;

    private String PARK_DIR1 = WtyhHelper.adminImgPath;//开发环境
    private static final String PARK_DIR = "data/img/park/";
    private static final String BUILDING_DIR = "data/img/building/";

    /**
     * 上海所有行政区
     *
     * @return
     */
    @RequestMapping("/areaList")
    @ResponseBody
    public ResponseBean areaList() {
        //因公用方法不稳定，暂时注释到公用方法
//        List<Map<String, Object>> list = ShanghaiAreaCode.getAndUpdateList(false);
//        if(list.size()>0){
//            list.remove(0);
//        }

        List<AreaDO> list = new ArrayList();
        try {
            list = areaMapper.areaListByCity(104);
            if (null != list) {
                for (AreaDO areaDO : list) {
                    if (null != areaDO.getAreaId() && 104 == areaDO.getAreaId()) {
                        areaDO.setCityName("上海全区");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            AreaDO areaDO = new AreaDO();
            areaDO.setCityName("上海全区");
            areaDO.setAreaId(104);
            list.add(areaDO);
        }
        return ResponseBean.successResponse(list);
    }

    /**
     * 园区列表
     *
     * @return
     */
    @RequestMapping("/parkList")
    @ResponseBody
    public ResponseBean parkList() {
        List<ParkDO> list = parkMgtService.queryParkList();
        return ResponseBean.successResponse(list);
    }

    /**
     * 楼宇列表(可模糊查询)
     *
     * @param parkId       园区ID
     * @param buildingName 楼宇名称
     * @return
     */
    @RequestMapping("/buildingList")
    @ResponseBody
    public ResponseBean buildingList(String parkId, String buildingName) {
        List<Map<String, String>> list = parkMgtService.queryBuildingList(parkId, buildingName);
        return ResponseBean.successResponse(list);
    }

    /**
     * 园区楼宇列表
     *
     * @param parkId       园区ID
     * @param buildingName 楼宇名称
     * @return
     */
    @RequestMapping("/queryParkAndBuilding")
    @ResponseBody
    public ResponseBean queryParkAndBuilding(String parkId, String buildingName) {
        List<ParkAndBuildingVO> list = parkMgtService.queryParkAndBuilding(parkId, buildingName);
        return ResponseBean.successResponse(list);
    }

    /**
     * 园区楼宇企业数量
     *
     * @param parkId 园区ID
     * @return
     */
    @RequestMapping("/queryBuildingCompanyNumber")
    @ResponseBody
    public ResponseBean queryBuildingCompanyNumber(String parkId) {
        List<ParkAndBuildingVO> list = parkMgtService.queryBuildingCompanyNumber(parkId);
        return ResponseBean.successResponse(list);
    }

    /**
     * 查询楼宇企业信息
     *
     * @param buildingId
     * @return
     */
    @RequestMapping("/queryCompanyByBuildingId")
    @ResponseBody
    public ResponseBean queryCompanyByBuildingId(String buildingId) {
        List<CompanyDO> list = parkMgtService.queryCompanyByBuildingId(buildingId);
        return ResponseBean.successResponse(list);
    }


    /**
     * 修改园区
     *
     * @param parkDO
     * @return
     */
    @RequestMapping("/updPark")
    @ResponseBody
    @LogRecord(logMsg = "修改园区：%s", params = {"parkName"}, page = Operation.Page.PARK_BUILDING_MANAGE,
            type = Operation.Type.modify, after = true, before = false)
    public ResponseBean updPark(ParkDO parkDO) {
        parkMgtService.updateParkAreaId(parkDO);
        return ResponseBean.successResponse("OK");
    }


    /**
     * 删除园区
     *
     * @param parkId
     * @return
     */
    @RequestMapping("/delPark")
    @ResponseBody
    @LogRecord(logMsg = "删除园区：%s", params = {"parkName"}, page = Operation.Page.PARK_BUILDING_MANAGE,
            type = Operation.Type.del, after = true, before = false)
    public ResponseBean delPark(@RequestParam String parkId,String parkName) {
        //删除园区时，需要将相关楼宇及企业一并删除
        try {
            parkMgtService.delParkById(parkId);
            return ResponseBean.successResponse("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse(e.getMessage());
        }
    }

    /**
     * 删除楼宇
     *
     * @param buildingId
     * @return
     */
    @RequestMapping("/delBuilding")
    @ResponseBody
    @LogRecord(logMsg = "删除楼宇：%s", params = {"buindingName"}, page = Operation.Page.PARK_BUILDING_MANAGE,
            type = Operation.Type.del, after = true, before = false)
    public ResponseBean delBuilding(@RequestParam String[] buildingId,String[] buindingName) {
        //删除楼宇时，需要将相关企业一并删除
        try {
            parkMgtService.delBuildingById(Arrays.asList(buildingId));
            return ResponseBean.successResponse("OK");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse(e.getMessage());
        }

    }

    /**
     * 删除企业
     *
     * @param buildingId  楼宇ID
     * @param companyList 企业ID列表
     * @return
     */
    @RequestMapping("/delCompanyByCompanyId")
    @ResponseBody
    @LogRecord(logMsg = "删除企业，楼宇名称：%s,企业列表：%s", params = {"buildingName","companyNameList"}, page = Operation.Page.PARK_BUILDING_MANAGE,
            type = Operation.Type.del, after = true, before = false)
    public ResponseBean delCompanyByCompanyId(@RequestParam String buildingId, @RequestParam String[] companyList,String buildingName,String[] companyNameList) {
        parkMgtService.delCompanyByCompanyId(buildingId, Arrays.asList(companyList));
        return ResponseBean.successResponse("OK");
    }

    /**
     * 新增园区
     *
     * @param park
     * @return
     */
    @RequestMapping("/addPark")
    @ResponseBody
    @LogRecord(logMsg = "新增园区：%s", params = {"name"}, page = Operation.Page.PARK_BUILDING_MANAGE,
            type = Operation.Type.add, after = true, before = false)
    public ResponseBean addPark(HttpServletRequest request, String name,@RequestParam(required = false) String areaId) {
        // 新增之前先查询该园区是否存在
        int i = parkMgtService.queryParkIdByName(name);
        if (i != 0) {
            return ResponseBean.errorResponse("该园区已存在");
        }
        //若前端不传用户名，则自行抓取
        String user = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if(StringUtils.isEmpty(user)) {
            return ResponseBean.errorResponse("非法用户");
        }
        ParkDO park = new ParkDO();
        park.setCreateBy(user);
        park.setAreaId(StringUtils.isEmpty(areaId) ? 0 : Integer.parseInt(areaId));
        park.setName(name);

        parkMgtService.addPark(park);
        return ResponseBean.successResponse("OK");
    }

    /**
     * 新增楼宇
     * @param building
     * @return
     */
    @RequestMapping("/addBuilding")
    @ResponseBody
    @LogRecord(logMsg = "新增楼宇,所属园区：%s，楼宇名称：%s", params = {"parkName","name"}, page = Operation.Page.PARK_BUILDING_MANAGE,
            type = Operation.Type.add, after = true, before = false)
    public ResponseBean addBuilding(HttpServletRequest request, BuildingDO building,String parkName) throws Exception {
        // 若前端不传用户名，则自行抓取
        String creatBy = building.getCreateBy();
        if(StringUtils.isEmpty(creatBy)){
            String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
            if(null == loginName)
                loginName = "building";
            building.setCreateBy(loginName);
        }
        // 新增之前先查询该楼宇是否存在
        int i = parkMgtService.queryBIdByName(building.getName());
        if (i == 1) {
            if (StringUtils.isEmpty(parkName))
                return  ResponseBean.errorResponse("请选择园区！");
            int relationCount = parkMgtService.queryPABRelation(parkName, building.getName());
            if (relationCount == 1)
                return  ResponseBean.errorResponse("该园区下已有该楼宇！");
            parkMgtService.bindingParkAndBuilding(building, parkName);
        } else
            parkMgtService.addBuilding(building, parkName);
        return ResponseBean.successResponse("OK");
    }

    /**
     * 新增企业
     * @param request
     * @param buildingId
     * @param name
     * @param creatBy
     * @return
     */
    @RequestMapping("/addCompanyBuilding")
    @ResponseBody
    @LogRecord(logMsg = "新增企业，所属楼宇：%s，企业名称：%s", params = {"buildingName","name"}, page = Operation.Page.PARK_BUILDING_MANAGE,
            type = Operation.Type.add, after = true, before = false)
    public ResponseBean addCompanyBuilding(HttpServletRequest request, String buildingId,String name,String creatBy,String buildingName) {
        CompanyBuildingDO companyBuildingDO = new CompanyBuildingDO();
        //新增之前先查询该企业是否存在，既不能存在于company_building中，也不能不存在于company中
        CompanyDO companyDO = companyService.getCompanyByName(name);
        if(null == companyDO){
            return ResponseBean.errorResponse("企业不存在于企业信息表");
        }
        Integer companyId  = companyDO.getCompanyId();

        Integer companyBuildingId = parkMgtService.queryCBId(companyId+"");
        if(companyBuildingId != null){
            return ResponseBean.errorResponse("企业已存在于该楼宇");
        }
        //校验完成则可新增
        companyBuildingDO.setBuildingId(Integer.valueOf(buildingId));
        companyBuildingDO.setCompanyId(Integer.valueOf(companyId));
        //若前端不传用户名，则自行抓取
        if(StringUtils.isEmpty(creatBy)){
            String loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
            if( null ==loginName ) {
                loginName ="cb";
            }
            companyBuildingDO.setCreateBy(loginName);
        }else{
            companyBuildingDO.setCreateBy(creatBy);
        }


        parkMgtService.addCompanyBuilding(companyBuildingDO);
        return ResponseBean.successResponse("OK");
    }

    /**
     * 查询园区图片路径
     * @param parkId
     * @return
     */
    @RequestMapping("/parkImg")
    @ResponseBody
    public ResponseBean parkImg(String parkId) {
        ParkDO parkDO = parkMgtService.queryParkById(parkId);
        String imgUrl = parkDO.getImgUrl();

        return ResponseBean.successResponse(imgUrl);
    }

    /**
     * 查询楼宇图片路径
     * @param parkId
     * @param buildingId
     * @return
     */
    @RequestMapping("/buildingImg")
    @ResponseBody
    public ResponseBean buildingImg(String parkId,String buildingId) {
        BuildingDO buildingDO = parkMgtService.queryBuildingByParkAndBuilding(parkId,buildingId);
        String imgUrl = buildingDO.getImgUrl();

        return ResponseBean.successResponse(imgUrl);
    }

    /**
     * 上传图片
     *
     * @param request
     * @param file         图片
     * @param picType      1：园区 2：楼宇
     * @param parkName     园区名称 --用名称是为了新增园区或楼宇时还没有生成其ID
     * @param buildingName 楼宇名称
     * @param user         用户名
     * @return
     */
    @RequestMapping("/upLoadPic")
    @LogRecord(logMsg = "上传图片，园区名称：%s，楼宇名称名称：%s", params = {"parkName","buildingName"}, page = Operation.Page.PARK_BUILDING_MANAGE,
            type = Operation.Type.add, after = true, before = false)
    public @ResponseBody ResponseBean upLoadPic(HttpServletRequest request,
                           @RequestParam("file") CommonsMultipartFile file,
                           @RequestParam Integer picType,
                           @RequestParam String parkName, String buildingName,
                           @RequestParam String user) {
        try {
//            File f = new File(request.getSession().getServletContext().getRealPath("/") + "/data/img/park/hpq.png");
            if (file != null) {
                String path = PARK_DIR;
                if (picType == 2) {
                    path = BUILDING_DIR;
                }

                ImgDO img = new ImgDO();
                InputStream ins = file.getInputStream();
                img.setPic(IOUtils.toByteArray(ins));
                if (null != file && null != file.getOriginalFilename() && !"".equals(file.getOriginalFilename()) && null != path && !"".equals(path) &&
                        ((path + file.getOriginalFilename()).equals(ParkDO.DEFAULT_PARK_IMG) || (path + file.getOriginalFilename()).equals(BuildingDO.DEFAULT_BUILDING_IMG)))
                    return ResponseBean.errorResponse("默认图片已占用该文件名，请修改文件名后在进行上传操作，谢谢！");
                img.setPicName(file.getOriginalFilename());
                img.setPicUrl(path + file.getOriginalFilename());
                img.setPicType(picType);
                Integer parkId = parkMgtService.queryParkIdByName(parkName);
                if (!StringUtils.isEmpty(picType) && picType == 1) {
                    img.setPicParkId(parkId);
                } else if (!StringUtils.isEmpty(picType) && picType == 2) {
                    img.setPicParkId(parkId);
                    Integer buildingId = parkMgtService.queryBuildingIdByName(parkId,buildingName);
                    if(buildingId == null ||buildingId == 0){
                        return ResponseBean.errorResponse("楼宇不存在");
                    }
                    img.setPicBuildingId(buildingId);
                }
                img.setCreateBy(user);

                int id = imgService.addImage(img);
                ins.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.errorResponse(e.getMessage());
        }
        return ResponseBean.successResponse("OK");
    }


    /**
     * 绑定(更新)图片到后台
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/updateDevPic")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public ResponseBean updateDevPic(HttpServletRequest request,String user) throws Exception {

        try {

            //查询状态为0的图片列表，依次更新
            List<ImgDO> list = imgService.queryImgByStatus(0);
            for (ImgDO imgDO : list) {

                updatePic(request, imgDO);//更新图片到执行文件夹

                if(imgDO.getPicType()==1){
                    ParkDO parkDO = new ParkDO();
                    parkDO.setImgUrl(imgDO.getPicUrl());
                    parkDO.setUpdateBy(user);
                    parkDO.setParkId(imgDO.getPicParkId());
                    parkMgtService.updateParkImgUrl(parkDO);//更新图片路径到园区表
                }else if(imgDO.getPicType()==2){
                    BuildingDO buildingDO = new BuildingDO();
                    buildingDO.setImgUrl(imgDO.getPicUrl());
                    buildingDO.setUpdateBy(user);
                    buildingDO.setBuildingId(imgDO.getPicBuildingId());
                    parkMgtService.updateBuildingImgUrl(buildingDO);//更新图片路径到楼宇表
                }
                 //将处理过的图片数据状态更新为1
                imgDO.setStatus(1);
                imgDO.setLastStatus(0);
                imgDO.setUser(user);
                imgService.updateImage(imgDO);

            }

        } catch (Exception e) {
//            logger.error("Method[updateDevPic],catch exception:" + e.getMessage());
            throw new Exception(e);
        }
        return ResponseBean.successResponse("OK");
    }

    /**
     * 更新图片到执行文件夹
     * @param request
     * @param img
     */
    private void updatePic(HttpServletRequest request,ImgDO img){
        String path = PARK_DIR;
        String filePath = PARK_DIR1;
        Integer picType = img.getPicType();
        String folder = "park";
        if (picType == 2) {
            path = BUILDING_DIR;
            folder = "building";
        }
        // /data/wtyh/static/wtyh-admin/build/data/img
        if(org.apache.commons.lang3.StringUtils.isBlank(PARK_DIR1)){//正式环境
            filePath = request.getSession().getServletContext().getRealPath("/") + File.separator + path + img.getPicName();
        }else{//开发环境
            filePath += File.separator + folder+ File.separator + img.getPicName();
        }

        File f = new File(filePath);
        FileOutputStream fos = null;

        try {
            //若原图片已经被打开，是否还能直接删除？能。。。
            if (f.exists()){
                f.delete();
            }

            if(!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }

//            f.createNewFile();

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
    }


}
