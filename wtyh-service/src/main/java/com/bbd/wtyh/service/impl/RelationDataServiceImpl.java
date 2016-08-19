package com.bbd.wtyh.service.impl;


import com.bbd.wtyh.common.Constants;
import com.bbd.wtyh.domain.vo.DynamicRiskIndexVO;
import com.bbd.wtyh.domain.vo.DynamicRiskVO;
import com.bbd.wtyh.domain.vo.RelationDataIndexVO;
import com.bbd.wtyh.domain.vo.RelationDataVO;
import com.bbd.wtyh.mapper.DynamicRiskMapper;
import com.bbd.wtyh.mapper.RelationDataMapper;

import com.bbd.wtyh.mapper.StaticRiskMapper;
import com.bbd.wtyh.service.RelationDataService;
import com.bbd.wtyh.service.impl.relation.common.APIConstants;
import com.bbd.wtyh.service.impl.relation.exception.BbdException;
import com.bbd.wtyh.service.impl.relation.param.RelatedParameters;
import com.bbd.wtyh.util.RelationDataUtils;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author tracy zhou
 * @since  2016.08.13
 */
@Service("relationDataService")
public class RelationDataServiceImpl implements RelationDataService {

    private Logger logger = LoggerFactory.getLogger(RelationDataServiceImpl.class);
    @Autowired
    private RelationDataMapper relationDataMapper;
    @Autowired
    private DynamicRiskMapper dynamicRiskMapper;
    @Autowired
    private StaticRiskMapper staticRiskMapper;

