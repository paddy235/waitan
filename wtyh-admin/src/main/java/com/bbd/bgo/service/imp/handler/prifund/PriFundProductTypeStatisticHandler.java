package com.bbd.bgo.service.imp.handler.prifund;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.FundProductStatisticDO;
import com.bbd.wtyh.domain.FundProductTypeDO;
import com.bbd.wtyh.domain.QdlpProgressDO;
import com.bbd.wtyh.domain.vo.PriFundProductTypeVO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.PrivateFundService;
import org.apache.commons.lang.StringUtils;
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
public class PriFundProductTypeStatisticHandler extends AbstractImportHandler<PriFundProductTypeVO> {

    final static String caption = "私募基金-产品类型数量";

    private Logger log = LoggerFactory.getLogger(PriFundProductTypeStatisticHandler.class);


    @Autowired
    private PrivateFundService privateFundService;

    private List<PriFundProductTypeVO> updateList = null;
    String loginName = "";

    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if (null == loginName) {
            loginName = "";
        }
        log.info("开始检查" + caption);
        updateList = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        boolean rtr = true;
        String adviserManage = row.get("adviserManage");
        if (!adviserManage.matches("^[0-9]+([.][0-9]+){0,1}$")) {
            addError("顾问管理格式错误");
            rtr = false;
        }
        String entrustedManage = row.get("entrustedManage");
        if (!entrustedManage.matches("^[0-9]+([.][0-9]+){0,1}$")) {
            addError("受委管理格式错误");
            rtr = false;
        }
        String selfManage = row.get("selfManage");
        if (!selfManage.matches("^[0-9]+([.][0-9]+){0,1}$")) {
            addError("自我管理格式错误");
            rtr = false;
        }
        return rtr;
    }

    @Override
    public void endRow(Map<String, String> row, PriFundProductTypeVO bean) throws Exception {
        updateList.add(bean);
    }

    @Override
    public void end() throws Exception {
        List<String> typeList = new ArrayList<>();
        typeList.add("顾问管理");
        typeList.add("受托管理");
        typeList.add("自我管理");
        for (PriFundProductTypeVO vo : updateList) {
            for(String typeName:typeList){
                FundProductTypeDO typeDO = privateFundService.getProductTypeByName(typeName);
                FundProductStatisticDO productDO = new FundProductStatisticDO();
                productDO.setProductTypeId(typeDO.getProductTypeId());

                if("顾问管理".equals(typeName)){
                    if(vo.getAdviserManage()==null){
                        continue;
                    }
                    productDO.setProductNumber(vo.getAdviserManage());
                }else if("受托管理".equals(typeName)){
                    if(vo.getEntrustedManage()==null){
                        continue;
                    }
                    productDO.setProductNumber(vo.getEntrustedManage());
                }else if("自我管理".equals(typeName)){
                    if(vo.getSelfManage()==null){
                        continue;
                    }
                    productDO.setProductNumber(vo.getSelfManage());
                }

                productDO.setUpdateDate(new Date());
                productDO.setUpdateBy(loginName);
                privateFundService.saveOrUpdateProductStatistic(productDO);
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
