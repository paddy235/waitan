package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.BbdSubIndexDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyStaticRiskScoreDO;
import com.bbd.wtyh.domain.SubIndexDO;
import com.bbd.wtyh.mapper.CompanyMapper;
import com.bbd.wtyh.mapper.CompanyStaticRiskScoreMapper;
import com.bbd.wtyh.service.CompanyStaticRiskScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.provider.Sun;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by puyuan on 2017/11/16
 */
@Service
public class CompanyStaticRiskScoreServiceImpl implements CompanyStaticRiskScoreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyStaticRiskScoreServiceImpl.class);
    @Autowired
    private CompanyStaticRiskScoreMapper CompanyStaticRiskScoreMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyStaticRiskScoreMapper companyStaticRiskScoreMapper;

    private static final String NORMAL_HOUSEHOLD_COGNIZANCE = "正常户认定";

    private static final String UNPAID_SOCIAL_SECURITY_FEE = "用人单位欠缴社会保险费，被依法责令限期缴纳信息";

    private static final String DISHONESTY_INFO = "失信被执行人信息";

    private static final String EXPOSURE_STAGE = "民事执行-曝光台";

    private static final String ADMINISTRATIVE_SANCTION = "市场监管类行政处罚（法人）";

    private static final String RESTRICTED_EXIT = "限制出境";

    private static final String LIMITING_HIGH_CONSUMPTION = "限制高消费";

    private static final String ONLINE_RECOVERY ="网上追讨";

    //模型系数数组
    private double[][] bate = {{-4.863,0.540,0.354,-0.478,-1.045,-0.486,0.583,0.935,3.184,1.370,2.474},
            {-5.159,0.604,0.441,-0.549,-1.440,-0.623,0.637,0.831,2.913,0.787,5.452},
            {-4.842,0.415,0.111,-0.579,-0.978,-0.482,0.635,0.862,2.633,1.431,3.481},
            {-5.191,0.390,0.618,-0.568,-1.625,-0.496,0.642,1.316,2.947,0.556,5.245},
            {-4.872,0.358,0.096,-0.543,-0.993,-0.479,0.633,1.047,3.776,1.732,2.491},
            {-4.854,0.476,0.105,-0.523,-0.925,-0.508,0.618,1.182,3.129,1.029,3.036},
            {-4.913,0.351,0.430,-0.561,-1.126,-0.393,0.602,0.983,3.563,1.154,2.950},
            {-5.043,0.503,0.563,-0.461,-1.382,-0.427,0.590,0.983,3.007,1.310,3.551},
            {-4.887,0.355,0.113,-0.436,-1.096,-0.370,0.649,1.145,3.231,0.414,2.068},
            {-5.100,0.502,0.610,-0.502,-1.472,-0.537,0.641,1.034,3.601,1.278,2.375},
            {-4.987,0.430,0.107,-0.557,-1.129,-0.448,0.625,1.065,3.668,1.433,3.044},
            {-4.938,0.450,0.425,-0.487,-1.189,-0.410,0.666,1.047,3.264,0.133,1.960},
            {-4.875,0.398,0.309,-0.465,-1.086,-0.455,0.651,1.079,3.021,0.624,2.422},
            {-4.703,0.454,0.067,-0.398,-0.871,-0.398,0.621,0.464,3.142,0.880,2.680},
            {-4.907,0.471,0.062,-0.504,-0.993,-0.527,0.652,1.161,3.721,1.482,3.425},
            {-4.822,0.348,0.069,-0.497,-0.993,-0.453,0.637,1.061,3.442,1.037,2.538},
            {-4.989,0.440,0.252,-0.435,-1.244,-0.468,0.638,1.230,3.688,0.419,4.639},
            {-4.978,0.580,0.444,-0.436,-1.117,-0.424,0.623,1.081,3.339,1.012,3.231},
            {-4.812,0.468,0.121,-0.471,-0.921,-0.521,0.599,0.848,3.238,1.428,3.030},
            {-4.838,0.470,0.353,-0.452,-0.965,-0.423,0.601,0.989,3.014,1.320,2.332},
            {-4.865,0.551,0.477,-0.394,-1.136,-0.466,0.590,0.811,3.047,0.456,2.005},
            {-4.883,0.551,0.327,-0.432,-0.974,-0.477,0.606,0.970,3.296,1.669,2.658},
            {-4.966,0.471,0.384,-0.526,-1.095,-0.527,0.646,1.164,3.508,1.647,3.778},
            {-4.923,0.520,0.077,-0.527,-0.948,-0.445,0.648,1.186,3.721,1.930,2.341},
            {-4.998,0.473,0.416,-0.559,-1.170,-0.439,0.602,1.216,2.975,0.787,2.725},
            {-4.993,0.431,0.487,-0.569,-1.124,-0.485,0.615,1.192,3.211,1.381,3.860},
            {-4.850,0.523,0.080,-0.458,-0.969,-0.511,0.623,0.891,3.195,1.656,2.088},
            {-5.105,0.448,0.627,-0.432,-1.517,-0.461,0.635,0.941,2.929,1.801,5.297},
            {-5.121,0.530,0.427,-0.376,-1.394,-0.444,0.631,1.228,3.650,1.793,2.444},
            {-5.053,0.501,0.558,-0.512,-1.299,-0.586,0.657,1.077,3.562,1.366,2.625},
    };


    @Override
    public void updateOffLineCompany(String newDataVersion,CompanyStaticRiskScoreDO CompanyStaticRiskScoreDO) {
      /*  //查询最新的版本
        String newDataVersion = CompanyStaticRiskScoreMapper.getNewDataVersion();
        //查询最新版本线下理财企业信息
        List<CompanyStaticRiskScoreDO> offlineCompanyInfo = CompanyStaticRiskScoreMapper.getOfflineCompanyInfo(newDataVersion);
*/
      //5万家白名单企业工信数据有敏感词直接赋值80
        int count = CompanyStaticRiskScoreMapper.getWhiteCompany(CompanyStaticRiskScoreDO.getCompanyId(), RESTRICTED_EXIT, LIMITING_HIGH_CONSUMPTION, ONLINE_RECOVERY);
        if(count > 0){
            CompanyStaticRiskScoreMapper.updateStaticRisk(CompanyStaticRiskScoreDO.getName(), newDataVersion, 80);
        }
        //没有铭感词风险值计算
        float Score = 0;
            //获取指标并且计算风险值
            double P = getTarget(CompanyStaticRiskScoreDO, Score);
            //保留四位小数
            DecimalFormat df = new DecimalFormat("#.0000");
            P =Double.parseDouble(df.format(P)) ;
           int i = CompanyStaticRiskScoreMapper.updateStaticRisk(CompanyStaticRiskScoreDO.getName(), newDataVersion, (float) P);
          LOGGER.info("公司名称："+CompanyStaticRiskScoreDO.getName()+"新版本："+newDataVersion+"静态值："+(float) P+"成功条数："+i);


    }

    @Override
    public SubIndexDO searchSubIndex(String companyName) {
        String newDataVersion = companyStaticRiskScoreMapper.getNewDataVersion();
        CompanyDO companyDO = companyMapper.selectByName(companyName);
        int companyId=companyDO.getCompanyId();
        CompanyStaticRiskScoreDO companyStaticRiskScoreDO = CompanyStaticRiskScoreMapper.findCompany(companyId, newDataVersion);
        SubIndexDO subIndexDo = new SubIndexDO();
        //保留两位小数
        DecimalFormat df = new DecimalFormat("#.00");
        //根据id获取上海的四个指标
        //非正常户认定指标
        int V1 = CompanyStaticRiskScoreMapper.getShanghaitarget(NORMAL_HOUSEHOLD_COGNIZANCE, companyStaticRiskScoreDO.getCompanyId());
        //double V1 = 0;
         subIndexDo.setNormalHousehold(df.format(100/(1+Math.exp(-2*V1+1))));
         subIndexDo.setNormalHouseholdNum(V1);
        //用人单位欠缴社会保险费指标
        int V2 = CompanyStaticRiskScoreMapper.getShanghaitarget(UNPAID_SOCIAL_SECURITY_FEE, companyStaticRiskScoreDO.getCompanyId());
        //double V2 = 1;
        if(V2 == 0){
            V2 = 0;
        }else{
            V2 = 1;
        }
        subIndexDo.setUnpaidInsurancePremium(df.format(100/(1+Math.exp(-5*V2+1))));
        subIndexDo.setUnpaidInsurancePremiumNum(V2);
        //失信曝光指标
        int V3 = CompanyStaticRiskScoreMapper.getShanghaitarget(EXPOSURE_STAGE, companyStaticRiskScoreDO.getCompanyId())+CompanyStaticRiskScoreMapper.getShanghaitarget(DISHONESTY_INFO, companyStaticRiskScoreDO.getCompanyId());
        //double V3 = 1;
        if(V3 == 0){
            V3 = 0;
        }else{
            V3 = 1;
        }
        subIndexDo.setDiscreditExposure(df.format(100/(1+Math.exp(-4*V3+1))));
        subIndexDo.setDiscreditExposureNum(V3);
        //市场监管类行政处罚指标
        int V4 = CompanyStaticRiskScoreMapper.getShanghaitarget(ADMINISTRATIVE_SANCTION, companyStaticRiskScoreDO.getCompanyId());
        //double V4 = 1;
        subIndexDo.setAdministrativeSanction(df.format(100/(1+Math.exp(-5*V4+1))));
        subIndexDo.setAdministrativeSanctionNum(V4);

        //信用信息风险
        //限制出境条数
        int restrictedExit = CompanyStaticRiskScoreMapper.getCreditInformationRisk(companyId, RESTRICTED_EXIT);
        subIndexDo.setRestrictedExit(restrictedExit);
        //限制高消费
        int LimetingHighConsumption = CompanyStaticRiskScoreMapper.getCreditInformationRisk(companyId, LIMITING_HIGH_CONSUMPTION);
        subIndexDo.setLimetingHighConsumption(LimetingHighConsumption);
        //网上追讨
        int onlineRecovery = CompanyStaticRiskScoreMapper.getCreditInformationRisk(companyId, ONLINE_RECOVERY);
        subIndexDo.setOnlineRecovery(onlineRecovery);
        return subIndexDo;
    }

    private double getTarget(CompanyStaticRiskScoreDO companyStaticRiskScoreDO,float Score) {

        //实际控制人风险
        double s = companyStaticRiskScoreDO.getReal_control_risk_v2();
        //double s = 1.5;
        //关联方中心积聚化风险
        double z = companyStaticRiskScoreDO.getRelation_in_risk_v2();
        //double z = 0;
        //非法融资衍生风险
        double f = companyStaticRiskScoreDO.getIllegal_financing_risk_v2();
        //double f = 0;
        //短期逐利风险
        double d = companyStaticRiskScoreDO.getShort_risk_v2();
        //double d = 0;
        //非法融资违规风险
        double w = companyStaticRiskScoreDO.getIllegal_money_financing_risk_v2();
        //double w = 1;
        //人才结构风险
        double r = companyStaticRiskScoreDO.getPerson_structure_risk_v2();
        //double r = 100;


        //计算子指标值保存数据库
        CalculationSubIndex(s,z,f,d,w,r);


        //根据id获取上海的四个指标
        //非正常户认定指标
        int V1 = CompanyStaticRiskScoreMapper.getShanghaitarget(NORMAL_HOUSEHOLD_COGNIZANCE, companyStaticRiskScoreDO.getCompanyId());
        //int V1 = 0;

        //用人单位欠缴社会保险费指标
        int V2 = CompanyStaticRiskScoreMapper.getShanghaitarget(UNPAID_SOCIAL_SECURITY_FEE, companyStaticRiskScoreDO.getCompanyId());
        //int V2 = 1;
        if(V2 == 0){
            V2 = 0;
        }else{
            V2 = 1;
        }
        //失信曝光指标
        int V3 = CompanyStaticRiskScoreMapper.getShanghaitarget(EXPOSURE_STAGE, companyStaticRiskScoreDO.getCompanyId())+CompanyStaticRiskScoreMapper.getShanghaitarget(DISHONESTY_INFO, companyStaticRiskScoreDO.getCompanyId());
       // int V3 = 1;
        if(V3 == 0){
            V3 = 0;
        }else{
            V3 = 1;
        }
        //市场监管类行政处罚指标
        int V4 = CompanyStaticRiskScoreMapper.getShanghaitarget(ADMINISTRATIVE_SANCTION, companyStaticRiskScoreDO.getCompanyId());
        //int V4 = 1;
        //初始化指标
        double P = InitializationTarget(s, z, f, d, w, r, V1, V2, V3, V4);

        return P ;
    }

    private void CalculationSubIndex(double s, double z, double f, double d, double w, double r) {
        //保留两位小数
        DecimalFormat df = new DecimalFormat("#.00");
        BbdSubIndexDO bbdSubIndexDO = new BbdSubIndexDO();
        s = Double.parseDouble(df.format(100/(1+Math.exp(-3*s+2))));
        f = Double.parseDouble(df.format(100/(1+Math.exp(6*f-6))));
        w = Double.parseDouble(df.format(100-200/(1+Math.exp(20*Math.pow(w-0.33,2)))));
        r = Double.parseDouble(df.format(100/(1+Math.exp(-5*r/100+1))));
        z = Double.parseDouble(df.format(100/(1+Math.exp(-1*z+1))));
        d = Double.parseDouble(df.format(100/(1+Math.exp(5*d-2))));
        bbdSubIndexDO.setReal_control_risk((float) s);
        bbdSubIndexDO.setIllegal_financing_risk((float) f);
        bbdSubIndexDO.setIllegal_money_financing_risk((float)w);
        bbdSubIndexDO.setPerson_structure_risk((float)r);
        bbdSubIndexDO.setRelation_in_risk((float)z);
        bbdSubIndexDO.setShort_risk((float)d);
        //存储新计算的bbd留个风险子指标
        CompanyStaticRiskScoreMapper.updateSubIndex(bbdSubIndexDO);

    }

    private double ProbabilityCalculation(double s, double z, double f, double d, double w, double r, int v1, int v2, int v3, int v4) {
        double[] Data = {s,z,f,d,w,r,v1,v2,v3,v4};
        double P =0;
        //三十组系数求p取平均
        for (int i = 0 ; i < 30 ; i++){
            double p = (bate[i][0]+bate[i][1]*Data[0]+bate[i][2]*Data[1]+bate[i][3]*Data[2]+bate[i][4]*Data[3]+bate[i][5]*Data[4]+bate[i][6]*Data[5]+bate[i][7]*Data[6]+bate[i][8]*Data[7]+bate[i][9]*Data[8]+bate[i][10]*Data[9]);
            p = Math.exp(p)/(1+Math.exp(p));
            P += p ;
        }
        P = P/30;

        return P ;
    }

    private double InitializationTarget(double s, double z, double f, double d, double w, double r, int v1, int v2, int v3, int v4) {
        double[] Mean = {1.115,  0.204,  0.723,  0.203,  0.621,   7.653};
        double[] Var = {0.379,  1.889,  0.548,  0.402,  0.313,  25.801};
        s = (s - Mean[0])/Var[0];
        z = (z - Mean[1])/Var[1];
        f = (f - Mean[2])/Var[2];
        d = (d - Mean[3])/Var[3];
        w = (w - Mean[4])/Var[4];
        r = (r - Mean[5])/Var[5];
        //保留8位小数
        DecimalFormat df = new DecimalFormat("#.00000000");
        s =Double.parseDouble(df.format(s));
        z =Double.parseDouble(df.format(z));
        f =Double.parseDouble(df.format(f));
        d =Double.parseDouble(df.format(d));
        w =Double.parseDouble(df.format(w));
        r =Double.parseDouble(df.format(r));

        //概率计算
        double P = ProbabilityCalculation(s, z, f, d, w, r, v1, v2, v3, v4);
        //分值转换
        P = Math.pow(P , 0.2)*100;

        return P ;
    }
}
