package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.service.BuildingDetailsService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 楼宇详情
 * @author tracy zhou
 * @since  2016/8/8
 */
@Controller
@RequestMapping("/buildingDetails")
public class BuildingDetailsController {
    @Autowired
    public BuildingDetailsService buildingDetailsService;



    /**
     * 楼宇图片
     * @param buildingId
     * @return
     */
    @RequestMapping("buildingPicture")
    @ResponseBody
    public ResponseBean buildingPicture(Integer buildingId) {
        Map<T, T> map = buildingDetailsService.buildingPicture(buildingId);
        return null;
    }
}
