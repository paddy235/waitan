package com.bbd.bgo.service.imp.handler.prifund;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.bgo.service.imp.handler.CompanyLevelHandler;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.report.word.WordReportBuilder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;

/**
 * Created by cgj on 2017/7/24.
 */

@Component
@Scope("prototype") //非单例模式
public class PriFundInvestmentReturnHandler extends AbstractImportHandler<InvestmentReturnStatisticDO> {

    final static String caption ="私募基金-股权投资市场退出及退出回报情况";

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;


    private List< InvestmentReturnStatisticDO > insertList = null;
    private List< InvestmentReturnStatisticDO > updateList = null;
    String loginName ="";



    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="";
        }
        //Object ob= request.getHeaderNames();
        log.info("开始检查 " + caption);

        insertList = new LinkedList<>();
        updateList = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        //int aa =row.size();
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        //正则：整数或者小数：^[0-9]+([.][0-9]+){0,1}$，只能输入至少一位数字"\\d+"，"+"等价于{1,}
        int [] validCntA = {0};
        FunIf1 f1 =(String numName, String  capName)->{
            String lessNumber =row.get(numName);
            if( StringUtils.isNotBlank( lessNumber ) ) {
                validCntA[0]++;
            }
        };
        f1.fun("lessNumber", "");
        f1.fun("betweenNumber", "");
        f1.fun("greaterNumber", "");
        f1.fun("quitNumber", "");
        if( validCntA[0] <1 ) {
            addError("选填参数数量不足");
            return false;
        }
        return true;
    }

    //@FunctionalInterface
    interface FunIf1 {
        void fun(String numName, String  capName);
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, InvestmentReturnStatisticDO bean) throws Exception {
        InvestmentReturnStatisticDO irs =baseService.selectOne(InvestmentReturnStatisticDO.class,
                "`year`=" +bean.getYear() +" LIMIT 1" );
        if( null ==irs ) {
            insertList.add(bean);
            bean.setCreateDate(new Date());
            bean.setCreateBy(loginName);
        } else {
            updateList.add(bean);
            bean.setUpdateDate(new Date());
            bean.setUpdateBy(loginName);
        }
    }

    @Override
    public void end() throws Exception {
        if( errorList().size() >0 ) {
            addError("用户上传的 " +caption +" 中的数据有误，所有数据均不予入库");
            log.warn("用户上传的 " +caption +" 中的数据有误，所有数据均不予入库");
            return;
        }
        //update
        baseService.updateList(updateList);
        //insert
        baseService.insertList(insertList);
        log.info(caption +" 导入已完成");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入{}服务器异常 ", caption, e);
    }

}
