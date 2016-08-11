package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.vo.StaticRiskVO;
import com.bbd.wtyh.service.impl.relation.common.Constants;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 线下理财
 * @author tracy zhou
 * @since  2016/8/8
 */
@Controller
@RequestMapping("/offlineFinance")
public class OfflineFinanceController {

    @Autowired
    private OfflineFinanceService offlineFinanceService;

    /**
     * 关联图谱
     * @param request
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/queryDynamicPicData")
    public @ResponseBody Map<String, List> queryDynamicPicData(HttpServletRequest request) {
        try {
            String companyName = request.getParameter("companyName");
            String dataVersion = request.getParameter("dataVersion");
            if (!StringUtils.isEmpty(dataVersion)) {
                dataVersion = (String) request.getSession().getAttribute("defaultVersion");
            }
            return offlineFinanceService.queryRelation(companyName, dataVersion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 公司舆情
     * @return
     */
    @SuppressWarnings("companyNews")
    @RequestMapping("/companyNews")
    @ResponseBody
    public ResponseBean companyNews(String companyName) {
        List<Map> data = offlineFinanceService.companyNews(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     * 静态风险指数构成
     * @param companyName
     * @return
     */
    @RequestMapping("/staticRiskIndex")
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
    @RequestMapping("/staticRiskList")
    @ResponseBody
    public ResponseBean staticRiskList(String companyName) {
        List<Map> data = offlineFinanceService.staticRiskList(companyName);
        return ResponseBean.successResponse(data);
    }

    /**
     * 风险指数趋势变化图
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/queryStatistics")
    @ResponseBody
    public List<StatisticsVO> queryStatistics(HttpServletRequest request) throws ParseException {
        String companyName = request.getParameter("companyName");
        String tabIndex = request.getParameter("tabIndex");
        String areaCode = (String) request.getSession().getAttribute(Constants.SESSION.AREA_CODE);
        return offlineFinanceService.queryStatistics(companyName, tabIndex, areaCode);
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryRiskData")
    @ResponseBody
    public ResponseBean queryRiskData(HttpServletRequest request) {
        String companyName = request.getParameter("companyName");
        String currentDate = request.getParameter("currentDate");
        String areaCode = (String) request.getSession().getAttribute(Constants.SESSION.AREA_CODE);
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
    @RequestMapping(value = "showYEDData")
    @ResponseBody
    public ResponseBean showYEDData(HttpServletRequest request,HttpServletResponse response) throws Exception
    {
        String companyName = request.getParameter("companyName");
        if(org.apache.commons.lang.StringUtils.isEmpty(companyName))
        {
            throw new Exception("公司名传入为空");
        }
        String month = request.getParameter("month");
        String filePath;
        try {
            filePath = offlineFinanceService.createYED(companyName,month);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        String targetPath = "";
        if(new File(filePath).exists())
        {
            targetPath = Constants.mappingPath+File.separator+Constants.attDir+File.separator+new File(filePath).getName();
        }
        return ResponseBean.successResponse(targetPath);
    }



    /**
     * 企业关联方特征指数对比
     * @param companyName 企业名称
     * @param dateA 对比时间
     * @param dateB 对比时间
     * @param typeId 对比内容
     * @return
     */
    @RequestMapping("/companyRelatedComparisonChart")
    @ResponseBody
    public ResponseBean companyRelatedComparisonChart(String companyName, String dateA, String dateB, Integer typeId) {
        List<Map> data = offlineFinanceService.companyRelatedComparisonChart(companyName, dateA, dateB);
        return ResponseBean.successResponse(data);
    }

    /**
     * 列表展示量化后的风险系数
     * @return
     */
    @RequestMapping("/riskFactor")
    @ResponseBody
    public ResponseBean riskFactor() {
        List<Map> data = offlineFinanceService.riskFactor();
        return ResponseBean.successResponse(data);
    }



}
