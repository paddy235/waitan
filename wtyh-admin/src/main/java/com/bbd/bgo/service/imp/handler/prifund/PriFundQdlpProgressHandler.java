package com.bbd.bgo.service.imp.handler.prifund;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.QdlpProgressDO;
import com.bbd.wtyh.domain.enums.CompanyProgress;
import com.bbd.wtyh.domain.vo.QdlpProgressVO;
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
 * Created by lixudong on 2017/7/25.
 */
@Component
@Scope("prototype") //非单例模式
public class PriFundQdlpProgressHandler extends AbstractImportHandler<QdlpProgressVO> {

    final static String caption = "私募基金-QDLP试点企业";

    private Logger log = LoggerFactory.getLogger(PriFundQdlpProgressHandler.class);

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PrivateFundService privateFundService;

    private List<QdlpProgressVO> insertList = null;
    private List<QdlpProgressVO> updateList = null;
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
        boolean rtr = true;
        String companyName = row.get("companyName");
        if (companyName.length() > 40) {
            addError("企业名称字数超过规定范围");
            rtr = false;
        }
        return rtr;
    }

    @Override
    public void endRow(Map<String, String> row, QdlpProgressVO bean) throws Exception {
        CompanyDO cp = companyService.getCompanyByName(bean.getCompanyName());
        if (null == cp) {
            cp = companyService.getCompanyByName(bean.getCompanyName(), true);
        }
        if (null == cp) {
            addError("未查询到此企业");
            return;
        }

        QdlpProgressDO qdlpProgressDO = privateFundService.getQdlpProgressByPrimaryKey(cp.getCompanyId());

        if (null == qdlpProgressDO) {
            insertList.add(bean);
        } else {
            updateList.add(bean);
        }
    }

    @Override
    public void end() throws Exception {
        if (errorList().size() > 0) {
            addError("用户上传的" + caption + "中的数据有误，所有数据均不予入库");
            log.warn("用户上传的" + caption + "中的数据有误，所有数据均不予入库");
            return;
        }

        for (QdlpProgressVO qdlpProgressVO : updateList) {
            CompanyDO cp = companyService.getCompanyByName(qdlpProgressVO.getCompanyName());
            QdlpProgressDO qdlpProgressDO = privateFundService.getQdlpProgressByPrimaryKey(cp.getCompanyId());
            qdlpProgressDO.setArchitecture(qdlpProgressVO.getArchitecture());
            qdlpProgressDO.setProgress((byte) CompanyProgress.getType(qdlpProgressVO.getProgress()));
            qdlpProgressDO.setQuatas(qdlpProgressVO.getQuatas());
            qdlpProgressDO.setChinaShareholder(qdlpProgressVO.getChinaShareholder());
            qdlpProgressDO.setForeignShareholder(qdlpProgressVO.getForeignShareholder());
            qdlpProgressDO.setUpdateBy(loginName);
            qdlpProgressDO.setUpdateDate(new Date());
            privateFundService.updateQdlpProgress(qdlpProgressDO);
        }

        for (QdlpProgressVO qdlpProgressVO : insertList) {
            CompanyDO cp = companyService.getCompanyByName(qdlpProgressVO.getCompanyName());
            QdlpProgressDO qdlpProgressDO = new QdlpProgressDO();
            qdlpProgressDO.setCompanyId(cp.getCompanyId());
            qdlpProgressDO.setArchitecture(qdlpProgressVO.getArchitecture());
            qdlpProgressDO.setProgress((byte) CompanyProgress.getType(qdlpProgressVO.getProgress()));
            qdlpProgressDO.setQuatas(qdlpProgressVO.getQuatas());
            qdlpProgressDO.setChinaShareholder(qdlpProgressVO.getChinaShareholder());
            qdlpProgressDO.setForeignShareholder(qdlpProgressVO.getForeignShareholder());
            qdlpProgressDO.setCreateBy(loginName);
            qdlpProgressDO.setCreateDate(new Date());
            privateFundService.addQdlpProgress(qdlpProgressDO);
        }
        log.info(caption + "导入已完成");
    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入{}服务器异常 ", caption, e);
    }
}
