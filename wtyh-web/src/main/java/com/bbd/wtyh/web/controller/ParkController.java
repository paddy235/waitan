package com.bbd.wtyh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.common.ResponseBean;
import com.bbd.wtyh.domain.Area;
import com.bbd.wtyh.service.AreaService;



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
    * 获取楼宇信息
    * @param building_id 楼宇id,必传
    * @return ResponseBean  
    */
    @RequestMapping("/company/concentration")
    @ResponseBody
    public ResponseBean oncentration(@RequestParam(required=true) String building_id) {

        List<Area> data = areaService.list();
        
        return ResponseBean.successResponse(data);
    }
    
    
    
    
}
