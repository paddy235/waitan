package com.bbd.wtyh.web.controller.mockServer;

import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.web.HistogramBean;
import com.bbd.wtyh.web.RadarChartBean;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * p2p行业检测平台控制层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Controller
@RequestMapping("/financial_services")
public class MockSerserController {

    /**
     * 平台状态信息
     *
     * @return
     */
    @ResponseBody
    public String platFormStatus(String dataType) {
        return "{plat_name: \"testhello\"}";
    }

}
