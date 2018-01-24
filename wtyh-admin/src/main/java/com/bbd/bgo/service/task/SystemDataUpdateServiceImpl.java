package com.bbd.bgo.service.task;


import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.bbdAPI.IndustryCodeDO;
import com.bbd.wtyh.mapper.CompanyBackgroundMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.service.TaskService;
import com.bbd.wtyh.service.impl.OfflineFinanceServiceImpl;
import com.bbd.wtyh.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cgj on 2017/4/20.
 */
@Service
public class SystemDataUpdateServiceImpl implements SystemDataUpdateService,TaskService {

    private Integer taskId = null;

    private Integer errorNum = null;

    private Logger logger = LoggerFactory.getLogger(OfflineFinanceServiceImpl.class);

    @Autowired
    private AreaService areaService;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyBackgroundMapper companyBackgroundMapper;

    @Autowired
    private HologramQueryService hologramQueryService;

    @Autowired
    private TaskFailInfoMapper taskFailInfoMapper;

    private volatile boolean isShutdown = false;//任务停止标志

    @Override
    public void stopTask() {
        isShutdown = true;
    }

    @Override
    public TaskResultDO updateCompanyAndBackgroundAutomaticOperate(Integer taskId) {
        logger.info("--- company baseInfo job begin ---");
        isShutdown=false;
        this.taskId=taskId;
        this.errorNum=0;
        TaskResultDO taskResultDO=new TaskResultDO();
        Integer dataTotal = 0;
        try {
            final int totalCount = companyMapper.countAllCompany();
            dataTotal = totalCount;
            final int pageSize = 100;
            Pagination pagination = new Pagination();
            pagination.setPageSize(pageSize);
            pagination.setCount(totalCount);
            int total = pagination.getLastPageNumber();
            ExecutorService dataExecutorService = Executors.newFixedThreadPool(12);
            logger.info("start update company ang background");
            for (int i = 1; i <= total; i++) {
                final int num = i;
                dataExecutorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        Pagination paginationP = new Pagination();
                        paginationP.setPageNumber(num);
                        paginationP.setPageSize(pageSize);
                        paginationP.setCount(totalCount);
                        System.out.println("Thread is Start! ID:" + Thread.currentThread().getId());
                        System.out.println("PageNumber:" + paginationP.getPageNumber());
                        companyAndBackgroundUpdateThread(paginationP,1,taskId);
                        System.out.println("Thread is Stop! ID:" + Thread.currentThread().getId());
                    }
                });
            }
            //logger.info("end update company area_id and address");
            dataExecutorService.shutdown();
            dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (isShutdown) {
            taskResultDO.setPlanCount(dataTotal);
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        }else{
            taskResultDO.setPlanCount(dataTotal);
            taskResultDO.setFailCount(errorNum);
            taskResultDO.setSuccessCount(dataTotal-errorNum);
        }

        logger.info("--- company baseInfo job end ---");
        return taskResultDO;
    }

    @Override
    public TaskResultDO updateCompanyAndBackgroundManualOperate(Integer oldTaskId,Integer newTaskId){
        logger.info("--- company baseInfo handle begin ---");
        isShutdown=false;
        TaskResultDO taskResultDO = new TaskResultDO();
        this.taskId=newTaskId;
        this.errorNum=0;
        Integer dataTotal = 0;
        try {
            final int totalCount = taskFailInfoMapper.countFailByTaskId(oldTaskId);
            dataTotal = totalCount;
            final int pageSize = 100;
            Pagination pagination = new Pagination();
            pagination.setPageSize(pageSize);
            pagination.setCount(totalCount);
            int total = pagination.getLastPageNumber();
            ExecutorService dataExecutorService = Executors.newFixedThreadPool(16);
            logger.info("start update company ang background");
            for (int i = 1; i <= total; i++) {
                if (isShutdown) {
                    break;
                }
                final int num = i;
                dataExecutorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        Pagination paginationP = new Pagination();
                        paginationP.setPageNumber(num);
                        paginationP.setPageSize(pageSize);
                        paginationP.setCount(totalCount);
                        System.out.println("Thread is Start! ID:" + Thread.currentThread().getId());
                        System.out.println("PageNumber:" + paginationP.getPageNumber());
                        companyAndBackgroundUpdateThread(paginationP,2,oldTaskId);
                        System.out.println("Thread is Stop! ID:" + Thread.currentThread().getId());
                    }
                });
            }
            //logger.info("end update company area_id and address");
            dataExecutorService.shutdown();
            dataExecutorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        if (isShutdown) {
            taskResultDO.setFailCount(0);
            taskResultDO.setSuccessCount(0);
        }else{
            taskResultDO.setPlanCount(dataTotal);
            taskResultDO.setFailCount(errorNum);
            taskResultDO.setSuccessCount(dataTotal-errorNum);
        }
        logger.info("--- company baseInfo handle end ---");
        return taskResultDO;
    }


    private void companyAndBackgroundUpdateThread(Pagination pagination,Integer type,Integer dataTaskId) {
        if (isShutdown) {
            return;
        }
        Map<String, Object> params = new HashMap<>();
        params.put("pagination", pagination);
        StringBuffer companyNameSerial = new StringBuffer();
        List<String> failNameList = new ArrayList<String>();
        Map<String,String> vaildateRepeat = new HashMap<>();
        if(1==type){
            List<CompanyDO> list = companyMapper.findByPage(params);
            if (CollectionUtils.isEmpty(list)) {
                return;
            }
            for (final CompanyDO cdo : list) {
                failNameList.add(cdo.getName());
                companyNameSerial.append(cdo.getName());
                companyNameSerial.append(",");
            }
        }else{
            params.put("taskId",dataTaskId);
            List<TaskFailInfoDO> failList = taskFailInfoMapper.findByPage(params);
            if (CollectionUtils.isEmpty(failList)) {
                return;
            }
            for (final TaskFailInfoDO fail : failList) {
                failNameList.add(fail.getFailName());
                companyNameSerial.append(fail.getFailName());
                companyNameSerial.append(",");
            }
        }
        companyNameSerial.deleteCharAt(companyNameSerial.length() - 1); //去掉最后一个逗号
        logger.info("call BbdQyxxBatch api ...");
        Map batchData = hologramQueryService.getBbdQyxxBatch(companyNameSerial.toString());
        // 接口处未查询到数据
        if (CollectionUtils.isEmpty(batchData)) {
            insertFailInfo(failNameList,null,"接口数据为空");
            return;
        }
        String msg = (String) (batchData.get("msg"));
        if (null == msg || !msg.equals("ok")) {
            insertFailInfo(failNameList,null,"接口查询错误");
            return;
        }
        List<Map> rList = (List) (batchData.get("results"));
        if (CollectionUtils.isEmpty(rList)) {
            insertFailInfo(failNameList,null,"接口未查询到对应数据");
            return;
        }
        for (Map itr1 : rList) {
            if (isShutdown) {
                return;
            }
            Integer areaId = null;
            String companyName = null;
            String address = null;
            String creditCode = null;
            Double companyGisLat = null;
            Double companyGisLon = null;
            String ipoCompany = null;
            String frname = null;
            Integer registeredCapital = null;
            Integer registeredCapitalType = 1;//注册资本类型 1:人民币 2:美元
            String esdate = null;
            String companyType = null;
            Integer status = 2;
            String businessType = null;
            String currentApprovalDate = null;
            Map itr = null;
            try {
                itr = (Map) (itr1.get("jbxx"));
                if (CollectionUtils.isEmpty(itr)) {
                    return;
                }
                String company_county = (String) (itr.get("company_county"));
                String company_province = (String) (itr.get("company_province"));
                companyName =(String ) (itr.get("company_name"));
                AreaDO areaDO = areaService.selectByCountyCodeOrProvinceName( company_county,company_province);
                if (null == areaDO) { //区代不匹配，则不修改这一条记录
                    insertFailInfo(null,companyName,"区代匹配错误");
                    continue;
                }
                CompanyDO company = companyMapper.selectByName(companyName);
                if(null!=company && null!=company.getAreaId()){
                    //2018-01-24产品需求更新
                    //判断接口数据中company_county 是否为 310000或者310100，若为这两个值，则不做更新，否则用接口值更新company表的值
                    if("310000".equals(company_county)||"310100".equals(company_county)){
                        areaId=company.getAreaId();
                    }else{
                        areaId=areaDO.getAreaId();
                    }
                }else{
                    areaId=areaDO.getAreaId();
                }
                Object addressObj=itr.get("address");
                if(null!=addressObj){
                    address = (String)addressObj;
                }
                Object creditCodeObj=itr.get("credit_code");
                if(null!=creditCodeObj){
                    creditCode = (String)creditCodeObj;
                }
                Object companyGisLatObj=itr.get("company_gis_lat");
                if(null!=companyGisLatObj){
                    companyGisLat = Double.parseDouble(String.valueOf(companyGisLatObj));
                }
                Object companyGisLonObj=itr.get("company_gis_lon");
                if(null!=companyGisLonObj){
                    companyGisLon = Double.parseDouble(String.valueOf(companyGisLonObj));
                }
                Object ipoObj=itr.get("ipo_company");
                if(null!=ipoObj){
                    ipoCompany = (String)ipoObj;
                }
                //companyMapper.updateAreaIdAndAddress(companyName, areaId, address, creditCode);
                //legal_person 法人
                Object frnameObj=itr.get("frname");
                if(null!=frnameObj){
                    frname = (String)frnameObj;
                }
                Object cesObj=itr.get("company_enterprise_status");
                if(null!=cesObj){
                    String companyEnterpriseStatus = (String)cesObj;
                    if("存续".equals(companyEnterpriseStatus)){
                        status=  1 ;
                    }
                }
                Object companyTypeObj=itr.get("company_type");
                if(null!=companyTypeObj){
                    companyType = (String)companyTypeObj;
                }
                Object esdateObj=itr.get("esdate");//registered_date 注册时间
                if(null!=esdateObj){
                    esdate = (String)esdateObj;
                }
                Object approvalDateObj=itr.get("approval_date");//approval_date 批准时间
                if(null!=approvalDateObj){
                    currentApprovalDate = (String)approvalDateObj;
                }
                Object rcObj=itr.get("regcap_currency");
                if(null!=rcObj){
                    String regcapCurrency = (String)rcObj;
                    if("美元".equals(regcapCurrency)){
                        registeredCapitalType = 2 ;
                    }
                }
                //Object regcapObj=itr.get("regcap");
                Object regcapObj=itr.get("regcap_amount");
                if(null!=regcapObj){
                    BigDecimal regcap = (BigDecimal)regcapObj;
                    registeredCapital=regcap.intValue()/10000;
                    //registeredCapital = Integer.parseInt(Pattern.compile("[^0-9]").matcher(regcap).replaceAll(""));
                }
                Object companyIndustryObj=itr.get("company_industry");
                if(null!=companyIndustryObj){
                    String companyIndustry = (String)companyIndustryObj;
                    businessType = IndustryCodeDO.getValueByNameStr(companyIndustry);

                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                insertFailInfo(null,companyName,"接口指数错误");
            }
            try {
                //当前记录的批准日期大于之前的日期，为最新的数据，再次更新，否则不做操作
                String lastApprovalDate = vaildateRepeat.get(companyName);
                if(StringUtils.isNotEmpty(lastApprovalDate)&&
                        DateUtils.compareDateStr(lastApprovalDate,currentApprovalDate)==1){
                    continue;
                }
                //companyMapper.updateAreaIdAndAddress( companyName,areaId, address, creditCode );
                companyMapper.updateBasicInfo(companyName,areaId, address, creditCode,companyGisLon,companyGisLat,
                        frname,registeredCapital,registeredCapitalType,esdate,companyType,status,businessType);
                updateCompanyBackground(companyName, ipoCompany, companyType);
                vaildateRepeat.put(companyName,currentApprovalDate);
            } catch (Exception e) {
                insertFailInfo(null,companyName,"更新数据错误");
            }
        }
    }

    /**
     * 更新background表
     *
     * @param companyName
     * @param ipoCompany
     */
    private void updateCompanyBackground(String companyName, String ipoCompany, String companyType) {
        CompanyDO companyDO = companyMapper.selectByName(companyName);
        if (companyDO != null&&companyDO.getCompanyId()!=null) {
            Integer companyId = companyDO.getCompanyId();
            companyBackgroundMapper.deleteByCompanyId(companyId);
            CompanyBackgroundDO companyBackgroundDO = new CompanyBackgroundDO();
            companyBackgroundDO.setCompanyId(companyId);
            companyBackgroundDO.setCreateBy("system");
            companyBackgroundDO.setCreateDate(new Date());
            companyBackgroundDO.setBackground(getCompanyIpo(ipoCompany));
            companyBackgroundMapper.add(companyBackgroundDO);
            companyBackgroundDO.setBackground(getCompanyType(companyType));
            companyBackgroundMapper.add(companyBackgroundDO);
        }
    }

    private void insertFailInfo(List<String> list,String companyName,String errorReason){
        TaskFailInfoDO failInfo = new TaskFailInfoDO();
        failInfo.setFailReason(errorReason);
        failInfo.setTaskId(taskId);
        failInfo.setCreateBy("system");
        if(null==list){
            failInfo.setFailName(companyName);
            taskFailInfoMapper.addTaskFailInfo(failInfo);
            errorNum++;
        }else{
            for(String name:list){
                failInfo.setFailName(name);
                taskFailInfoMapper.addTaskFailInfo(failInfo);
                errorNum++;
            }
        }
    }

    private Byte getCompanyIpo(String ipoCompany) {
        if ("上市公司".equals(ipoCompany)) {
            return 1;
        } else {
            return 2;
        }
    }

    private Byte getCompanyType(String companyType) {
        //国企：company_type包含“全民所有制”，或者（包含“国有”但排除“非国有”）的企业
        //外企：company_type包含：外商、外资、外国、港、澳、台、中外几个关键字之一的企业。
        //民企：除了以上两个类别外的其他企业。
        // 3:国企 4:民营企业 5:外资企业
        if(companyType.indexOf("全民所有制")>=0){
            return 3;
        }else if(companyType.indexOf("非国有")==-1&&companyType.indexOf("国有")>=0){
            return 3;
        }else if(companyType.indexOf("外商")>=0||
                companyType.indexOf("外资")>=0||
                companyType.indexOf("外国")>=0||
                companyType.indexOf("港")>=0||
                companyType.indexOf("澳")>=0||
                companyType.indexOf("台")>=0||
                companyType.indexOf("中外")>=0){
            return 5;
        }else{
            return 4;
        }
    }

    @Override
    public String getTaskKey() {
        return "companyBaseInfoJob";
    }

    @Override
    public String getTaskGroup() {
        return "job_work";
    }

    @Override
    public TaskResultDO autoExecute(Integer taskId, Integer runMode) {
        TaskResultDO taskResultDO = updateCompanyAndBackgroundAutomaticOperate(taskId);
        return taskResultDO;
    }

    @Override
    public TaskResultDO reExecute(Integer oldTaskId, Integer newTaskId, Integer runMode) {

        TaskResultDO taskResultDO = updateCompanyAndBackgroundManualOperate(oldTaskId, newTaskId);
        return taskResultDO;
    }

    @Override
    public void stopExecute(Integer taskId) {
        stopTask();
    }

    @Override
    public void resetTask() {
        this.isShutdown=false;
    }

}


