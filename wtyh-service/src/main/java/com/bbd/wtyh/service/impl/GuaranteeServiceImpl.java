package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.GuaranteeBalanceDO;
import com.bbd.wtyh.domain.GuaranteedInfoDO;
import com.bbd.wtyh.domain.dto.GuaranteeBalanceByQuaterDTO;
import com.bbd.wtyh.mapper.GuaranteeBalanceMapper;
import com.bbd.wtyh.mapper.GuaranteedInfoMapper;
import com.bbd.wtyh.service.GuaranteeService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/8/8.
 */
@Service
public class GuaranteeServiceImpl extends BaseServiceImpl implements GuaranteeService {

	@Autowired
	private GuaranteeBalanceMapper guaranteeBalanceMapper;
	@Autowired
	private GuaranteedInfoMapper guaranteedInfoMapper;

	@Override
	public List<GuaranteeBalanceDO> getGuaranteeBalanceByMonth() {
		int totalItems = 6;
		return guaranteeBalanceMapper.listByMonth(totalItems);
	}

	@Override
	public List<GuaranteeBalanceByQuaterDTO> getGuaranteeBalanceByQuarter() {
		// 取最近20个月的数据，比七个季度少一个月的目的是判断的时候方便，直接舍弃不满三个月的那个季度
		int totalItems = 7 * 3 - 1;
		List<GuaranteeBalanceDO> balanceDOList = guaranteeBalanceMapper.listByMonth(totalItems);
		Map<String, GuaranteeBalanceByQuaterDTO> map = Maps.newHashMap();
		Map<String, Integer> monthCount = Maps.newHashMap();
		for (GuaranteeBalanceDO balanceDO : balanceDOList) {
			String key = "" + balanceDO.getYear() + ((balanceDO.getMonth() + 2) / 3);
			if (map.containsKey(key)) {
				GuaranteeBalanceByQuaterDTO quaterDTO = map.get(key);
				quaterDTO.setCompositeBalance(quaterDTO.getCompositeBalance() + balanceDO.getCompositeBalance());
				quaterDTO.setAmount(quaterDTO.getAmount() + balanceDO.getGuaranteeBalance());
				quaterDTO.setNumber(quaterDTO.getNumber() + balanceDO.getNumber());
				quaterDTO.setPolicyBalance(quaterDTO.getPolicyBalance() + balanceDO.getPolicyBalance());
				quaterDTO.setSteelBalance(quaterDTO.getSteelBalance() + balanceDO.getSteelBalance());
				monthCount.put(key, monthCount.get(key) + 1);
			} else {
				GuaranteeBalanceByQuaterDTO dto = new GuaranteeBalanceByQuaterDTO();
				dto.setYear(balanceDO.getYear());
				dto.setQuarter((balanceDO.getMonth() + 2) / 3);
				dto.setPolicyBalance(balanceDO.getPolicyBalance());
				dto.setCompositeBalance(balanceDO.getCompositeBalance());
				dto.setSteelBalance(balanceDO.getSteelBalance());
				dto.setAmount(balanceDO.getGuaranteeBalance());
				dto.setNumber(balanceDO.getNumber());
				dto.setCompanyAmount(balanceDO.getCompanyAmount());
				map.put(key, dto);
				monthCount.put(key, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : monthCount.entrySet()) {
			if (entry.getValue() < 3) {
				map.remove(entry.getKey());
			}
		}
		return Ordering.from(new Comparator<GuaranteeBalanceByQuaterDTO>() {

			@Override
			public int compare(GuaranteeBalanceByQuaterDTO o1, GuaranteeBalanceByQuaterDTO o2) {
				return Integer.valueOf("" + o2.getYear() + o2.getQuarter()) - Integer.valueOf("" + o1.getYear() + o1.getQuarter());
			}
		}).sortedCopy(map.values());
	}

	@Override
	public List<GuaranteeBalanceDO> getGuaranteeBalanceByYear() {
		return guaranteeBalanceMapper.listByYear();
	}

	@Override
	public List<GuaranteedInfoDO> listLargeGuarantee(Pagination pagination, Integer orderByField, String descAsc) {
		if (null != orderByField && orderByField >= 5) {
			orderByField = null;
		}
		List<GuaranteedInfoDO> largeGuaranteeDTOs = guaranteedInfoMapper.listLargeGuarantee(pagination, orderByField, descAsc);
		return largeGuaranteeDTOs;
	}

	@Override
	public int countLargeGuarantee() {
		return guaranteedInfoMapper.countLargeGuarantee();
	}

	@Override
	public GuaranteedInfoDO selectByPrimaryKey(Integer id) {

		return guaranteedInfoMapper.selectByPrimaryKey(id);
	}
}
