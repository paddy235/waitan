package com.bbd.bgo.web.controller;

import com.bbd.wtyh.service.CoChgMonitorService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


/**
 * Created by Administrator on 2017/4/18 0018.
 */
@Controller
@RequestMapping("/coChgMonitor")
public class CoChgMonitorController {

    @Autowired
    CoChgMonitorService coChgMonitorService;

    @RequestMapping("/queryCompanyStatusChg")
    @ResponseBody
    public ResponseBean queryCompanyStatusChg(Integer areaId, Integer companyType, String beginDate, String endDate,
                                              Integer changeTpye, Integer source, Integer closedType,
                                              @RequestParam Integer page, @RequestParam Integer pageSize)
    {
        try {
            if(null==page){
                page=1;
            }
            if(null==pageSize){
                pageSize=10;
            }

            Map<String, Object> map = coChgMonitorService.queryCompanyStatusChg(
                                            areaId, companyType, beginDate, endDate,
                                            changeTpye, source, closedType, page, pageSize);

            return ResponseBean.successResponse(map);

        }catch (Exception e){
            return ResponseBean.errorResponse("服务器异常：" + e);
        }

    }
}
