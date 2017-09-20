package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.HologramQueryDao;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyStatusChangeDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.CompanyStatusChangeMapper;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CompanyStatusChangeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/19 0019.
 */
@Service("companyStatusChangeService")
public class CompanyStatusChangeServiceImpl implements CompanyStatusChangeService{

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private AreaService areaService;
    @Autowired
    private CompanyStatusChangeMapper companyStatusChangeMapper;
    @Autowired
    private HologramQueryDao hologramQueryDao;


    private static final Logger logger = LoggerFactory.getLogger(CompanyStatusChangeServiceImpl.class);
    private static final int REGISTERED_CAPITAL_TYPE_RMB = 1;
    private static final int REGISTERED_CAPITAL_TYPE_DOLLAR = 2;

    @Override
    public void companyStatusChange(boolean isNew,String companyName,Byte newCompanyType) {
        CompanyStatusChangeDO companyStatusChangeDO;
        try{
            companyStatusChangeDO=companyChange(isNew,companyName,newCompanyType);
            if(null!=companyStatusChangeDO){
                //企业信息变更 过来的数据都是人工修改
                companyStatusChangeDO.setAdjustDate(new Date());//调整日期
                companyStatusChangeDO.setSource(3);//人工修改
                companyStatusChangeDO.setOrderDate(companyStatusChangeDO.getAdjustDate());
                companyStatusChangeMapper.insertOne(companyStatusChangeDO);
            }

        }catch (Exception e){
            logger.error("companyIsChange"+e);
        }

    }

    /**
     * for 功杰
     *
     */
    @Override
    public void companyStatusChange(boolean isNew,CompanyDO companyDO, BaseDataDO.Results bddRst) {
        CompanyStatusChangeDO companyStatusChangeDO;
        try{
            companyStatusChangeDO=companyChange(isNew,companyDO,bddRst);
            if(null!=companyStatusChangeDO){
                companyStatusChangeMapper.insertOne(companyStatusChangeDO);
            }

        }catch (Exception e){
            logger.error("companyIsChange:",e);
        }

    }

    /**
     * for 功杰
     *
     */
    public CompanyStatusChangeDO companyChange(boolean isNew, CompanyDO companyDO, BaseDataDO.Results bddRst) {

        Map<String,Object> coInfo=transCompanyInfo(bddRst);
        if(null==coInfo){
            //数据平台查不到这家企业的信息则不记录
            return null;
        }
        return getCompanyStatusDO(isNew,companyDO,companyDO.getCompanyType(),coInfo);
    }

    /**
     * for 老阎
     *
     */
    @Override
    public CompanyStatusChangeDO companyChange(boolean isNew,String companyName,Byte newCompanyType) {

        CompanyDO companyDO=companyMapper.selectByName(companyName);

        Map<String,Object> coInfo=getCompanyInfo(companyName);

        if(null==coInfo || null==companyDO){
            //数据平台查不到这家企业的信息则不记录
            return null;
        }

        return getCompanyStatusDO(isNew,companyDO,newCompanyType,coInfo);

    }


    public Map<String,Object> getCompanyInfo(String companyName) {
        Map<String,Object> coInfo;
        BaseDataDO baseDataDo = hologramQueryDao.companyQyxxDataApi(companyName);
        if(null == baseDataDo || null == baseDataDo.getResults() || null == baseDataDo.getResults().get(0)){
            return null ;
        }

        coInfo = transCompanyInfo(baseDataDo.getResults().get(0));

        return coInfo;

    }


    public Map<String,Object> transCompanyInfo(BaseDataDO.Results bddRst) {
        if(null==bddRst){
            return  null;
        }
        Map companyDO = new HashMap();
        String company_county = bddRst.getJbxx().getCompany_county();
        AreaDO areaDO = areaService.selectByCountyCodeOrProvinceName( company_county,bddRst.getJbxx().getCompany_province() );
        if (null == areaDO) {
            return null;
        }
        companyDO.put("areaId",areaDO.getAreaId());
        companyDO.put("areaName",areaDO.getName());
        String esdate = bddRst.getJbxx().getEsdate();
        if (StringUtils.isNotEmpty(esdate)) {
            companyDO.put("registeredDate",esdate);
        }

        String revokeDate = bddRst.getJbxx().getRevoke_date();
        String cancelDate = bddRst.getJbxx().getCancel_date();
        if (StringUtils.isNotEmpty(revokeDate)) {
            companyDO.put("closedDate",revokeDate);

        }
        if (StringUtils.isNotEmpty(cancelDate)) {
            companyDO.put("closedDate",cancelDate);

        }

        String address = bddRst.getJbxx().getAddress();
        companyDO.put("address",address);

        String companyEnterpriseStatus = bddRst.getJbxx().getEnterprise_status();
        if (StringUtils.isNotEmpty(companyEnterpriseStatus)) {
            companyDO.put("status",companyEnterpriseStatus);
        }

        String regcap = bddRst.getJbxx().getRegcap();
        if (StringUtils.isNotEmpty(regcap)) {
            companyDO.put("registeredCapitalType",REGISTERED_CAPITAL_TYPE_RMB);
            if (regcap.endsWith("美元")) {
                companyDO.put("registeredCapitalType",REGISTERED_CAPITAL_TYPE_DOLLAR);
            }
            regcap = StringUtils.substringBefore(regcap, ".");
            regcap = StringUtils.substringBefore(regcap, "万");
            regcap = regcap.replace(",", "");
            companyDO.put("registeredCapital",Integer.valueOf(regcap));

        }

        return companyDO;

    }

