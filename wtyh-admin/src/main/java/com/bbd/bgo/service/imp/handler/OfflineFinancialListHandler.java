package com.bbd.bgo.service.imp.handler;


import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.OfflineFinancialListDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CompanyService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 线下理财行业-线下理财名单处理器
 *
 * @author Created by Wll on 2017-11-16 11:35.
 */
@Component
@Scope("prototype")
public class OfflineFinancialListHandler extends AbstractImportHandler<OfflineFinancialListDO> {
    private Logger log = LoggerFactory.getLogger(OfflineFinancialListHandler.class);

    @Autowired
    private CompanyService companyService;

    private List<OfflineFinancialListDO> insertList = null;
    private List<OfflineFinancialListDO> deleteList = new ArrayList<>();
    private Set<String> com_name = new HashSet<>();

    private String loginName = "";

    @Override
    public void start(HttpServletRequest request) throws Exception {
        log.info("导入线下理财行业-线下理财名单开始");
        insertList = new ArrayList<>();

        String tmpName = (String) request.getSession().getAttribute(Constants.SESSION.loginName);
        if (tmpName != null) {
            loginName = tmpName;
        }
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        //
        String type = row.get("type");
        String companyName = row.get("company_name");
        if (StringUtils.isBlank(companyName)) {
            addError("公司不存在，请先导入线下理财公司名单");
            log.info("公司不存在，请先导入线下理财公司名单");
            return false;
        }
        if (StringUtils.isBlank(type)) {
            addError("类型不存在，请填写正确的类型");
            log.info("类型不存在，请填写正确的类型");
            return false;
        }
        if (!type.equals("新增")&&!type.equals("删除")) {
            addError("输入的类型不合法");
            log.info("输入的类型不合法");
            return false;
        }


        if (type.equals("新增")) {
            CompanyDO companyInfo = this.companyService.getCompanyByName(companyName);
            if (null==companyInfo){
                addError("请先导入企业");
                log.info("请先导入企业");
                return false;
            }

            if(!((Byte)CompanyDO.TYPE_XXLC_4).equals(companyInfo.getCompanyType())){
                addError("该企业不属于线下理财名单企业");
                log.info("该企业不属于线下理财名单企业");
                return false;
            }

            OfflineFinancialListDO offlinefinancialList = this.companyService.selectOne(OfflineFinancialListDO.class,
                    "companyName = " + "'"+companyName+"'" );
            if(offlinefinancialList!=null){
                addError("该企业已经存在于线下理财白名单中");
                log.info("该企业已经存在于线下理财白名单中");
                return false;
            }

            if(com_name.add(companyInfo.getName())){
                //执行增加
                int companyId = companyInfo.getCompanyId();
                String name =  companyInfo.getName();
                row.put("companyName",name);
                row.put("companyId", companyId + "");
            }else{
                addError("excel中企业名称重复");
                log.info("excel中企业名称重复");
                return false;
            }
        }

        //判断企业名称会否已经存在白名单中国，若不存在则报错：该企业不在线下理财白名单中，不需要进行删除。
        if (type.equals("删除")) {
            OfflineFinancialListDO offlinefinancialList = this.companyService.selectOne(OfflineFinancialListDO.class,
                    "companyName = " + "'"+companyName+"'" );
            if (offlinefinancialList==null){
                addError("该企业不在线下理财白名单中，不需要进行删除");
                log.info("该企业不在线下理财白名单中，不需要进行删除");
                return false;
            }else{
                //增加删除list公司名单
                 deleteList.add(offlinefinancialList);
            }
        }
        return true;
    }

    @Override
    public void endRow(Map<String, String> row, OfflineFinancialListDO bean) throws Exception {
        if(row.get("type").equals("新增")){
            bean.setCreateBy(loginName);
            bean.setCreateDate(new Date());
            insertList.add(bean);
        }
    }

    @Override
    public void end() throws Exception {
        if (errorList().isEmpty()) {
            if(insertList!=null && !insertList.isEmpty()){
                this.companyService.insertList(insertList);
            }
            if(deleteList!=null && !deleteList.isEmpty()){
                for (OfflineFinancialListDO delCompany: deleteList) {
                    //先删除白名单表中的该企业
                    this.companyService.executeCUD("DELETE from offline_financial_white where companyId = ?",delCompany.getCompanyId());
                    //再把company表的该企业风险等级设置为null
                    this.companyService.executeCUD("update company set risk_level = null where companyId = ?",delCompany.getCompanyId());
                }
            }

        } else {
            addError("用户上传的线下理财名单中的数据有误，所有数据均不予入库");
            log.info("用户上传的线下理财名单中的数据有误，所有数据均不予入库");
        }
        log.info("导入线下理财行业-线下理财名单结束");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入线下理财行业-线下理财名单服务器异常！", e);
    }
}
