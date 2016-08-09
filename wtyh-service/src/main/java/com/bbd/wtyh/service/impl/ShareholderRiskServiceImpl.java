package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyDO;
import com.bbd.wtyh.domain.RelatedCompanyStatisticDO;
import com.bbd.wtyh.domain.dto.ShareholderRiskDTO;
import com.bbd.wtyh.mapper.RelatedCompanyMapper;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.ShareholderRiskService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/8/8 0008.
 */
@Service
public class ShareholderRiskServiceImpl implements ShareholderRiskService {
    @Autowired
    private RelatedCompanyMapper relatedCompanyMapper;
    @Autowired
    private CompanyService companyService;


    @Override
    public List<ShareholderRiskDTO> listShareholderRisk(Integer companyType) {
        List<RelatedCompanyStatisticDO> list = relatedCompanyMapper.logisticRelatedCompany(companyType);
        Map<Integer, ShareholderRiskDTO> company2Risk = Maps.newHashMap();
        for (RelatedCompanyStatisticDO relatedCompanyStatisticDO : list) {
            ShareholderRiskDTO shareholderRiskDTO = company2Risk.get(relatedCompanyStatisticDO.getCompanyId());
            if (null == shareholderRiskDTO) {
                shareholderRiskDTO = new ShareholderRiskDTO();
                shareholderRiskDTO.setCompanyId(relatedCompanyStatisticDO.getCompanyId());
                shareholderRiskDTO.setCompanyName(companyService.getNameById(relatedCompanyStatisticDO.getCompanyId()));
                company2Risk.put(relatedCompanyStatisticDO.getCompanyId(), shareholderRiskDTO);
            }
            if (relatedCompanyStatisticDO.getCompanyType() == (int) CompanyDO.TYPE_P2P_1) {
                shareholderRiskDTO.setP2p(relatedCompanyStatisticDO.getAmount());
            } else if (relatedCompanyStatisticDO.getCompanyType() == (int) CompanyDO.TYPE_SMJJ_5) {
                shareholderRiskDTO.setPrivateFund(relatedCompanyStatisticDO.getAmount());
            } else if (relatedCompanyStatisticDO.getCompanyType() == (int) CompanyDO.TYPE_XXLC_4) {
                shareholderRiskDTO.setOfflineFinance(relatedCompanyStatisticDO.getAmount());
            }
        }
        return Lists.newArrayList(company2Risk.values());
    }

    @Override
    public List<RelatedCompanyDO> getRelatedCompany(Integer companyId) {
        return relatedCompanyMapper.selectByCompanyId(companyId);
    }
}
