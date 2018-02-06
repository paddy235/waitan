
/**
* @Title: AreaServiceImpl.java
* @Package com.bbd.wtyh.service.impl
* @Description: TODO
* @author Ian.Su
* @date 2016年8月5日 下午1:48:36
* @version V1.0
*/

package com.bbd.wtyh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.core.base.BaseServiceImpl;
import org.apache.commons.lang.StringUtils;
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
public class AreaServiceImpl extends BaseServiceImpl implements AreaService {
	
	@Autowired
	private AreaMapper areaMapper;



	/**
	 * 根据session 取区域id，如果是全上海市则返回null
	 *
	 * */
	public Integer getAreaId(HttpSession session){

		//AreaDO area = (AreaDO) session.getAttribute(Constants.SESSION_AREA);
		String area = (String) session.getAttribute("area");
		Integer it=null;
		if(null != area){
			it=Integer.valueOf(area);
		}
		 return (it==null || Constants.SH_AREAID==it)?null:it;
		//return 1122;
	}

	/**
	 * 根据session 取区域名，如果是全上海市则返回null
	 *
	 * */
	public String getAreaName(HttpSession session){

		//AreaDO area = (AreaDO) session.getAttribute(Constants.SESSION_AREA);
		String area = (String) session.getAttribute("areaName");
		if(Constants.SH_AREANAME.equals(area)){
			area=null;
		}else if(Constants.SH_CHONGMINGQU.equals(area)){
			// 线下理财需要转换， 因为index_data中保存的崇明县，所以需要把area中的崇明区转换成崇明县查询
			area=Constants.SH_CHONGMINGXIAN;
		}

		 return area;
		//return "浦东新区";
	}
	
	
	public List<AreaDO> areaList(Integer areaId){
		
		return areaMapper.areaList(areaId);
		
	}

	@Override
	public List<AreaDO> areaListAll(Integer parentId) {
		return areaMapper.areaListAll(parentId);
	}

	@Override
	public Map<Integer, String> areaMapAll(Integer parentId) {
		List<AreaDO> areaList = areaMapper.areaListAll(parentId);
		Map map = new HashMap();
		for (AreaDO area : areaList) {
			map.put(area.getAreaId(), area.getName());
		}
		return map;
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
	public AreaDO selectByCountyCodeOrProvinceName( String countyCode, String provinceName ) {
		AreaDO ad =new AreaDO();
		if ( StringUtils.isNotBlank(countyCode) && countyCode.matches("^([0-9]){6}$") ) {
			ad =this.selectOne(AreaDO.class, "`nation_district_code` ='" +countyCode +"'" );
			if( null !=ad ) {
				return ad;
			} else { ad =new AreaDO(); }
			//降级到市一级的区县代码匹配
			countyCode =countyCode.substring(0, 4) +"00";
			ad =this.selectOne(AreaDO.class, "`nation_district_code` ='" +countyCode +"'" );
			if( null !=ad ) {
				return ad;
			} else { ad =new AreaDO(); }
		}
		if ( StringUtils.isNotBlank(provinceName) ) {
			if ( provinceName.endsWith("省") ) {
				provinceName =provinceName.substring(0, provinceName.length() -1);
			}
			ad =selectByNameAndLevel( provinceName, 1 );
			if( null !=ad ) {
				return ad;
			} else { ad =new AreaDO(); }
		}
		//没有查到，默认返回上海市的AreaDo
		return selectByNameAndLevel( "上海市", 2 );
		// todo area表中的nation_district_code有待补充
	}

	@Override
	public AreaDO getAreaByAreaId(Integer areaId) {
		return areaMapper.getAreaByAreaId(areaId);
	}

	@Override
	public AreaDO getAreaByAreaName(String areaName) {
		return areaMapper.getAreaByAreaName(areaName);
	}
}
