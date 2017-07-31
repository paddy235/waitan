package com.bbd.bgo.service.imp.handler;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.CommercialFactoringExtraDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;
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
 * 商业保理-企业类型
 * Created by zhaodongjun on 2017/7/29 0029.
 */
@Component
@Scope("prototype") //非单例模式
public class CommercialFactoringHandler extends AbstractImportHandler<CommercialFactoringExtraDO> {
    @Autowired
    private CompanyService companyService;

    private List<CommercialFactoringExtraDO> listCommercialFactoring = null;

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
        log.info("开始检查 商业保理-企业类型列表");
        listCommercialFactoring = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        String companyName = row.get("companyName");

        //企业名称必须存在于company表中
        CompanyDO companyDO = companyService.getCompanyByName(companyName);
        if(null == companyDO){
            addError("企业不存在于企业信息表");
            return false;
        }
        Integer companyId  = companyDO.getCompanyId();
        if (companyId == null || companyId == 0) {
            addError("企业ID不存在于企业信息表");
            return false;
        }
        row.put("companyId",companyId + "");

        String companyType = row.get("companyType");
        if(!StringUtils.isEmpty(companyType)){
            if(companyType.equals("内资")){
                row.put("domestic","1");
                row.put("foreignOwned","0");
            }else if(companyType.equals("外资")){
                row.put("domestic","0");
                row.put("foreignOwned","1");
            }else if(companyType.equals("内外资")){
                row.put("domestic","1");
                row.put("foreignOwned","1");
            }else {
                addError("企业类型不存在");
                return false;
            }
        }else{
            addError("企业类型不可为空");
            return false;
        }


        return true;
    }

    @Override
    public void endRow(Map<String, String> row, CommercialFactoringExtraDO bean) throws Exception {

        bean.setCreateBy(loginName);
        bean.setCreateDate(sqlDate);
        listCommercialFactoring.add(bean);
    }

    @Override
    public void end() throws Exception {
        if (errorList().isEmpty()) {
            baseService.insertList(listCommercialFactoring);
            log.info("导入商业保理-企业类型列表结束");
        }else{
            log.info("导入商业保理-企业类型列表失败，数据有误");
        }
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入商业保理-企业类型列表服务器异常！", e);
    }
}
