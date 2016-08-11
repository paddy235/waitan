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

    /**
     * 根据公司名称搜索
     * @param companyType 见CompanyDO里面的常量
     * @param keyword 关键字
     * @return 公司列表
     */
    @RequestMapping("searchCompany")
    public ResponseBean searchCompany(Integer companyType, String keyword) {
        List<CompanyDO> list = companyService.searchCompany(companyType, keyword);
        return ResponseBean.successResponse(list);
    }


}
