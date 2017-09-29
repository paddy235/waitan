package com.bbd.bgo.service.imp.handler;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.bgo.service.imp.handler.company.modify.validator.RiskValidatorFactory;
import com.bbd.bgo.service.imp.handler.company.modify.validator.RiskValueConverter;
import com.bbd.wtyh.constants.CompanyType;
import com.bbd.wtyh.constants.RiskChgCoSource;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.web.companyInfoModify.ModifyData;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;

/**
 * Created by cgj on 2017/9/25.
 */

@Component
@Scope("prototype") //非单例模式
public class ExchangeHandler extends AbstractImportHandler<ExchangeCompanyDO> {

    final static String caption ="交易场所-交易场所";

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    private List<CompanyDO> tempList = new LinkedList<>();
    private List<ExchangeCompanyDO> ecList = new LinkedList<>();

    CompanyImportAssist companyImportAssist;

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    @Autowired
    private CoRiskChgService coRiskChgService;

    String loginName ="";


    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="System";
        }
        companyImportAssist =new CompanyImportAssist( errorList(), getSheet() );
        //Object ob= request.getHeaderNames();
        log.info("开始检查 " + caption);
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        //int aa =row.size();
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        //正则：整数或者小数：^[0-9]+([.][0-9]+){0,1}$，只能输入至少一位数字"\\d+"，"+"等价于{1,}
        String companyName =row.get("companyName");
        if( StringUtils.isBlank( companyName ) || companyName.length() <3 ) {
            addError("企业名称格式错误");
            return false;
        }
        int [] validCntA = { 0 ,0 }; //[0]格式正确，[1]格式错误
        FunIf1 f1 =(String nameStr, String  capName)->{
            String val =row.get(nameStr);
            if( StringUtils.isNotBlank( val ) ) {
                validCntA[0]++;
                //addError(capName +" 内容错误");
            }
        };
        f1.fun("establishWay", "设立途径" );
        f1.fun("approveDepartment", "审批部门" );
        f1.fun("supervise_department", "监管部门" );
        f1.fun("riskLevel", "风险等级" );
        f1.fun("website", "网址" );
        if( validCntA[0] <1 ) {
            addError("选填参数数量不足");
            return false;
        }
        return true;
    }

    @FunctionalInterface
    interface FunIf1 {
        void fun(String numName, String capName);
    }
    @FunctionalInterface
    interface FunIf2 {
        void fun(String typeVal, int riskType);
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, ExchangeCompanyDO bean) throws Exception {
        ecList.add(bean);

        Byte status =null;
        switch (bean.getEstablishWay()) {
            case "市政府及市相关主管单位批复设立" :
                status =1;
                break;
            case "企业自行设立" :
                status =2;
                break;
            case "2013年通过清理整联办验收" :
                status =5;
        }
        bean.setStatus(status);
        Byte type =null;
        switch (bean.getDataSrc()) {
            case "金融办" :
                type =1;
                break;
            case "BBD" :
                type =2;
        }
        bean.setType(type);

        CompanyDO cDo=new CompanyDO();
        tempList.add(cDo);
        cDo.setName( bean.getCompanyName() );
        cDo.setCompanyType( CompanyDO.companyType( "交易场所" ) );
        RiskValueConverter converter = RiskValidatorFactory.validator(CompanyType.TYPE_JYS_9.desc());
        String rV = converter.convertDigit(bean.getRiskLevel());
        cDo.setRiskLevel( StringUtils.isBlank(rV) ? null : Integer.valueOf(rV) );
        cDo.setId(getRowNumber()); //将行号存下
        if( tempList.size() <200 ) {
            return;
        }
        companyImportAssist.processCp(tempList); //processCp( );
    }

    @Override
    public void end() throws Exception {
        if ( tempList.size() >0 ) {
            //有企业没有处理完
            companyImportAssist.processCp(tempList); //processCp( );
        }
        if( errorList().size() >0 ) {
            addError("用户上传的 " +caption +" 中的数据有误，所有数据均不予入库");
            log.warn("用户上传的 " +caption +" 中的数据有误，所有数据均不予入库");
            return;
        }
        companyImportAssist.save(loginName);
        List< Map.Entry<CompanyDO, BaseDataDO.Results> > searchList =companyImportAssist.getResultList();
        for ( ExchangeCompanyDO ecDo : ecList ) {
            CompanyDO locCDo =null;
            for ( Map.Entry<CompanyDO, BaseDataDO.Results> me : searchList ) {
                if ( me.getKey().getName().equals(ecDo.getCompanyName()) ) {
                    locCDo =me.getKey();
                }
            }
            if ( null ==locCDo) continue;
            ecDo.setCompanyId( locCDo.getCompanyId() );
            //写和更新exchange_company表
            ExchangeCompanyDO srcEc =baseService.selectById(ExchangeCompanyDO.class, locCDo.getCompanyId());
            if ( null ==srcEc ) {
                ecDo.setCreateBy(loginName);
                ecDo.setCreateDate(new Date());
                baseService.insert(ecDo);
            } else {
                ecDo.setUpdateDate(new Date());
                ecDo.setUpdateBy(loginName);
                baseService.update(ecDo);
            }
        }
        //更新风险变化记录
         for ( Map.Entry<CompanyDO, BaseDataDO.Results>  updateList : companyImportAssist.getUpdateList() ) {
             CompanyDO locCDo =updateList.getKey();
             if ( locCDo.getRiskLevel() != locCDo.getAnalysisResult() ) {
                 /*RiskChgCoDo riskChgCoDo = new RiskChgCoDo();
                 // 区域
                 AreaDO areaDO = this.baseService.selectById(AreaDO.class, riskChgCoDo.getAreaId());
                 if (areaDO != null) {
                     riskChgCoDo.setAreaName(areaDO.getName());
                 }
                 // 楼宇
                 BuildingDO buildingDO = this.baseService.selectById(BuildingDO.class, riskChgCoDo.getCompanyId());
                 if (buildingDO != null) {
                     riskChgCoDo.setBuildingId(buildingDO.getBuildingId());
                     riskChgCoDo.setBuildingName(buildingDO.getName());
                 }
                 riskChgCoDo.setCompanyId(locCDo.getCompanyId());
                 riskChgCoDo.setCompanyName(locCDo.getName());
                 riskChgCoDo.setCompanyType(locCDo.getCompanyType().intValue());
                 riskChgCoDo.setAreaId(locCDo.getAreaId());
                 riskChgCoDo.setHaveRisk(isRisk[0]);
                 riskChgCoDo.setOldHaveRisk(isRisk[1]);*/
                 ModifyData modifyData = new ModifyData();
                 modifyData.setName(locCDo.getName());
                 modifyData.setLevel(locCDo.getRiskLevel().toString());
                 modifyData.setIndustry(locCDo.getCompanyType().toString());
                 String createBy = loginName + "导入交易场所";
                 RiskChgCoDo riskChgCoDo = coRiskChgService.generateNewRecord(modifyData, createBy, RiskChgCoSource.MANUAL_MODIFY);
                 baseService.insert(riskChgCoDo);
             }
         }
        log.info(caption +" 导入已完成");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入{}服务器异常 ", caption, e);
    }

}
