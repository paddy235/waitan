package com.bbd.wtyh.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.wtyh.domain.CompanyCreditRawInfoDO;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import com.bbd.wtyh.domain.dto.CreditInfoDTO;
import com.bbd.wtyh.mapper.CompanyCreditRawInfoMapper;
import com.bbd.wtyh.service.CoCreditScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8 0008.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class CreditTest {

	@Autowired
	private CoCreditScoreService coCreditScoreService;
	@Autowired
	private CompanyCreditRawInfoMapper companyCreditRawInfoMapper;

	@Test
	public void queryfailCompanyTest() {
		List<CompanyCreditFailInfoDO> list = coCreditScoreService.queryfailCompany(new String[] {}, "1002", 2, 1, 2);
		System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));

	}

	@Test
	public void insertTest() {
		CompanyCreditRawInfoDO companyCreditRawInfoDO = new CompanyCreditRawInfoDO();
		companyCreditRawInfoDO.setCompanyName("你好5");
		companyCreditRawInfoMapper.saveCompanyCreditRawInfo(companyCreditRawInfoDO);

	}

	@Test
	public void getCreditInfoTest() {
		List<CreditInfoDTO> list=coCreditScoreService.getCreditInfo("中阜投融资产管理股份有限公司","3");
		System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));

	}
}
