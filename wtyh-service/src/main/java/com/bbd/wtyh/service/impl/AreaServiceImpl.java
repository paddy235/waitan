
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

import com.bbd.wtyh.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.mapper.AreaMapper;
import com.bbd.wtyh.service.AreaService;

import javax.servlet.http.HttpSession;

/**
* 区域数据
* @author Ian.Su
* @since 2016年8月5日 下午1:48:36
*/
@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaMapper areaMapper;



	/**
	 * 根据session 取区域id，如果是全上海市则返回null
	 *
	 * */
	public Integer getAreaId(HttpSession session){

		//AreaDO area = (AreaDO) session.getAttribute(Constants.SESSION_AREA);
		String area = (String) session.getAttribute("area");

		 return (area==null || Constants.SH_AREAID.equals(area))?null:Integer.valueOf(area);
		//return 1122;
	}

	/**
	 * 根据session 取区域名，如果是全上海市则返回null
	 *
	 * */
	public String getAreaName(HttpSession session){

		//AreaDO area = (AreaDO) session.getAttribute(Constants.SESSION_AREA);
		String area = (String) session.getAttribute("areaName");

		 return area;
		//return "浦东新区";
	}
	
	
	public List<AreaDO> areaList(Integer areaId){
		
		return areaMapper.areaList(areaId);
		
	}


	
	@Override
	public List<NvDO> hot() {
		return areaMapper.hot();
	}

	@Override
	public List<AreaDO> selectByParentId(Integer parentId) {
		return areaMapper.selectByParentId(parentId);
	}

	@Override
	public AreaDO selectByNameAndLevel(String name, Integer level) {
		return areaMapper.selectByNameAndLevel(name, level);
	}

	@Override
	public AreaDO getAreaByAreaId(Integer areaId) {
		return areaMapper.getAreaByAreaId(areaId);
	}
}
