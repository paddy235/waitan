package com.bbd.bgo.service.imp.handler.prifund;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.PrivateFundStatisticDO;
import com.bbd.wtyh.domain.PrivateFundTypeDO;
import com.bbd.wtyh.domain.vo.PriFundTypeVO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.PrivateFundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by lixudong on 2017/7/26.
 */
@Component
@Scope("prototype") //非单例模式
public class PriFundTypeStatisticHandler extends AbstractImportHandler<PriFundTypeVO> {

    final static String caption = "私募基金类型数量";

    private Logger log = LoggerFactory.getLogger(PriFundTypeStatisticHandler.class);


    @Autowired
    private PrivateFundService privateFundService;

    private List<PriFundTypeVO> insertList = new ArrayList<>();
    private List<PriFundTypeVO> updateList = new ArrayList<>();
    String loginName = "";

    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if (null == loginName) {
            loginName = "";
        }
        log.info("开始检查" + caption);
        insertList = new LinkedList<>();
        updateList = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {

        return true;
    }

    @Override
    public void endRow(Map<String, String> row, PriFundTypeVO bean) throws Exception {
        updateList.add(bean);
    }

    @Override
    public void end() throws Exception {
        if (errorList().size() > 0) {
            addError("用户上传的" + caption + "中的数据有误，所有数据均不予入库");
            log.warn("用户上传的" + caption + "中的数据有误，所有数据均不予入库");
            return;
        }

        List<String> typeList = new ArrayList<>();
        typeList.add("股权投资基金");
        typeList.add("证券投资基金");
        typeList.add("VC");
        typeList.add("FOFs");
        typeList.add("券商投资");
        typeList.add("战略投资");
        typeList.add("天使投资");
        typeList.add("PE");
        typeList.add("其他");
        for (PriFundTypeVO vo : updateList) {
            for (String typeName : typeList) {
                PrivateFundTypeDO typeDO = privateFundService.getPriFundTypeByName(typeName);
                PrivateFundStatisticDO productDO = new PrivateFundStatisticDO();
                productDO.setTypeId(typeDO.getTypeId());
                switch (typeName) {
                    case "股权投资基金":
                        productDO.setAmount(vo.getEquityInvestment());
                        break;
                    case "证券投资基金":
                        productDO.setAmount(vo.getPortfolioInvestment());
                        break;
                    case "VC":
                        productDO.setAmount(vo.getVc());
                        break;
                    case "FOFs":
                        productDO.setAmount(vo.getFofs());
                        break;
                    case "券商投资":
                        productDO.setAmount(vo.getBroker());
                        break;
                    case "战略投资":
                        productDO.setAmount(vo.getStrategy());
                        break;
                    case "天使投资":
                        productDO.setAmount(vo.getAngel());
                        break;
                    case "PE":
                        productDO.setAmount(vo.getPe());
                        break;
                    default:
                        productDO.setAmount(vo.getOther());
                        break;
                }
                if (productDO.getAmount() == null) {
                    continue;
                }
                productDO.setUpdateDate(new Date());
                productDO.setUpdateBy(loginName);
                privateFundService.saveOrUpdateStatistic(productDO);
            }
        }
        log.info(caption + "导入已完成");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入{}服务器异常 ", caption, e);
    }
}
