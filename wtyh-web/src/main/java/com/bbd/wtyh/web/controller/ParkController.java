package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.entity.Area;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 园区相关接口
 *
 * @author Ian.Su
 * @since: 2016年8月5日 上午11:55:20
 */
@Controller
@RequestMapping("/park")
public class ParkController {

    //  属性描述
    private int test = 1;
    @Autowired
    private AreaService areaService;


    /**
     * 方法描述
     *
     * @return Object    返回类型
     */
    @RequestMapping("/area/list")
    @ResponseBody
    public Object areaList() {

        List<Area> data = areaService.list();

        return ResponseBean.successResponse(data);
    }


}
