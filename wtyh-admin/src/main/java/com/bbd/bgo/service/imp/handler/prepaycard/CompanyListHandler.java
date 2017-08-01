package com.bbd.bgo.service.imp.handler.prepaycard;

import com.bbd.bgo.service.imp.handler.assist.CompanyImportAssist;
import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.excel.imp.handler.AbstractImportHandler;
import com.bbd.wtyh.mapper.CompanyAnalysisResultMapper;
import com.bbd.wtyh.service.CompanyService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 预付卡-企业列表
 * Created by zhaodongjun on 2017/7/27.
 */
@Component
@Scope("prototype") //非单例模式
public class CompanyListHandler extends AbstractImportHandler<CompanyAnalysisResultDO> {
    @Autowired
    private CompanyAnalysisResultMapper companyAnalysisResultMapper;
    @Autowired
    private CompanyService companyService;

    private List<CompanyAnalysisResultDO> listCompanyAnalysisResult = null;

    private Logger log = LoggerFactory.getLogger(com.bbd.bgo.service.imp.handler.CommercialFactoringHandler.class);

    String loginName = "";

    Date sqlDate = null;

    CompanyImportAssist companyImportAssist;
    private List<CompanyDO> tempList = new LinkedList<>();
    private List<RiskChgCoDo> riskChgCoList = null;

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
        log.info("开始检查 预付卡-企业列表");
        listCompanyAnalysisResult = new LinkedList<>();
        companyImportAssist =new CompanyImportAssist( errorList(), getSheet() );
        riskChgCoList = new ArrayList<>();
    }

    @Override
    public void startRow(Map<String, String> row) throws Exception {

    }

    @Override
    public boolean validateRow(Map<String, String> row) throws Exception {
        String analysisResult = row.get("analysisResult");
        if(!StringUtils.isEmpty(analysisResult)){
            if(analysisResult.equals("正常")){
                row.put("analysisResult","4");
            }else if(analysisResult.equals("潜在")){
                row.put("analysisResult","3");
            }else if(analysisResult.equals("已发生")){
                row.put("analysisResult","2");
            }else {
                addError("风险状态不存在");
                return false;
            }
        }

        return true;
    }

    @Override
    public void endRow(Map<String, String> row, CompanyAnalysisResultDO bean) throws Exception {
        //准备更新或新增Company表的数据
        CompanyDO cDo=new CompanyDO();
        tempList.add(cDo);
        cDo.setName(row.get("companyName"));
        cDo.setCompanyType(CompanyDO.companyType( "预付卡" ));
        cDo.setId(getRowNumber()); //将行号存下
        cDo.setRecordNumber(row.get("recordNumber"));//备案号
        cDo.setBusinessType(row.get("businessType"));//所属行业
        cDo.setRiskLevel(Integer.valueOf(row.get("analysisResult")));//风险等级


        //准备新增表数据
//        bean.setCompanyName(row.get("companyName"));
//        bean.setCreateBy(loginName);
//        bean.setCreateDate(sqlDate);
//        listCompanyAnalysisResult.add(bean);
    }

    @Override
    public void end() throws Exception {
        //对企业信息进行判断，若存在，则更新，不存在则新增(针对Company表)
        companyImportAssist.processCp(tempList);
        for(CompanyDO companyDO:tempList){
            Integer riskLevel = companyDO.getRiskLevel();//待塞入的风险等级
            Integer analysisResult = companyDO.getAnalysisResult();//数据库当前的风险等级(前面的processCp方法返回的)
            //如果两者不相等，则将新的风险等级塞入
            if(riskLevel != null && riskLevel != analysisResult){
//                CompanyDO.setRiskLevel();//endRow已塞值
                companyDO.setPreviousRiskLevel(companyDO.getAnalysisResult());//前次风险等级(塞入值为数据库当前的风险等级)
                //准备风险等级变化增量表数据
                addRiskChgCo(companyDO);
            }

        }
        if (errorList().isEmpty()) {
            //更新company表
            companyImportAssist.save(loginName);
            //更新风险等级变化表
            this.companyService.insertList(riskChgCoList);
            //取得CompanyId
            boolean isFalse = true;//标记是否能正常取得更新后的company信息
            List< Map.Entry<CompanyDO, BaseDataDO.Results> > searchList =companyImportAssist.getResultList();
            for ( CompanyAnalysisResultDO cf : listCompanyAnalysisResult ) {
                CompanyDO locCDo = null;
                for (Map.Entry<CompanyDO, BaseDataDO.Results> me : searchList) {
                    if (me.getKey().getName().equals(cf.getName())) {
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
                //针对company_analysis_result表做更新或新增
                if (errorList().isEmpty()) {
                    //遍历List,若重复则更新，否则新增
                    for (CompanyAnalysisResultDO CompanyAnalysisResultDO:listCompanyAnalysisResult){
                        CompanyAnalysisResultDO cDO = this.companyAnalysisResultMapper.selectByPrimaryKey(CompanyAnalysisResultDO.getCompanyId());
                        if(cDO == null){//表中不存在待新增数据
                            CompanyAnalysisResultDO.setCreateBy(loginName);
                            CompanyAnalysisResultDO.setCreateDate(sqlDate);
                            baseService.insert(CompanyAnalysisResultDO);
                        }else{
                            CompanyAnalysisResultDO.setUpdateBy(loginName);
                            CompanyAnalysisResultDO.setUpdateDate(sqlDate);
                            baseService.update(CompanyAnalysisResultDO);
                        }
                    }

                    log.info("导入预付卡-企业列表结束");
                }else{
                    log.info("导入预付卡-企业列表失败，数据有误");
                }
            }
        }

    }

    @Override
    public void exception(Exception e) {
        addError("服务器异常：" + e.getMessage());
        log.error("导入预付卡-企业列表服务器异常！", e);
    }

    /**
     * 风险等级变化
     * @param companyDO
     */
    private void addRiskChgCo(CompanyDO companyDO) {
        RiskChgCoDo riskChgCoDo = new RiskChgCoDo();

        riskChgCoDo.setCompanyName(companyDO.getName());
        riskChgCoDo.setCompanyType(companyDO.getCompanyType().intValue());

        riskChgCoDo.setRiskLevel(companyDO.getRiskLevel());
        riskChgCoDo.setOldLiveLevel(companyDO.getAnalysisResult());
        // 1表示手工修改
        riskChgCoDo.setSource(1);

        // 区域
        AreaDO areaDO = this.companyService.selectById(AreaDO.class, riskChgCoDo.getAreaId());
        if (areaDO != null) {
            riskChgCoDo.setAreaName(areaDO.getName());
        }

        // 楼宇
        BuildingDO buildingDO = this.companyService.selectById(BuildingDO.class, riskChgCoDo.getCompanyId());
        if (buildingDO != null) {
            riskChgCoDo.setBuildingId(buildingDO.getBuildingId());
            riskChgCoDo.setBuildingName(buildingDO.getName());
        }
        riskChgCoDo.setChangeDate(new Date());
        riskChgCoDo.setCreateBy("导入预付卡-企业列表");
        riskChgCoDo.setCreateDate(new Date());
        riskChgCoDo.setUpdateBy(null);
        riskChgCoDo.setUpdateDate(null);

        this.riskChgCoList.add(riskChgCoDo);

    }
}
