package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.vo.*;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.RelationDataService;
import com.bbd.wtyh.web.ResponseBean;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 线下理财
 * @author tracy zhou
 * @since  2016/8/8
 */
@Controller
@RequestMapping("/offlineFinance/")
public class OfflineFinanceController {

    @Autowired
    private OfflineFinanceService offlineFinanceService;
    @Autowired
    private RelationDataService relationDataService;


    /**
     * 关联图谱
     * @param request
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "queryDynamicPicData.do")
    public @ResponseBody Map<String, List> queryDynamicPicData(HttpServletRequest request) {
        try {
            String companyName = request.getParameter("companyName");
            String dataVersion = request.getParameter("dataVersion");
            String degreesLevel = request.getParameter("degreesLevel");
            return offlineFinanceService.queryRelation(companyName, dataVersion, degreesLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 风险指数趋势变化图
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "queryStatistics.do")
    @ResponseBody
    public List<StatisticsVO> queryStatistics(HttpServletRequest request) throws ParseException {
        String companyName = request.getParameter("companyName");
        String tabIndex = request.getParameter("tabIndex");
        String areaCode = request.getParameter("areaCode");
        return offlineFinanceService.queryStatistics(companyName, tabIndex, areaCode);
    }

    /**
     * 静态风险指数列表
     * @param request
     * @return
     */
    @RequestMapping(value = "queryRiskData.do")
    @ResponseBody
    public ResponseBean queryRiskData(HttpServletRequest request) {
        String companyName = request.getParameter("companyName");
        String currentDate = request.getParameter("currentDate");
        String areaCode = request.getParameter("areaCode");
        StaticRiskVO vo = offlineFinanceService.queryCurrentStaticRisk(companyName, currentDate, areaCode);
        return ResponseBean.successResponse(vo);
    }

    /**
     * 动态指数时间轴对比图
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "showYEDData.do")
    @ResponseBody
    public ResponseBean showYEDData(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        String companyName = request.getParameter("companyName");
        if(StringUtils.isEmpty(companyName))
        {
            throw new Exception("公司名传入为空");
        }
        String month = request.getParameter("month");
        String targetPath;
        try {
            targetPath = offlineFinanceService.createYED(companyName,month);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return ResponseBean.successResponse(targetPath);
    }

    /**
     * 企业关联方特征指数对比
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "dynamicRiskData.do")
    @ResponseBody
    public ResponseBean dynamicRiskData(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String companyName = request.getParameter("companyName");
        String areaCode = request.getParameter("areaCode");
        String keyword = request.getParameter("kw");
        if(org.apache.commons.lang.StringUtils.isEmpty(companyName))
        {
            throw new Exception("公司名传入为空");
        }
        String currentMonth = request.getParameter("currentMonth");
        String compareMonth = request.getParameter("compareMonth");
        List<String> dataVersionList = null;
        dataVersionList =  relationDataService.queryDateVersion(companyName,areaCode);
        List<MonthVO> monthList = new ArrayList<MonthVO>();
        if(!StringUtils.isEmpty(currentMonth) && !StringUtils.isEmpty(compareMonth)){
            if(dataVersionList.size()>1){
                currentMonth = dataVersionList.get(0);
                compareMonth = dataVersionList.get(1);
            }else if(dataVersionList.size()==1){
                currentMonth = dataVersionList.get(0);
                compareMonth = dataVersionList.get(0);
            }else if(dataVersionList.size()<1){
                throw new Exception("对不起，该公司数据不完整");
            }
        }
        for(int i = 0;i<dataVersionList.size();i++)
        {
            MonthVO m = new MonthVO();
            m.setKey(getMonth(dataVersionList.get(i)));
            m.setValue(dataVersionList.get(i));
            monthList.add(m);
        }
        //比较两个月份的关联方数据
        RelationDataVO vo = relationDataService.compareRelationData(companyName,areaCode, currentMonth, compareMonth);
        //比较两个月动态风险指标结果
        DynamicRiskVO riskvo = relationDataService.compareDynamicRisk(companyName,areaCode, currentMonth, compareMonth);
        Map result = new HashedMap();
        result.put("companyName",companyName);
        result.put("relationData",vo);
        result.put("monthList", monthList);
        result.put("currentMonth", currentMonth);
        result.put("compareMonth", compareMonth);
        result.put("current", getMonth(vo.getCurrentMonth()));
        result.put("compare", getMonth(vo.getCompareMonth()));
        result.put("dynamicRisk",riskvo);
        result.put("keyword", keyword);
        return ResponseBean.successResponse(result);
    }

    /**
     * 公司舆情
     * @return
     */
    @SuppressWarnings("companyNews")
    @RequestMapping("companyNews.do")
    @ResponseBody
    public ResponseBean companyNews(String companyName) {
        String data = offlineFinanceService.companyNews(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     * 静态风险指数构成
     * @param companyName
     * @return
     */
    @RequestMapping("staticRiskIndex.do")
    @ResponseBody
    public ResponseBean staticRiskIndex(String companyName) {
        List<Map> data = offlineFinanceService.staticRiskIndex(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     * 静态风险指数列表
     * @param companyName
     * @return
     */
    @RequestMapping("staticRiskList.do")
    @ResponseBody
    public ResponseBean staticRiskList(String companyName) {
        List<Map> data = offlineFinanceService.staticRiskList(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     * 企业关联方特征指数对比
     * @param companyName 企业名称
     * @param dateA 对比时间
     * @param dateB 对比时间
     * @param typeId 对比内容
     * @return
     */
    @RequestMapping("companyRelatedComparisonChart.do")
    @ResponseBody
    public ResponseBean companyRelatedComparisonChart(String companyName, String dateA, String dateB, Integer typeId) {
        List<Map> data = offlineFinanceService.companyRelatedComparisonChart(companyName, dateA, dateB);
        return ResponseBean.successResponse(data);
    }

    /**
     * 列表展示量化后的风险系数
     * @return
     */
    @RequestMapping("riskFactor.do")
    @ResponseBody
    public ResponseBean riskFactor() {
        List<Map> data = offlineFinanceService.riskFactor();
        return ResponseBean.successResponse(data);
    }

    /**
     * 公司标签
     * @return
     */
    @SuppressWarnings("companyInfo")
    @RequestMapping("companyInfo.do")
    @ResponseBody
    public ResponseBean companyInfo(String companyName) {
        Map data = offlineFinanceService.companyInfo(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     *
     * @param dataVersionString
     * @return
     */
    public String getMonth(String dataVersionString)
    {
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = dateformat.parse(dataVersionString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String month = dateformat1.format(date);
        return month;
    }
}
