package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.RelatedCompanyDO;
import com.bbd.wtyh.domain.dto.ShareholderRiskDTO;

import java.util.List;

/**
 * Created by Marco on 2016/8/8.
 */
public interface ShareholderRiskService {


    List<ShareholderRiskDTO> listShareholderRisk(Integer companyType);


    List<RelatedCompanyDO> getRelatedCompany(Integer companyId);
}
