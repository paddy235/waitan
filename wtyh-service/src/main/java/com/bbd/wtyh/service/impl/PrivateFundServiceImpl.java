package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.EasyExport.PrivateOfferedFundData;
import com.bbd.wtyh.domain.dto.PrivateFundCompanyDTO;
import com.bbd.wtyh.mapper.*;
import com.bbd.wtyh.service.PrivateFundService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Marco on 2016/8/10.
 */
@Service
public class PrivateFundServiceImpl implements PrivateFundService {

    @Autowired
    private QdlpProgressMapper qdlpProgressMapper;
    @Autowired
    private QflpCompanyMapper qflpCompanyMapper;
    @Autowired
    private PrivateFundStatisticMapper statisticMapper;
    @Autowired
    private PrivateFundTypeMapper privateFundTypeMapper;
    @Autowired
    private FundProductTypeMapper productTypeMapper;
    @Autowired
    private FundProductStatisticMapper productStatisticMapper;
    @Autowired
    private ProductAmountMapper productAmountMapper;
    @Autowired
    private CapitalAmountMapper capitalAmountMapper;
    @Autowired
    private InvestmentReturnStatisticMapper investmentReturnStatisticMapper;
    @Autowired
    private InvestmentStatisticMapper investmentStatisticMapper;
    @Autowired
    private PrivateFundExtraMapper privateFundExtraMapper;


    @Override
    public List<QdlpProgressDO> qdlpProgressList() {
        return qdlpProgressMapper.selectAll();
    }

    @Override
    public QdlpProgressDO getQdlpProgressByPrimaryKey(Integer companyId) {
        return qdlpProgressMapper.selectByPrimaryKey(companyId);
    }

    @Override
    public List<QflpCompanyDO> qflpCompanyList() {
        return qflpCompanyMapper.selectAll();
    }

    @Override
    public QflpCompanyDO getQflpCompanyByPrimaryKey(Integer companyId) {
        return qflpCompanyMapper.selectByPrimaryKey(companyId);
    }

    @Override
    public List<PrivateFundStatisticDO> typeStatisticList() {
        return statisticMapper.selectAll();
    }

    @Override
    public PrivateFundTypeDO getTypeById(Integer privateFundTypeId) {
        return privateFundTypeMapper.selectByPrimaryKey(privateFundTypeId.byteValue());
    }

    @Override
    public FundProductTypeDO getProductTypeById(Integer productTypeId) {
        return productTypeMapper.selectByPrimaryKey(productTypeId);
    }

    @Override
    public List<FundProductStatisticDO> productTypeStatisticList() {
        return productStatisticMapper.selectAll();
    }

    @Override
    public List<ProductAmountDO> topProductNumber(Integer numbers) {
        return productAmountMapper.topProductNumber(numbers);
    }

    @Override
    public List<CapitalAmountDO> capitalAmount() {
        return capitalAmountMapper.selectAll();
    }

    @Override
    public List<InvestmentReturnStatisticDO> investmentReturn() {
        return investmentReturnStatisticMapper.selectAll();
    }

    @Override
    public List<InvestmentStatisticDO> investmentAmount() {
        return investmentStatisticMapper.selectAll();
    }

    @Override
    public List<PrivateFundCompanyDTO> privateFundExtraList(Integer orderByField, String descAsc, Integer recordStatus) {
        return privateFundExtraMapper.selectAll(orderByField, descAsc, recordStatus);
    }

    @Override
    public List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition, PageBean pagination) {
        return privateFundExtraMapper.getPrivateOfferedFund(exportCondition, pagination);
    }

    @Override
    public void updateQflpCompany(QflpCompanyDO qflpCompanyDO) {
        qflpCompanyMapper.update(qflpCompanyDO);
    }

    @Override
    public void addQflpCompany(QflpCompanyDO qflpCompanyDO) {
        qflpCompanyMapper.add(qflpCompanyDO);
    }

    @Override
    public void updateQdlpProgress(QdlpProgressDO qdlpProgressDO) {
        qdlpProgressMapper.update(qdlpProgressDO);
    }

    @Override
    public void addQdlpProgress(QdlpProgressDO qdlpProgressDO) {
        qdlpProgressMapper.add(qdlpProgressDO);
    }

}
