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
    public String platFormStatus(String dataType) {
        return "{plat_name: \"testhello\"}";
    }

    /**
     * 核心数据及集中度
     *
     * @param dataType
     * @return
     */
    public String coreData(String dataType) {
        return "{\"plat_name\":\"来财街\"," +
                "\"plat_score\":73.2," +
                "\"other_sum_amount\":0," +
                "\"bor_num_stay_stil\":1," +
                "\"inserest_rate\":12.58," +
                "\"money_stock\":8430.91," +
                "\"top10_num_amount\":0," +
                "\"bid_num_stay_stil\":6205," +
                "\"plat_data_six_month\":[{" +
                "\"date\":1321435453132," +
                "\"date_interset_rate\":0," +
                "\"day_net_inflow\":-26.99," +
                "\"day_amount\":0," +
                "\"day_money_stock\":8430.91},]," +
                "\"company_name\":\"阿丽亚路上海投资发展有限公司\"," +
                "\"plat_status\":\"正常\"," +
                "\"30_day_net_inflow\":6565.6," +
                "\"top1_sum_amount\":0," +
                "\"amount_taotal\":23154.0985}";
    }

    /**
     * 平台名称和公司名称
     *
     * @return
     */
    public String platFormName( String dataType) {
        return "";
    }

    /**
     * 雷达评分
     *
     * @param dataType
     * @return
     */
    @RequestMapping("/radarScore")
    @ResponseBody
    public String radarScore(String dataType) {
        return "{\"plat_name\":\"今日劫财\"," +
                "\"penalty_cost\":67.25," +
                "\"info_disclosure\":69.77," +
                "\"capital\":76.67," +
                "\"operation\":73.23," +
                "\"fluidity\":53.33," +
                "\"dispersion\":71.73}";
    }

}
