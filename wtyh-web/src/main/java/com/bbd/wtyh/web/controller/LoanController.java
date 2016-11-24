package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 小额贷款
 * <p/>
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
    private AreaDO shanghaiCity;


    /**
     * 分区域统计数据
     *
     * @return
     */
    @RequestMapping("areaStatistic.do")
    public ResponseBean areaStatistic() {

        List<AreaDO> areaList = areaService.selectByParentId(shanghaiCity.getAreaId());
        List<HotAreaDTO> result = Lists.newArrayList();
        for (AreaDO areaDO : areaList) {
            CompanyQuery query = new CompanyQuery();
            query.setCompanyType((int) CompanyDO.TYPE_XD_2);
            query.setAreaId(areaDO.getAreaId());
            query.setBackground((int) CompanyBackgroundDO.Bg.Gq.val);
            int stateOwned = companyService.countCompanyNum(query);
            query.setBackground((int) CompanyBackgroundDO.Bg.Myqy.val);
            int privateCompany = companyService.countCompanyNum(query);
            query.setBackground((int) CompanyBackgroundDO.Bg.Wzqy.val);
            int foreignCapital = companyService.countCompanyNum(query);
            HotAreaDTO hotAreaDTO = new HotAreaDTO();
            hotAreaDTO.setAreaId(areaDO.getAreaId());
            hotAreaDTO.setAreaName(areaDO.getName());
            hotAreaDTO.setAll(stateOwned + privateCompany);
            hotAreaDTO.setPrivateCompany(privateCompany);
            hotAreaDTO.setStateOwned(stateOwned);
            hotAreaDTO.setForeignCapital(foreignCapital);
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
    public ResponseBean companyLevel(Integer areaId, Integer orderByField, String descAsc) {
        return ResponseBean.successResponse(companyLevelService.getCompanyLevel((int) CompanyDO.TYPE_XD_2, areaId, orderByField, descAsc));
    }

    /**
     * 贷款余额统计信息
     *
     * @return
     */
    @RequestMapping("balance.do")
    public ResponseBean balance() {
        List<LoanBalanceDO> loanBalanceList = loanService.getLoanBalanceByYear();
        List<LoanBalanceDTO> result = Lists.newArrayList();
        for (LoanBalanceDO balanceDO : loanBalanceList) {
            result.add(getLoanBalanceDTO(balanceDO));
        }
        return ResponseBean.successResponse(result);
    }

    private LoanBalanceDTO getLoanBalanceDTO(LoanBalanceDO balanceDO) {
        LoanBalanceDTO loanBalanceDTO = new LoanBalanceDTO();
        loanBalanceDTO.setMonth(balanceDO.getMonth());
        loanBalanceDTO.setYear(balanceDO.getYear());
        loanBalanceDTO.setAmount(balanceDO.getAmount());
        loanBalanceDTO.setAgricultureBalance(balanceDO.getAgricultureBalance());
        loanBalanceDTO.setSmallCompanyBalance(balanceDO.getSmallCompanyBalance());
        loanBalanceDTO.setNumber(balanceDO.getNumber());
        loanBalanceDTO.setCompanyAmount(balanceDO.getCompanyAmount());
        return loanBalanceDTO;
    }


    /**
     * 贷款余额统计信息
     *
     * @return
     */
    @RequestMapping("balanceByMonth.do")
    public ResponseBean balanceByMonth() {
        List<LoanBalanceDO> loanBalanceList = loanService.getLoanBalanceByMonth();
        List<LoanBalanceDTO> result = Lists.newArrayList();
        for (LoanBalanceDO balanceDO : loanBalanceList) {
            result.add(getLoanBalanceDTO(balanceDO));
        }
        return ResponseBean.successResponse(Lists.reverse(result));
    }


    /**
     * 担保余额统计,按照季度统计
     *
     * @return
     */
    @RequestMapping("balanceByQuarter.do")
    public ResponseBean balanceByQuarter() {
        List<LoanBalanceByQuarterDTO> dtoList = loanService.getLoanBalanceByQuater();
        return ResponseBean.successResponse(dtoList);
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
                dto.setBorrowerRegisteredCapital(borrowerCompany.getRegisteredCapital() + (borrowerCompany.getRegisteredCapitalType() == 1 ? "万元" : "万美元"));
            } else {
                dto.setBorrowerRegisteredCapital("无");
            }
            dto.setRelatedOfflineFinance(shareholderRiskService.getRelatedCompany(largeLoanDO.getBorrowerId()).values().size());
            result.add(dto);
        }
        //根据关联风险数排序
        if (null != orderByField && orderByField.equals(5)) {
            result = Ordering.from(new Comparator<LargeLoanDTO>() {
                @Override
                public int compare(LargeLoanDTO o1, LargeLoanDTO o2) {
                    return o1.getRelatedOfflineFinance() - o2.getRelatedOfflineFinance();
                }
            }).sortedCopy(result);
            if (StringUtils.isNotEmpty(descAsc) && descAsc.equals("desc")) {
                result = Lists.reverse(result);
            }
        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("list", result);
        map.put("pagination", pagination);
        return ResponseBean.successResponse(map);
    }

    @PostConstruct
    public void init() {
        shanghaiCity = areaService.selectByNameAndLevel("上海市", AreaDO.LEVEL_CITY);
    }


}
