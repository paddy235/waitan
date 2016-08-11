package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.service.CompanySearchAPIService;
import com.bbd.wtyh.service.CompanyService;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marco on 2016/8/9.
 */
@RestController
public class CompanySearchController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanySearchAPIService comSearApiSer;

    @RequestMapping("searchCompany")
    @ResponseBody
    public ResponseBean searchCompany(Integer companyType, String keyword, Integer size) {
        if (null == size || size <= 0) {
            size = 5;
        }
        List<CompanyDO> list = companyService.searchCompany(companyType, keyword, size);
        List<String> companyNames = Lists.transform(list, new Function<CompanyDO, String>() {
            @Override
            public String apply(CompanyDO companyDO) {
                return companyDO.getName();
            }
        });
        return ResponseBean.successResponse(companyNames);
    }


    /**
     * 从数据平台查询企业名称
     *
     * @param
     * @return ResponseBean
     * @throws Exception
     */
    @RequestMapping("/searchCompanyByDataPlat")
    @ResponseBody
    public ResponseBean searchCompanyByDataPlat(String keyword) throws Exception {
        String data = comSearApiSer.searchCompanyByKeyword(keyword);
        return ResponseBean.successResponse(data);
    }


}
