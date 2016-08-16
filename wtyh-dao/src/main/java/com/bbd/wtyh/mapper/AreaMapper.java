package com.bbd.wtyh.mapper;

import java.util.List;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.NvDO;
import org.apache.ibatis.annotations.Param;


/**
* 区域mapper
* @author Ian.Su
* @since 2016年8月5日 下午1:52:45
*/
public interface AreaMapper{
	
    
    /**
    * @return List<Area> 
    */
    List<AreaDO> areaList();

	
	/**
	*
	* @return List<NvDO>
	*/
	List<NvDO> hot();


	AreaDO selectByNameAndLevel(@Param("name") String name,@Param("level") Integer level);

	List<AreaDO> selectByParentId(Integer parentId);

}
