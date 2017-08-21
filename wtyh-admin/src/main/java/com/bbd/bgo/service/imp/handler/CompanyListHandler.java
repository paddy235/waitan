package com.bbd.bgo.service.imp.handler;

import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.CompanyStatusChangeService;
import com.bbd.wtyh.service.HologramQueryService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cgj on 2017/7/19.
 */

@Component
@Scope("prototype") //非单例模式
public class CompanyListHandler extends AbstractImportHandler<CompanyDO> {

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);

    private List<CompanyDO> tempList = null;
    String loginName ="";

    CompanyImportAssist companyImportAssist;


    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if( null ==loginName ) {
            loginName ="";
        }
        tempList = new LinkedList<>();
        companyImportAssist =new CompanyImportAssist( errorList(), getSheet() );
        log.info("开始检查企业名单");
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        //int aa =row.size();
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        /*String companyName =row.get("name");
        if( StringUtils.isBlank( companyName ) || companyName.length() <3 ) {
            addError("企业名称格式错误");
            return false;
        }
        int validCnt =0;
        String creditCode =row.get("creditCode");
        if( StringUtils.isNotBlank( creditCode ) ) {
            if ( creditCode.matches("^([A-Z]|[0-9]){18}$") ){
                validCnt++;
            } else {
                addError("统一信用代码 格式错误");
            }
        }
        String organizationCode =row.get("organizationCode");
        if( StringUtils.isNotBlank( organizationCode ) ) {
            if ( organizationCode.matches("^([0-9]){15}$") ){
                validCnt++;
            } else {
                addError("注册号 格式错误"); //原组织机构代码变更成验证注册号
            }
        }*/
        return true;
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, CompanyDO bean) throws Exception {
        byte cpTypeCode =CompanyDO.companyType( bean.getComTypeCnItself() );
        /*if( cpTypeCode <0 ) {
            addError("指定的 行业类别 有误");
            return;
        }*/
        bean.setCompanyType( cpTypeCode );
        bean.setId(getRowNumber()); //将行号存下
        tempList.add(bean);
        if( tempList.size() <200 ) {
            return;
        }
        companyImportAssist.processCp(tempList,true);
    }

    @Override
    public void end() throws Exception {
        if ( tempList.size() >0 ) {
            //有企业没有处理完
            companyImportAssist.processCp(tempList, true);
        }
        if( errorList().size() >0 ) {
            addError("用户上传的企业名单中的数据有误，所有数据均不予入库");
            log.warn("用户上传的企业名单中的数据有误，所有数据均不予入库");
            return;
        }
        companyImportAssist.save(loginName);

        log.info("企业名单导入已完成");
    }


    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入企业名单时服务器异常 ", e);
    }

}
