package com.bbd.bgo.service.imp.handler;

import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.CommercialFactoringExtraDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.service.CommercialFactoringExtraService;
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
 * 商业保理-企业名单
 * Created by zhaodongjun on 2017/7/29 0029.
 */
@Component
@Scope("prototype") //非单例模式
public class CommercialFactoringHandler extends AbstractImportHandler<CommercialFactoringExtraDO> {
    @Autowired
    private CommercialFactoringExtraService commercialFactoringExtraService;

    private List<CommercialFactoringExtraDO> listCommercialFactoring = null;

    private Logger log = LoggerFactory.getLogger(CommercialFactoringHandler.class);

    String loginName = "";

    Date sqlDate = null;

    CompanyImportAssist companyImportAssist;
    private List<CompanyDO> tempList = new LinkedList<>();

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
        log.info("开始检查 商业保理-企业名单列表");
        listCommercialFactoring = new LinkedList<>();
        companyImportAssist =new CompanyImportAssist( errorList(), getSheet() );
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
//        String companyName = row.get("companyName");
//
//        //企业名称必须存在于company表中
//        CompanyDO companyDO = companyService.getCompanyByName(companyName);
//        if(null == companyDO){
//            addError("企业不存在于企业信息表");
//            return false;
//        }
//        Integer companyId  = companyDO.getCompanyId();
//        if (companyId == null || companyId == 0) {
//            addError("企业ID不存在于企业信息表");
//            return false;
//        }
//        row.put("companyId",companyId + "");

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
                addError("企业名单不存在");
                return false;
            }
        }else{
            addError("企业名单不可为空");
            return false;
        }


        return true;
    }

    @Override
    public void endRow(Map<String, String> row, CommercialFactoringExtraDO bean) throws Exception {
        //准备更新或新增Company表的数据
        CompanyDO cDo=new CompanyDO();
        tempList.add(cDo);
        cDo.setName(row.get("companyName"));
        cDo.setCompanyType(CompanyDO.companyType( "商业保理" ));
        cDo.setId(getRowNumber()); //将行号存下


        //准备新增商业保理表数据
        bean.setCompanyName(row.get("companyName"));
//        bean.setCreateBy(loginName);
//        bean.setCreateDate(sqlDate);
        listCommercialFactoring.add(bean);
    }

    @Override
    public void end() throws Exception {
        //对企业信息进行判断，若存在，则更新，不存在则新增(针对Company表)
        companyImportAssist.processCp(tempList);
        if (errorList().isEmpty()) {
            companyImportAssist.save(loginName);

            //取得CompanyId
            boolean isFalse = true;//标记是否能正常取得更新后的company信息
            List< Map.Entry<CompanyDO, BaseDataDO.Results> > searchList =companyImportAssist.getResultList();
            for ( CommercialFactoringExtraDO cf : listCommercialFactoring ) {
                CompanyDO locCDo = null;
                for (Map.Entry<CompanyDO, BaseDataDO.Results> me : searchList) {
                    if (me.getKey().getName().equals(cf.getCompanyName())) {
                        locCDo = me.getKey();
                    }
                }
                if (null == locCDo) {
                    isFalse = false;
                }
                cf.setCompanyId(locCDo.getCompanyId());
            }

            if(!isFalse){
                addError("企业名称异常");
            }else{
                //针对商业保理表
                if (errorList().isEmpty()) {
                    //遍历List,若重复则更新，否则新增
                    for (CommercialFactoringExtraDO commercialFactoringExtraDO:listCommercialFactoring){
                        CommercialFactoringExtraDO cDO = commercialFactoringExtraService.selectById(commercialFactoringExtraDO.getCompanyId());
                        if(cDO == null){//表中不存在待新增数据
                            commercialFactoringExtraDO.setCreateBy(loginName);
                            commercialFactoringExtraDO.setCreateDate(sqlDate);
                            baseService.insert(commercialFactoringExtraDO);
                        }else{
                            commercialFactoringExtraDO.setUpdateBy(loginName);
                            commercialFactoringExtraDO.setUpdateDate(sqlDate);
                            baseService.update(commercialFactoringExtraDO);
                        }
                    }

                    log.info("导入商业保理-企业名单列表结束");
                }else{
                    log.info("导入商业保理-企业名单列表失败，数据有误");
                }
            }
        }

    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入商业保理-企业名单列表服务器异常！", e);
    }
}
