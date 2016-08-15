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
 * 融资担保
 * <p>
 * Created by Marco on 2016/8/8.
 */
@RestController
@RequestMapping("/guarantee/")
public class GuaranteeController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyLevelService companyLevelService;
    @Autowired
    private AreaService areaService;
    @Autowired
    private GuaranteeService guaranteeService;
    @Autowired
    private ShareholderRiskService shareholderRiskService;


    /**
     * 查询公司数量
     *
     * @return
     */
    @RequestMapping("areaStatistic.do")
    public ResponseBean areaStatistic() {
        List<AreaDO> areaList = areaService.areaList();
        List<HotAreaDTO> result = Lists.newArrayList();
        for (AreaDO areaDO : areaList) {
            CompanyQuery query = new CompanyQuery();
            query.setCompanyType((int) CompanyDO.TYPE_RZDB_3);
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
        return ResponseBean.successResponse(companyLevelService.getCompanyLevel((int) CompanyDO.TYPE_RZDB_3, orderByField, descAsc));
    }

    /**
     * 担保余额统计
     *
     * @return
     */
    @RequestMapping("balance.do")
    public ResponseBean balance() {
        CompanyQuery query = new CompanyQuery();
        query.setCompanyType((int) CompanyDO.TYPE_RZDB_3);
        int amount = companyService.countCompanyNum(query);
        List<GuaranteeBalanceDO> guaranteeBalanceList = guaranteeService.getGuaranteeBalance();
        List<GuaranteeBalanceDTO> result = Lists.newArrayList();
        for (GuaranteeBalanceDO balanceDO : guaranteeBalanceList) {
            GuaranteeBalanceDTO guaranteeBalanceDTO = new GuaranteeBalanceDTO();
            guaranteeBalanceDTO.setYear(balanceDO.getYear());
            guaranteeBalanceDTO.setAmount(balanceDO.getGuaranteeBalance());
            guaranteeBalanceDTO.setSteelBalance(balanceDO.getSteelBalance());
            guaranteeBalanceDTO.setCompositeBalance(balanceDO.getCompositeBalance());
            guaranteeBalanceDTO.setPolicyBalance(balanceDO.getPolicyBalance());
            guaranteeBalanceDTO.setNumber(balanceDO.getNumber());
            guaranteeBalanceDTO.setCompanyAmount(amount);
            result.add(guaranteeBalanceDTO);
        }
        return ResponseBean.successResponse(result);
    }


    /**
     * 股东关联风险列表
     *
     * @return
     */
    @RequestMapping("shareholderRisk.do")
    public ResponseBean shareholderRisk() {
        List<ShareholderRiskDTO> list = shareholderRiskService.listShareholderRisk((int) CompanyDO.TYPE_RZDB_3);
        return ResponseBean.successResponse(list);
    }


    /**
     * 股东关联企业详情列表
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
     * 大额(超过2000万)担保信息列表
     *
     * @param pagination
     * @param orderByField
     * @param descAsc
     * @return
     */
    @RequestMapping("largeGuaranteeList.do")
    public ResponseBean largeGuaranteeList(Pagination pagination, Integer orderByField, String descAsc) {
        List<GuaranteedInfoDO> list = guaranteeService.listLargeGuarantee(pagination, orderByField, descAsc);
        int count = guaranteeService.countLargeGuarantee();
        pagination.setCount(count);
        List<LargeGuaranteeDTO> result = Lists.newArrayList();

        for (GuaranteedInfoDO infoDO : list) {
            LargeGuaranteeDTO dto = new LargeGuaranteeDTO();
            dto.setGuaranteeId(infoDO.getGuaranteeId());
            dto.setGuaranteedId(infoDO.getGuaranteedId());
            dto.setGuaranteeName(companyService.getNameById(infoDO.getGuaranteeId()));
            CompanyDO guaranteedCompany = companyService.getCompanyById(infoDO.getGuaranteedId());

            dto.setGuaranteedName(guaranteedCompany.getName());
            dto.setGuaranteedBusinessType(guaranteedCompany.getBusinessType());
            if (guaranteedCompany.getRegisteredCapital() != null && guaranteedCompany.getRegisteredCapitalType() != null) {
                dto.setGuaranteedRegisteredCapital(guaranteedCompany.getRegisteredCapital() + guaranteedCompany.getRegisteredCapitalType() == 1 ? "万元" : "万美元");
            } else {
                dto.setGuaranteedRegisteredCapital("无");
            }
            result.add(dto);

        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("list", result);
        map.put("pagination", pagination);
        return ResponseBean.successResponse(map);

    }


}
