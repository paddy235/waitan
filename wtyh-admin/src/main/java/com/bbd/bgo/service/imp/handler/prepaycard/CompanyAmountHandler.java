package com.bbd.bgo.service.imp.handler.prepaycard;

import com.bbd.bgo.service.imp.handler.CommercialFactoringHandler;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.mapper.PrepaidCompanyStatisticMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaodongjun on 2017/7/29 0029.
 */
@Component
@Scope("prototype") //非单例模式
public class CompanyAmountHandler extends AbstractImportHandler<PrepaidCompanyStatisticDO> {
    @Autowired
    private PrepaidCompanyStatisticMapper prepaidCompanyStatisticMapper;
    private List<PrepaidCompanyStatisticDO> listPrepaidCompanyStatistic = null;

    private Logger log = LoggerFactory.getLogger(CommercialFactoringHandler.class);

    String loginName = "";

    Date sqlDate = null;

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;

    @Override
    public void start(HttpServletRequest request) throws Exception {
        sqlDate = new java.sql.Date(new Date().getTime());
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="";
        }
        //Object ob= request.getHeaderNames();
        log.info("开始检查 预付卡-备案企业预付金额总额列表");
        listPrepaidCompanyStatistic = new LinkedList<>();

    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {

        //将输入的金额从“亿”转换为“万”(因数据库存储单位为“万”)
        String sAmount = row.get("amount");
        if(!StringUtils.isEmpty(sAmount)){
            Double dAmount = Double.valueOf(sAmount)*10000;
            Integer iAmount = dAmount.intValue();
            row.put("amount",iAmount+"");
        }

        return true;
    }

    @Override
    public void endRow(Map<String, String> row, PrepaidCompanyStatisticDO bean) throws Exception {

        //准备预付卡企业统计信息表数据
//        bean.setCreateBy(loginName);
//        bean.setCreateDate(sqlDate);
        listPrepaidCompanyStatistic.add(bean);
    }

    @Override
    public void end() throws Exception {
        //针对预付卡企业统计信息表
        if (errorList().isEmpty()) {
            //遍历List,若重复则更新，否则新增
            for (PrepaidCompanyStatisticDO PrepaidCompanyStatisticDO : listPrepaidCompanyStatistic) {
                PrepaidCompanyStatisticDO cDO = prepaidCompanyStatisticMapper.selectByPrimaryKey(PrepaidCompanyStatisticDO.getYear());
                if (cDO == null) {//表中不存在待新增数据
                    PrepaidCompanyStatisticDO.setCreateBy(loginName);
                    PrepaidCompanyStatisticDO.setCreateDate(sqlDate);
                    baseService.insert(PrepaidCompanyStatisticDO);
                } else {
                    PrepaidCompanyStatisticDO.setUpdateBy(loginName);
                    PrepaidCompanyStatisticDO.setUpdateDate(sqlDate);
                    baseService.update(PrepaidCompanyStatisticDO);
                }
            }

            log.info("导入预付卡-备案企业预付金额总额列表结束");
        } else {
            log.info("导入预付卡-备案企业预付金额总额列表失败，数据有误");
        }


    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入预付卡-备案企业预付金额总额列表服务器异常！", e);
    }
}