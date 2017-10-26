package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyInfoModify.RecordInfo;
import com.bbd.wtyh.domain.EasyExport.TradeMarketData;
import com.bbd.wtyh.domain.vo.ExchangeCompanyAreaVO;
import com.bbd.wtyh.domain.vo.ExchangeCompanyVO;
import com.bbd.wtyh.mapper.ExchangeCompanyMapper;
import com.bbd.wtyh.service.ExchangeCompanyService;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 交易所接口实现层
 *
 * @author zhouxuan
 * @since 2016.08.10
 */
@Service("exchangeCompanyService")
public class ExchangeCompanyServiceImpl implements ExchangeCompanyService {

    private Logger logger = LoggerFactory.getLogger(ExchangeCompanyServiceImpl.class);

    @Resource
    private ExchangeCompanyMapper exchangeCompanyMapper;

    @Override
    public List<Map> exchangeCompanyCategory() {
        List<Map> list = exchangeCompanyMapper.queryExchangeCompanyCategory();
        List<Map> resultList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            Map<String, Integer> resultMap = new HashedMap();
            for (Map map : list) {
                int status ;
                Object object=map.get("status");
                if(null != object){
                    status = (int) map.get("status");
                }else{
                    status = -1;
                }

                int number = Integer.parseInt(map.get("number").toString());
                String statusName ;
                if (status == 2) {
                    statusName = "企业自行设立";
                    resultMap.put(statusName, number);
                } else if (status == 1 || status == 3 || status == 4) {
                    statusName = "市政府及市相关主管单位批复设立";
                    if (resultMap.get(statusName) == null) {
                        resultMap.put(statusName, number);
                    } else {
                        resultMap.put(statusName, resultMap.get(statusName) + number);
                    }
                } else if (status == 5) {
                    statusName = "2013年通过清整联办验收";
                    resultMap.put(statusName, number);
                } else {
                    //do nothing;
                }
            }
            for (String key : resultMap.keySet()) {
                Map temp = new HashedMap();
                temp.put(key, resultMap.get(key));
                resultList.add(temp);
            }
        }
        return resultList;
    }

    @Override
    public List<ExchangeCompanyAreaVO> exchangeCompanyArea() {
        List<ExchangeCompanyAreaVO> list = exchangeCompanyMapper.queryExchangeCompanyArea();
        return list;
    }

    @Override
    public List<ExchangeCompanyVO> exchangeCompanyByStatus(String statusName) {
        List<ExchangeCompanyVO> list = new ArrayList<>();
        if ("企业自行设立".equals(statusName)) {
            list.addAll(exchangeCompanyMapper.queryExchangeCompanyByStatus(2));
        } else if ("市政府及市相关主管单位批复设立".equals(statusName)) {
            list.addAll(exchangeCompanyMapper.queryExchangeCompanyByStatus(1));
            list.addAll(exchangeCompanyMapper.queryExchangeCompanyByStatus(3));
            list.addAll(exchangeCompanyMapper.queryExchangeCompanyByStatus(4));
        } else if ("2013年通过清整联办验收".equals(statusName)) {
            list.addAll(exchangeCompanyMapper.queryExchangeCompanyByStatus(5));
        } else {
            list.addAll(exchangeCompanyMapper.queryExchangeCompanyByStatus(0));
        }
        return list;
    }

    @Override
    public List<ExchangeCompanyVO> exchangeCompanyListByAreaId(String areaName, String orderName, String orderType, Integer type) {
        Map map = new HashMap();
        map.put("areaName", areaName);
        map.put("orderName", orderName);
        map.put("orderType", orderType);
        map.put("type", type);
        return exchangeCompanyMapper.queryExchangeCompanyListByAreaId(map);
    }

    @Override
    public List<TradeMarketData> getTradeMarket(ExportCondition exportCondition, PageBean pagination) {
        pagination.setTotalCount(exchangeCompanyMapper.countTradeMarket(exportCondition));
        return exchangeCompanyMapper.getTradeMarket(exportCondition, pagination);
    }

    @Override
    public void deleteByCompanyId(RecordInfo recordInfo) {
        exchangeCompanyMapper.deleteByCompanyId(recordInfo);
    }

    @Override
    public void addExchange(RecordInfo recordInfo) {
        deleteByCompanyId(recordInfo);
        exchangeCompanyMapper.addExchange(recordInfo);
    }
}
