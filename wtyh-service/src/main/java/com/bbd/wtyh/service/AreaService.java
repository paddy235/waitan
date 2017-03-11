package com.bbd.wtyh.service;

import java.util.List;

import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.NvDO;

import javax.servlet.http.HttpSession;

/**
* 园区相关接口
* @author Ian.Su
* @since 2016年8月5日 上午11:57:08
*/
public interface AreaService {




	/**
	 * 根据session 取区域id，如果是全上海市则返回null
	 *
	 * */
	public Integer getAreaId(HttpSession session);


	/**
	 * 根据session 取区域名，如果是全上海市则返回null
	 *
	 * */
	public String getAreaName(HttpSession session);


	/**
	*
	* 获取所有的区域
	* @param areaId  根据区域id获取数据
	* @return List<Area>
	*/
	public List<AreaDO> areaList(Integer areaId);

	/**
	 *
	 * 获取所有的区域（有数据的园区）
	 * @param parentId  根据区域id获取数据
	 * @return List<Area>
	 */
	public List<AreaDO> areaListAll(Integer parentId);

	/**
	* 获取区域热力图
	* @return List<NvDO>
	*/
	public List<NvDO> hot();


	List<AreaDO> selectByParentId(Integer parentId);

	AreaDO selectByNameAndLevel(String name,Integer level);

	AreaDO getAreaByAreaId(Integer areaId);

}
