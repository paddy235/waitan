package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.ParkService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bbd.wtyh.domain.Area;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.InBusiness;

import java.util.List;


/**
* 园区相关接口
* @author Ian.Su
* @since 2016年8月5日 上午11:55:20
*/
@Controller
@RequestMapping("/park")
public class ParkController {

    @Autowired
    private AreaService areaService;
    
    @Autowired
    private ParkService parkService;


    /**
    *
    * 获取区域信息
    * @return ResponseBean
    */
    @RequestMapping("/area/list")
    @ResponseBody
    public ResponseBean areaList() {

        List<Area> data = areaService.list();

        return ResponseBean.successResponse(data);
    }
    
    
    /**
    * 根据园区查询类金融企业集中度
    * @param parkId 区域id,必传
    * @return ResponseBean  
    */
    @RequestMapping("/company/concentration")
    @ResponseBody
    public ResponseBean oncentration(@RequestParam(required=true) Integer parkId) {

        List<BuildingDO> data = parkService.queryBuildings(parkId);
        
        return ResponseBean.successResponse(data);
    }
    
    
    
    /**
    * 在营时间分布
    * @param parkId 区域id,必传
    * @return ResponseBean  
    */
    @RequestMapping("/in/business")
    @ResponseBody
    public ResponseBean inBusiness(@RequestParam(required=true) Integer areaId) {

        List<InBusiness> data = parkService.inBusiness(areaId);
        
        return ResponseBean.successResponse(data);
    }
    
    
    /**
    * 园区舆情查询
    * @param parkId 区域id,必传
    * @return ResponseBean  
    */
    @RequestMapping("/news")
    @ResponseBody
    public ResponseBean news(@RequestParam(required=true) Integer areaId) {

        Object data = parkService.queryParkNews(areaId,2,1);
        
        return ResponseBean.successResponse(data);
    }
    
}
