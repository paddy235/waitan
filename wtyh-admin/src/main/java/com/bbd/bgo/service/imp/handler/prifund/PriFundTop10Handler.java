package com.bbd.bgo.service.imp.handler.prifund;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.bbd.bgo.service.imp.handler.CompanyLevelHandler;
import com.bbd.wtyh.domain.ProductAmountDO;
import com.bbd.wtyh.service.ProductAmountService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;

/**
 * Created by cgj on 2017/7/22.
 */

@Component
@Scope("prototype") //非单例模式
public class PriFundTop10Handler extends AbstractImportHandler<ProductAmountDO> {

    final static String caption ="私募基金-产品数量前十";

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ProductAmountService productAmountService;

    private List< ProductAmountDO > insertList = null;
    private List< ProductAmountDO > updateList = null;
    String loginName ="";



    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="";
        }
        //Object ob= request.getHeaderNames();
        log.info("开始检查" +caption);
        insertList = new LinkedList<>();
        updateList = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        //int aa =row.size();
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        //todo 正则：整数或者小数：^[0-9]+([.][0-9]+){0,1}$，只能输入至少一位数字"\\d+"，"+"等价于{1,}
        boolean rtr =true;
        String companyName =row.get("companyName");
        if( StringUtils.isBlank( companyName ) || companyName.length() <3 ) {
            addError("企业名称格式错误");
            rtr =false;
        }
        String productNumber =row.get("productNumber");
        if( StringUtils.isEmpty( productNumber ) || !productNumber.matches("\\d+") ) {
            addError("产品数量格式错误");
            rtr =false;
        }
        return rtr;
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, ProductAmountDO bean) throws Exception {
        CompanyDO cp = companyService.getCompanyByName(bean.getCompanyName());
        if( null ==cp ) {
            cp = companyService.getCompanyByName(bean.getCompanyName(), true);
        }
        if ( null ==cp ) {
            addError("未查询到此企业");
            return;
        }
        ProductAmountDO pa = productAmountService.selectByPrimaryKey(cp.getCompanyId());
        if( null ==pa ) {
            insertList.add( bean );
            bean.setCreateBy(loginName);
            bean.setCreateDate(new Date());
        } else {
            updateList.add(bean);
            bean.setUpdateBy(loginName);
            bean.setUpdateDate(new Date());
        }
        bean.setCompanyId( cp.getCompanyId() );
    }

    @Override
    public void end() throws Exception {
        if( errorList().size() >0 ) {
            log.warn("用户上传的" +caption +"中的数据有误，所有数据均不予入库");
            return;
        }
        //update
        productAmountService.updateList(updateList);
        //insert
        productAmountService.insertList(insertList); //todo 插入报异常
        log.info( caption +"导入已完成" );
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        e.printStackTrace();

    }
}