    private CompanyStatusChangeDO getCompanyStatusDO(boolean isNew,CompanyDO companyDO,Byte newCompanyType,Map<String,Object> coInfo){
        String now=(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).substring(0,7);

        Integer oldCompanyType=companyDO.getCompanyType().intValue();
        CompanyStatusChangeDO companyStatusChangeDO=new CompanyStatusChangeDO();
        companyStatusChangeDO.setCompanyId(companyDO.getCompanyId());
        companyStatusChangeDO.setCompanyName(companyDO.getName());//公司名称
        companyStatusChangeDO.setCompanyType(newCompanyType.intValue());//新金融类型
        companyStatusChangeDO.setAreaId((Integer)coInfo.get("areaId"));//地区ID
        companyStatusChangeDO.setAreaName((String)coInfo.get("areaName"));//地区名称
        companyStatusChangeDO.setAddress((String)coInfo.get("address"));//注册地址
        companyStatusChangeDO.setRegisteredCapitalType((Integer) coInfo.get("registeredCapitalType"));//注册资本类型
        companyStatusChangeDO.setRegisteredCapital((Integer) coInfo.get("registeredCapital"));//注册资本
        companyStatusChangeDO.setCreateBy("system");
        companyStatusChangeDO.setCreateDate(new Date());

        String statusName=(String)coInfo.get("status");//状态
        Integer statusType=1;
        if(statusName!=null){
            if(!(statusName.contains("存续")||statusName.contains("在营")||statusName.contains("开业")) ){
                statusType=2;//变化类型 2:停业
                companyStatusChangeDO.setChangeType(statusType);
                Object closeStr=coInfo.get("closedDate");
                if(closeStr!=null){
                    try {
                        companyStatusChangeDO.setClosedDate(DateUtils.parseDate((String)closeStr, "yyyy-MM-dd"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                companyStatusChangeDO.setClosedType(CompanyStatusChangeDO.getClosedTypeByName(statusName));
            }else{
                companyStatusChangeDO.setChangeType(1);//变化类型 1:新增
            }
        }

        if(isNew){
            //取注册日期
            String registeredDate=(String)coInfo.get("registeredDate");
            //注册日期等于本月，则为新注册；否则为新发现
            String regDate="0000-00-00";
            if(registeredDate!=null && registeredDate.length()>6){
                regDate=registeredDate.substring(0,7);
            }
            if(regDate.equals(now)){
                //新注册
                try {
                    companyStatusChangeDO.setRegisterDate(DateUtils.parseDate((String)registeredDate, "yyyy-MM-dd"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                companyStatusChangeDO.setSource(1);//新注册
                companyStatusChangeDO.setOrderDate(companyStatusChangeDO.getRegisterDate());
            }else{
                //新发现
                try {
                    companyStatusChangeDO.setRegisterDate(DateUtils.parseDate((String)registeredDate, "yyyy-MM-dd"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                companyStatusChangeDO.setAdjustDate(new Date());//调整日期
                companyStatusChangeDO.setSource(2);//新发现
                companyStatusChangeDO.setOrderDate(companyStatusChangeDO.getAdjustDate());
            }

        }else{
            int oldType=oldCompanyType==null?0:oldCompanyType;
            int newType=newCompanyType==null?0:newCompanyType;

            if(oldType==newType){
                return null ;
            }
            companyStatusChangeDO.setOldCompanyType(oldCompanyType);
            companyStatusChangeDO.setRegisterDate(companyDO.getRegisteredDate());
            companyStatusChangeDO.setAdjustDate(new Date());//调整日期
            companyStatusChangeDO.setSource(2);//新发现
            companyStatusChangeDO.setOrderDate(companyStatusChangeDO.getAdjustDate());

        }

        return companyStatusChangeDO;
    }
}
