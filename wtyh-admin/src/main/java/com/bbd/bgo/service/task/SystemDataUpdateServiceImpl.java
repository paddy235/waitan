package com.bbd.bgo.service.task;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.CompanyBackgroundDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.mapper.CompanyBackgroundMapper;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.service.HologramQueryService;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.service.impl.OfflineFinanceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cgj on 2017/4/20.
 */
@Service
public class SystemDataUpdateServiceImpl implements SystemDataUpdateService {

    private Logger logger = LoggerFactory.getLogger(OfflineFinanceServiceImpl.class);

    @Autowired
    private PToPMonitorService pToPMonitorService;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyBackgroundMapper companyBackgroundMapper;

    @Autowired
    private HologramQueryService hologramQueryService;

    /**
     * 每月2日晚上8点，更新企业表中的地区ID和企业地址
     * (by cgj)
     */
    @Scheduled(cron = "0 0 20 2 * ?")
    @Override
    public void updateCompanyTableAreaIdAndAddress() {
        Object obj = new Object();
        try {
            final int totalCount = companyMapper.countAllCompany();
            final int pageSize = 190;
            Pagination pagination = new Pagination();
            pagination.setPageSize(pageSize);
            pagination.setCount(totalCount);
            int total = pagination.getLastPageNumber();
            ExecutorService dataExecutorService = Executors.newFixedThreadPool(16);
            logger.info("start update company area_id and address");
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
                        companyAreaIdAndAddressUpdateThread(paginationP);
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
    }


    private void companyAreaIdAndAddressUpdateThread(Pagination pagination) {
        Map<String, Object> params = new HashMap<>();
        params.put("pagination", pagination);
        List<CompanyDO> list = companyMapper.findByPage(params);
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        StringBuffer companyNameSerial = new StringBuffer(list.size() * 41);
        for (final CompanyDO cdo : list) {
            companyNameSerial.append(cdo.getName());
            companyNameSerial.append(",");
        }
        companyNameSerial.deleteCharAt(companyNameSerial.length() - 1); //去掉最后一个逗号
        Map batchData = hologramQueryService.getBbdQyxxBatch(companyNameSerial.toString());
        if (CollectionUtils.isEmpty(batchData)) {
            return;
        }
        String msg = (String) (batchData.get("msg"));
        if (null == msg || !msg.equals("ok")) {
            return;
        }
        List<Map> rList = (List) (batchData.get("results"));
        if (CollectionUtils.isEmpty(rList)) {
            return;
        }
        for (Map itr1 : rList) {
            Map itr = (Map) (itr1.get("jbxx"));
            if (CollectionUtils.isEmpty(itr)) {
                return;
            }
            String company_county = (String) (itr.get("company_county"));
            Integer areaId = ShanghaiAreaCode.getCodeToAreaMap().get(Integer.valueOf(company_county));
            if (null == areaId) { //区代不匹配，则不修改这一条记录
                continue;
            }
            String companyName = (String) (itr.get("company_name"));
            String address = (String) (itr.get("address"));
            String creditCode = (String) (itr.get("credit_code"));
            String ipoCompany = (String) (itr.get("ipo_company"));
            String companyType = (String) (itr.get("company_type"));
            companyMapper.updateAreaIdAndAddress(companyName, areaId, address, creditCode);
            updateCompanyBackground(companyName, ipoCompany, companyType);
        }
    }

    /**
     * 更新background表
     *
     * @param companyName
     * @param ipoCompany
     */
    private void updateCompanyBackground(String companyName, String ipoCompany, String companyType) {
        try {
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
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
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


