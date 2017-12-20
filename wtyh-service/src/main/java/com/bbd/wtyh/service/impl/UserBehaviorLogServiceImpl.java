package com.bbd.wtyh.service.impl;

import java.util.*;

import com.bbd.wtyh.cachetobean.ShanghaiAreaCode;
import com.bbd.wtyh.domain.vo.UseDetailVO;
import com.bbd.wtyh.domain.vo.UseHotPage;
import com.bbd.wtyh.domain.vo.UserSearchVO;
import com.bbd.wtyh.excel.ExportExcelExample;
import com.bbd.wtyh.mapper.UserBehaviorLogMapper;
import com.bbd.wtyh.service.UserBehaviorLogService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.exception.BusinessException;

/**
 * Created by cgj on 2017/3/20.
 */
@Service
public class UserBehaviorLogServiceImpl extends BaseServiceImpl implements UserBehaviorLogService {

	@Autowired
	private UserBehaviorLogMapper userBehaviorLogMapper;

	@Value("${exportExcel.userOperator}")
	private String userOperator;

	@Value("${exportExcel.searchString}")
	private String searchString;

	@Override
	public Map<String, Object> listUserBehaviorLog(int pageSize, Integer pageNumber, String excludeName, String userName, Integer areaCode,
			Integer sysCode, Integer opTpCd, Integer opPgCd, Date beginTime, Date endTime, String logContent, String orderBy)
			throws Exception {
		if (pageSize < 1) {
			throw new BusinessException("pageSize参数小于1，无意义");
		}
		Map<String, Object> params = new HashMap<>();
		if (StringUtils.isNotBlank(excludeName)) {
			params.put("excludeName", excludeName);
		}
		if (StringUtils.isNotBlank(userName)) {
			params.put("userName", userName);
		}
		if (null != areaCode && areaCode > 0) {
			params.put("areaCode", areaCode);
		}
		if (null != sysCode && sysCode > 0) {
			params.put("sysCode", sysCode);
		}
		if (null != opTpCd && opTpCd > 0) {
			params.put("opTpCd", opTpCd);
		}
		if (null != opPgCd && opPgCd > 0) {
			params.put("opPgCd", opPgCd);
		}
		if (null != beginTime) {
			params.put("beginTime", beginTime);
		}
		if (null != endTime) {
			if (null != beginTime && endTime.before(beginTime)) {
				throw new BusinessException("截止时刻不能早于起始时刻");
			}
			params.put("endTime", endTime);
		}
		if (StringUtils.isNotEmpty(logContent)) {
			params.put("logContent", logContent);
		}
		if (StringUtils.isNotBlank(orderBy) && orderBy.equals("DESC")) {
			params.put("orderBy", "DESC");
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
		params.put("listing", 1); // 使能列表查询功能
		lm = userBehaviorLogMapper.selectUserBehaviorLogList(params);
		for (Map<String, Object> itr : lm) {
			orderNum++;
			itr.put("orderNum", orderNum); // 构建行序号
			Object obj = itr.get("area");
			if (null != obj) { // 将区域代码转换成行政区名称
				try {
					int tmp = Integer.parseInt((String) obj);
					obj = ShanghaiAreaCode.getMap().get(tmp);
					if (null != obj) {
						itr.put("area", obj);
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
		Map<String, Object> rstMap = new HashMap<>();
		rstMap.put("listTotalNum", ltn);
		rstMap.put("list", lm);
		return rstMap;
	}

	@Override
	public List<Map<String, Object>> listUserOperaLog(Date beginTime, Date endTime,Integer sysCode,String excludeName) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		params.put("sysCode", sysCode);
		params.put("excludeName", excludeName);
		List<Map<String, Object>> lm = userBehaviorLogMapper.selectlistUserOperaLog(params);
		return lm;
	}

	@Override
	public HSSFWorkbook produceExcel(HSSFWorkbook workbook, HSSFSheet sheet, List<UseDetailVO> opeList,String headTitle,Integer [] res){
		HSSFWorkbook hssfWorkbook = null;
		hssfWorkbook = ExportExcelExample.exportExcel(workbook,sheet, userOperator, opeList, "yyyyMMdd",headTitle,true,res);
		return hssfWorkbook;
	}

	@Override
	public HSSFWorkbook produceExcel3(HSSFWorkbook workbook, HSSFSheet sheet, List<UserSearchVO> opeList, String headTitle) {
		HSSFWorkbook hssfWorkbook = null;
		hssfWorkbook = ExportExcelExample.exportExcel(workbook,sheet, searchString, opeList, "yyyyMMdd",headTitle,false,null);
		return hssfWorkbook;
	}

	@Override
	public List<UserSearchVO> findKeyWord(Date beginTime, Date endTime,Integer sysCode,String excludeName) {
		Map<String, Object> params = new HashMap<>();
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		params.put("sysCode", sysCode);
		params.put("excludeName", excludeName);
		List<UserSearchVO> list = userBehaviorLogMapper.findSearchList(params);
		return list;
	}

	@Override
	public List<UseHotPage> findHotPage(Date beginTime, Date endTime, Integer sysCode,String excludeName) {
		List<UseHotPage> lm = new ArrayList<>();
		lm.clear();
		Map<String, Object> params = new HashMap<>();
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		params.put("sysCode", sysCode);
		params.put("excludeName", excludeName);
		userBehaviorLogMapper.findHotPageList(params);
		lm = userBehaviorLogMapper.findHotPageList(params);
		return lm;
	}
	/*
	 * public static void main( String[] argc ) {
	 * 
	 * List<Map<String, Object>> otl =new ArrayList<Map<String, Object>>() {{
	 * for ( Operation.Type opT : Operation.Type.values() ) { add( new
	 * HashMap<String, Object>() {{ put("opCode", (Integer)opT.code());
	 * put("opDesc", opT.desc()); }} ); } }};
	 * 
	 * List<Map<String, Object>> otl1 =new ArrayList<Map<String, Object>>() {{
	 * for ( Operation.Type opT : Operation.Type.values() ) { add( new
	 * HashMap<String, Object>() {{ put("opCode", (Integer)opT.ordinal());
	 * put("opDesc", opT.name()); }} ); } }}; }
	 */



}

//
/*
 * class Assist1 { <T> List<Map<String, Object>> assistFun1( String k1, String
 * k2) { return new ArrayList<Map<String, Object>>() {{ add(new HashMap<String,
 * Object>() {{ put(k1, (Integer) (-1)); put(k2, "全部"); }}); for (T opT : T) {
 * add(new HashMap<String, Object>() {{ put(k1, (Integer) opT.code()); put(k2,
 * opT.desc()); }}); } }}; } }
 */
