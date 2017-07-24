package com.bbd.bgo.service.imp.handler;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.CapitalAmountDO;
import com.bbd.wtyh.domain.PrivateFundTypeDO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.ProductAmountDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;

/**
 * Created by cgj on 2017/7/23.
 */

@Component
@Scope("prototype") //非单例模式
public class PriFundCapitalAmountHandler extends AbstractImportHandler<CapitalAmountDO> {

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;


    private List< CapitalAmountDO > insertList = null;
    private List< CapitalAmountDO > updateList = null;
    String loginName ="";



    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="";
        }
        //Object ob= request.getHeaderNames();
        log.info("开始检查 私募基金-股权投资机构管理资本量");
        updateList = new LinkedList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        //int aa =row.size();
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        //正则：整数或者小数：^[0-9]+([.][0-9]+){0,1}$，只能输入至少一位数字"\\d+"，"+"等价于{1,}

        String typeName =row.get("typeName");
        if( StringUtils.isBlank( typeName ) || typeName.length() <2 ) {
            addError("私募机构类型 格式错误");
            return false;
        }
        int validCnt =0;
        String managedCapitalAmount =row.get("managedCapitalAmount");
        if( StringUtils.isNotBlank( managedCapitalAmount ) ) {
            if ( managedCapitalAmount.matches("^[0-9]+([.][0-9]+){0,1}$") ){
                validCnt++;
            } else {
                addError("管理资本金额（亿元） 格式错误");
                return false;
            }
        }
        String publishCompanyNumber =row.get("publishCompanyNumber");
        if( StringUtils.isNotBlank( publishCompanyNumber ) ) {
            if ( publishCompanyNumber.matches("\\d+") ){
                validCnt++;
            } else {
                addError("数量 格式错误");
                return false;
            }
        }
        if( validCnt <1 ) {
            addError("选填参数数量太少");
            return false;
        }
        return true;
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, CapitalAmountDO bean) throws Exception {
        PrivateFundTypeDO pft =baseService.selectOne(PrivateFundTypeDO.class,
                "`type_parent_id` =1 AND `type_name`='" +bean.getTypeName() +"' LIMIT 1" );
        if( null ==pft ) {
            addError("私募机构类型 在系统中无此名称");
            return ;
        }
        bean.setTypeId(pft.getTypeId().intValue());
        updateList.add(bean);
        bean.setManagedCapitalAmount( bean.getManagedCapitalAmount() *10000F );
        bean.setUpdateBy(loginName);
        bean.setUpdateDate(new Date());
    }

    @Override
    public void end() throws Exception {
        if( errorList().size() >0 ) {
            log.warn("用户上传的 私募基金-股权投资机构管理资本量 中的数据有误，所有数据均不予入库");
            return;
        }
        //update
        baseService.updateList(updateList);
        log.info("私募基金-股权投资机构管理资本量 导入已完成");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        e.printStackTrace();

    }
}
