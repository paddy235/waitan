package com.bbd.wtyh.test;

import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.service.CoRiskChgService;
import com.bbd.wtyh.util.ApplicationContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-04-20 15:22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class CoRiskChgTest {

	@Autowired
	private CoRiskChgService coRiskChgService;

	@Test
	public void queryPageDateTest() throws Exception {
		Pagination page = new Pagination();

		Map<String, String> map = new HashMap<>();
		map.put("sdate", "2017-04");
		map.put("edate", "2017-04");
		map.put("areaSet", "104,1122");
		map.put("financialType", "1");
		map.put("buildId", "1");
		map.put("riskLevel", "4");
		map.put("source", "2");
		map.put("statusSort", "ASC");
		map.put("", "");
		map.put("", "");
		long s = System.currentTimeMillis();
		this.coRiskChgService.queryPageData(map, page);
		long e = System.currentTimeMillis();
		// page.setPageIndex("7684");
		//
		//
		// this.coRiskChgService.selectByPage(UserLog.class, page, null);
		//
		System.out.println("总耗时：" + (e - s));
		System.out.println(page);

	}

	@Autowired
	private CoCreditScoreService coCreditScoreService;

	@Test
	public void test() throws Exception {
		coCreditScoreService.creditScoreCalculate();
	}
}
