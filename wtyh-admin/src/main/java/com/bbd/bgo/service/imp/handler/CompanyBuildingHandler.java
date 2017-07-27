package com.bbd.bgo.service.imp.handler;

import com.bbd.wtyh.domain.CompanyBuildingDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.ImgService;
import com.bbd.wtyh.service.shiro.ParkMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/26 0026.
 */
@Component
@Scope("prototype") //非单例模式
public class CompanyBuildingHandler extends AbstractImportHandler<CompanyBuildingDO> {
    @Autowired
    private ParkMgtService parkMgtService;

    @Override
    public void start(HttpServletRequest request) throws Exception {

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
        if(parkId == 0){
            addError("园区不存在");
            return false;
        }

        int buildingId = parkMgtService.queryBuildingIdByName(parkId,buildingName);
        if(buildingId == 0){
            addError("楼宇不存在");
            return false;
        }
        int companyId = 0;
        //既不能存在于company_building中，也不能不存在于company中

        row.put("buildingId",buildingId + "");
        row.put("companyId",companyId + "");
        return true;
    }

    @Override
    public void endRow(Map<String, String> row, CompanyBuildingDO bean) throws Exception {

    }

    @Override
    public void end() throws Exception {

    }

    @Override
    public void exception(Exception e) {

    }
}
