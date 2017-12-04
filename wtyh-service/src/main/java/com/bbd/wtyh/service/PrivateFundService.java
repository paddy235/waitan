package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.EasyExport.PrivateOfferedFundData;
import com.bbd.wtyh.domain.dto.PrivateFundCompanyDTO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Marco on 2016/8/10.
 */
public interface PrivateFundService {

    List<QdlpProgressDO> qdlpProgressList();

    QdlpProgressDO getQdlpProgressByPrimaryKey(Integer companyId);

    List<QflpCompanyDO> qflpCompanyList();

    QflpCompanyDO getQflpCompanyByPrimaryKey(Integer companyId);

    List<PrivateFundStatisticDO> typeStatisticList();

    PrivateFundTypeDO getTypeById(Integer privateFundTypeId);

    PrivateFundTypeDO getPriFundTypeByName(String typeName);

    FundProductTypeDO getProductTypeById(Integer productTypeId);

    FundProductTypeDO getProductTypeByName(String typeName);

    List<FundProductStatisticDO> productTypeStatisticList();

    List<ProductAmountDO> topProductNumber(Integer numbers);


    List<CapitalAmountDO> capitalAmount();

    LinkedList<InvestmentReturnStatisticDO> investmentReturn();

    LinkedList<InvestmentStatisticDO> investmentAmount();

    PageBean<PrivateFundCompanyDTO> privateFundExtraList(String companyName,Integer orderByField, String descAsc, Integer recordStatus,Integer start,Integer pageSize);

    PageBean<PrivateFundCompanyDTO> privateFundQueryList(String companyName,Integer orderByField, String descAsc,Integer recordStatus,Integer start,Integer pageSize);

    List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition, PageBean pagination);

    void updateQflpCompany(QflpCompanyDO qflpCompanyDO);

    void addQflpCompany(QflpCompanyDO qflpCompanyDO);

    void updateQdlpProgress(QdlpProgressDO qdlpProgressDO);

    void addQdlpProgress(QdlpProgressDO qdlpProgressDO);

    void saveOrUpdateProductStatistic(FundProductStatisticDO productDO);

    void saveOrUpdateStatistic(PrivateFundStatisticDO statisticDO);

    int selectQdlpMaxIndexNum();

    int selectQflpMaxIndexNum();
}
