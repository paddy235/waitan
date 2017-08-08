package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.EasyExport.TradeMarketData;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;

import java.util.List;
import java.util.Map;

/**
 * 交易所接口层
 *
 * @author zhouxuan
 * @since 2016.08.10
 */
public interface ExchangeCompanyService {

    /**
     * 交易场所清理整顿分类统计
     *
     * @return
     */
    public List<Map> exchangeCompanyCategory();

    /**
     * 交易场所地域分布
     *
     * @return
     */
    public List<ExchangeCompanyAreaVO> exchangeCompanyArea();

    /**
     * 查询不同状态的交易场所列表
     * 取得合规意见或经过会商的交易场所详细列表
     *
     * @param statusName
     * @return
     */
    public List<ExchangeCompanyVO> exchangeCompanyByStatus(String statusName);

    /**
     * 按地区查询交易所列表
     *
     * @param areaName
     * @param orderName
     * @param orderType
     * @return
     */
    public List<ExchangeCompanyVO> exchangeCompanyListByAreaId(String areaName, String orderName, String orderType, Integer type);

    List<TradeMarketData> getTradeMarket(ExportCondition exportCondition, PageBean pagination);

    void deleteByCompanyId(RecordInfo recordInfo);

    void addExchange(RecordInfo recordInfo);
}
