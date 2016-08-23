package com.bbd.wtyh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbd.wtyh.domain.AreaDO;
import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyAnalysisResultDO;
import com.bbd.wtyh.domain.CompanyNewsDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;
import com.bbd.wtyh.service.AreaService;
import com.bbd.wtyh.service.CompanyNewsService;
import com.bbd.wtyh.service.ParkService;
import com.bbd.wtyh.web.ResponseBean;


/**
* 园区相关接口
* @author Ian.Su
* @since 2016年8月5日 上午11:55:20
*/
@Controller
@RequestMapping("/park")
public class ParkController {

    @Autowired
    private AreaService areaService;
    
    @Autowired
    private ParkService parkService;
    



    /**
    *
    * 获取区域信息
    * @return ResponseBean
    */
    @RequestMapping("/areaList")
    @ResponseBody
    public ResponseBean areaList() {

        List<AreaDO> data = areaService.areaList();

        return ResponseBean.successResponse(data);
    }
    
    
    /**
    * 根据园区查询类金融企业集中度  与 楼宇列表 共用接口
    * @param areaId 区域id,必传
    * @return ResponseBean  
    */
    @RequestMapping("/companyConcentration")
    @ResponseBody
    public ResponseBean oncentration(@RequestParam(required=true) Integer areaId) {

        List<BuildingDO> data = parkService.queryBuildings(areaId);
        
        return ResponseBean.successResponse(data);
    }
    
    
    
    /**
    * 在营时间分布
    * @param areaId 区域id,必传
    * @return ResponseBean  
    */
    @RequestMapping("/inBusiness")
    @ResponseBody
    public ResponseBean inBusiness(@RequestParam(required=true) Integer areaId) {

        List<InBusinessDO> data = parkService.inBusiness(areaId);
        
        return ResponseBean.successResponse(data);
    }
    
    
    /**
    * 园区舆情查询
    * @param areaId 区域id,必传
    * @return ResponseBean  
    */
    @RequestMapping("/news")
    @ResponseBody
    public ResponseBean news(@RequestParam(required=true) Integer areaId) {

        Object data = parkService.queryParkNews(areaId,20,1);
        
        return ResponseBean.successResponse(data);
    }
    
    
    /**
     * 园区行业分布
     * @param areaId 区域id,必传
     * @return ResponseBean  
     */
     @RequestMapping("/businessDistribute")
     @ResponseBody
     public ResponseBean businessDistribute(@RequestParam(required=true) Integer areaId) {

    	 List<CompanyTypeCountDO> data = parkService.businessDistribute(areaId);
         
         return ResponseBean.successResponse(data);
     }
     
     /**
      * 园区图片
      * @param areaId 区域id,必传
      * @return ResponseBean  
      */
      @RequestMapping("/parkImg")
      @ResponseBody
      public ResponseBean parkImg(@RequestParam(required=true) Integer areaId) {

          Object data = parkService.parkImg(areaId);
          
          return ResponseBean.successResponse(data);
      }
    
      
      
      /**
       * 楼宇企业列表
       * @param buildingId 楼宇id,必传
       * @param orderField 排序字段，非必须，默认按行业，值范围[1 ,2，3，4，5]：
       *                                              1：行业
       *                                              2：注册资本
       *                                              3：企业背景
       *                                              4：注册时间
       *                                              5：企业类型
       * @param descAsc    排序方式：desc:降序，asc:升序
       * @return ResponseBean  
       */
       @RequestMapping("/buildingCompany")
       @ResponseBody
       public ResponseBean buildingCompany(@RequestParam(required=true) Integer buildingId,Integer orderField,String descAsc) {

           Object data = parkService.buildingCompany(buildingId,orderField,descAsc);
           
           return ResponseBean.successResponse(data);
       }
       
       
       /**
        * 楼宇行业分布
        * @param buildingId 楼宇id,必传
        * @return ResponseBean  
        */
        @RequestMapping("/buildingBusinessDistribute")
        @ResponseBody
        public ResponseBean buildingBusinessDistribute(@RequestParam(required=true) Integer buildingId) {

        	List<CompanyTypeCountDO> data = parkService.buildingBusinessDistribute(buildingId);
            
            return ResponseBean.successResponse(data);
        }
        
        /**
         * 企业背景情况
         * @param buildingId 楼宇id,必传
         * @return ResponseBean  
         */
         @RequestMapping("/buildingBackground")
         @ResponseBody
         public ResponseBean buildingBackground(@RequestParam(required=true) Integer buildingId) {

         	List<CompanyTypeCountDO> data = parkService.buildingBackground(buildingId);
             
            return ResponseBean.successResponse(data);
         }
         
         /**
          * 楼宇舆情
          * @param buildingId 楼宇id,必传
          * @return ResponseBean  
          */
          @RequestMapping("/buildingNews")
          @ResponseBody
          public ResponseBean buildingNews(@RequestParam(required=true) Integer buildingId) {

          	 String data = parkService.buildingNews(buildingId);
              
             return ResponseBean.successResponse(data);
          }
          
          /**
           * 已出风险企业
           * @param buildingId 楼宇id,必传
           * @return ResponseBean  
           */
           @RequestMapping("/buildingRisk")
           @ResponseBody
           public ResponseBean buildingRisk(@RequestParam(required=true) Integer buildingId) {

           	  List<CompanyAnalysisResultDO> data = parkService.queryRiskByBuilding(buildingId);
               
              return ResponseBean.successResponse(data);
           }
         
        
   
}
