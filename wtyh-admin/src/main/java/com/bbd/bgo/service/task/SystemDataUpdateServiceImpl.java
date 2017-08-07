package com.bbd.bgo.service.task;


import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.mapper.CompanyBackgroundMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.TaskFailInfoMapper;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.service.impl.OfflineFinanceServiceImpl;
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
public class SystemDataUpdateServiceImpl implements SystemDataUpdateService {

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

    @Override
    public TaskResultDO updateCompanyAndBackgroundAutomaticOperate(Integer taskId) {
        this.taskId=taskId;
        this.errorNum=0;
        TaskResultDO taskResultDO=new TaskResultDO();
        Integer dataTotal = 0;
        try {
            final int totalCount = companyMapper.countAllCompany();
            dataTotal = totalCount;
            final int pageSize = 190;
            Pagination pagination = new Pagination();
            pagination.setPageSize(pageSize);
            pagination.setCount(totalCount);
            int total = pagination.getLastPageNumber();
            ExecutorService dataExecutorService = Executors.newFixedThreadPool(16);
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

        taskResultDO.setPlanCount(dataTotal);
        taskResultDO.setFailCount(errorNum);
        taskResultDO.setSuccessCount(dataTotal-errorNum);

        return taskResultDO;
    }

    @Override
    public TaskResultDO updateCompanyAndBackgroundManualOperate(Integer oldTaskId,Integer newTaskId){
        TaskResultDO taskResultDO = new TaskResultDO();
        this.taskId=newTaskId;
        this.errorNum=0;
        Integer dataTotal = 0;
        try {
            final int totalCount = taskFailInfoMapper.countFailByTaskId(oldTaskId);
            dataTotal = totalCount;
            final int pageSize = 190;
            Pagination pagination = new Pagination();
            pagination.setPageSize(pageSize);
            pagination.setCount(totalCount);
            int total = pagination.getLastPageNumber();
            ExecutorService dataExecutorService = Executors.newFixedThreadPool(16);
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

        taskResultDO.setPlanCount(dataTotal);
        taskResultDO.setFailCount(errorNum);
        taskResultDO.setSuccessCount(dataTotal-errorNum);
        return taskResultDO;
    }


    private void companyAndBackgroundUpdateThread(Pagination pagination,Integer type,Integer dataTaskId) {
        Map<String, Object> params = new HashMap<>();
        params.put("pagination", pagination);
        StringBuffer companyNameSerial = new StringBuffer();
        List<String> failNameList = new ArrayList<String>();
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
        logger.info("update company name:"+companyNameSerial.toString());
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
                areaId=areaDO.getAreaId();

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
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                insertFailInfo(null,companyName,"接口指数错误");
            }
            try {
                //companyMapper.updateAreaIdAndAddress( companyName,areaId, address, creditCode );
                companyMapper.updateBasicInfo(companyName,areaId, address, creditCode,companyGisLon,companyGisLat,
                        frname,registeredCapital,registeredCapitalType,esdate,companyType,status);

                updateCompanyBackground(companyName, ipoCompany, companyType);
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
        if ("全民所有制".equals(companyType)) {
            return 3;
        } else {
            return 4;
        }
    }
}