    /**
     * 比较两个月份的关联方数据
     * @param companyName
     * @param currentMonth
     * @param compareMonth
     * @return
     */
    public RelationDataVO compareRelationData(String companyName, String areaCode, String currentMonth, String compareMonth)
    {
        RelationDataVO vo = new RelationDataVO();
        Date m1 = getMonthDate(currentMonth);
        Date m2 = getMonthDate(compareMonth);
        String cur = currentMonth;
        String cpr = compareMonth;
        if(m2.before(m1))
        {
            currentMonth = cpr;
            compareMonth = cur;
        }
        Map<String, Object> params1 = new HashMap<String, Object>();
        params1.put("companyName", companyName);
        params1.put("dataVersion", currentMonth);
        params1.put("areaCode", areaCode);
        RelationDataIndexVO currentRelationData = relationDataMapper.getRelationData(params1);
        DynamicRiskIndexVO currentDynamicRisk = dynamicRiskMapper.queryDynamicRisk(params1);

        Map<String, Object> params2 = new HashMap<String, Object>();
        params2.put("companyName", companyName);
        params2.put("dataVersion", compareMonth);
        params2.put("areaCode",areaCode);
        RelationDataIndexVO compareRelationData = relationDataMapper.getRelationData(params2);
        DynamicRiskIndexVO compareDynamicRisk = dynamicRiskMapper.queryDynamicRisk(params2);

        if(currentRelationData==null || compareRelationData==null)
        {
            System.out.println("关联方数据不存在");
            throw new BbdException("关联方数据不存在",true);
            //return null;
        }
        if(currentDynamicRisk==null || compareDynamicRisk==null)
        {
            System.out.println("动态指标数据不存在");
            throw new BbdException("动态指标数据不存在",true);
            //return null;
        }
        try {
            vo = RelationDataUtils.compareRelationData(currentRelationData, compareRelationData);
            vo = RelationDataUtils.addAgreeActionProp(vo,currentDynamicRisk,compareDynamicRisk);
            vo.setCurrentMonth(currentMonth);
            vo.setCompareMonth(compareMonth);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return vo;
    }
    /**
     * 平台稳态运营风险
     * @param curDynamicRisk
     * @param cprDynamicRisk
     * @return
     */
    private double getSteadyOperationRisk(DynamicRiskIndexVO curDynamicRisk,DynamicRiskIndexVO cprDynamicRisk)
    {
        //当前自然人节点总数
        int x1 = curDynamicRisk.getPersonNum();
        //比较自然人节点总数
        int x2 = cprDynamicRisk.getPersonNum();
        //当前企业法人节点总数
        int y1 = curDynamicRisk.getCompanyNum();
        //比较企业法人节点总数
        int y2 = cprDynamicRisk.getCompanyNum();
        //自然人节点增长率
        double x = (x2-x1)/(double)x1;
        //企业法人节点增长率
        double y = (y2-y1)/(double)y1;

        double p = 10*((double)x+y)/2;
        DecimalFormat df = new DecimalFormat("#.0");
        Double result = Double.parseDouble(df.format(p));
        if(result>15)
        {
            result = 15.0;
        }else if(result <= 0.0)
        {
            result = 0.0;
        }
        return result;

    }
    /**
     * 平台可持续性风险
     * @param curDynamicRisk
     * @param cprDynamicRisk
     * @return
     */
    private double getsustainableRisk(DynamicRiskIndexVO curDynamicRisk,DynamicRiskIndexVO cprDynamicRisk)
    {
        //当前利益一致行动法人数量占关联企业数量总和的比
        float x = curDynamicRisk.getAgreeActProp();
        //比较利益一致行动法人数量占关联企业数量总和的比
        float y = cprDynamicRisk.getAgreeActProp();
        Double result = 0.0;
        if(x!=0){
            double c = 4*y/x;
            DecimalFormat df = new DecimalFormat("#.0");
            result = Double.parseDouble(df.format(c));
            if(result>15)
            {
                result = 15.0;
            }else if(result <= 0.0)
            {
                result = 0.0;
            }
        }
        return result;
    }
    /**
     * 平台泡沫化风险
     * @param curDynamicRisk
     * @param cprDynamicRisk
     * @return
     */
    private double getfoamRisk(DynamicRiskIndexVO curDynamicRisk,DynamicRiskIndexVO cprDynamicRisk)
    {
        //当前 一度二度关联法人数量
        int x = curDynamicRisk.getOneTwoCompanyNum();
        //比较一度二度关联法人数量
        int y = cprDynamicRisk.getOneTwoCompanyNum();
        double p = 0.0;
        Double result = 0.0;
        if(x!=0)
        {
            p = 15*((double)y-x)/x;
        }
        DecimalFormat df = new DecimalFormat("#.0");
        result = Double.parseDouble(df.format(p));
        if(result>15)
        {
            result = 15.0;
        }else if(result <= 0.0)
        {
            result = 0.0;
        }
        return result;
    }
    /**
     * 平台核心资本运营风险
     * @param curDynamicRisk
     * @param cprDynamicRisk
     * @return
     */
    private double getCoreCapitalOperationRisk(DynamicRiskIndexVO curDynamicRisk,DynamicRiskIndexVO cprDynamicRisk)
    {
        //核心自然人前三控制节点总数
        int x = 0;
        Double result = 0.0;
        String[] curControlNum = curDynamicRisk.getControlNum().split("\\|");
        for(int i =0;i<curControlNum.length;i++)
        {
            x += Integer.parseInt(curControlNum[i]);
        }
        //核心自然人前三控制节点总数
        int y = 0;
        String[] cprControlNum = cprDynamicRisk.getControlNum().split("\\|");
        for(int i =0;i<cprControlNum.length;i++)
        {
            y += Integer.parseInt(cprControlNum[i]);
        }
        if(x != 0)
        {
            double h = 15*((double)y-x)/x;

            DecimalFormat df = new DecimalFormat("#.0");
            result = Double.parseDouble(df.format(h));
            if(result>15)
            {
                result = 15.0;
            }else if(result <= 0.0)
            {
                result = 0.0;
            }
        }

        return result;
    }
    /**
     * 平台传销风险
     * @param curDynamicRisk
     * @param cprDynamicRisk
     * @return
     */
    private double getPyramidSellingRisk(DynamicRiskIndexVO curDynamicRisk,DynamicRiskIndexVO cprDynamicRisk)
    {
        int x = curDynamicRisk.getThreePersonNum();
        int y = cprDynamicRisk.getThreePersonNum();
        double c1 = 0.0;
        Double result = 0.0;
        if(x!=0){
            c1 = 15*((double)y-x)/x;
        }
        DecimalFormat df = new DecimalFormat("#.0");
        result = Double.parseDouble(df.format(c1));
        if(result>15)
        {
            result = 15.0;
        }else if(result <= 0.0)
        {
            result = 0.0;
        }
        return result;
    }
    /**
     * 平台非法融资违约风险
     * @param curDynamicRisk
     * @param cprDynamicRisk
     * @return
     */
    private double getIllegalFundRaisingRisk(DynamicRiskIndexVO curDynamicRisk,DynamicRiskIndexVO cprDynamicRisk)
    {
        int x = curDynamicRisk.getTypeSumNum();

        int y = cprDynamicRisk.getTypeSumNum();

        double w1 = 0.0;
        Double result = 0.0;

        if(x!=0)
        {
            w1 = 15*((double)y-x)/x;
        }
        DecimalFormat df = new DecimalFormat("#.0");
        result = Double.parseDouble(df.format(w1));
        if(result>15)
        {
            result = 15.0;
        }else if(result <= 0.0)
        {
            result = 0.0;
        }
        return result;
    }
    /**
     * 平台跨区域舞弊行为
     * @param curDynamicRisk
     * @param cprDynamicRisk
     * @return
     */
    private double getSteadyStateOperationRisk(DynamicRiskIndexVO curDynamicRisk,DynamicRiskIndexVO cprDynamicRisk)
    {
        int x = 0;
        if(!com.mysql.jdbc.StringUtils.isNullOrEmpty(curDynamicRisk.getAreaCompanyNum()))
        {
            String[] curAreaCompanyNum = curDynamicRisk.getAreaCompanyNum().split("\\|");
            for(int i =0;i<curAreaCompanyNum.length;i++)
            {
                x += Integer.parseInt(curAreaCompanyNum[i]);
            }
        }

        int y = 0;
        if(!com.mysql.jdbc.StringUtils.isNullOrEmpty(cprDynamicRisk.getAreaCompanyNum()))
        {
            String[] cprAreaCompanyNum = cprDynamicRisk.getAreaCompanyNum().split("\\|");
            for(int i =0;i<cprAreaCompanyNum.length;i++)
            {
                y += Integer.parseInt(cprAreaCompanyNum[i]);
            }
        }


        double k = 0.0;
        if(x!=0)
        {
            k = 15*((double)y-x)/x;
        }
        DecimalFormat df = new DecimalFormat("#.0");
        Double result = Double.parseDouble(df.format(k));
        if(result>15)
        {
            result = 15.0;
        }else if(result <= 0.0)
        {
            result = 0.0;
        }
        return result;
    }
    /**
     *
     * BBD 风险
     * @param curDynamicRisk
     * @param cprDynamicRisk
     * @return
     */
    private double getbbdTimeRiskIndex(DynamicRiskIndexVO curDynamicRisk,DynamicRiskIndexVO cprDynamicRisk)
    {
        double r1  = getSteadyOperationRisk(curDynamicRisk,cprDynamicRisk);
        double r2  = getCoreCapitalOperationRisk(curDynamicRisk,cprDynamicRisk);
        double r3  = getsustainableRisk(curDynamicRisk,cprDynamicRisk);
        double r4  = getfoamRisk(curDynamicRisk,cprDynamicRisk);
        double r5  = getPyramidSellingRisk(curDynamicRisk,cprDynamicRisk);
        double r6  = getIllegalFundRaisingRisk(curDynamicRisk,cprDynamicRisk);
        double r7  = getSteadyStateOperationRisk(curDynamicRisk,cprDynamicRisk);
        double r = r1+r2+r3+r4+r5+r6+r7;
        DecimalFormat df = new DecimalFormat("#.0");
        Double result = Double.parseDouble(df.format(r));
        return result;
    }
    @Override
    public DynamicRiskVO compareDynamicRisk(String companyName, String areaCode, String currentMonth, String compareMonth) {
        DecimalFormat fnum  =   new  DecimalFormat("##0.00000");
        Map<String, Object> cur_params = new HashMap<String, Object>();
        //比较两个月份，将时间靠前的作为被比较方，时间靠后的作为比较方
        Date m1 = getMonthDate(currentMonth);
        Date m2 = getMonthDate(compareMonth);
        DynamicRiskIndexVO cur = new DynamicRiskIndexVO();
        DynamicRiskIndexVO cpr = new DynamicRiskIndexVO();
        cur_params.put("companyName", companyName);
        cur_params.put("dataVersion", currentMonth);
        cur_params.put("areaCode", areaCode);
        DynamicRiskIndexVO curDynamicRisk = dynamicRiskMapper.queryDynamicRisk(cur_params);
        Map<String, Object> cpr_params = new HashMap<String, Object>();
        cpr_params.put("companyName", companyName);
        cpr_params.put("dataVersion", compareMonth);
        cpr_params.put("areaCode",areaCode);
        DynamicRiskIndexVO cprDynamicRisk = dynamicRiskMapper.queryDynamicRisk(cpr_params);
        if(m1.before(m2))
        {
            cur = curDynamicRisk;
            cpr = cprDynamicRisk;
        }else
        {
            cur = cprDynamicRisk;
            cpr = curDynamicRisk;
        }
        DynamicRiskVO vo = new DynamicRiskVO();
        double bbdTimeRiskIndex = getbbdTimeRiskIndex(cur,cpr);
        vo.setBbdTimeRiskIndex(bbdTimeRiskIndex);
        double steadyOperationRisk = getSteadyOperationRisk(cur,cpr);
        vo.setSteadyOperationRisk(steadyOperationRisk);
        vo.setCurPersonNum(cur.getPersonNum());
        vo.setCprPersonNum(cpr.getPersonNum());
        vo.setCurCompanyNum(cur.getCompanyNum());
        vo.setCprCompanyNum(cpr.getCompanyNum());
        vo.setCurSumNum(cur.getSumNum());
        vo.setCprSumNum(cpr.getSumNum());
        double coreCapitalOperationRisk = getCoreCapitalOperationRisk(cur,cpr);
        vo.setCoreCapitalOperationRisk(coreCapitalOperationRisk);
        String[] curCorePerLists = cur.getCorePerList().split("\\|");
        List<String> curCorePerList = new ArrayList<String>();
        Collections.addAll(curCorePerList, curCorePerLists);
        vo.setCurCorePersonList(curCorePerList);
        String[] cprCorePerLists = cpr.getCorePerList().split("\\|");
        List<String> cprCorePerList = new ArrayList<String>();
        Collections.addAll(cprCorePerList, cprCorePerLists);
        vo.setCprCorePersonList(cprCorePerList);
        String[] curControlNum = cur.getControlNum().split("\\|");
        List<String> curControlNums = new ArrayList<String>();
        Collections.addAll(curControlNums, curControlNum);
        vo.setCurControlNum(curControlNums);
        String[] cprControlNum = cpr.getControlNum().split("\\|");
        List<String> cprControlNums = new ArrayList<String>();
        Collections.addAll(cprControlNums, cprControlNum);
        vo.setCprControlNum(cprControlNums);
        double sustainableRisk = getsustainableRisk(cur,cpr);
        vo.setSustainableRisk(sustainableRisk);
        vo.setCurAgreeActNum(cur.getAgreeActNum());
        vo.setCprAgreeActNum(cpr.getAgreeActNum());

        Float curAgreeActProp = Float.parseFloat(fnum.format(cur.getAgreeActProp()));
        vo.setCurAgreeActProp(Math.round(curAgreeActProp*Constants.INT10000)/Constants.INT100);  //2015年1月5日修改  占比变为百分比
        Float cprAgreeActProp = Float.parseFloat(fnum.format(cpr.getAgreeActProp()));
        vo.setCprAgreeActProp(Math.round(cprAgreeActProp*Constants.INT10000)/Constants.INT100);  //2015年1月5日修改  占比变为百分比
        String[] curAgreeComDet = cur.getAgreeComDet().split("\\|");
        List<String> curAgreeComDets = new ArrayList<String>();
        Collections.addAll(curAgreeComDets, curAgreeComDet);
        vo.setCurAgreeComDet(curAgreeComDets);
        String[] cprAgreeComDet = cpr.getAgreeComDet().split("\\|");
        List<String> cprAgreeComDets = new ArrayList<String>();
        Collections.addAll(cprAgreeComDets, cprAgreeComDet);
        vo.setCprAgreeComDet(cprAgreeComDets);
        double foamRisk = getfoamRisk(cur,cpr);
        vo.setFoamRisk(foamRisk);
        vo.setCurOneTwoComapnyNum(cur.getOneTwoCompanyNum());
        vo.setCprOneTwoComapnyNum(cpr.getOneTwoCompanyNum());
        Float curOneTwoCompanyProp = Float.parseFloat(fnum.format(cur.getOneTwoCompanyProp()));
        vo.setCurOneTwoCompanyProp(Math.round(curOneTwoCompanyProp*Constants.INT10000)/Constants.INT100);  //2015年1月5日修改  占比变为百分比
        Float cprOneTwoCompanyProp = Float.parseFloat(fnum.format(cpr.getOneTwoCompanyProp()));
        vo.setCprOneTwoCompanyProp(Math.round(cprOneTwoCompanyProp*Constants.INT10000)/Constants.INT100);  //2015年1月5日修改  占比变为百分比
        double pyramidSellingRisk = getPyramidSellingRisk(cur,cpr);
        vo.setPyramidSellingRisk(pyramidSellingRisk);
        vo.setCurThreePersonNum(cur.getThreePersonNum());
        vo.setCprThreePersonNum(cpr.getThreePersonNum());
        Float curThreePersonProp = Float.parseFloat(fnum.format(cur.getThreePersonProp()));
        vo.setCurThreePersonProp(Math.round(curThreePersonProp*Constants.INT10000)/Constants.INT100);  //2015年1月5日修改  占比变为百分比
        Float cprThreePersonProp = Float.parseFloat(fnum.format(cpr.getThreePersonProp()));
        vo.setCprThreePersonProp(Math.round(cprThreePersonProp*Constants.INT10000)/Constants.INT100);  //2015年1月5日修改  占比变为百分比
        double IllegalFundRaisingRisk = getIllegalFundRaisingRisk(cur,cpr);
        vo.setIllegalFundRaisingRisk(IllegalFundRaisingRisk);
        vo.setCurTypeSumNum(cur.getTypeSumNum());
        vo.setCprTypeSumNum(cpr.getTypeSumNum());
        Float curTypeSumProp = Float.parseFloat(fnum.format(cur.getTypeSumProp()));
        vo.setCurTypeSumProp(Math.round(curTypeSumProp*Constants.INT10000)/Constants.INT100);  //2015年1月5日修改  占比变为百分比
        Float cprTypeSumProp = Float.parseFloat(fnum.format(cpr.getTypeSumProp()));
        vo.setCprTypeSumProp(Math.round(cprTypeSumProp*Constants.INT10000)/Constants.INT100);  //2015年1月5日修改  占比变为百分比
        String[] curCompanyDetail = cur.getCompanyDetail().split("\\|");
        List<String> curCompanyDetails = new ArrayList<String>();
        Collections.addAll(curCompanyDetails, curCompanyDetail);
        vo.setCurCompanyDetail(curCompanyDetails);
        String[] cprCompanyDetail = cpr.getCompanyDetail().split("\\|");
        List<String> cprCompanyDetails = new ArrayList<String>();
        Collections.addAll(cprCompanyDetails, cprCompanyDetail);
        vo.setCprCompanyDetail(cprCompanyDetails);
        double steadyStateOperationRisk = getSteadyStateOperationRisk(cur,cpr);
        vo.setSteadyStateOperationRisk(steadyStateOperationRisk);
        String[] curAreaList = cur.getAreaList().split("\\|");
        List<String> curAreaLists = new ArrayList<String>();
        Collections.addAll(curAreaLists, curAreaList);
        vo.setCurAreaList(curAreaLists);
        String[] cprAreaList = cpr.getAreaList().split("\\|");
        List<String> cprAreaLists = new ArrayList<String>();
        Collections.addAll(cprAreaLists, cprAreaList);
        vo.setCprAreaList(cprAreaLists);
        String[] curAreaCompanyNum = cur.getAreaCompanyNum().split("\\|");
        List<String> curAreaCompanyNums = new ArrayList<String>();
        Collections.addAll(curAreaCompanyNums, curAreaCompanyNum);
        vo.setCurAreaCompanyNum(curAreaCompanyNums);
        String[] cprAreaCompanyNum = cpr.getAreaCompanyNum().split("\\|");
        List<String> cprAreaCompanyNums = new ArrayList<String>();
        Collections.addAll(cprAreaCompanyNums, cprAreaCompanyNum);
        vo.setCprAreaCompanyNum(cprAreaCompanyNums);
        return vo;
    }

    @Override
    public List<String> queryDateVersion(String companyName, String areaCode) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("companyName", companyName);
        params.put("areaCode", areaCode);
        return staticRiskMapper.queryDateVersion(params);
    }


    public Date getMonthDate(String dataVersionString)
    {
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            if (!StringUtils.isEmpty(dataVersionString)) {
                date = dateformat.parse(dataVersionString);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
