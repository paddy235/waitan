package com.bbd.wtyh.web.controller;

import java.util.ArrayList;
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
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.XAxisSeriesDO;
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
    	
    	return ResponseBean.successResponse(map);
    }
    
    /**
    * 获取数据
    *
    * @return List<IndustryShanghaiDTO>
    */
    private List<IndustryShanghaiDTO> getData(){
    	
    	List<IndustryShanghaiDTO> list = new ArrayList<>();
    	for (int year = 2014; year < 2016; year++) {
    		for (int m=1;m<13;m++) {
        		IndustryShanghaiDTO dto = new IndustryShanghaiDTO();
        		dto.setDate(year+"-"+m);
        		dto.setAmount(1);
        		dto.setBorrowed_num(1+m);
        		dto.setInterest_rate(1);
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
    * @return XAxisSeriesDO<Integer>
    */
    private XAxisSeriesDO<Integer> newlyPlat(List<IndustryShanghaiDTO> list){
    	XAxisSeriesDO<Integer> data = new XAxisSeriesDO<Integer>();
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
     * @return XAxisSeriesDO<Integer>
     */
     private XAxisSeriesDO<Double> bargain(List<IndustryShanghaiDTO> list){
     	XAxisSeriesDO<Double> data = new XAxisSeriesDO<Double>();
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
