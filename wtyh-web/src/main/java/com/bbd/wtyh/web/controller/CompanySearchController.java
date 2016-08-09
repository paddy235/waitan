package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.web.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marco on 2016/8/9.
 */
@RestController
public class CompanySearchController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("searchCompany")
    public ResponseBean searchCompany(Integer companyType, String keyword) {
        List<CompanyDO> list = companyService.searchCompany(companyType, keyword);
        return ResponseBean.successResponse(list);
    }


}
