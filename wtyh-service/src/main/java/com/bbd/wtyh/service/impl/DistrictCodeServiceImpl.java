package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.Area1DO;
import com.bbd.wtyh.domain.DistrictCodeDO;
import com.bbd.wtyh.service.DistrictCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/1.
 */

@Service
public class DistrictCodeServiceImpl implements DistrictCodeService {

    private Logger log = LoggerFactory.getLogger(DistrictCodeServiceImpl.class);

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    @Override
    public String ImportDistrictCode() {
        log.info( "导入开始：" );
        failCnt =0;
        List< DistrictCodeDO > scrData=baseService.selectAll(DistrictCodeDO.class, "");
        log.info( "临时表中代码共计[{}]条。", scrData.size() );
        for( int rowNum =0 ;rowNum <scrData.size(); rowNum++ ) {
            endRow(rowNum , scrData.get(rowNum));
        }
        log.info( "导入已完成。" );
        return "导入已完成！";
    }


    private String lastPro ="";
    private String lastCity ="";
    private int dbLastPro =0;
    private int failCnt =0;

    public void endRow(int rowNum, DistrictCodeDO bean)  {
        if ( null ==bean || null ==bean.getCode() || null ==bean.getName() ||
                null ==bean.getProCode()|| null ==bean.getCityCode()|| null ==bean.getTownCode() ) {
            log.info( "第[{}]行转换失败", rowNum );
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
            log.info( "NM[{}]-ndCode[{}]", bean.getName(), bean.getCode() );
            failCnt++;
        }
    }
}
