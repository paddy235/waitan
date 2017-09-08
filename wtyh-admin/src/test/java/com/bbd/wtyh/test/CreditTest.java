package com.bbd.wtyh.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bbd.wtyh.domain.CompanyCreditRawInfoDO;
import com.bbd.wtyh.domain.credit.CompanyCreditFailInfoDO;
import com.bbd.wtyh.domain.dto.CreditInfoDTO;
import com.bbd.wtyh.domain.dto.CreditRiskDataDTO;
import com.bbd.wtyh.mapper.CompanyCreditRawInfoMapper;
import com.bbd.wtyh.service.CoCreditScoreService;
import com.bbd.wtyh.service.CompanyStatusChangeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
	@Autowired
	private CompanyStatusChangeService companyStatusChangeService;

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
    public void resourceCountsTest() {
        List<CreditRiskDataDTO> list = coCreditScoreService.getResourceCounts(null,"上海互信金融信息服务有限公司");
        System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));


    }

	@Test
	public void getCreditInfoTest() {
		List<CreditInfoDTO> list = coCreditScoreService.getCreditInfo("中阜投融资产管理股份有限公司", "3",null);
		System.err.println(JSON.toJSONString(list, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));

	}

	@Test
	public void companyStatusChangeTest() {
		companyStatusChangeService.companyStatusChange(false,"成都数联铭品科技有限公司",Byte.valueOf("1"));

	}

	@Autowired
	private DataSource dataSource;

	@Test
	public void test() throws Exception {
		String sql = "insert into test1(name) values (?)";
		Connection conn = dataSource.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setObject(1, "成都4");
		statement.execute();
		System.out.println(statement.getUpdateCount());
		ResultSet resultSet = statement.getGeneratedKeys();
		while (resultSet.next()) {
			System.out.println(resultSet.getObject(1));
			System.out.println(resultSet.getObject(2));
		}

	}
}
