package com.bbd.wtyh.web.controller.mockServer;

import com.bbd.wtyh.domain.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * p2p行业检测平台控制层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Controller
public class MockSerserController {

    /**
     * 核心数据及集中度
     *
     * @param dataType
     * @return
     */
    @RequestMapping(value = "/financial_services", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Object coreData(@RequestParam(required = true) String dataType, String plat_name) {
        // 核心数据及集中度
        if (dataType.equals("plat_data")) {
            return "{\"plat_name\":\"来财街\"," +
                    "\"plat_score\":73.2," +
                    "\"other_sum_amount\":0," +
                    "\"bor_num_stay_stil\":1," +
                    "\"inserest_rate\":12.58," +
                    "\"money_stock\":8430.91," +
                    "\"top10_num_amount\":0," +
                    "\"bid_num_stay_stil\":6205," +
                    "\"company_name\":\"汕头市金通汽车运输有限公司\"," +
                    "\"plat_status\":\"正常\"," +
                    "\"30_day_net_inflow\":6565.6," +
                    "\"top1_sum_amount\":0," +
                    "\"amount_taotal\":23154.0985," +
                    "\"plat_data_six_month\": [" +
                           "{date: \"2016-08-08\", day_interest_rate: \"5.6\", day_amount: \"100\", day_money_stock: \"578\"}, " +
                           "{date: \"2016-08-09\", day_interest_rate: \"6.6\", day_amount: \"300\", day_money_stock: \"666\"}, " +
                           "{date: \"2016-08-10\", day_interest_rate: \"5.7\", day_amount: \"200\", day_money_stock: \"333\"}, " +
                           "{date: \"2016-08-12\", day_interest_rate: \"5.8\", day_amount: \"400\", day_money_stock: \"555\"}, " +
                           "{date: \"2016-08-13\", day_interest_rate: \"5.9\", day_amount: \"500\", day_money_stock: \"789\"}, " +
                           "{date: \"2016-08-14\", day_interest_rate: \"6.0\", day_amount: \"600\", day_money_stock: \"452\"}, " +
                           "{date: \"2016-08-15\", day_interest_rate: \"6.1\", day_amount: \"400\", day_money_stock: \"125\"}, " +
                           "{date: \"2016-08-16\", day_interest_rate: \"6.2\", day_amount: \"100\", day_money_stock: \"852\"}, " +
                           "{date: \"2016-08-17\", day_interest_rate: \"6.3\", day_amount: \"300\", day_money_stock: \"963\"}, " +
                           "{date: \"2016-08-18\", day_interest_rate: \"6.4\", day_amount: \"700\", day_money_stock: \"784\"}, " +
                           "{date: \"2016-08-19\", day_interest_rate: \"6.5\", day_amount: \"400\", day_money_stock: \"123\"}, " +
                           "{date: \"2016-08-20\", day_interest_rate: \"6.6\", day_amount: \"100\", day_money_stock: \"148\"}, " +
                           "{date: \"2016-08-21\", day_interest_rate: \"6.7\", day_amount: \"500\", day_money_stock: \"524\"}, " +
                           "{date: \"2016-08-22\", day_interest_rate: \"6.8\", day_amount: \"600\", day_money_stock: \"745\"}, " +
                           "{date: \"2016-08-23\", day_interest_rate: \"6.9\", day_amount: \"300\", day_money_stock: \"326\"}, " +
                    "]}";

        } else if (dataType.equals("yuqing")) {
            return "{plat_name: \"投融范\", " +
                    "score: \"10\", " +
                    "warning: [" +
                    "{info:\"上海p2p投融范发逾期公告 承诺9个月内兑付\"}," +
                    "{info:\"投融范一个推子布局的诈骗平台推子兼职诈骗，人人得而诛之\"}," +
                    "{info:\"投融范项目逾期，回款无望\"}" +
                    "]}";

        } else if (dataType.equals("plat_list")) {
            return "{plat_name: \"测试数据\", company_name: \"攀枝花市交通旅游客运有限责任公司\", logo_url: \"http://logo.url.com\"}";

        } else if (dataType.equals("leida")) {
            return "{\"plat_name\":\"今日劫财\"," +
                    "\"penalty_cost\":67.25," +
                    "\"info_disclosure\":69.77," +
                    "\"capital\":76.67," +
                    "\"operation\":73.23," +
                    "\"fluidity\":53.33," +
                    "\"dispersion\":71.73}";

        } else if ("industry_shanghai".equalsIgnoreCase(dataType)) {
            return getIndustry_shanghai();

        } else if ("industry_problem".equalsIgnoreCase(dataType)) {
            return getProblemData();

        } else if ("industry_compare".equalsIgnoreCase(dataType)) {
            return getCompareData();

        } else if ("area_index".equalsIgnoreCase(dataType)) {
            return getAreaIndex();

        } else if ("plat_rank_data".equalsIgnoreCase(dataType)) {
            return getPlatRankData();

        } else {
            return "Not right RequestParam.";
        }
    }


    /**
     * 核心数据及集中度
     *
     * @param dataType
     * @return
     */
    @RequestMapping(value = "/financial_services2")
    @ResponseBody
    public Object coreData2(@RequestParam(required = true) String dataType, String plat_name) {
        // 核心数据及集中度
        if (dataType.equals("plat_data")) {
            return "{\"plat_name\":\"来财街\"," +
                    "\"plat_score\":73.2," +
                    "\"other_sum_amount\":0," +
                    "\"bor_num_stay_stil\":1," +
                    "\"inserest_rate\":12.58," +
                    "\"money_stock\":8430.91," +
                    "\"top10_num_amount\":0," +
                    "\"bid_num_stay_stil\":6205," +
                    "\"company_name\":\"阿丽亚路上海投资发展有限公司\"," +
                    "\"plat_status\":\"正常\"," +
                    "\"30_day_net_inflow\":6565.6," +
                    "\"top1_sum_amount\":0," +
                    "\"amount_taotal\":23154.0985," +
                    "\"plat_data_six_month\": [" +
                    "{date: \"2016-08-08\", day_interest_rate: \"5.6\", day_amount: \"100\", day_money_stock: \"578\"}, " +
                    "{date: \"2016-08-09\", day_interest_rate: \"6.6\", day_amount: \"300\", day_money_stock: \"666\"}, " +
                    "{date: \"2016-08-10\", day_interest_rate: \"5.7\", day_amount: \"200\", day_money_stock: \"333\"}, " +
                    "{date: \"2016-08-11\", day_interest_rate: \"5.8\", day_amount: \"400\", day_money_stock: \"123\"}" +
                    "]}";

        } else if (dataType.equals("yuqing")) {
            return "{plat_name: \"投融范\", " +
                    "score: \"10\", " +
                    "warning: [" +
                    "{info:\"上海p2p投融范发逾期公告 承诺9个月内兑付\"}," +
                    "{info:\"投融范一个推子布局的诈骗平台推子兼职诈骗，人人得而诛之\"}," +
                    "{info:\"投融范项目逾期，回款无望\"}" +
                    "]}";

        } else if (dataType.equals("plat_list")) {
            return "{plat_name: \"测试数据\", company_name: \"攀枝花市交通旅游客运有限责任公司\", logo_url: \"http://logo.url.com\"}";

        } else if (dataType.equals("leida")) {
            return "{\"plat_name\":\"今日劫财\"," +
                    "\"penalty_cost\":67.25," +
                    "\"info_disclosure\":69.77," +
                    "\"capital\":76.67," +
                    "\"operation\":73.23," +
                    "\"fluidity\":53.33," +
                    "\"dispersion\":71.73}";

        } else if ("industry_shanghai".equalsIgnoreCase(dataType)) {
            return getIndustry_shanghai();

        } else if ("industry_problem".equalsIgnoreCase(dataType)) {
            return getProblemData();

        } else if ("industry_compare".equalsIgnoreCase(dataType)) {
            return getCompareData();

        } else if ("area_index".equalsIgnoreCase(dataType)) {
            return getAreaIndex();

        } else if ("plat_rank_data".equalsIgnoreCase(dataType)) {
            return getPlatRankData();

        } else {
            return "Not right RequestParam.";
        }
    }


    private List<PlatRankDataDTO> getPlatRankData() {

        List<PlatRankDataDTO> list = new ArrayList<>();

        for (int k = 1; k < 6; k++) {
            PlatRankDataDTO dto = new PlatRankDataDTO();

            dto.setAmount(k * 3);
            dto.setIncome_rate(k * 4);
            dto.setLoan_period(k * 5);
            dto.setPlat_name("平台名称" + k);
            dto.setRank(k);
            dto.setStay_still_of_total(k * 90000);
            list.add(dto);
        }

        return list;

    }


    private List<AreaIndexDTO> getAreaIndex() {

        List<AreaIndexDTO> list = new ArrayList<>();

        for (int k = 0; k < 3; k++) {
            AreaIndexDTO dto = new AreaIndexDTO();

            dto.setArea(k == 0 ? "浦东新区" : (k == 1 ? "虹口区" : "黄浦区"));
            dto.setCompetitiveness(k * 3);
            dto.setEcosystem(k * 2);
            dto.setRank(k * 5);
            dto.setRecognition(k << 3);
            dto.setSafety(k * 9);
            dto.setScale(k * 7);
            list.add(dto);
        }

        return list;

    }


    private List<IndustryCompareDTO> getCompareData() {

        IndustryCompareDTO dto = new IndustryCompareDTO();
        dto.setArea("上海");
        dto.setAmount(1);
        dto.setBalance_loans(10);

        IndustryCompareDTO dto2 = new IndustryCompareDTO();
        dto2.setArea("全国");
        dto2.setAmount(2);
        dto2.setBalance_loans(20);

        return Arrays.asList(dto, dto2);

    }

    /**
     * 获取数据
     *
     * @return List<IndustryShanghaiDTO>
     */
    private List<IndustryProblemDTO> getProblemData() {

        List<IndustryProblemDTO> list = new ArrayList<>();
        for (int year = 2014; year < 2016; year++) {
            for (int m = 1; m < 13; m += 2) {
                IndustryProblemDTO shDto = new IndustryProblemDTO();
                shDto.setDate(year + "-" + (m < 10 ? "0" : "") + m);
                shDto.setArea("上海");
                shDto.setProblem_plat_number(m * 2);
                list.add(shDto);

                IndustryProblemDTO dto = new IndustryProblemDTO();
                dto.setDate(year + "-" + (m < 10 ? "0" : "") + m);
                dto.setArea("全国");
                dto.setProblem_plat_number(m * 3);
                list.add(dto);
            }
        }
        return list;
    }


    private List<IndustryShanghaiDTO> getIndustry_shanghai() {

        List<IndustryShanghaiDTO> list = new ArrayList<>();
        for (int year = 2014; year < 2016; year++) {
            for (int m = 1; m < 13; m += 2) {
                IndustryShanghaiDTO dto = new IndustryShanghaiDTO();
                dto.setDate(year + "-" + (m < 10 ? "0" : "") + m);
                dto.setAmount(m * 2);
                dto.setBorrowed_num(1 + m);
                dto.setInterest_rate(m * 2);
                dto.setInvest_num(1);
                dto.setNew_plat_num(1 + m);
                dto.setTotal_plat_num_sh(2 + m);

                dto.setArea_num(new HashMap<String, Object>());
                dto.getArea_num().put("浦东新区", 3);
                dto.getArea_num().put("黄浦区", 1);

                list.add(dto);
            }
        }
        return list;
    }


//    /**
//     * 平台名称和公司名称
//     *
//     * @return
//     */
//    public String platFormName( String dataType) {
//        return "[{" +
//                "\"plat_name\":\"来财街\"，" +
//                "\"company_name\":\"阿里路亚上海投资有限公司\"}," +
//                "{" +
//                "\"plat_name\":\"91投\"，" +
//                "\"company_name\":\"上海浙鑫金融有限服务有限公司\"},]";
//    }
//
//    /**
//     * 雷达评分
//     *
//     * @param dataType
//     * @return
//     */
//    @RequestMapping("/radarScore")
//    @ResponseBody
//    public String radarScore(String dataType) {
//        return "{\"plat_name\":\"今日劫财\"," +
//                "\"penalty_cost\":67.25," +
//                "\"info_disclosure\":69.77," +
//                "\"capital\":76.67," +
//                "\"operation\":73.23," +
//                "\"fluidity\":53.33," +
//                "\"dispersion\":71.73}";
//    }

}
