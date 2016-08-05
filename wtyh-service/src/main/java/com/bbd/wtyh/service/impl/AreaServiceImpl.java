
/**
* @Title: AreaServiceImpl.java
* @Package com.bbd.wtyh.service.impl
* @Description: TODO
* @author Ian.Su
* @date 2016年8月5日 下午1:48:36
* @version V1.0
*/

package com.bbd.wtyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.entity.Area;
import com.bbd.wtyh.mapper.AreaMapper;
import com.bbd.wtyh.service.AreaService;

/**
* @ClassName: AreaServiceImpl
* @Description: 区域数据
* @author Ian.Su
* @date 2016年8月5日 下午1:48:36
*/
@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaMapper areaMapper;
	
	
	/**
	* @see com.bbd.wtyh.service.AreaService#list()
	*/
	public List<Area> list(){
		
		return areaMapper.list();
		
	}
}
