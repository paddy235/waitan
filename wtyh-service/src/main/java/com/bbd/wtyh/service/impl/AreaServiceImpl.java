
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

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.mapper.AreaMapper;
import com.bbd.wtyh.service.AreaService;

/**
* 区域数据
* @author Ian.Su
* @since 2016年8月5日 下午1:48:36
*/
@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaMapper areaMapper;
	
	
	public List<AreaDO> areaList(){
		
		return areaMapper.areaList();
		
	}


	
	@Override
	public List<NvDO> hot() {
		return areaMapper.hot();
	}
}
