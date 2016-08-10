package com.bbd.wtyh.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.domain.dto.IndustryProblemDTO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.XAxisSeriesBarLineDTO;
import com.bbd.wtyh.domain.dto.XAxisSeriesLinesDTO;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.web.ResponseBean;

/**
* P2P行业监测平台
* @author Ian.Su
* @since 2016年8月7日 下午2:02:01
*/
@Controller
@RequestMapping("/PToPMonitor")
public class PToPMonitorController {
	
	@Autowired
	private AreaService areaService;
	
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
     * 平台状态信息
     *
     * @return ResponseBean
     */
    @RequestMapping("/integrated")
    @ResponseBody
    public Object integrated(){
    	
    	Map<String,Object> map = new HashMap<>();
    	
    	List<IndustryShanghaiDTO> list = getData();
    	
    	map.put("newly", newlyPlat(list) );
    	
    	map.put("bargain", bargain(list));
    	
    	List<IndustryProblemDTO> problemData = getProblemData();
    	
    	map.put("problem",problem(problemData));
    	
    	map.put("popularity",popularity(list));
    	
    	return ResponseBean.successResponse(map);
    }
    
    
    
    
    
    
    
    
    
    /**
     * 行业人气
     *
     * @return XAxisSeriesLinesDO<Integer>
     */
    public XAxisSeriesLinesDTO<Integer> popularity(List<IndustryShanghaiDTO> list){
    	
    	@SuppressWarnings("unchecked")
		XAxisSeriesLinesDTO<Integer> data = new XAxisSeriesLinesDTO<Integer>(
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
    private XAxisSeriesLinesDTO<Integer> problem(List<IndustryProblemDTO> list){
    	@SuppressWarnings("unchecked")
		XAxisSeriesLinesDTO<Integer> data = new XAxisSeriesLinesDTO<Integer>(
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
     * 获取数据
     *
     * @return List<IndustryShanghaiDTO>
     */
     private List<IndustryProblemDTO> getProblemData(){
     	
     	List<IndustryProblemDTO> list = new ArrayList<>();
     	for (int year = 2014; year < 2016; year++) {
     		for (int m=1;m<13;m+=2) {
     			IndustryProblemDTO shDto = new IndustryProblemDTO();
     			shDto.setDate(year+"-"+(m<10?"0":"")+m);
     			shDto.setArea("上海");
     			shDto.setProblem_plat_number(m*2);
         		list.add(shDto);
         		
         		IndustryProblemDTO dto = new IndustryProblemDTO();
         		dto.setDate(year+"-"+(m<10?"0":"")+m);
         		dto.setArea("全国");
         		dto.setProblem_plat_number(m*3);
         		list.add(dto);
     		}
 		}
     	return list;
     }
     
     
    
    
    /**
    * 获取数据
    *
    * @return List<IndustryShanghaiDTO>
    */
    private List<IndustryShanghaiDTO> getData(){
    	
    	List<IndustryShanghaiDTO> list = new ArrayList<>();
    	for (int year = 2014; year < 2016; year++) {
    		for (int m=1;m<13;m+=2) {
        		IndustryShanghaiDTO dto = new IndustryShanghaiDTO();
        		dto.setDate(year+"-"+(m<10?"0":"")+m);
        		dto.setAmount(m*2);
        		dto.setBorrowed_num(1+m);
        		dto.setInterest_rate(m*2.3);
        		dto.setInvest_num(1);
        		dto.setNew_plat_num(1+m);
        		dto.setTotal_plat_num_sh(2+m);
        		list.add(dto);
    		}
		}
    	return list;
    }
    
    
    
    
    
    
    /**
    * 上海新增平台发展趋势
    *
    * @return XAxisSeriesBarLineDO<Integer>
    */
    private XAxisSeriesBarLineDTO<Integer> newlyPlat(List<IndustryShanghaiDTO> list){
    	XAxisSeriesBarLineDTO<Integer> data = new XAxisSeriesBarLineDTO<Integer>();
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
     private XAxisSeriesBarLineDTO<Double> bargain(List<IndustryShanghaiDTO> list){
     	XAxisSeriesBarLineDTO<Double> data = new XAxisSeriesBarLineDTO<Double>();
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
     
    
	
}
