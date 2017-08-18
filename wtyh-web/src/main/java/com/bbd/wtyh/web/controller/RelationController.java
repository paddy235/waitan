package com.bbd.wtyh.web.controller;


import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.service.OfflineFinanceService;
import com.bbd.wtyh.service.P2PImageService;
import com.bbd.wtyh.service.impl.relation.RegisterUniversalFilterChainImp;
import com.bbd.wtyh.service.impl.relation.RelationService;
import com.bbd.wtyh.service.impl.relation.SearchAPIandRelatedPartyService;
import com.bbd.wtyh.util.relation.StringUtils;
import com.bbd.wtyh.web.relationVO.AjaxVO;
import com.bbd.wtyh.web.relationVO.CompanyDataStatisticsVO;
import com.bbd.wtyh.web.relationVO.RelationDiagramVO;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 关联方动态图谱控制器
 *
 * @author Barney Lau
 */
@Controller
public class RelationController {
    @Autowired
    private OfflineFinanceService offlinefinanceservice;
    @Autowired
    private RegisterUniversalFilterChainImp registerUniversalFilterChainImp;
    @Autowired
    private RelationService relationService;
    @Autowired
    private SearchAPIandRelatedPartyService searchAPIandRelatedPartyService;

    @Autowired
    private P2PImageService p2PImageService;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/queryDynamicPicData")
    public
    @ResponseBody
    Map<String, List> queryDynamicPicData(HttpServletRequest request) {
        try {
            String companyName = request.getParameter("companyName");
            // p2p 平台名称 传入，查询 公司名称
            String plat_name = request.getParameter("platName");
            if (plat_name != null) {
                PlatDataDO platData = p2PImageService.getPlatData(plat_name);
                companyName = platData == null ? "" : ((platData.getCompany_name() == null) ? "" : platData.getCompany_name());
            }
            String dataVersion = request.getParameter("dataVersion");
            Integer degree = Integer.valueOf(request.getParameter("degree"));
            if (StringUtils.isNullOrEmpty(dataVersion)) {
                dataVersion = (String) request.getSession().getAttribute("defaultVersion");
            }
            RelationDiagramVO relationDiagramVO=offlinefinanceservice.queryRealRealation(companyName, degree);
            Map<String, List> map=new HashedMap();
            map.put("pointList", relationDiagramVO.getPointList());
            map.put("lineList", relationDiagramVO.getLineList());
            return map;
            //return registerUniversalFilterChainImp.queryRelation(companyName, dataVersion, degree);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 动态关联方 目标公司数据基本信息
     * 目标公司名称
     * 被查询公司名称
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes"})
    @RequestMapping("relatedPartyStatistics.do")
    public
    @ResponseBody
    AjaxVO relatedPartyStatistics(HttpServletRequest request) throws Exception {
        String origCompanyName = request.getParameter("origCompanyName");
        String dataVersion = request.getParameter("dataVersion");
        String tarCompanyName = request.getParameter("tarCompanyName");
        Integer degree = Integer.valueOf(request.getParameter("degree"));
        if (StringUtils.isNullOrEmpty(dataVersion)) {
            dataVersion = (String) request.getSession().getAttribute("defaultVersion");
        }
        AjaxVO ajax = new AjaxVO();
        Map<String, List> map = registerUniversalFilterChainImp.queryRelation(origCompanyName, dataVersion, degree);
        if (null != map) {
            CompanyDataStatisticsVO routeList = searchAPIandRelatedPartyService.relatedPartyStatistics(origCompanyName, tarCompanyName, map.get("lineList"));
            if (null != routeList) {
                ajax.setSuccess(1);
                ajax.setObj(routeList);
            } else {
                ajax.setSuccess(0);
            }
        } else {
            ajax.setSuccess(0);
        }
        return ajax;
    }

}
