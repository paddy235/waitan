package com.bbd.wtyh.web.controller;

import com.bbd.higgs.utils.StringUtils;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.domain.dto.IndustryCompareDTO;
import com.bbd.wtyh.domain.dto.IndustryProblemDTO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.redis.RedisDAO;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.service.ShareholderRiskService;
import com.bbd.wtyh.util.CalculateUtils;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesLinesBean;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * P2P行业监测平台
 *
 * @author Ian.Su
 * @since 2016年8月7日 下午2:02:01
 */
@Controller
@RequestMapping("/PToPMonitor")
public class PToPMonitorController {

    Logger log = LoggerFactory.getLogger(getClass());
    private static final String PLAT_RANK_CACHE_PRIFIX = "wtyh:pToPMonitor:platRank";

    @Autowired
    private AreaService areaService;

    @Autowired
    private PToPMonitorService pToPMonitorService;

    @Autowired
    private P2PImageService p2PImageService;

    @Autowired
    private ShareholderRiskService shareholderRiskService;

    @Autowired
    private RedisDAO redisDAO;


    /**
     * 平台状态信息
     *
     * @return ResponseBean
     */
    @RequestMapping("/hot")
    @ResponseBody
    public ResponseBean hot() {

        List<NvDO> list = areaService.hot();

        return ResponseBean.successResponse(list);

    }


    /**
     * 1：公司分布地图，成交量和综合利率，问题平台比例，行业人气，网贷数据对比 综合接口
     *
     * @return ResponseBean
     * @throws Exception
     */
    @RequestMapping("/integrated")
    @ResponseBody
    public Object integrated() throws Exception {

        Map<String, Object> map = new LinkedHashMap<>();

        List<IndustryShanghaiDTO> list = pToPMonitorService.getData();

        map.put("hotMap", hotMap(list));

        map.put("newly", newlyPlat(list));

        map.put("bargain", bargain(list));

        List<IndustryProblemDTO> problemData = pToPMonitorService.getProblemData();

        map.put("problem", problem(problemData));

        map.put("popularity", popularity(list));

        map.put("compare", compare(pToPMonitorService.getCompareData()));


        return ResponseBean.successResponse(map);
    }


    /**
     * 热力图
     *
     * @return XAxisSeriesLinesDO<Integer>
     */
    public Map<String, Object> hotMap(List<IndustryShanghaiDTO> list) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("title", "热力图");
        if (CollectionUtils.isEmpty(list)) {
            map.put("data", new ArrayList<>());
            return map;
        }

//        IndustryShanghaiDTO maxDto = list.get(0);
//        for (IndustryShanghaiDTO dto : list) {
//            if (maxDto.getDate().compareTo(dto.getDate()) <= 0) {
//                maxDto = dto;
//            }
//        }
        IndustryShanghaiDTO maxDto = null;
        for (IndustryShanghaiDTO dto : list) {
            if (dto.getArea_num() != null && dto.getArea_num().size() > 0) {
                maxDto = dto;
                break;
            }
        }

        Map<String, Object> ja = null;
        Map<String, Object> zb = null;
        List<Map<String, Object>> data = new ArrayList<>();
        for (Map.Entry<String, Object> entry : maxDto.getArea_num().entrySet()) {
            Map<String, Object> areaNum = new HashMap<>();
            areaNum.put("name", "浦东".equals(entry.getKey()) ? "浦东新区" : entry.getKey() + (entry.getKey().endsWith("区") ? "" : "区"));
            areaNum.put("value", entry.getValue());
            if (entry.getKey().contains("闸北")) {
                zb = areaNum;
                continue;
            } else if (entry.getKey().contains("静安")) {
                ja = areaNum;
            }
            data.add(areaNum);
        }
        if (ja != null && zb != null)
            ja.put("value", Double.valueOf(zb.get("value").toString()) + Double.valueOf(ja.get("value") + ""));

