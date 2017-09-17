package com.bbd.wtyh.service.shiro;

import com.bbd.wtyh.domain.BuildingDO;
import com.bbd.wtyh.domain.CompanyBuildingDO;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.ParkDO;
import com.bbd.wtyh.domain.vo.ParkAndBuildingVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/13 0013.
 */
public interface ParkMgtService{

    /**
     * 园区列表
     * @return
     */
    List<ParkDO> queryParkList();

    /**
     * 楼宇列表
     * @param parkId
     * @param buildingName
     * @return
     */
    List<Map<String,String>> queryBuildingList(String parkId,String buildingName);

    /**
     * 园区楼宇列表
     * @param parkId 园区ID
     * @param buildingName 楼宇名称
     * @return
     */
    List<ParkAndBuildingVO> queryParkAndBuilding(String parkId,String buildingName);

    /**
     * 查询楼宇企业信息
     * @param buildingId 楼宇ID
     * @return
     */
    List<CompanyDO> queryCompanyByBuildingId(String buildingId);

    /**
     * 根据园区ID查询楼宇
     * @param parkId
     * @return
     */
    List<Map<String,String>> queryBuildingByParkId(String parkId);

    /**
     * 修改园区
     * @param park
     */
    void updateParkAreaId(ParkDO park);

    /**
     * 删除园区
     * @param parkId
     */
    void delParkById(String parkId) throws Exception;

    /**
     * 删除楼宇
     * @param buildingId
     */
    void delBuildingById(List<String> buildingId) throws Exception;

    /**
     * 根据企业ID删除企业
     * @param companyIdList 企业名称列表
     */
    void delCompanyByCompanyId(String buildingId,List<String> companyIdList);

    /**
     * 根据园区名称取得园区ID
     * @param parkName 园区名称
     * @return
     */
    int queryParkIdByName(String parkName);

    /**
     * 根据楼宇名称取得楼宇ID
     * @param buildingName
     * @return
     */
    int queryBuildingIdByName(Integer parkId,String buildingName);

    /**
     * 根据楼宇名称取得楼宇ID
     * @param buildingName
     * @return
     */
    int queryBIdByName(String buildingName);

    /**
     * 园区楼宇企业数量
     * @param parkId 园区ID
     * @return
     */
    List<ParkAndBuildingVO> queryBuildingCompanyNumber(String parkId);

    /**
     * 取得公司ID
     * @param buildingId
     * @param companyId
     * @return
     */
    Integer queryCompanyBuildingId(String buildingId, String companyId);

    /**
     * 取得公司ID
     * @param companyId
     * @return
     */
    Integer queryCBId(String companyId);

    /**
     * 新增园区
     * @param park
     */
    void addPark(ParkDO park);

    /**
     * 新增楼宇
     * @param building
     */
    void addBuilding(BuildingDO building, String parkName) throws Exception;

    /**
     * 新增楼宇企业
     * @param companyBuildingDO
     */
    void addCompanyBuilding(CompanyBuildingDO companyBuildingDO);

    /**
     * 返回园区图片路径
     * @param parkId
     * @return
     */
    ParkDO queryParkById(String parkId);

    /**
     * 返回楼宇图片路径
     * @param parkId
     * @param buildingId
     * @return
     */
    BuildingDO queryBuildingByParkAndBuilding(String parkId, String buildingId);

    /**
     * 更新园区图片URL
     * @param park
     */
    void updateParkImgUrl(ParkDO park);

    /**
     * 更新楼宇图片URL
     * @param building
     */
    void updateBuildingImgUrl(BuildingDO building);

    /**
     * 检查园区、楼宇是否绑定
     *
     * @param parkName
     * @param buildingName
     * @return
     */
    public int queryPABRelation(String parkName, String buildingName);

    /**
     * 绑定园区、楼宇
     *
     * @param building
     * @param parkName
     */
    void bindingParkAndBuilding(BuildingDO building, String parkName);

}
