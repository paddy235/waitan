package com.bbd.bgo.service.imp.handler.assist;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.Area1DO;
import com.bbd.wtyh.domain.DistrictCodeDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbd.bgo.service.imp.handler.CompanyLevelHandler;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;

/**
 * Created by cgj on 2017/7/19.
 */

@Component
@Scope("prototype") //非单例模式
public class DistrictCodeHandler extends AbstractImportHandler<DistrictCodeDO> {

    final static String caption ="区县代码导入";

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    private List<CompanyDO> tempList = new LinkedList<>();

    String loginName ="";

    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="";
        }
        log.info("开始检查" +caption);
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        //int aa =row.size();
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        return true;
    }

    String lastPro ="";
    String lastCity ="";
    int dbLastPro =0;
    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, DistrictCodeDO bean) throws Exception {
        if ( null ==bean || null ==bean.getCode() || null ==bean.getName() ||
         null ==bean.getProCode()|| null ==bean.getCityCode()|| null ==bean.getTownCode() ) {
            log.info( "第[{}]行转换失败", getRowNumber() );
            return;
        }
        String name =bean.getName();
        int level =3;
        if ( 0 ==bean.getTownCode() ) {
            if ( 0 ==bean.getCityCode() ) {
                level =1;
                lastPro =bean.getName();
            } else {
                lastCity =bean.getName();
                level =2;
                if( name.contains("市辖区") ) {
                    name =lastPro +name;
                }
            }
        } else {
            if ( 90 ==bean.getCityCode() ) {
                level =2;
            }
            if( name.contains("市辖区") ) {
                name =lastCity +name;
            }
        }
        if ( name.indexOf("族") >=3 || name.lastIndexOf("自治区")  >=2 ) {
            name = name.substring(0, 2);
        }  else {
            if (name.length() > 4) {
                name = name.substring(0, 4);
            }
            int endCut = name.indexOf("地区");
            if (endCut < 2) {
                endCut = name.lastIndexOf("区");
            }
            if (endCut < 2) {
                endCut = name.indexOf("县");
            }
            if (endCut < 2) {
                endCut = name.indexOf("市");
            }
            if (endCut < 2) {
                endCut = name.indexOf("省");
            }
            if (endCut < 2) {
                endCut = name.lastIndexOf("州");
            }
            if (endCut >= 2) {
                name = name.substring(0, endCut);
            }
        }
        String strWhere =" `level` = " +level +" AND `name` LIKE '%" +name +"%' ";
        if ( level >1 && dbLastPro >0 ) {
            strWhere = "`province_id` = '" +dbLastPro +"' AND " +strWhere;
        }
        Area1DO area=baseService.selectOne(Area1DO.class, strWhere);
        if ( null !=area ) {
            if ( 1 ==level ) { //更新对应db的省级代码
                dbLastPro =area.getProvinceId();
            }
            Area1DO updateD =new Area1DO();
            updateD.setAreaId( area.getAreaId() );
            updateD.setNationDistrictCode( bean.getCode() );
            baseService.update(updateD);
            //log.info( "[{}]-ndCode[{}]-->[{}]-areaId[{}]", bean.getName(), bean.getCode(), area.getName(), area.getAreaId() );
        } else {
            log.info( "未匹配到[{}]-ndCode[{}]", bean.getName(), bean.getCode() );
        }
    }

    @Override
    public void end() throws Exception {
        log.info(caption +"导入已完成");
    }


    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入" +caption +"时服务器异常 ", e);
    }

}
