package com.bbd.wtyh.test;



import com.bbd.wtyh.core.base.BaseServiceImpl;
import com.bbd.wtyh.service.ParkService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;


/**
 * wtyh
 *
 * @author Created by LiYao on 2017-03-16 10:39.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class MyTest extends BaseServiceImpl {

	@Autowired
	private ParkService parkService;


	@Test
	public  void queryParkCompany(){
		Map<String, Object> map= parkService.queryParkCompany(1122,null,null,null,null,null,"上海申彤",50,1);
		//System.err.println(JSON.toJSONString(map, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect));
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.err.println(mapper.writeValueAsString(map));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
