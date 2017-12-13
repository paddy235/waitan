package com.bbd.wtyh.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.domain.vo.UseDetailVO;
import com.bbd.wtyh.domain.vo.UseHotPage;
import com.bbd.wtyh.domain.vo.UserSearchVO;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 用户基本信息服务接口 Created by cgj on 2017/2/27.
 */
public interface UserBehaviorLogService extends BaseService {

	Map<String, Object> listUserBehaviorLog(int pageSize, Integer pageNumber, String excludeName, String userName, Integer areaCode,
			Integer sysCode, Integer opTpCd, Integer opPgCd, Date beginTime, Date endTime, String logContent, String orderBy)
			throws Exception;

	List<Map<String, String >> listUserOperaLog(Date beginTime, Date endTime,Integer sysCode)
			throws Exception;

	 HSSFWorkbook produceExcel(HSSFWorkbook workbook, HSSFSheet sheet, List<UseDetailVO> opeList,String headTitle,Integer [] res) ;

	HSSFWorkbook produceExcel3(HSSFWorkbook workbook, HSSFSheet sheet, List<UserSearchVO> opeList,String headTitle) ;

	 List<UserSearchVO> findKeyWord(Date beginTime, Date endTime,Integer sysCode);

	List<UseHotPage> findHotPage(Date beginTime, Date endTime, Integer sysCode);
}
