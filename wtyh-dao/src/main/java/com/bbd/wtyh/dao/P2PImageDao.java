package com.bbd.wtyh.dao;

import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.bbdAPI.BaseDataDO;
import com.bbd.wtyh.domain.bbdAPI.ZuZhiJiGoudmDO;
import com.bbd.wtyh.domain.wangDaiAPI.*;

import java.util.List;
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
     *
     * @param platName
     * @return 舆情信息
     */
    YuQingDTO platformConsensus(String platName);

    Map<String, Object> lawsuitMsg(String company);

    Map<String, Object> radarScore(String plat_name);

    List<PlatListDO> baseInfoWangDaiApi();
    List<PlatListDO> baseInfoWangDaiApiFromNet();

    BaseDataDO baseInfoBBDData(String companyName);

    ZuZhiJiGoudmDO baseInfoZuZhiJiGou(String companyName);

    Map<String, Object> coreDataInfo(String platName);

    /**
     * 获取 p2p平台核心数据
     *
     * @param platName 核心数据
     * @return
     */
    PlatDataDO getPlatData(String platName);

    /**
     * 监测是否有要查询的公司
     *
     * @param platName
     * @return
     */
    PlatformNameInformationDO hasOrNotCompany(String platName);

    /**
     * 企业logo
     * @param platName
     * @return
     */
    PlatListDO wangDaiLogo(String platName);

    /**
     * 联想  平台名称
     * @param platName
     * @return
     */
    List<PlatformNameInformationDO> associatedPlatName(String platName);

    /**
     * 联想  公司名称
     * @param platName
     * @return
     */
    List<PlatformNameInformationDO> associatedCompanyName(String platName, Integer limit_size);



    RadarScoreDTO getRadarScore(String platName) throws Exception;


    PlatCoreDataDTO getPlatCoreData(String platName) throws Exception;
}
