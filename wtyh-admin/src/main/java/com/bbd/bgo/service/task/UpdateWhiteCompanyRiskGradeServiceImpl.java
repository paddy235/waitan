package com.bbd.bgo.service.task;

import com.bbd.wtyh.core.base.BaseService;
import com.bbd.wtyh.mapper.UpdateWhiteCompanyRiskGradeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:WLL
 * @Date:Create on 9:562017/11/21
 */
@Service
public class UpdateWhiteCompanyRiskGradeServiceImpl implements UpdateWhiteCompanyRiskGradeService{
    private static final Logger logger = LoggerFactory.getLogger(UpdateWhiteCompanyRiskGradeServiceImpl.class);

    @Autowired
    @Qualifier(value = "baseServiceImpl")
    private BaseService baseService;
    @Autowired
    private UpdateWhiteCompanyRiskGradeMapper updateWhiteGradeMapper;
    //白名单企业名称
    List<String> companyNames = new ArrayList<>();
    //5万家白名单企业的公信中心数据包含：限制出境、限制高消费和网上追讨的公司名单
    List<String> creditNames = new ArrayList<>();
    //前1~200家企业名单
    List<String> names1 = new ArrayList<>();
    //201~1000家企业名单
    List<String> names2 = new ArrayList<>();

    //5万家白名单企业风险等级更新
    @Override
    public  void startUpdate(){
        logger.info("白名单企业风险等级更新开始");

        companyNames = updateWhiteGradeMapper.WhiteCompanyList();
        logger.info("白名单企业共有："+companyNames.size());

        if(companyNames==null ||companyNames.isEmpty()){
            logger.info("白名单为空！");
            return ;
        }

        creditNames = updateWhiteGradeMapper.query_raw_info();
        logger.info("企业的公信中心数据中包含：限制出境、限制高消费和网上追讨 的企业数："+creditNames.size());

        names1 = updateWhiteGradeMapper.find(0,200);
        logger.info(names1.size()+"");

        names2 = updateWhiteGradeMapper.find(200,800);
        logger.info(names2.size()+"");


        //5万家企业进行等级划分。前1~200家为重点关注企业，201~1000家为一般关注企业，其他为正常企业
        for (String name :companyNames) {
            //前1~200家为重点关注企业
            if(names1!=null && !names1.isEmpty()&&names1.contains(name)){
                //更新company重点关注企业
                this.updateWhiteGradeMapper.updateCompanyRisk_level(name,2);
                continue;
            }
            //201~1000家为一般关注企业
            if(names2!=null && !names2.isEmpty()&&names2.contains(name)){
                //更新company一般关注企业
                this.updateWhiteGradeMapper.updateCompanyRisk_level(name,3);
                continue;
            }
            //其他为正常企业
            this.updateWhiteGradeMapper.updateCompanyRisk_level(name,4);
        }

        //公信中心数据中包含：限制出境、限制高消费和网上追讨三类数据任何一类，则企业风险等级直接赋值为“重点关注”
        if(creditNames!=null && !creditNames.isEmpty()){
            for(String c_name:creditNames){
                this.updateWhiteGradeMapper.updateCompanyRisk_level(c_name,2);
            }
        }

        logger.info("白名单企业风险等级更新结束");
    }
}
