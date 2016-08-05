package com.bbd.wtyh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.common.ResponseBean;
import com.bbd.wtyh.entity.Area;
import com.bbd.wtyh.service.AreaService;



/**
* @ClassName: ParkController
* @Description: 园区相关接口
* @author Ian.Su
* @date 2016年8月5日 上午11:55:20
*/
@Controller
@RequestMapping("/park")
public class ParkController {

    @Autowired
    private AreaService areaService;


    
    /**
    *
    * @Title: 获取区域信息
    * @Description: TODO
    * @param   设定文件
    * @return Object    返回类型
    * @throws
    * @author Ian.Su
    * @date 2016年8月5日 下午2:44:35 
    */
    @RequestMapping("/area/list")
    @ResponseBody
    public Object areaList() {

        List<Area> data = areaService.list();
        
        return ResponseBean.successResponse(data);
    }
    
    
    
    
    
}
