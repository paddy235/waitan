package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.domain.vo.StatisticsVO;
import org.apache.poi.ss.formula.functions.T;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 交易所接口层
 * @author zhouxuan
 * @since  2016.08.10
 */
public interface ExchangeCompanyService {

    /**
     * 交易场所清理整顿分类统计
     * @return
     */
    public List<Map> exchangeCompanyCategory();

    /**
     * 交易场所地域分布
     * @return
     */
    public List<ExchangeCompanyAreaVO> exchangeCompanyArea();

    /**
     * 查询不同状态的交易场所列表
     * 取得合规意见或经过会商的交易场所详细列表
     * @param status
     * @return
     */
    public List<ExchangeCompanyVO> exchangeCompanyByStatus(Integer status);

    /**
     * 按地区查询交易所列表
     * @param areaId
     * @return
     */
    public List<CompanyDO> exchangeCompanyListByAreaId(Integer areaId, String orderName, String orderType);
}
