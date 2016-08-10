package com.bbd.wtyh.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bbd.wtyh.domain.NvDO;
import com.bbd.wtyh.domain.dto.AreaIndexDTO;
import com.bbd.wtyh.domain.dto.IndustryCompareDTO;
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
     * 1：公司分布地图，成交量和综合利率，问题平台比例，行业人气，网贷数据对比 综合接口
     *
     * @return ResponseBean
     */
    @RequestMapping("/integrated")
    @ResponseBody
    public Object integrated(){
    	
    	Map<String,Object> map = new LinkedHashMap<>();
    	
    	List<IndustryShanghaiDTO> list = getData();
    	
    	map.put("hotMap",hotMap(list));
    	
    	map.put("newly", newlyPlat(list) );
    	
    	map.put("bargain", bargain(list));
    	
    	List<IndustryProblemDTO> problemData = getProblemData();
    	
    	map.put("problem",problem(problemData));
    	
    	map.put("popularity",popularity(list));
    	
    	map.put("compare",compare(getCompareData()));
    	
    	
    	return ResponseBean.successResponse(map);
    }
    
    
    
    
    
    
    /**
     * 上海区域发展指数排名
     *
     * @return ResponseBean
     */
    @RequestMapping("/areaIndex")
    @ResponseBody
    public Object areaIndex(){
    	
    	return ResponseBean.successResponse(getAreaIndex());
    	
    }
    
    
    private List<AreaIndexDTO> getAreaIndex(){
    	
    	List<AreaIndexDTO> list = new ArrayList<>();
    	
    	for (int k=0;k<20;k++) {
    		AreaIndexDTO dto = new AreaIndexDTO();
    		
    		dto.setArea("四川省"+k);
    		dto.setCompetitiveness(k*3);
    		dto.setEcosystem(k*2);
    		dto.setRank(k*5);
    		dto.setRecognition(k<<3);
    		dto.setSafety(k*9);
    		dto.setScale(k*7);
    		list.add(dto);
		}
    	
    	return list;
    	
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
    private XAxisSeriesLinesDTO<Double> compare(List<IndustryCompareDTO> list){
    	@SuppressWarnings("unchecked")
		XAxisSeriesLinesDTO<Double> data = new XAxisSeriesLinesDTO<Double>(
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
    
    
    private List<IndustryCompareDTO> getCompareData(){
    	
    	IndustryCompareDTO dto = new IndustryCompareDTO();
    	dto.setArea("上海");
    	dto.setAmount(1);
    	dto.setBalance_loans(10);
    	
    	IndustryCompareDTO dto2 = new IndustryCompareDTO();
    	dto2.setArea("全国");
    	dto2.setAmount(2);
    	dto2.setBalance_loans(20);
    	
    	return Arrays.asList(dto,dto2);
    	
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
        		
        		dto.setArea_num(new HashMap<String,Object>());
        		dto.getArea_num().put("浦东区", 3);
        		dto.getArea_num().put("黄埔区", 1);
        		
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
