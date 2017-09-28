package com.bbd.bgo.service.imp.handler;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.CompanyBuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.shiro.ParkMgtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 园区管理-楼宇企业列表 Created by zhaodonghjun on 2017/7/26 0026.
 */
@Component
@Scope("prototype") //非单例模式
public class CompanyBuildingHandler extends AbstractImportHandler<CompanyBuildingDO> {

    @Autowired
    private ParkMgtService parkMgtService;
    @Autowired
    private CompanyService companyService;

    private List<CompanyBuildingDO> listCompanyBuinding = null;

    private Map<String, Integer> checkRepeatMap = new HashMap<>();

    private Logger log = LoggerFactory.getLogger(CompanyBuildingHandler.class);

    String loginName = "";
    Date sqlDate = null;

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    @Override
    public void start(HttpServletRequest request) throws Exception {
        sqlDate = new Date();
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if (null == loginName) {
            loginName = "";
        }
        //Object ob= request.getHeaderNames();
        log.info("开始检查 楼宇企业列表");
        listCompanyBuinding = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        String companyName = row.get("companyName");
        String buildingName = row.get("buildingName");
        String parkName = row.get("parkName");

        int parkId = parkMgtService.queryParkIdByName(parkName);
        if (parkId == 0) {
            addError("园区不存在");
            return false;
        }

        int buildingId = parkMgtService.queryBuildingIdByName(parkId, buildingName);
        if (buildingId == 0) {
            addError("楼宇不存在");
            return false;
        }

        //既不能存在于company_building中，也不能不存在于company中
        CompanyDO companyDO = companyService.getCompanyByName(companyName);
        if (null == companyDO) {
            addError("企业不存在于企业信息表");
            return false;
        }
        Integer companyId = companyDO.getCompanyId();
        if (companyId == null || companyId == 0) {
            addError("企业ID不存在于企业信息表");
            return false;
        }

        Integer companyBuildingId = parkMgtService.queryCompanyBuildingId(buildingId + "", companyId + "");
        if (companyBuildingId != null) {
            addError("企业已存在于该楼宇");
            return false;
        }
        String key = companyId + "_" + buildingId;
        if (checkRepeatMap.containsKey(key)) {
            addError("关联关系【" + companyName + "+" + buildingName + "】在文件中有重复，请检查");
            return false;
        }
        checkRepeatMap.put(key, 1);

        row.put("buildingId", buildingId + "");
        row.put("companyId", companyId + "");
        return true;
    }

    @Override
    public void endRow(Map<String, String> row, CompanyBuildingDO bean) throws Exception {

        bean.setCreateBy(loginName);
        bean.setCreateDate(sqlDate);
        listCompanyBuinding.add(bean);
    }

    @Override
    public void end() throws Exception {
        if (errorList().isEmpty()) {
            baseService.insertList(listCompanyBuinding);
            log.info("导入楼宇企业列表结束");
        } else {
            log.info("导入楼宇企业列表失败，数据有误");
        }
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入楼宇企业列表服务器异常！", e);
    }
}
