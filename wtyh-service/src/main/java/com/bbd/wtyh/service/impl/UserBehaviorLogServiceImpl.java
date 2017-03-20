package com.bbd.wtyh.service.impl;

import java.util.*;

import com.bbd.wtyh.mapper.UserBehaviorLogMapper;
import com.bbd.wtyh.service.UserBehaviorLogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.exception.BusinessException;
import com.bbd.wtyh.service.UserInfoService;

/**
 * Created by cgj on 2017/3/20.
 */
@Service
public class UserBehaviorLogServiceImpl extends BaseServiceImpl implements UserBehaviorLogService {

	@Autowired
	private UserBehaviorLogMapper userBehaviorLogMapper;

	@Override
	public Map<String, Object> listUserInfo(int areaCode, String selectType, String selectObject, int pageLimit, Integer pageNumber)
			throws Exception {
		if (StringUtils.isBlank(selectType)) {
			throw new BusinessException("selectType参数为空");
		}
		if (pageLimit < 1) {
			throw new BusinessException("pageLimit参数小于1，无意义");
		}
		if (!selectType.equals("default") && !selectType.equals("loginName") && !selectType.equals("realName")
				&& !selectType.equals("department") && !selectType.equals("userType")) {
			throw new BusinessException("selectType参数不合法");
		}
		if (!selectType.equals("default") && StringUtils.isBlank(selectObject)) {
			// throw new BusinessException("selectObject参数不合法");
			selectType = "default";
		}
		if (selectType.equals("userType")) {
			if (selectObject.equals("后台系统管理员")) {
				selectObject = "'A','B'";
			} else if (selectObject.equals("普通用户")) {
				selectObject = "'F'";
			} else if (selectObject.equals("预分配用户")) {
				selectObject = "'U'";
			} else {
				throw new BusinessException("userType对应的selectObject参数不合法");
			}
		}
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put(selectType, selectObject);
		params.put("pageLimit", pageLimit);
		if (areaCode > 0) {
			params.put("areaCode", areaCode);
		}
		List<Map<String, Object>> lm = userBehaviorLogMapper.selectUserBehaviorLogList(params); // 查询符合条件的记录总条数
		Long ltn = (Long) (lm.get(0).get("recordTotal"));
		int orderNum = 0;
		if ((null != pageNumber) && (pageNumber > 0)) {
			orderNum = (pageNumber - 1) * pageLimit;
			pageNumber = (pageNumber - 1) * pageLimit; // pageNumber的意义已经变为了“Offset”
			params.put("pageNumber", pageNumber);
		}
		params.put("listing", 1);
		lm = userBehaviorLogMapper.selectUserBehaviorLogList(params);
		UserInfoTableDo uitd = new UserInfoTableDo();
		for (Map<String, Object> itr : lm) {
			orderNum++;
			itr.put("orderNum", orderNum);
			Object tmpObj = itr.get("userType");
			switch ((String) tmpObj) {
			case "A": // itr.put("userType", "后台系统管理员"); break;
			case "B":
				itr.put("userType", "后台系统管理员");
				break;
			case "F":
				itr.put("userType", "普通用户");
				break;
			default:
				itr.put("userType", "预分配用户");
			}
			tmpObj = itr.get("realName");
			if (null != tmpObj) {
				uitd.setRealName((String) tmpObj);
			}
			tmpObj = itr.get("fixPhone");
			if (null != tmpObj) {
				uitd.setFixPhone((String) tmpObj);
			}
			tmpObj = itr.get("mobile");
			if (null != tmpObj) {
				uitd.setMobile((String) tmpObj);
			}
			itr.put("realName", uitd.getRealName());
			itr.put("fixPhone", uitd.getFixPhone());
			itr.put("mobile", uitd.getMobile());
		}

		Map<String, Object> rstMap = new HashMap<String, Object>();
		rstMap.put("listTotalNum", ltn);
		rstMap.put("list", lm);
		return rstMap;
	}

	@Override
	public Map<String, Object> get(String type) throws Exception {
		Map<String, Object> rstMap =null;
		List<Map<String, Object>> lm = userBehaviorLogMapper.selectUserBehaviorLogList(null);
		if (null != lm) {
			for (Map<String, Object> iter : lm) {
				if (null != iter.get("areaId") && 104 == (Integer) iter.get("areaId")) {
					iter.put("cityName", "上海全区");
					break;
				}
			}

		}
		if (StringUtils.isNotBlank(type) && type.equals("0")) {
			Map<String, Object> allArea = new HashMap<String, Object>();
			allArea.put("areaId", (Integer) 0);
			allArea.put("cityName", "全部");
			lm.add(0, allArea);
		}
		return rstMap;
	}
}
