package com.bbd.wtyh.service;

import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.dto.*;

/**
 * @author Ian.Su
 * @since 2016年8月12日 下午2:08:42
 */
public interface PToPMonitorService {


    /**
     * 获取线下理财公司数量
     *
     * @param companyName
     * @return
     */
    Integer getOfflineFinanceNum(String companyName) throws Exception;

    /**
     * 网贷对比数据
     *
     * @return List<IndustryCompareDTO>
     */
    public List<IndustryCompareDTO> getCompareData() throws Exception;


    /**
     * 上海区域发展指数排名
     *
     * @param
     * @return List<AreaIndexDTO>
     */
    public List<AreaIndexDTO> getAreaIndex() throws Exception;


    /**
     * 网贷平台数据展示
     *
     * @return List<PlatRankDataDTO>
     */
    public List<PlatRankDataDTO> getPlatRankData() throws Exception;

    /**
     * 网贷平台企业光谱数据
     *
     * @return
     * @throws Exception
     */
    public Map<Integer, Integer> getPlatRankMapData() throws Exception;


    /**
     * 网贷行业整体数据
     *
     * @return List<IndustryShanghaiDTO>
     */
    public List<IndustryShanghaiDTO> getData() throws Exception;


    /**
     * 网贷行业整体数据-问题平台
     *
     * @return List<IndustryProblemDTO>
     */
    public List<IndustryProblemDTO> getProblemData() throws Exception;


    /**
     * 网贷平台数据 -平台列表（含对应公司及平台logo网址）
     * @return
     * @throws Exception
     *  by cgj
     */
    List<PlatCompanyDTO> getPlatList() throws Exception;

    /**
     * 根据公司名称查询对应的平台列表（数据源来自于网贷之家的线上数据）
     * @param companyName
     * @return
     *  by cgj
     */
    List<PlatCompanyDTO> searchPlatListByCompanyName( String companyName );


    /**
     * p2p行业监测相关接口数据落地
     * @return
     * @throws Exception
     */
    Map pToPMonitorDataLandTask(Integer taskId);


    /**
     * 重新执行失败的数据落地任务
     */
    Map executeFailTaskByTaskId(Integer runMode,Integer oldTaskId,Integer taskId);

}
