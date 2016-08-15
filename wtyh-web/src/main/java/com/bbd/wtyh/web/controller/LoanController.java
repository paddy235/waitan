package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 小额贷款
 * <p>
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
     * 分区域统计数据
     *
     * @return
     */
    @RequestMapping("areaStatistic.do")
    public ResponseBean areaStatistic() {
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
    @RequestMapping("companyLevel.do")
    public ResponseBean companyLevel(Integer orderByField, String descAsc) {
        return ResponseBean.successResponse(companyLevelService.getCompanyLevel((int) CompanyDO.TYPE_XD_2, orderByField, descAsc));
    }

    /**
     * 贷款余额统计信息
     *
     * @return
     */
    @RequestMapping("balance.do")
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


    /**
     * 股东行业风险列表
     *
     * @return
     */
    @RequestMapping("shareholderRisk.do")
    public ResponseBean shareholderRisk() {
        List<ShareholderRiskDTO> list = shareholderRiskService.listShareholderRisk((int) CompanyDO.TYPE_XD_2);
        return ResponseBean.successResponse(list);
    }


    /**
     * 股东行业风险详情列表
     *
     * @param companyId
     * @return
     */
    @RequestMapping("shareholderRiskDetail.do")
    public ResponseBean shareholderRiskDetail(Integer companyId) {
        if (null == companyId || companyId <= 0) {
            return ResponseBean.errorResponse("companyId must be not null");
        }
        return ResponseBean.successResponse(shareholderRiskService.getRelatedCompany(companyId).asMap());
    }


    /**
     * 大额贷款信息列表
     *
     * @param pagination
     * @param orderByField
     * @param descAsc
     * @return
     */
    @RequestMapping("largeLoanList.do")
    public ResponseBean largeLoanList(Pagination pagination, Integer orderByField, String descAsc) {
        List<LargeLoanDO> list = loanService.listLargeLoan(pagination, orderByField, descAsc);
        int count = loanService.countLargeLoan();
        pagination.setCount(count);
        List<LargeLoanDTO> result = Lists.newArrayList();

        for (LargeLoanDO largeLoanDO : list) {
            LargeLoanDTO dto = new LargeLoanDTO();
            dto.setLenderId(largeLoanDO.getLenderId());
            dto.setBorrowerId(largeLoanDO.getBorrowerId());
            dto.setLenderName(companyService.getNameById(largeLoanDO.getLenderId()));
            CompanyDO borrowerCompany = companyService.getCompanyById(largeLoanDO.getBorrowerId());

            dto.setBorrowerName(borrowerCompany.getName());
            dto.setBorrowerBusinessType(borrowerCompany.getBusinessType());
            if (borrowerCompany.getRegisteredCapital() != null && borrowerCompany.getRegisteredCapitalType() != null) {
                dto.setBorrowerRegisteredCapital(borrowerCompany.getRegisteredCapital() + borrowerCompany.getRegisteredCapitalType() == 1 ? "万元" : "万美元");
            } else {
                dto.setBorrowerRegisteredCapital("无");
            }
            result.add(dto);

        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("list", result);
        map.put("pagination", pagination);
        return ResponseBean.successResponse(map);
    }


}
