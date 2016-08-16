package com.bbd.wtyh.mapper;

import java.util.List;

/**
* 
* @author Ian.Su
* @since 2016年8月15日 下午6:10:57
*/
public interface UserMapper {
	
	public List<String> getPassword(String loginName);
	
}
