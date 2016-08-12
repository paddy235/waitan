package com.bbd.wtyh.web.controller.mockServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.domain.dto.AreaIndexDTO;
import com.bbd.wtyh.domain.dto.IndustryCompareDTO;
import com.bbd.wtyh.domain.dto.IndustryProblemDTO;
import com.bbd.wtyh.domain.dto.IndustryShanghaiDTO;
import com.bbd.wtyh.domain.dto.PlatRankDataDTO;

/**
 * p2p行业检测平台控制层
 *
 * @author wangchenge
 * @since 2016.08.05
 */
@Controller
public class MockSerserController {

    /**
     * 核心数据及集中度
     *
     * @param dataType
     * @return
     */
	@RequestMapping("/financial_services")
    @ResponseBody
    public Object coreData(@RequestParam(required = true) String dataType, String plat_name) {
        // 核心数据及集中度
        if (dataType.equals("plat_data")) {
            return "{\"plat_name\":\"来财街\"," +
                    "\"plat_score\":73.2," +
                    "\"other_sum_amount\":0," +
                    "\"bor_num_stay_stil\":1," +
                    "\"inserest_rate\":12.58," +
                    "\"money_stock\":8430.91," +
                    "\"top10_num_amount\":0," +
                    "\"bid_num_stay_stil\":6205," +
                    "\"plat_data_six_month\":[{" +
                    "\"date\":1321435453132," +
                    "\"date_interset_rate\":0," +
                    "\"day_net_inflow\":-26.99," +
                    "\"day_amount\":0," +
                    "\"day_money_stock\":8430.91},]," +
                    "\"company_name\":\"阿丽亚路上海投资发展有限公司\"," +
                    "\"plat_status\":\"正常\"," +
                    "\"30_day_net_inflow\":6565.6," +
                    "\"top1_sum_amount\":0," +
                    "\"amount_taotal\":23154.0985}";
        } else if (dataType.equals("plat_list")) {
            // 搜索 - 平台名称和公司名称
            return "[{" +
                    "\"plat_name\":\"来财街\"，" +
                    "\"company_name\":\"阿里路亚上海投资有限公司\"}," +
                    "{" +
                    "\"plat_name\":\"91投\"，" +
                    "\"company_name\":\"上海浙鑫金融有限服务有限公司\"},]";
        } else if (dataType.equals("leida")) {
            return "{\"plat_name\":\"今日劫财\"," +
                    "\"penalty_cost\":67.25," +
                    "\"info_disclosure\":69.77," +
                    "\"capital\":76.67," +
                    "\"operation\":73.23," +
                    "\"fluidity\":53.33," +
                    "\"dispersion\":71.73}";
        }else if("industry_shanghai".equalsIgnoreCase(dataType)){
        	return getIndustry_shanghai();
        }else if("industry_problem".equalsIgnoreCase(dataType)){
        	return getProblemData();
        }else if("industry_compare".equalsIgnoreCase(dataType)){
        	return getCompareData();
        }else if("area_index".equalsIgnoreCase(dataType)){
        	return getAreaIndex();
        }else if("plat_rank_data".equalsIgnoreCase(dataType)){
        	return getPlatRankData();
        } else {
            return "Not right RequestParam.";
        }
    }
	
	
    private List<PlatRankDataDTO> getPlatRankData(){
    	
    	List<PlatRankDataDTO> list = new ArrayList<>();
    	
    	for (int k=1;k<6;k++) {
    		PlatRankDataDTO dto = new PlatRankDataDTO();
    		
    		dto.setAmount(k*3);
    		dto.setIncome_rate(k*4);
    		dto.setLoan_period(k*5);
    		dto.setPlat_name("平台名称"+k);
    		dto.setRank(k);
    		dto.setStay_still_of_total(k*9);
    		list.add(dto);
		}
    	
    	return list;
    	
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
	
	
	
	private List<IndustryShanghaiDTO> getIndustry_shanghai(){
    	
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
	

//    /**
//     * 平台名称和公司名称
//     *
//     * @return
//     */
//    public String platFormName( String dataType) {
//        return "[{" +
//                "\"plat_name\":\"来财街\"，" +
//                "\"company_name\":\"阿里路亚上海投资有限公司\"}," +
//                "{" +
//                "\"plat_name\":\"91投\"，" +
//                "\"company_name\":\"上海浙鑫金融有限服务有限公司\"},]";
//    }
//
//    /**
//     * 雷达评分
//     *
//     * @param dataType
//     * @return
//     */
//    @RequestMapping("/radarScore")
//    @ResponseBody
//    public String radarScore(String dataType) {
//        return "{\"plat_name\":\"今日劫财\"," +
//                "\"penalty_cost\":67.25," +
//                "\"info_disclosure\":69.77," +
//                "\"capital\":76.67," +
//                "\"operation\":73.23," +
//                "\"fluidity\":53.33," +
//                "\"dispersion\":71.73}";
//    }

}
