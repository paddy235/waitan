package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.HotAreaDTO;
import com.bbd.wtyh.domain.dto.LoanBalanceDTO;
import com.bbd.wtyh.domain.dto.ShareholderRiskDTO;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 小额贷款
 *
 * Created by Marco on 2016/8/8.
 */
@RestController
@RequestMapping("/loan/")
public class LoanController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyLevelService companyLevelService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private LoanService loanService;
    @Autowired
    private ShareholderRiskService shareholderRiskService;


    /**
     * 查询公司数量
     *
     * @return
     */
    @RequestMapping("hotArea")
    public ResponseBean hotArea() {
        List<AreaDO> areaList = areaService.areaList();
        List<HotAreaDTO> result = Lists.newArrayList();
        for (AreaDO areaDO : areaList) {
            CompanyQuery query = new CompanyQuery();
            query.setCompanyType((int) CompanyDO.TYPE_XD_2);
            query.setAreaId(areaDO.getAreaId());
            query.setBackground((int) CompanyBackgroundDO.Bg.Gq.val);
            int stateOwned = companyService.countCompanyNum(query);
            query.setBackground((int) CompanyBackgroundDO.Bg.Myqy.val);
            int privateCompany = companyService.countCompanyNum(query);
            HotAreaDTO hotAreaDTO = new HotAreaDTO();
            hotAreaDTO.setAreaId(areaDO.getAreaId());
            hotAreaDTO.setAreaName(areaDO.getName());
            hotAreaDTO.setAll(stateOwned + privateCompany);
            hotAreaDTO.setPrivateCompany(privateCompany);
            hotAreaDTO.setStateOwned(stateOwned);
            result.add(hotAreaDTO);
        }
        return ResponseBean.successResponse(result);
    }

    /**
     * 公司评级，包括内部、外部、现场
     *
     * @param orderByField 1:外部评级 2:内部评级
     * @param descAsc      desc/asc
     * @return
     */
    @RequestMapping("companyLevel")
    public ResponseBean companyLevel(Integer orderByField, String descAsc) {
        return ResponseBean.successResponse(companyLevelService.getCompanyLevel((int) CompanyDO.TYPE_XD_2, orderByField, descAsc));
    }


    @RequestMapping("balance")
    public ResponseBean balance() {
        CompanyQuery query = new CompanyQuery();
        query.setCompanyType((int) CompanyDO.TYPE_XD_2);
        int amount = companyService.countCompanyNum(query);
        List<LoanBalanceDO> loanBalanceList = loanService.getLoanBalance();
        List<LoanBalanceDTO> result = Lists.newArrayList();
        for (LoanBalanceDO balanceDO : loanBalanceList) {
            LoanBalanceDTO loanBalanceDTO = new LoanBalanceDTO();
            loanBalanceDTO.setYear(balanceDO.getYear());
            loanBalanceDTO.setAmount(balanceDO.getAmount());
            loanBalanceDTO.setAgricultureBalance(balanceDO.getAgricultureBalance());
            loanBalanceDTO.setSmallCompanyBalance(balanceDO.getSmallCompanyBalance());
            loanBalanceDTO.setNumber(balanceDO.getNumber());
            loanBalanceDTO.setCompanyAmount(amount);
            result.add(loanBalanceDTO);
        }
        return ResponseBean.successResponse(result);
    }


    @RequestMapping("shareholderRisk")
    public ResponseBean shareholderRisk() {
        List<ShareholderRiskDTO> list = shareholderRiskService.listShareholderRisk((int) CompanyDO.TYPE_XD_2);
        return ResponseBean.successResponse(list);
    }


    @RequestMapping("shareholderRiskDetail")
    public ResponseBean shareholderRiskDetail(Integer companyId) {
        if (null == companyId || companyId <= 0) {
            return ResponseBean.errorResponse("companyId must be not null");
        }
        List<RelatedCompanyDO> relatedCompanyList = shareholderRiskService.getRelatedCompany(companyId);
        Multimap<Integer, String> result = ArrayListMultimap.create();
        for (RelatedCompanyDO relatedCompanyDO : relatedCompanyList) {
            CompanyDO companyDO = companyService.getCompanyById(relatedCompanyDO.getRelatedCompanyId());
            result.put((int) companyDO.getCompanyType(), companyDO.getName());
        }
        return ResponseBean.successResponse(result.asMap());
    }


    @RequestMapping("largeLoanList")
    public ResponseBean largeLoanList(Pagination pagination, Integer orderByField, String descAsc) {
        return ResponseBean.successResponse(loanService.listLargeLoan(pagination, orderByField, descAsc));
    }


}
