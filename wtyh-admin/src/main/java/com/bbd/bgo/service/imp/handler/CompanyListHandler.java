package com.bbd.bgo.service.imp.handler;

import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.util.CompanyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by cgj on 2017/7/19.
 */

@Component
@Scope("prototype") //非单例模式
public class CompanyListHandler extends AbstractImportHandler<CompanyDO> {

    private Logger log = LoggerFactory.getLogger(CompanyLevelHandler.class);
    private Map<String, Integer> checkRepeatMap = new HashMap<>();
    private List<CompanyDO> tempList = null;
    String loginName = "";

    CompanyImportAssist companyImportAssist;

    //@Transactional //事务--原子性操作
    @Override
    public void start(HttpServletRequest request) throws Exception {
        loginName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if (null == loginName) {
            loginName = "";
        }
        tempList = new LinkedList<>();
        companyImportAssist = new CompanyImportAssist(errorList(), getSheet());
        log.info("开始检查企业名单");
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {
        //int aa =row.size();
    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        String companyName = row.get("name");
        companyName = CompanyUtils.dealCompanyName(companyName);
        if (checkRepeatMap.containsKey(companyName)) {
            addError("企业【" + companyName + "】在文件中有重复，请检查");
            return false;
        }
        checkRepeatMap.put(companyName, 1);
        return true;
    }

    //BusinessException()
    @Override
    public void endRow(Map<String, String> row, CompanyDO bean) throws Exception {
        byte cpTypeCode = CompanyDO.companyType(bean.getComTypeCnItself());
        bean.setCompanyType(cpTypeCode);
        bean.setId(getRowNumber()); //将行号存下
        bean.setName(CompanyUtils.dealCompanyName(bean.getName()));
        tempList.add(bean);
        if (tempList.size() < 200) {
            return;
        }
        companyImportAssist.processCp(tempList, true);
    }

    @Override
    public void end() throws Exception {
        if (tempList.size() > 0) {
            //有企业没有处理完
            companyImportAssist.processCp(tempList, true);
        }
        if (errorList().size() > 0) {
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
