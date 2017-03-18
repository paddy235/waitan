package com.bbd.wtyh.test;

import com.bbd.wtyh.core.entity.Pagination;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.UserInfoTableDo;
import com.bbd.wtyh.service.UserInfoService;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * wtyh
 *
 * @author Created by LiYao on 2017-03-16 10:39.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class Test {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserInfoService userInfoService;

	@org.junit.Test
	public void test1() {

		List<UserInfoTableDo> users = userInfoService.selectAll(UserInfoTableDo.class, "login_name='admin'");
		System.out.println("total:" + users.size());
		for (UserInfoTableDo us : users) {
			System.err.println(us);
		}

	}

	@org.junit.Test
	public void test2() {
		Pagination<UserInfoTableDo> page = new Pagination<>();
		// 页码设置
		page.setPageIndex("1");

		List<UserInfoTableDo> users = userInfoService.selectByPage(UserInfoTableDo.class, page, "");
		page.setList(users);

		System.out.println("total:" + users.size());
		for (UserInfoTableDo us : users) {
			logger.info(us.toString());
		}

		logger.error(".........................");
	}

	@org.junit.Test
	public void test3() {
		AreaDO ad = userInfoService.selectById(AreaDO.class,1111);


	}

}
