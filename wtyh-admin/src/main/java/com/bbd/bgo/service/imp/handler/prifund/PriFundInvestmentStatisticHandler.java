package com.bbd.bgo.service.imp.handler.prifund;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.bgo.service.imp.handler.CompanyLevelHandler;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.InvestmentStatisticDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbd.wtyh.common.Constants;

/**
 * Created by cgj on 2017/7/24.
 */

@Component
@Scope("prototype") //非单例模式
public class PriFundInvestmentStatisticHandler extends AbstractImportHandler<InvestmentStatisticDO> {

    final static String caption ="私募基金-股权投资市场投资金额情况";

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;


    private List< InvestmentStatisticDO > insertList = null;
    private List< InvestmentStatisticDO > updateList = null;
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

        String year =row.get("year");
        if( StringUtils.isBlank( year ) || ! year.matches("\\d+") ) {
            addError("年份 格式错误");
            return false;
        }
        int [] validCntA = {0};
        FunIf1 f1 =(String numName, String  capName)->{
            String lessNumber =row.get(numName);
            if( StringUtils.isNotBlank( lessNumber ) ) {
                if ( lessNumber.matches("\\d+") ){
                    validCntA[0]++;
                } else {
                    addError(capName +" 格式错误");
                }
            }
        };
        f1.fun("investmentAmount", "投资金额（亿元）");
        f1.fun("publishNumber", "披露数量");
        if( validCntA[0] <1 ) {
            addError("选填参数数量太少");
            return false;
        }
        return true;
    }

    @FunctionalInterface
    interface FunIf1 {
        void fun(String numName, String  capName);
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, InvestmentStatisticDO bean) throws Exception {
        InvestmentStatisticDO isDo =baseService.selectOne(InvestmentStatisticDO.class,
                "`year`=" +bean.getYear() +" LIMIT 1" );
        if( null ==isDo ) {
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
        baseService.insert(insertList);
        log.info(caption +" 导入已完成");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入{}服务器异常 ", caption, e);
    }

}
