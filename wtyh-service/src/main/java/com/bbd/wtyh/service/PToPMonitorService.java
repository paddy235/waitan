package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.dto.AreaIndexDTO;
import com.bbd.wtyh.domain.dto.IndustryCompareDTO;
import com.bbd.wtyh.domain.dto.IndustryProblemDTO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;

/**
* 
* @author Ian.Su
* @since 2016年8月12日 下午2:08:42
*/
public interface PToPMonitorService {
	
	
	 
	/**
	* 网贷对比数据
	* @return List<IndustryCompareDTO>
	*/
	public List<IndustryCompareDTO> getCompareData()throws Exception;
	
	
	
	    
	 
	/**
	* 上海区域发展指数排名
	*
	* @param   
	* @return List<AreaIndexDTO>
	*/
	public List<AreaIndexDTO> getAreaIndex()throws Exception;
	
	
	
	    
	 
	/**
	* 网贷平台数据展示
	* @return List<PlatRankDataDTO>
	*/
	public List<PlatRankDataDTO> getPlatRankData()throws Exception;

	/**
	 * 网贷平台企业光谱数据
	 * @return
	 * @throws Exception
	 */
	public Map<Integer, Integer> getPlatRankMapData()throws Exception;
	
	     
	
	/**
	* 网贷行业整体数据
	*
	* @return List<IndustryShanghaiDTO>
	*/
	public List<IndustryShanghaiDTO> getData()throws Exception;
	    
	
	/**
	* 网贷行业整体数据-问题平台
	*
	* @return List<IndustryProblemDTO>
	*/
	public List<IndustryProblemDTO> getProblemData()throws Exception;
	     
	

}
