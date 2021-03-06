package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.domain.EasyExport.WaiTanData;
import com.bbd.wtyh.domain.EasyExport.WangdaiData;
import com.bbd.wtyh.domain.PlatCoreDataDO;
import com.bbd.wtyh.domain.PlatformNameInformationDO;
import com.bbd.wtyh.domain.TaskResultDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatDataDO;
import com.bbd.wtyh.domain.wangDaiAPI.PlatListDO;
import com.bbd.wtyh.domain.wangDaiAPI.YuQingDTO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;

import java.util.List;
import java.util.Map;

/**
 * P2P平台状态业务层接口
 *
 * @author wangchenge
 * @since 2016.8.5
 */
public interface P2PImageService {
    /**
     *
     * @param platName
     * @return
     */
    PlatDataDO getPlatData(String platName);

    /**
     * P2P 获取平台名称
     *
     * @return
     */
    PlatCoreDataDO getPlatCoreData(String platName);

    /**
     * P2P检测平台状态信息
     *
     * @return
     */
    Map<String, Object> platFormStatus(String platName);

    /**
     * 从网贷之家的 平台列表 找出指定的平台
     *
     * @return
     */
    PlatListDO findFromWangdaiPlatList(String platName);

    /**
     * 获取 网贷之家 平台列表 list
     *
     * @return
     */
    Map<String, PlatListDO> getWangdaiPlatList();

    /**
     * 舆情信息
     *
     * @param platName
     * @return
     */
    YuQingDTO platformConsensus(String platName);

    /**
     * 诉讼信息
     *
     * @return
     */
    Map<String, Object> lawsuitMsg(String platName);

    /**
     * 雷达评分
     *
     * @return
     */
    Map<String, Object> radarScore(String plat_name);

    String findCompanyNameFromDbThenAPI(String platName, Map<String, PlatListDO> wangdaiList);

    Map<String, Object> baseInfo(String platName);

    Map<String, Object> coreDataInfo(String platName);

    List<List<String>> coreDataDealTrend(String platNmae);

    List<PlatformNameInformationDO> queryPlatFromPlatList(String platName);

    List<List<String>> coreDataInterestRateTrend(String plat_name);

    List<List<String>> coreDataLoadOverage(String plat_name);

    PlatformNameInformationDO hasOrNotCompany(String plat_name);

    /**
     * 根据用户输入，联想 平台名称，以及公司名称
     *
     * @param platName
     * @return
     */
    List<PlatformNameInformationDO> associatedCompanys(String platName);

    /**
     * 平台画像相关接口数据落地
     *
     * @return
     */
    TaskResultDO p2pImageDataLandTask(Integer taskId);

    /**
     * 重新执行数据落地失败任务
     *
     * @param runMode
     * @param oldTaskId
     * @param taskId
     * @return
     */
    TaskResultDO executeFailTaskByTaskId(Integer runMode, Integer oldTaskId, Integer taskId);

    PlatListDO getWangdaiCompanyList(String name);

    List<WangdaiData> getWangdai(ExportCondition exportCondition, PageBean pagination);

    List<WaiTanData> getWaiTanOther(ExportCondition exportCondition, PageBean pagination);

    void recordWangdai(WangdaiModify companyInfo);

    /**
     * 手动终止正在执行的任务
     */
    void stopTask();
}
