package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.LargeLoanDO;
import com.bbd.wtyh.domain.LoanBalanceDO;
import com.bbd.wtyh.domain.dto.LoanBalanceByQuarterDTO;
import com.bbd.wtyh.mapper.LargeLoanMapper;
import com.bbd.wtyh.mapper.LoanBalanceMapper;
import com.bbd.wtyh.service.LoanService;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/8/8.
 */
@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanBalanceMapper loanBalanceMapper;
    @Autowired
    private LargeLoanMapper largeLoanMapper;

    @Override
    public List<LoanBalanceDO> getLoanBalanceByMonth() {
        int totalItems = 6;
        return loanBalanceMapper.listByMonth(totalItems);
    }

    @Override
    public List<LoanBalanceByQuarterDTO> getLoanBalanceByQuater() {
        //取最近20个月的数据，比七个季度少一个月的目的是判断的时候方便，直接舍弃不满三个月的那个季度
        int totalItems = 7 * 3 - 1;
        List<LoanBalanceDO> balanceDOList = loanBalanceMapper.listByMonth(totalItems);
        Map<String, LoanBalanceByQuarterDTO> map = Maps.newHashMap();
        Map<String, Integer> monthCount = Maps.newHashMap();
        for (LoanBalanceDO balanceDO : balanceDOList) {
            String key = "" + balanceDO.getYear() + ((balanceDO.getMonth() + 2) / 3);
            if (map.containsKey(key)) {
                LoanBalanceByQuarterDTO quaterDTO = map.get(key);
                quaterDTO.setNumber(quaterDTO.getNumber() + balanceDO.getNumber());
                quaterDTO.setAgricultureBalance(quaterDTO.getAgricultureBalance() + balanceDO.getAgricultureBalance());
                quaterDTO.setAmount(quaterDTO.getAmount() + balanceDO.getAmount());
                quaterDTO.setSmallCompanyBalance(quaterDTO.getSmallCompanyBalance() + balanceDO.getSmallCompanyBalance());
                monthCount.put(key, monthCount.get(key) + 1);
            } else {
                LoanBalanceByQuarterDTO dto = new LoanBalanceByQuarterDTO();
                dto.setYear(balanceDO.getYear());
                dto.setQuarter((balanceDO.getMonth() + 2) / 3);
                dto.setAgricultureBalance(balanceDO.getAgricultureBalance());
                dto.setSmallCompanyBalance(balanceDO.getSmallCompanyBalance());
                dto.setAmount(balanceDO.getAmount());
                dto.setNumber(balanceDO.getNumber());
                dto.setCompanyAmount(balanceDO.getCompanyAmount());
                map.put(key, dto);
                monthCount.put(key, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : monthCount.entrySet()) {
            if (entry.getValue() < 3) {
                map.remove(entry.getKey());
            }
        }
        return Ordering.from(new Comparator<LoanBalanceByQuarterDTO>() {
            @Override
            public int compare(LoanBalanceByQuarterDTO o1, LoanBalanceByQuarterDTO o2) {
                return Integer.valueOf("" + o2.getYear() + o2.getQuarter()) - Integer.valueOf("" + o1.getYear() + o1.getQuarter());
            }
        }).sortedCopy(map.values());
    }

    @Override
    public List<LoanBalanceDO> getLoanBalanceByYear() {
        return loanBalanceMapper.listByYear();
    }

    @Override
    public List<LargeLoanDO> listLargeLoan(Pagination pagination, Integer orderByField, String descAsc) {
        if (null != orderByField && orderByField >= 5) {
            orderByField = null;
        }
        return largeLoanMapper.listLargeLoan(pagination, orderByField, descAsc);
    }

    @Override
    public int countLargeLoan() {
        return largeLoanMapper.countLargeLoan();
    }


}
