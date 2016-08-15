package com.bbd.wtyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bbd.wtyh.mapper.UserMapper;
import com.bbd.wtyh.service.UserService;

/**
* 
* @author Ian.Su
* @since 2016年8月15日 下午6:23:15
*/
@Service
public class UserServiceImple implements UserService {

	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String getPassword(String loginName) {
		
		List<String> list = userMapper.getPassword(loginName);
		
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return list.get(0);
		
	}

}
