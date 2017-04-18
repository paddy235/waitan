package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.InvestigationInfoDO;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.mapper.InvestigationInfoMapper;
import com.bbd.wtyh.service.InvestigationInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/18.
 */
public class InvestigationInfoImpl extends BaseServiceImpl implements InvestigationInfo {

    @Autowired
    private InvestigationInfoMapper investigationInfoMapper;
    @Override
    public Map<String, Object> listInvestigationInfo(int pageSize, Integer pageNumber, String orderBy, Integer companyId,
                                                     String companyName, String recorder, Date beginTime, Date endTime)
            throws Exception {
        if (pageSize < 1) {
            throw new BusinessException("pageSize参数小于1，无意义");
        }
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (null != companyId) {
            params.put("companyId", companyId);
        }
        if( StringUtils.isNotBlank(companyName) ) {
            params.put("companyName", companyName);
        }
        if( StringUtils.isNotBlank(recorder) ) {
            params.put("updateBy", recorder);
        }
        if (null != beginTime) {
            params.put("beginTime", beginTime);
        }
        if (null != endTime) {
            if( null !=beginTime && endTime.before(beginTime) ) {
                throw new BusinessException("截止时刻不能早于起始时刻");
            }
            params.put("endTime", endTime);
        }
        List<Map<String, Object>> lm = investigationInfoMapper.listInvestigationInfo(params); // 查询符合条件的记录总条数
        Long ltn = (Long) (lm.get(0).get("recordTotal"));
        params.put("pageSize", pageSize);
        int orderNum = 0;
        if ((null != pageNumber) && (pageNumber > 0)) {
            orderNum = (pageNumber - 1) * pageSize;
            pageNumber = (pageNumber - 1) * pageSize; // pageNumber的意义已经变为了“Offset”
            params.put("pageNumber", pageNumber);
        }
        params.put("listing", 1);  //使能列表查询功能
        if (StringUtils.isNotBlank(orderBy ) && orderBy.equals("DESC") ) {
            params.put("orderBy", "DESC");
        }
        lm = investigationInfoMapper.listInvestigationInfo(params);
        Map<String, Object> rstMap = new HashMap<String, Object>();
        rstMap.put("listTotalNum", ltn);
        rstMap.put("list", lm);
        return rstMap;
    }

    @Override
    public void saveInvestigationInfo(InvestigationInfoDO iid, String recorder) throws Exception {
        if (null ==iid) {
            throw new BusinessException("对象不能为空");
        }
        iid.setId(null);
        if( null ==iid.getCompanyId() && StringUtils.isBlank( iid.getCompanyName() ) ) {
            throw new BusinessException("公司ID或名称不能同时为空");
        }
        if( StringUtils.isBlank( iid.getTitle() ) ||StringUtils.isBlank( iid.getDetail() )
                ||StringUtils.isBlank( recorder ) ) {
            throw new BusinessException("标题、详情和记录者均不能为空");
        }
        iid.setCreateBy(recorder);
        iid.setUpdateBy(recorder);
        iid.setCreateDate(new Date());
        iid.setUpdateDate(new Date());
        investigationInfoMapper.saveInvestigationInfo(iid);
    }
}
