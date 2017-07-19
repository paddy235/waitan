package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.dto.CompanyLevelDTO;

import java.util.List;

/**
 * Created by Marco on 2016/8/8.
 */
public interface CompanyLevelService {


    List<CompanyLevelDTO> getCompanyLevel(Integer companyType, Integer areaId, Integer orderByField, String descAsc);


    CompanyInfo getLoanOrGuaranteeByCompanyName(String name);
}