        map.put("data", data);
        return map;
    }


    /**
     * 网贷数据对比(上海VS全国)
     *
     * @param
     * @return XAxisSeriesLinesDTO<Double>
     */
    private XAxisSeriesLinesBean<Double, String> compare(List<IndustryCompareDTO> list) {
        @SuppressWarnings("unchecked")
        XAxisSeriesLinesBean<Double, String> data = new XAxisSeriesLinesBean<Double, String>(
                new ArrayList<Double>(),
                new ArrayList<Double>());
        data.setTitle("网贷数据对比(上海VS全国)");
        if (CollectionUtils.isEmpty(list)) {
            return data;
        }

        data.setxAxis(Arrays.asList("贷款余额", "成交量"));
        for (IndustryCompareDTO dto : list) {
            if ("全国".equals(dto.getArea())) {
                data.getSeries()[0].add(0, dto.getBalance_loans());
                data.getSeries()[1].add(0, dto.getAmount());
            } else {
                data.getSeries()[0].add(dto.getBalance_loans());
                data.getSeries()[1].add(dto.getAmount());
            }
        }


        return data;
    }


    /**
     * 行业人气
     *
     * @return XAxisSeriesLinesDO<Double>
     */
    public XAxisSeriesLinesBean<Double, String> popularity(List<IndustryShanghaiDTO> list) {

        @SuppressWarnings("unchecked")
        XAxisSeriesLinesBean<Double, String> data = new XAxisSeriesLinesBean<>(
                new ArrayList<Double>(),
                new ArrayList<Double>());
        data.setTitle("行业人气");
        if (CollectionUtils.isEmpty(list)) {
            return data;
        }

        Map<String, Double[]> map = new TreeMap<>();

        for (IndustryShanghaiDTO dto : list) {

            Double[] as = map.get(dto.getDate());
            if (as == null) {
                as = new Double[]{0.0, 0.0};
            }
            as[0] += dto.getInvest_num();
            as[1] += dto.getBorrowed_num();
            map.put(dto.getDate(), as);
        }

        for (Map.Entry entry : map.entrySet()) {
            Double[] as = (Double[]) entry.getValue();
            as[0] = CalculateUtils.divide(as[0], 10000, 2);
            as[1] = CalculateUtils.divide(as[1], 10000, 2);
            entry.setValue(as);
        }


        data.getxAxis().addAll(map.keySet());

        Iterator<Double[]> it = map.values().iterator();
        while (it.hasNext()) {
            Double[] lines = it.next();
            data.getSeries()[0].add(lines[0]);
            data.getSeries()[1].add(lines[1]);
        }

        return data;
    }


    /**
     * 问题平台比例
     *
     * @return XAxisSeriesLinesDO<Integer>
     */
    private XAxisSeriesLinesBean<Integer, String> problem(List<IndustryProblemDTO> list) {
        @SuppressWarnings("unchecked")
        XAxisSeriesLinesBean<Integer, String> data = new XAxisSeriesLinesBean<>(
                new ArrayList<Integer>(),
                new ArrayList<Integer>());
        data.setTitle("问题平台比例");
        if (CollectionUtils.isEmpty(list)) {
            return data;
        }

        Map<String, Integer[]> map = new TreeMap<>();

        for (IndustryProblemDTO dto : list) {

            Integer[] as = map.get(dto.getDate());
            if (as == null) {
                as = new Integer[]{0, 0};
            }
            as["全国".equals(dto.getArea()) ? 1 : 0] += dto.getProblem_plat_number();
            map.put(dto.getDate(), as);
        }

        data.getxAxis().addAll(map.keySet());

        Iterator<Integer[]> it = map.values().iterator();
        while (it.hasNext()) {
            Integer[] nums = it.next();
            data.getSeries()[0].add(nums[0]);
            data.getSeries()[1].add(nums[1]);
        }
        return data;
    }


    /**
     * 上海新增平台发展趋势
     *
     * @return XAxisSeriesBarLineDO<Integer>
     */
    public XAxisSeriesBarLineBean<Integer, String> newlyPlat(List<IndustryShanghaiDTO> list) {
        XAxisSeriesBarLineBean<Integer, String> data = new XAxisSeriesBarLineBean<>();
        data.setTitle("上海新增平台发展趋势");
        if (CollectionUtils.isEmpty(list)) {
            return data;
        }

        for (int i = list.size() - 1; i > -1; i--) {
            IndustryShanghaiDTO dto = list.get(i);
            data.getxAxis().add(dto.getDate());
            data.getSeries().getBar().add(dto.getNew_plat_num());
            data.getSeries().getLine().add(dto.getTotal_plat_num());
        }

        return data;
    }


    /**
     * 成交和综合利率
     *
     * @return XAxisSeriesBarLineDO<Integer>
     */
    private XAxisSeriesBarLineBean<Double, String> bargain(List<IndustryShanghaiDTO> list) {
        XAxisSeriesBarLineBean<Double, String> data = new XAxisSeriesBarLineBean<Double, String>();
        data.setTitle("成交和综合利率");
        if (CollectionUtils.isEmpty(list)) {
            return data;
        }

        Map<String, double[]> map = new TreeMap<>();

        for (IndustryShanghaiDTO dto : list) {
            map.put(dto.getDate(), new double[]{dto.getInterest_rate(), dto.getAmount()});
        }

        data.getxAxis().addAll(map.keySet());

        Iterator<double[]> it = map.values().iterator();
        while (it.hasNext()) {
            double[] newTot = it.next();
            data.getSeries().getBar().add(newTot[1]);
            data.getSeries().getLine().add(newTot[0]);
        }
        return data;
    }


    /**
     * 上海区域发展指数排名
     *
     * @return ResponseBean
     * @throws Exception
     */
    @RequestMapping("/areaIndex")
    @ResponseBody
    public Object areaIndex() throws Exception {

        return ResponseBean.successResponse(pToPMonitorService.getAreaIndex());

    }


    private List<Map<String, String>> filterPlatRankDataStatus(List<Map<String, String>> list, String platStatus) {
        List<Map<String, String>> rst = new ArrayList<>();
        if (!Strings.isNullOrEmpty(platStatus)) {
            for (Map<String, String> element: list) {
                if (element.get("plat_status").equals(platStatus)) {
                    rst.add(element);
                }
            }
            return rst;
        } else {
            return list;
        }

    }

    /**
     * 上海网贷平台数据展示
     *
     * @return ResponseBean
     * @throws Exception
     */
    @RequestMapping("/platRankData")
    @ResponseBody
    public Object platRankData(@RequestParam(required = false, defaultValue = "") String platStatus) throws Exception {
        List<Map<String, String>> rstCache = (List<Map<String, String>>) redisDAO.getObject(PLAT_RANK_CACHE_PRIFIX);
        if (null != rstCache) {
            return ResponseBean.successResponse(filterPlatRankDataStatus(rstCache, platStatus));
        }

        List<PlatRankDataDTO> list = pToPMonitorService.getPlatRankData();
        if (CollectionUtils.isEmpty(list)) {
            return ResponseBean.successResponse(new ArrayList<>());
        }

        List<Map> rst1 = new ArrayList<>();
        Map<String, PlatListDO> wangdaiPlatList = p2PImageService.getWangdaiPlatList();
        for (PlatRankDataDTO dto : list) {
            Map<String, Object> rst = new HashMap<>();
            rst.put("rank", dto.getRank());
            rst.put("plat_name", dto.getPlat_name());
            try {
                rst.put("amount", CalculateUtils.divide(dto.getAmount(), 100000000, 2));
            } catch (Exception e) {
            }
            rst.put("income_rate", dto.getIncome_rate() == null ? "" : dto.getIncome_rate());
            rst.put("loan_period", dto.getLoan_period() == null ? "" : dto.getLoan_period());
            rst.put("stay_still_of_total", CalculateUtils.divide(dto.getStay_still_of_total(), 100000000, 2));
            rst.put("plat_status", dto.getPlat_status());
            rst.put("registered_address", dto.getRegistered_address());
            if (wangdaiPlatList.get(dto.getPlat_name()) == null) {//处理空指针异常
                rst.put("OffLineFinanceNum", 0);
            } else {
                rst.put("OffLineFinanceNum", pToPMonitorService.getOfflineFinanceNum(p2PImageService.findCompanyNameFromDbThenAPI(dto.getPlat_name(), wangdaiPlatList)));
            }

            rst1.add(rst);
        }

        if (null != rst1) {
            redisDAO.addObject(PLAT_RANK_CACHE_PRIFIX, rst1, Constants.REDIS_10, rst1.getClass());
        }

        return ResponseBean.successResponse(rst1);
    }


    @RequestMapping("/offlineFinanceNum")
    @ResponseBody
    public ResponseBean shareholderRiskDetail(String platName) {
        if (Strings.isNullOrEmpty(platName)) {
            return ResponseBean.errorResponse("platName must be not null");
        }
        Map<String, PlatListDO> wangdaiPlatList = p2PImageService.getWangdaiPlatList();
        return ResponseBean.successResponse(shareholderRiskService.getRelatedCompany(p2PImageService.findCompanyNameFromDbThenAPI(platName, wangdaiPlatList)).asMap());
    }


    /**
     * 测试是否有”公司信息“
     *
     * @return
     */
    @RequestMapping("/hasOrNotInfo")
    @ResponseBody
    public ResponseBean hasOrNotCompany(@RequestParam(required = true) String platName) {
        Map<String, Object> hasOrNotCompany = p2PImageService.platFormStatus(platName);
        PlatListDO platListDO = p2PImageService.findFromWangdaiPlatList(platName);

        Map<String, Object> rst = new HashMap<>();
        if (null == hasOrNotCompany) {
            rst.put("isGoToP2P", false);
            if (null == platListDO) {
                rst.put("companyName", "");
            } else {
                rst.put("companyName", platListDO.getCompany_name());
            }
        } else {
            if (StringUtils.isNullOrEmpty(String.valueOf(hasOrNotCompany.get("score")))) {
                rst.put("isGoToP2P", false);
                if (StringUtils.isNullOrEmpty(String.valueOf(hasOrNotCompany.get("companyName")))) {
                    if (null == platListDO) {
                        rst.put("companyName", "");
                    } else {
                        rst.put("companyName", platListDO.getCompany_name());
                    }
                }
            } else {
                rst.put("companyName", hasOrNotCompany.get("companyName"));
            }
            rst.put("isGoToP2P", true);
            rst.put("platName", platName);
        }
        return ResponseBean.successResponse(rst);
    }
}
