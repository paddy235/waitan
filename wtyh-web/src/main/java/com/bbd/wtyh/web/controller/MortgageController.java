package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.dto.MortgageCompanyDTO;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.service.MortgageService;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marco on 2016/8/10.
 */
@RestController
@RequestMapping("/mortgage/")
public class MortgageController {

    @Autowired
    private MortgageService mortgageService;
    @Autowired
    private CompanyService companyService;


    /**
     * 典当统计，按年统计
     *
     * @return
     */
    @RequestMapping("statisticList.do")
    public ResponseBean statisticList() {
        return ResponseBean.successResponse(mortgageService.getMortgageStatisticList());
    }


    @RequestMapping("companyList.do")
    public ResponseBean companyList() {
        CompanyQuery query = new CompanyQuery();
        query.setCompanyType((int) CompanyDO.TYPE_DD_12);
        List<CompanyDO> companyDOList = companyService.queryCompany(query);
        List<MortgageCompanyDTO> result = Lists.newArrayList();

        for (CompanyDO companyDO : companyDOList) {
            MortgageCompanyDTO dto = new MortgageCompanyDTO();
            dto.setCompanyId(companyDO.getCompanyId());
            dto.setCompanyName(companyDO.getName());
            dto.setLegalPerson(companyDO.getLegalPerson());
            dto.setRegisteredCapital(companyDO.getRegisteredCapital());
            dto.setRegisteredCapitalType(companyDO.getRegisteredCapitalType());
            dto.setAddress(companyDO.getAddress());
            dto.setRegisteredTime(companyDO.getRegisteredDate());
            result.add(dto);
        }
        return ResponseBean.successResponse(result);
    }


}
