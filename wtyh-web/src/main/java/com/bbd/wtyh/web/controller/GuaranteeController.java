package com.bbd.wtyh.web.controller;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.*;
import com.bbd.wtyh.domain.dto.*;
import com.bbd.wtyh.domain.query.CompanyQuery;
import com.bbd.wtyh.log.user.Operation;
import com.bbd.wtyh.log.user.annotation.LogRecord;
import com.bbd.wtyh.service.*;
import com.bbd.wtyh.web.ResponseBean;
import com.google.common.collect.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 融资担保
 * <p/>
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
	@Autowired
	private SysConfigService sysConfigService;
	private AreaDO shanghaiCity;

	/**
	 * 查询公司数量
	 *
	 * @return
	 */
	@RequestMapping("areaStatistic.do")
	@LogRecord(logMsg = "浏览融资担保页面", page = Operation.Page.guarantee)
	public ResponseBean areaStatistic() {
		List<AreaDO> areaList = areaService.selectByParentId(shanghaiCity.getAreaId());
		List<HotAreaDTO> result = Lists.newArrayList();
		for (AreaDO areaDO : areaList) {
			CompanyQuery query = new CompanyQuery();
			query.setCompanyType((int) CompanyDO.TYPE_RZDB_3);
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
		if(result.size()>0){
//			String guaranteePrivateCompany = sysConfigService.findByKey("guaranteePrivateCompany");
//			String guaranteeStateOwned = sysConfigService.findByKey("guaranteeStateOwned");
//			String guaranteeForeignCapital = sysConfigService.findByKey("guaranteeForeignCapital");
			Integer guaranteePrivateCompany = companyLevelService.countCompanyBackground("民企","3");
			Integer guaranteeStateOwned = companyLevelService.countCompanyBackground("国企","3");
			Integer guaranteeForeignCapital = companyLevelService.countCompanyBackground("外企","3");
			HotAreaDTO hotAreaDTO = result.get(0);
			hotAreaDTO.setForeignCapital(guaranteeForeignCapital);
			hotAreaDTO.setPrivateCompany(guaranteePrivateCompany);
			hotAreaDTO.setStateOwned(guaranteeStateOwned);
		}
		return ResponseBean.successResponse(result);
	}

	/**
	 * 公司评级，包括内部、外部、现场
	 *
	 * @param orderByField
	 *            1:外部评级 2:内部评级
	 * @param descAsc
	 *            desc/asc
	 * @return
	 */
	@RequestMapping("companyLevel.do")
	public ResponseBean companyLevel(Integer areaId, Integer orderByField, String descAsc) {
		return ResponseBean
				.successResponse(companyLevelService.getCompanyLevel((int) CompanyDO.TYPE_RZDB_3, areaId, orderByField, descAsc));
	}

	/**
	 * 担保余额统计
	 *
	 * @return
	 */
	@RequestMapping("balance.do")
	public ResponseBean balance() {
		List<GuaranteeBalanceDO> guaranteeBalanceList = guaranteeService.getGuaranteeBalanceByYear();
		List<GuaranteeBalanceDTO> result = Lists.newArrayList();
		for (GuaranteeBalanceDO balanceDO : guaranteeBalanceList) {
			result.add(getGuaranteeBalanceDTO(balanceDO));
		}
		return ResponseBean.successResponse(result);
	}

	/**
	 * 担保余额统计
	 *
	 * @return
	 */
	@RequestMapping("balanceByMonth.do")
	public ResponseBean balanceByMonth() {
		List<GuaranteeBalanceDO> guaranteeBalanceList = guaranteeService.getGuaranteeBalanceByMonth();
		List<GuaranteeBalanceDTO> result = Lists.newArrayList();
		for (GuaranteeBalanceDO balanceDO : guaranteeBalanceList) {
			result.add(getGuaranteeBalanceDTO(balanceDO));
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
		List<GuaranteeBalanceByQuaterDTO> guaranteeBalanceList = guaranteeService.getGuaranteeBalanceByQuarter();
		return ResponseBean.successResponse(guaranteeBalanceList);
	}

	private GuaranteeBalanceDTO getGuaranteeBalanceDTO(GuaranteeBalanceDO balanceDO) {
		GuaranteeBalanceDTO guaranteeBalanceDTO = new GuaranteeBalanceDTO();
		guaranteeBalanceDTO.setYear(balanceDO.getYear());
		guaranteeBalanceDTO.setMonth(balanceDO.getMonth());
		guaranteeBalanceDTO.setAmount(balanceDO.getGuaranteeBalance());
		guaranteeBalanceDTO.setSteelBalance(balanceDO.getSteelBalance());
		guaranteeBalanceDTO.setCompositeBalance(balanceDO.getCompositeBalance());
		guaranteeBalanceDTO.setPolicyBalance(balanceDO.getPolicyBalance());
		guaranteeBalanceDTO.setNumber(balanceDO.getNumber());
		guaranteeBalanceDTO.setCompanyAmount(balanceDO.getCompanyAmount());
		return guaranteeBalanceDTO;
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
				dto.setGuaranteedRegisteredCapital(
						guaranteedCompany.getRegisteredCapital() + (guaranteedCompany.getRegisteredCapitalType() == 1 ? "万元" : "万美元"));
			} else {
				dto.setGuaranteedRegisteredCapital("无");
			}
			dto.setRelatedOfflineFinance(shareholderRiskService.getRelatedCompany(infoDO.getGuaranteedId()).values().size());
			result.add(dto);
		}

		// 根据关联风险数排序
		if (null != orderByField && orderByField.equals(5)) {
			result = Ordering.from(new Comparator<LargeGuaranteeDTO>() {

				@Override
				public int compare(LargeGuaranteeDTO o1, LargeGuaranteeDTO o2) {
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
