package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.PrepaidCompanyDO;
import com.bbd.wtyh.domain.PrepaidCompanyStatisticDO;
import com.bbd.wtyh.mapper.PrepaidCompanyStatisticMapper;
import com.bbd.wtyh.service.PrepaidCompanyStaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ian.Su
 * @since 2016年8月12日 上午9:35:34
 */
@Service
public class PrepaidCompanyStaticServiceImpl implements PrepaidCompanyStaticService {

    @Autowired
    private PrepaidCompanyStatisticMapper pcsMapper;

    @Override
    public List<PrepaidCompanyStatisticDO> prepaidAll() {

        return pcsMapper.prepaidAll();

    }

    @Override
    public List<PrepaidCompanyDO> prepaidCompanyAll() {
        return pcsMapper.prepaidCompanyAll();
    }

    @Override
    public CompanyInfo getPerpaycardByCompanyName(String name) {
        return pcsMapper.getPerpaycardByCompanyName(name);
    }

    @Override
    public void modifyPerpaycard(RecordInfo recordInfo) {
        pcsMapper.modifyPerpaycard(recordInfo);
    }

    @Override
    public void addPerpaycard(RecordInfo recordInfo) {
        pcsMapper.addPerpaycard(recordInfo);
    }

    @Override
    public void deleteByCompanyId(RecordInfo recordInfo) {
        pcsMapper.deleteByCompanyId(recordInfo);
    }

}
