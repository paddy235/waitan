package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.bbdAPI1.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI1.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.SearchCompanyDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDO;

import java.util.Map;

/**
 * p2p检测平台dao层接口
 *
 * @author wangchenge
 * @since 2016.08.05
 */
public interface P2PImageDao {
    /**
     * 舆情信息
     * @return 舆情信息
     * @param platName
     */
    YuQingDO platformConsensus(String platName);

    Map<String, Object> lawsuitMsg(String company);

    Map<String, Object> radarScore(String plat_name);

    Map<String, Object> baseInfoWangDaiApi(String platName);

    BaseDataDO baseInfoBBDData(String companyName);

    ZuZhiJiGoudmDO baseInfoZuZhiJiGou(String companyName);

    Map<String, Object> coreDataInfo(String platName);

    /**
     * 获取 p2p平台核心数据
     * @param platName  核心数据
     * @return
     */
    PlatDataDO getPlatData(String platName);

    /**
     * 监测是否有要查询的公司
     * @param plat_name
     * @return
     */
    SearchCompanyDO hasOrNotCompany(String plat_name);
}
