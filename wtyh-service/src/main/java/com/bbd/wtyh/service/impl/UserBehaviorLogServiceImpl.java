package com.bbd.wtyh.service.impl;

import java.util.*;

import com.bbd.wtyh.log.user.Operation;
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
	private UserInfoService uis;

	@Autowired
	private UserBehaviorLogMapper userBehaviorLogMapper;

	@Override
	public Map<String, Object> listUserBehaviorLog(int pageSize, Integer pageNumber, String userName, Integer areaCode,
												   Integer sysCode, Integer opTpCd, Integer opPgCd, Date beginTime,
												   Date endTime, Long logSN ) throws Exception {
		if (pageSize < 1) {
			throw new BusinessException("pageSize参数小于1，无意义");
		}
		HashMap<String, Object> params = new HashMap<String, Object>();
		if( StringUtils.isNotBlank(userName) ) {
			params.put("userName", userName);
		}
		if ( null !=areaCode && areaCode > 0) {
			params.put("areaCode", areaCode);
		}
		if ( null !=sysCode && sysCode > 0) {
			params.put("sysCode", sysCode);
		}
		if ( null !=opTpCd && opTpCd > 0) {
			params.put("opTpCd", opTpCd);
		}
		if (null !=opPgCd && opPgCd >= 0) {
			params.put("opPgCd", opPgCd);
		}
		if (null != beginTime) {
			params.put("beginTime", beginTime);
		}
		if (null != endTime) {
			params.put("endTime", endTime);
		}
		if (null != logSN) {
			params.put("logSN", logSN);
		}
		List<Map<String, Object>> lm = userBehaviorLogMapper.selectUserBehaviorLogList(params); // 查询符合条件的记录总条数
		Long ltn = (Long) (lm.get(0).get("recordTotal"));
		params.put("pageSize", pageSize);
		int orderNum = 0;
		if ((null != pageNumber) && (pageNumber > 0)) {
			orderNum = (pageNumber - 1) * pageSize;
			pageNumber = (pageNumber - 1) * pageSize; // pageNumber的意义已经变为了“Offset”
			params.put("pageNumber", pageNumber);
		}
		params.put("listing", 1);  //使能列表查询功能
		lm = userBehaviorLogMapper.selectUserBehaviorLogList(params);
		List<Map<String, Object>> lmac =uis.getShanghaiAreaCodeTable("0"); //读取区域代码表
		Map<Integer, String> mpac = new HashMap<Integer, String>();
		for ( Map<String, Object>itr: lmac ) { //构造一个区域代码名称字典
			mpac.put( (Integer) itr.get("areaId") , (String) itr.get("cityName"));
		}
		for (Map<String, Object> itr : lm) {
			orderNum++;
			itr.put("orderNum", orderNum);  //构建行序号
			Object obj =itr.get("area");
			if( null !=  obj ) { //将区域代码
				try {
					int tmp = Integer.parseInt( (String)obj );
					obj =mpac.get(tmp);
					if( null !=  obj ) {
						itr.put("area", (String)obj);
					} else {
						itr.put("area", "");
					}
				} catch (Exception e) {
					itr.put("area", "");
				}
			} else {
				itr.put("area", "");
			}
		}
		Map<String, Object> rstMap = new HashMap<String, Object>();
		rstMap.put("listTotalNum", ltn);
		rstMap.put("list", lm);
		return rstMap;
	}


/*	public static void main( String[] argc ) {

		List<Map<String, Object>> otl =new ArrayList<Map<String, Object>>() {{
			for (  Operation.Type opT  : Operation.Type.values() ) {
				add( new  HashMap<String, Object>() {{
					put("opCode", (Integer)opT.code());
					put("opDesc", opT.desc());
				}} );
			}
		}};

		List<Map<String, Object>> otl1 =new ArrayList<Map<String, Object>>() {{
			for (  Operation.Type opT  : Operation.Type.values() ) {
				add( new  HashMap<String, Object>() {{
					put("opCode", (Integer)opT.ordinal());
					put("opDesc", opT.name());
				}} );
			}
		}};
	}*/

}

//
/*class Assist1 {
	<T> List<Map<String, Object>> assistFun1( String k1, String k2) {
		return new ArrayList<Map<String, Object>>() {{
			add(new HashMap<String, Object>() {{
				put(k1, (Integer) (-1));
				put(k2, "全部");
			}});
			for (T opT : T) {
				add(new HashMap<String, Object>() {{
					put(k1, (Integer) opT.code());
					put(k2, opT.desc());
				}});
			}
		}};
	}
}*/
