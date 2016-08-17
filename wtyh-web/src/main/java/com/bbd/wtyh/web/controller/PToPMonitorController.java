package com.bbd.wtyh.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.domain.dto.IndustryCompareDTO;
import com.bbd.wtyh.domain.dto.IndustryProblemDTO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.PToPMonitorService;
import com.bbd.wtyh.web.ResponseBean;
import com.bbd.wtyh.web.XAxisSeriesBarLineBean;
import com.bbd.wtyh.web.XAxisSeriesLinesBean;

/**
* P2P行业监测平台
* @author Ian.Su
* @since 2016年8月7日 下午2:02:01
*/
@Controller
@RequestMapping("/PToPMonitor")
public class PToPMonitorController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private PToPMonitorService pToPMonitorService;
	
	
	
	
	
	 /**
     * 平台状态信息
     *
     * @return ResponseBean
     */
    @RequestMapping("/hot")
    @ResponseBody
    public ResponseBean hot(){
    	
    	List<NvDO> list = areaService.hot();
    	
    	return ResponseBean.successResponse(list);
    	
    }
    
    
    
    
    /**
     * 1：公司分布地图，成交量和综合利率，问题平台比例，行业人气，网贷数据对比 综合接口
     *
     * @return ResponseBean
     * @throws Exception 
     */
    @RequestMapping("/integrated")
    @ResponseBody
    public Object integrated() throws Exception{
    	
    	Map<String,Object> map = new LinkedHashMap<>();
    	
    	List<IndustryShanghaiDTO> list = pToPMonitorService.getData();
    	
    	map.put("hotMap",hotMap(list));
    	
    	map.put("newly", newlyPlat(list) );
    	
    	map.put("bargain", bargain(list));
    	
    	List<IndustryProblemDTO> problemData = pToPMonitorService.getProblemData();
    	
    	map.put("problem",problem(problemData));
    	
    	map.put("popularity",popularity(list));
    	
    	map.put("compare",compare(pToPMonitorService.getCompareData()));
    	
    	
    	return ResponseBean.successResponse(map);
    }
    
    
    
    
    
    

    
    
    
    
    
    




	/**
     * 热力图
     *
     * @return XAxisSeriesLinesDO<Integer>
     */
    public Map<String, Object> hotMap(List<IndustryShanghaiDTO> list){
    	
    	HashMap<String,Object> map = new HashMap<>();
    	map.put("code", 1);
    	map.put("title", "热力图");
    	IndustryShanghaiDTO maxDto = list.get(0);
    	for (IndustryShanghaiDTO dto : list) {
			if(maxDto.getDate().compareTo(dto.getDate()) > 0){
				maxDto = dto;
			}
		}
    	
    	List<Map<String, Object>> data = new ArrayList<>();
    	for (Map.Entry<String, Object> entry: maxDto.getArea_num().entrySet()) {
    		Map<String, Object> areaNum = new HashMap<>();
    		areaNum.put("name", entry.getKey());
    		areaNum.put("value", entry.getValue());
			data.add(areaNum);
		}
    	map.put("data", data);
    	return map;
    }
    
    
    
    
    
    /**
    * 网贷数据对比(上海VS全国)
    *
    * @param   
    * @return XAxisSeriesLinesDTO<Double>
    */
    private XAxisSeriesLinesBean<Double,String> compare(List<IndustryCompareDTO> list){
    	@SuppressWarnings("unchecked")
		XAxisSeriesLinesBean<Double,String> data = new XAxisSeriesLinesBean<Double,String>(
								    			new ArrayList<Double>(),
								    			new ArrayList<Double>());
    	data.setTitle("网贷数据对比(上海VS全国)");
    	if(CollectionUtils.isEmpty(list) ){
    		return data;
    	}
    	
    	data.setxAxis(Arrays.asList("贷款余额","成交量"));
    	for (IndustryCompareDTO dto : list) {
			if("全国".equals(dto.getArea())){
				data.getSeries()[0].add(0, dto.getBalance_loans());
				data.getSeries()[1].add(0, dto.getAmount());
			}else{
				data.getSeries()[0].add(dto.getBalance_loans());
				data.getSeries()[1].add(dto.getAmount());
			}
		}
    	
    	
    	return data;
    }
    
    
  
    
    
    
    /**
     * 行业人气
     *
     * @return XAxisSeriesLinesDO<Integer>
     */
    public XAxisSeriesLinesBean<Integer,String> popularity(List<IndustryShanghaiDTO> list){
    	
    	@SuppressWarnings("unchecked")
		XAxisSeriesLinesBean<Integer,String> data = new XAxisSeriesLinesBean<>(
								    			new ArrayList<Integer>(),
								    			new ArrayList<Integer>());
    	data.setTitle("行业人气");
    	if(CollectionUtils.isEmpty(list) ){
    		return data;
    	}
    	
    	Map<String, Integer[]> map = new TreeMap<>();
    	
    	for (IndustryShanghaiDTO dto : list) {
			
    		Integer[] as = map.get(dto.getDate());
    		if(as == null){
    			as = new Integer[]{0,0};
    		}
    		as[0] += dto.getInvest_num();
    		as[1] += dto.getBorrowed_num();
    		map.put(dto.getDate(), as);
		}
    	
    	data.getxAxis().addAll(map.keySet());
    	
    	Iterator<Integer[]> it = map.values().iterator();
    	while(it.hasNext()){
    		Integer[] lines = it.next();
    		data.getSeries()[0].add(lines[0]);
    		data.getSeries()[1].add(lines[1]);
    	}
    	
    	return data;
    }
    
 
    
    
    /**
    * 问题平台比例
    *
    * @return XAxisSeriesLinesDO<Integer>
    */
    private XAxisSeriesLinesBean<Integer,String> problem(List<IndustryProblemDTO> list){
    	@SuppressWarnings("unchecked")
		XAxisSeriesLinesBean<Integer,String> data = new XAxisSeriesLinesBean<>(
								    			new ArrayList<Integer>(),
								    			new ArrayList<Integer>());
    	data.setTitle("问题平台比例");
    	if(CollectionUtils.isEmpty(list) ){
    		return data;
    	}
    	
    	Map<String, Integer[]> map = new TreeMap<>();
    	
    	for (IndustryProblemDTO dto : list) {
			
    		Integer[] as = map.get(dto.getDate());
    		if(as == null){
    			as = new Integer[]{0,0};
    		}
    		as["全国".equals(dto.getArea())?1:0] += dto.getProblem_plat_number();
    		map.put(dto.getDate(), as);
		}
    	
    	data.getxAxis().addAll(map.keySet());
    	
    	Iterator<Integer[]> it = map.values().iterator();
    	while(it.hasNext()){
    		Integer[] nums = it.next();
    		data.getSeries()[0].add(nums[0]);
    		data.getSeries()[1].add(nums[1]);
    	}
    	return data;
    }
    
    
    
    
    
   
    
    

    
    
    
    
    /**
    * 上海新增平台发展趋势
    *
    * @return XAxisSeriesBarLineDO<Integer>
    */
    private XAxisSeriesBarLineBean<Integer,String> newlyPlat(List<IndustryShanghaiDTO> list){
    	XAxisSeriesBarLineBean<Integer,String> data = new XAxisSeriesBarLineBean<>();
    	data.setTitle("上海新增平台发展趋势");
    	if(CollectionUtils.isEmpty(list) ){
    		return data;
    	}
    	
    	Map<String, Integer[]> map = new TreeMap<>();
    	
    	for (IndustryShanghaiDTO dto : list) {
			
    		Integer[] as = map.get(dto.getSeason());
    		if(as == null){
    			as = new Integer[]{0,0};
    		}
    		as[0] += dto.getNew_plat_num();
    		as[1] += dto.getTotal_plat_num_sh();
    		map.put(dto.getSeason(), as);
		}
    	
    	data.getxAxis().addAll(map.keySet());
    	
    	Iterator<Integer[]> it = map.values().iterator();
    	while(it.hasNext()){
    		Integer[] newTot = it.next();
    		data.getSeries().getBar().add(newTot[0]);
    		data.getSeries().getLine().add(newTot[1]);
    	}
    	return data;
    }
    
    
    
    
    /**
     * 成交和综合利率
     *
     * @return XAxisSeriesBarLineDO<Integer>
     */
     private XAxisSeriesBarLineBean<Double,String> bargain(List<IndustryShanghaiDTO> list){
     	XAxisSeriesBarLineBean<Double,String> data = new XAxisSeriesBarLineBean<Double,String>();
     	data.setTitle("成交和综合利率");
     	if(CollectionUtils.isEmpty(list) ){
     		return data;
     	}
     	
     	Map<String, double[]> map = new TreeMap<>();
     	
     	for (IndustryShanghaiDTO dto : list) {
     		map.put(dto.getDate(), new double[]{ dto.getInterest_rate(),dto.getAmount()});
 		}
     	
     	data.getxAxis().addAll(map.keySet());
     	
     	Iterator<double[]> it = map.values().iterator();
     	while(it.hasNext()){
     		double[] newTot = it.next();
     		data.getSeries().getBar().add(newTot[1]);
     		data.getSeries().getLine().add(newTot[0]);
     	}
     	return data;
     }
     
    
     
     /**
      * 上海区域发展指数排名
      *
      * @return ResponseBean
     * @throws Exception 
      */
     @RequestMapping("/areaIndex")
     @ResponseBody
     public Object areaIndex() throws Exception{
     	
     	return ResponseBean.successResponse(pToPMonitorService.getAreaIndex());
     	
     }
     

     
     
     
     /**
      * 上海网贷平台数据展示
      *
      * @return ResponseBean
     * @throws Exception 
      */
     @RequestMapping("/platRankData")
     @ResponseBody
     public Object platRankData() throws Exception{
    	 
    	 List<PlatRankDataDTO> list = pToPMonitorService.getPlatRankData();
    	 
    	 if(CollectionUtils.isEmpty(list)){
    		 return ResponseBean.successResponse( new ArrayList<>() );
    	 }
    	 
    	 for (PlatRankDataDTO dto : list) {
    		double total = dto.getStay_still_of_total();
    		total = new BigDecimal("0"+total).divide(new BigDecimal("10000"), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
    		dto.setStay_still_of_total(total);
		 }
     	
     	 return ResponseBean.successResponse( list );
     	
     }
     

     
    

     
     
     
     
	
}
