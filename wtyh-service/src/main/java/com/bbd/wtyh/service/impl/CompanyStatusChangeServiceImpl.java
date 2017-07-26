package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyStatusChangeDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.mapper.AreaMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.CompanyStatusChangeMapper;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CompanyStatusChangeService;
import com.bbd.wtyh.service.HologramQueryService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/19 0019.
 */
public class CompanyStatusChangeServiceImpl implements CompanyStatusChangeService{

    @Autowired
    private HologramQueryService hologramQueryService;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private AreaService areaService;
    @Autowired
    private CompanyStatusChangeMapper companyStatusChangeMapper;


    private static final Logger logger = LoggerFactory.getLogger(CompanyStatusChangeServiceImpl.class);
    private static final int REGISTERED_CAPITAL_TYPE_RMB = 1;
    private static final int REGISTERED_CAPITAL_TYPE_DOLLAR = 2;

    @Override
    public void companyStatusChange(boolean isNew,Integer companyId,String companyName,
                                                 Integer oldCompanyType,Integer newCompanyType) {
        CompanyStatusChangeDO companyStatusChangeDO;
        try{
            companyStatusChangeDO=companyChange(isNew,companyId,companyName,oldCompanyType,newCompanyType);
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
            logger.error("companyIsChange"+e);
        }

    }

    /**
     * for 功杰
     *
     */
    public CompanyStatusChangeDO companyChange(boolean isNew, CompanyDO companyDO, BaseDataDO.Results bddRst) {


        String now=(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).substring(0,7);


        Map<String,Object> coInfo=transCompanyInfo(bddRst);
        if(null==coInfo){
            //数据平台查不到这家企业的信息则不记录
            return null;
        }
        CompanyStatusChangeDO companyStatusChangeDO=new CompanyStatusChangeDO();
        companyStatusChangeDO.setCompanyId(companyDO.getCompanyId());
        companyStatusChangeDO.setCompanyName(companyDO.getName());//公司名称
        companyStatusChangeDO.setCompanyType(companyDO.getCompanyType().intValue());//新金融类型
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
            if(!statusName.startsWith("存续")){
                statusType=2;
                companyStatusChangeDO.setChangeType(2);//变化类型 2:停业
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
            int oldType=companyDO.getOldCompanyType()==null?0:companyDO.getOldCompanyType();
            int newType=companyDO.getCompanyType()==null?0:companyDO.getCompanyType();

            if(oldType==newType){
                return null ;
            }
            companyStatusChangeDO.setOldCompanyType(companyDO.getOldCompanyType().intValue());
            companyStatusChangeDO.setRegisterDate(companyDO.getRegisteredDate());
            companyStatusChangeDO.setAdjustDate(new Date());//调整日期
            companyStatusChangeDO.setSource(2);//新发现
            companyStatusChangeDO.setOrderDate(companyStatusChangeDO.getAdjustDate());

        }

        return companyStatusChangeDO;
    }


    @Override
    public CompanyStatusChangeDO companyChange(boolean isNew,Integer companyId,String companyName,
                                               Integer oldCompanyType,Integer newCompanyType) {


        String now=(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).substring(0,7);


        Map<String,Object> coInfo=getCompanyInfo(companyName);
        if(null==coInfo){
            //数据平台查不到这家企业的信息则不记录
            return null;
        }
        CompanyStatusChangeDO companyStatusChangeDO=new CompanyStatusChangeDO();
        companyStatusChangeDO.setCompanyId(companyId);
        companyStatusChangeDO.setCompanyName(companyName);//公司名称
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
            if(!statusName.startsWith("存续")){
                statusType=2;
                companyStatusChangeDO.setChangeType(2);//变化类型 2:停业
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
            CompanyDO companyDO=companyMapper.getCompanyById(companyId);
            companyStatusChangeDO.setOldCompanyType(oldCompanyType);
            companyStatusChangeDO.setRegisterDate(companyDO.getRegisteredDate());
            companyStatusChangeDO.setAdjustDate(new Date());//调整日期
            companyStatusChangeDO.setSource(2);//新发现
            companyStatusChangeDO.setOrderDate(companyStatusChangeDO.getAdjustDate());

        }

        return companyStatusChangeDO;

    }


    public Map<String,Object> getCompanyInfo(String companyName) {

        Map batchData = hologramQueryService.getBbdQyxxBatch(companyName);
        if (CollectionUtils.isEmpty(batchData)) {
            return null ;
        }
        String msg = (String) (batchData.get("msg"));
        if (null == msg || !msg.equals("ok")) {
            return null;
        }
        List<Map> results = (List) (batchData.get("results"));
        if (CollectionUtils.isEmpty(results)) {
            return null;
        }
        Map<String, Object> result = (Map<String, Object>) results.get(0);
        Map<String, Object> jbxx = (Map<String, Object>) result.get("jbxx");
        Map companyDO = new HashMap();
        String company_county = (String) (result.get("company_county"));
        Integer areaId = ShanghaiAreaCode.getCodeToAreaMap().get(Integer.valueOf(company_county));
        if (null == areaId) {
            return null;
        }
        AreaDO areaDO=areaMapper.getAreaByAreaId(areaId);
        companyDO.put("areaId",areaId);
        companyDO.put("areaName",areaDO==null?null:areaDO.getName());
        String esdate = (String) jbxx.get("esdate");
        if (StringUtils.isNotEmpty(esdate)) {
            companyDO.put("registeredDate",esdate);
        }

        String revokeDate = (String) jbxx.get("revoke_date");
        String cancelDate = (String) jbxx.get("cancel_date");
        if (StringUtils.isNotEmpty(revokeDate)) {
            companyDO.put("closedDate",revokeDate);

        }
        if (StringUtils.isNotEmpty(cancelDate)) {
            companyDO.put("closedDate",cancelDate);

        }

        String address = (String) jbxx.get("address");
        companyDO.put("address",address);

        String companyEnterpriseStatus = (String) jbxx.get("company_enterprise_status");
        if (StringUtils.isNotEmpty(companyEnterpriseStatus)) {
            companyDO.put("status",companyEnterpriseStatus);
        }

        String regcap = (String) jbxx.get("regcap");
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
}
