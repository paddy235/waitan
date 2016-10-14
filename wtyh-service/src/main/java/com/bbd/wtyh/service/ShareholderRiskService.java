package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.dto.RelatedCompanyDTO;
import com.bbd.wtyh.domain.dto.ShareholderRiskDTO;
import com.google.common.collect.Multimap;

import java.util.List;

/**
 * Created by Marco on 2016/8/8.
 */
public interface ShareholderRiskService {


    List<ShareholderRiskDTO> listShareholderRisk(Integer companyType);


    Multimap<Integer, RelatedCompanyDTO> getRelatedCompany(Integer companyId);

    Multimap<Integer, RelatedCompanyDTO> getRelatedCompany(String companyName);
}
