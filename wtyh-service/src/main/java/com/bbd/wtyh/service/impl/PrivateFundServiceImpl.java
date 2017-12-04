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

import java.util.Date;
import java.util.LinkedList;
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
    public PrivateFundTypeDO getPriFundTypeByName(String typeName) {
        return privateFundTypeMapper.getPriFundTypeByName(typeName);
    }

    @Override
    public FundProductTypeDO getProductTypeById(Integer productTypeId) {
        return productTypeMapper.selectByPrimaryKey(productTypeId);
    }

    @Override
    public FundProductTypeDO getProductTypeByName(String typeName) {
        return productTypeMapper.getProductTypeByName(typeName);
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
    public LinkedList<InvestmentReturnStatisticDO> investmentReturn() {
        return investmentReturnStatisticMapper.selectAll();
    }

    @Override
    public LinkedList<InvestmentStatisticDO> investmentAmount() {
        return investmentStatisticMapper.selectAll();
    }

    @Override
    public PageBean<PrivateFundCompanyDTO> privateFundExtraList(Integer orderByField, String descAsc, Integer recordStatus,Integer start,Integer pageSize) {
        Long count = privateFundExtraMapper.countCompany(orderByField, descAsc, recordStatus);
        PageBean<PrivateFundCompanyDTO> paging = new PageBean<>();
        if(count.equals(0)){
            return paging;
        }
        paging.setCurrentPage(start/pageSize+1);
        paging.setTotalCount(count);
        paging.setPageSize(pageSize);
        List<PrivateFundCompanyDTO> fundCompanyList = privateFundExtraMapper.selectAll(orderByField, descAsc, recordStatus,start,pageSize);

        paging.setItems(fundCompanyList);
        return paging;
    }

    @Override
    public PageBean<PrivateFundCompanyDTO> privateFundQueryList(String companyName, Integer orderByField, String descAsc, Integer start, Integer pageSize) {
        companyName = "%"+companyName+"%";
        Long count = privateFundExtraMapper.countQueryCompany(companyName,orderByField, descAsc);
        PageBean<PrivateFundCompanyDTO> paging = new PageBean<>();
        if(count.equals(0)){
            return paging;
        }
        paging.setCurrentPage(start/pageSize+1);
        paging.setTotalCount(count);
        paging.setPageSize(pageSize);
        List<PrivateFundCompanyDTO> fundCompanyList = privateFundExtraMapper.queryAll(companyName,orderByField, descAsc,start,pageSize);

        paging.setItems(fundCompanyList);
        return paging;
    }

    @Override
    public List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition, PageBean pagination) {
        pagination.setTotalCount(privateFundExtraMapper.countPrivateOfferedFund(exportCondition));
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
    public int selectQdlpMaxIndexNum() {
        return qdlpProgressMapper.selectQdlpMaxIndexNum();
    }

    @Override
    public int selectQflpMaxIndexNum() {
        return qflpCompanyMapper.selectQflpMaxIndexNum();
    }

    @Override
    public void addQdlpProgress(QdlpProgressDO qdlpProgressDO) {
        qdlpProgressMapper.add(qdlpProgressDO);
    }

    @Override
    public void saveOrUpdateProductStatistic(FundProductStatisticDO productDO) {
        FundProductStatisticDO statisticDO = productStatisticMapper.selectByPrimaryKey(productDO.getProductTypeId());
        if (statisticDO != null) {
            statisticDO.setProductNumber(productDO.getProductNumber());
            statisticDO.setUpdateBy(productDO.getUpdateBy());
            statisticDO.setUpdateDate(new Date());
            productStatisticMapper.update(statisticDO);
            return;
        }
        productDO.setCreateDate(new Date());
        productDO.setCreateBy(productDO.getUpdateBy());
        productStatisticMapper.add(productDO);

    }

    @Override
    public void saveOrUpdateStatistic(PrivateFundStatisticDO statisticDO) {
        PrivateFundStatisticDO privateFundStatisticDO = statisticMapper.selectByPrimaryKey(statisticDO.getTypeId());

        if (privateFundStatisticDO != null) {
            privateFundStatisticDO.setAmount(statisticDO.getAmount());
            privateFundStatisticDO.setUpdateBy(statisticDO.getUpdateBy());
            privateFundStatisticDO.setUpdateDate(new Date());
            statisticMapper.update(privateFundStatisticDO);
            return;
        }
        statisticDO.setCreateBy(statisticDO.getUpdateBy());
        statisticDO.setCreateDate(new Date());
        statisticMapper.add(privateFundStatisticDO);
    }

}
