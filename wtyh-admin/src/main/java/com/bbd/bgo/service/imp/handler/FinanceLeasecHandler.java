package com.bbd.bgo.service.imp.handler;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.vo.FinanceLeaseStatisticVO;
import com.bbd.wtyh.domain.vo.FinanceLeaseVO;
import com.bbd.wtyh.domain.vo.FinanceLeasecCompanyVO;
import com.bbd.wtyh.excel.imp.importer.AbstractImporter;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;

/**
 * Created by cgj on 2017/7/27.
 */

@Component
@Scope("prototype") //非单例模式
public class FinanceLeasecHandler extends AbstractImportHandler<FinanceLeasecCompanyVO> {

    final static String caption ="典当-典当数据";

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    private List<CompanyDO> tempList = new LinkedList<>();
    private List<FinanceLeasecCompanyVO> flcList = new LinkedList<>();

    CompanyImportAssist companyImportAssist;

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    String loginName ="";


    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="";
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
                if ( 1 ==val.length() && ( val.equals("是") ||val.equals("否") ) ) {
                    validCntA[0]++;
                    return;
                }
                addError(capName +" 内容错误");
            }
        };
        f1.fun("address", "是否在自贸区" );
        f1.fun("riskStatusA", "失联企业" );
        f1.fun("riskStatusB", "未参加自查企业" );
        f1.fun("riskStatusC", "一年以上零认缴资本" );
        f1.fun("riskStatusD", "一年以上未经营" );
        if( validCntA[0] <1 ) {
            addError("选填参数数量不足");
            return false;
        }
        return true;
    }

    @FunctionalInterface
    interface FunIf1 {
        void fun( String numName, String capName );
    }
    @FunctionalInterface
    interface FunIf2 {
        void fun( String typeVal, int riskType );
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, FinanceLeasecCompanyVO bean) throws Exception {
        flcList.add(bean);
        CompanyDO cDo=new CompanyDO();
        tempList.add(cDo);
        cDo.setName( bean.getCompanyName() );
        cDo.setCompanyType( CompanyDO.companyType( "融资租赁" ) );
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
        for ( FinanceLeasecCompanyVO fv : flcList ) {
            CompanyDO locCDo =null;
            for ( Map.Entry<CompanyDO, BaseDataDO.Results> me : searchList ) {
                if ( me.getKey().getName().equals(fv.getCompanyName()) ) {
                    locCDo =me.getKey();
                }
            }
            if ( null ==locCDo) continue;
            final CompanyDO fLocC =locCDo;
            boolean []isRisk ={false,false}; //[0]当前， [1]之前
            FunIf2 savRisk =( String status, int riskType )-> {
                if ( StringUtils.isNotBlank( status ) ) {
                    FinanceLeaseRiskDO frDo = new FinanceLeaseRiskDO();
                    frDo.setCompanyId( fLocC.getCompanyId() );
                    frDo.setRiskType(riskType);
                    frDo.setRiskStatus( status.equals("是") ? 1 : 0 );
                    String strWhere = "`company_id`=" + fLocC.getCompanyId() + " AND `risk_type`=" + riskType;
                    FinanceLeaseRiskDO sFrDo = baseService.selectOne(FinanceLeaseRiskDO.class, strWhere);
                    if ( null == sFrDo ) {
                        frDo.setCreateDate(new Date());
                        frDo.setCreateBy(loginName);
                        baseService.insert( frDo );
                    } else {
                        frDo.setMkId( sFrDo.getMkId() );
                        frDo.setUpdateBy(loginName);
                        frDo.setUpdateDate(new Date());
                        baseService.update(frDo);
                        if ( 1 == sFrDo.getRiskStatus() ) {
                            isRisk[1] =true;
                        }
                    }
                    if ( 1 == frDo.getRiskStatus() ) {
                        isRisk[0] =true;
                    }
                }
            };
            //写和更新finance_lease_risk表
            savRisk.fun(fv.getRiskStatusA(), 1); //失联企业
            savRisk.fun(fv.getRiskStatusB(), 2); //未参加自查企业
            savRisk.fun(fv.getRiskStatusC(), 3); //一年以上零认缴资本
            savRisk.fun(fv.getRiskStatusD(), 4); //一年以上未经营
            //写和更新finance_lease_extra表
            if ( StringUtils.isNotBlank( fv.getAddress() ) ) {
                FinanceLeaseExtraDO feDo = new FinanceLeaseExtraDO();
                feDo.setCompanyId(locCDo.getCompanyId());
                feDo.setFreeTradeZone( fv.getAddress().equals("是") ? true : false );
                FinanceLeaseExtraDO srcFe = baseService.selectById(FinanceLeaseExtraDO.class, locCDo.getCompanyId());
                if ( null == srcFe ) {
                    feDo.setCreateBy(loginName);
                    feDo.setCreateDate(new Date());
                    baseService.insert( feDo );
                } else {
                    feDo.setUpdateBy(loginName);
                    feDo.setUpdateDate(new Date());
                    baseService.update(feDo);
                }
            }
            RiskChgCoDo riskChgCoDo =new RiskChgCoDo();
            riskChgCoDo.setCompanyId( locCDo.getCompanyId() );
            riskChgCoDo.setCompanyName( locCDo.getName() );
            riskChgCoDo.setCompanyType(locCDo.getCompanyType().intValue());
            riskChgCoDo.setAreaId(locCDo.getAreaId());
            riskChgCoDo.setHaveRisk(isRisk[0]);
            riskChgCoDo.setOldHaveRisk(isRisk[1]);
            baseService.insert(riskChgCoDo);
        }

        log.info(caption +" 导入已完成");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入{}服务器异常 ", caption, e);
    }

}
