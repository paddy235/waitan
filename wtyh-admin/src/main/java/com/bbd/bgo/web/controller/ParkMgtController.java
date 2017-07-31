package com.bbd.bgo.web.controller;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;
import com.bbd.wtyh.service.ImgService;
import com.bbd.wtyh.service.shiro.ParkMgtService;
import com.bbd.wtyh.util.WtyhHelper;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.io.IOUtils;
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
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * Created by Barney on 2017/7/6.
 */
@Controller
@RequestMapping("/park-mgt")
public class ParkMgtController {

    private static final String PARK_DIR = "data/img/park/";
    private static final String BUILDING_DIR = "data/img/building/";
    @Autowired
    private ImgService imgService;
    @Autowired
    private ParkMgtService parkMgtService;

    /**
     * 上海所有行政区
     *
     * @return
     */
    @RequestMapping("/areaList")
    @ResponseBody
    public ResponseBean areaList() {
        List<Map<String, Object>> list = ShanghaiAreaCode.getAndUpdateList(false);
        list.remove(0);
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
     * 删除园区
     *
     * @param parkId
     * @return
     */
    @RequestMapping("/delPark")
    @ResponseBody
    public ResponseBean delPark(String parkId) {
        //删除园区时，需要将相关楼宇及企业一并删除
        parkMgtService.delCompanyBuildingByParkId(parkId);
        parkMgtService.delBuildingByParkId(parkId);
        parkMgtService.delParkById(parkId);
        return ResponseBean.successResponse("OK");
    }

    /**
     * 删除楼宇
     *
     * @param buildingId
     * @return
     */
    @RequestMapping("/delBuilding")
    @ResponseBody
    public ResponseBean delBuilding(String[] buildingId) {
        //删除楼宇时，需要将相关企业一并删除
        parkMgtService.delCompanyByBuildingId(Arrays.asList(buildingId));
        parkMgtService.delBuildingById(Arrays.asList(buildingId));
        return ResponseBean.successResponse("OK");
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
    public ResponseBean delCompanyByCompanyId(String buildingId, String[] companyList) {
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
    public ResponseBean addPark(ParkDO park) {
        //新增之前先查询该园区是否存在
        int i = parkMgtService.queryParkIdByName(park.getName());
        if (i != 0) {
            return ResponseBean.errorResponse("该园区已存在");
        }
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
    public ResponseBean addBuilding(BuildingDO building) {
        //新增之前先查询该楼宇是否存在
        int i = parkMgtService.queryBuildingIdByName(building.getParkId(),building.getName());
        if(i != 0){
            return  ResponseBean.errorResponse("该楼宇已存在");
        }
        parkMgtService.addBuilding(building);
        return ResponseBean.successResponse("OK");
    }

    /**
     * 新增企业
     * @param companyBuildingList
     * @return
     */
    @RequestMapping("/addCompanyBuilding")
    @ResponseBody
    public ResponseBean addCompanyBuilding(List<CompanyBuildingDO> companyBuildingList) {
        //新增之前先查询该企业是否存在

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
                img.setPicName(file.getOriginalFilename());
                img.setPicUrl(path + file.getOriginalFilename());
                img.setPicType(picType);
                Integer parkId = parkMgtService.queryParkIdByName(parkName);
                if (!StringUtils.isEmpty(picType) && picType == 1) {
                    img.setPicParkId(parkId);
                } else if (!StringUtils.isEmpty(picType) && picType == 2) {
                    img.setPicParkId(parkId);
                    Integer buildingId = parkMgtService.queryBuildingIdByName(parkId,buildingName);
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
            String macId = getMacId();
            Integer port = request.getLocalPort();
            String ip = macId + ":" + port;//作为服务器唯一识别码

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
                buildingDO.setParkId(imgDO.getPicParkId());
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



    private String PARK_DIR1 = WtyhHelper.adminImgPath;//开发环境

    /**
     * 更新图片到执行文件夹
     * @param request
     * @param img
     */
    private void updatePic(HttpServletRequest request,ImgDO img){
        String path = PARK_DIR;
        Integer picType = img.getPicType();
        if (picType == 2) {
            path = BUILDING_DIR;
        }
        // /data/wtyh/static/wtyh-admin/build/data/img
        if(org.apache.commons.lang3.StringUtils.isBlank(PARK_DIR1)){//正式环境
            PARK_DIR1 = request.getSession().getServletContext().getRealPath("/") + File.separator + path + img.getPicName();
        }else{//开发环境
            PARK_DIR1+=File.separator+ "park"+File.separator+ img.getPicName();
        }

        File f = new File(PARK_DIR1);
        request.getRemoteAddr();
        FileOutputStream fos = null;

        try {
            //若原图片已经被打开，是否还能直接删除？
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

    /**
     * 此方法描述的是：获得服务器的MAC地址
     */
    public static String getMacId() {
        String macId = "";
        InetAddress ip = null;
        NetworkInterface ni = null;
        try {
            boolean bFindIP = false;
            Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
                    .getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                if (bFindIP) {
                    break;
                }
                ni = (NetworkInterface) netInterfaces
                        .nextElement();
                // ----------特定情况，可以考虑用ni.getName判断
                // 遍历所有ip
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    ip = (InetAddress) ips.nextElement();
                    if (!ip.isLoopbackAddress() // 非127.0.0.1
                            && ip.getHostAddress().matches(
                            "(\\d{1,3}\\.){3}\\d{1,3}")) {
                        bFindIP = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != ip) {
            try {
                macId = getMacFromBytes(ni.getHardwareAddress());
            } catch (SocketException e) {

            }
        }
        return macId;
    }

    private static String getMacFromBytes(byte[] bytes) {
        StringBuffer mac = new StringBuffer();
        byte currentByte;
        boolean first = false;
        for (byte b : bytes) {
            if (first) {
                mac.append("-");
            }
            currentByte = (byte) ((b & 240) >> 4);
            mac.append(Integer.toHexString(currentByte));
            currentByte = (byte) (b & 15);
            mac.append(Integer.toHexString(currentByte));
            first = true;
        }
        return mac.toString().toUpperCase();
    }

}
