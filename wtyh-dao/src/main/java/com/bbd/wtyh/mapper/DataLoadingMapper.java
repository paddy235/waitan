package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.OfflineFinancialRecordDO;
import com.bbd.wtyh.domain.dataLoading.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 数据落地
 * 
 * @author ZhaoHongWen
 * @since 2016年8月21日 下午1:52:45
 */
public interface DataLoadingMapper {

    int saveDishonestyDO(List<DishonestyDO> dishonestyList);

    int saveKtggDO(List<KtggDO> ktggList);

    int saveQyxgYuqingDO(List<QyxgYuqingDO> qyxgYuqingList);

    int saveOneQyxgYuqingDO(QyxgYuqingDO qyxgYuqingDO);

    int saveQyxxBasicDO(List<QyxxBasicDO> qyxxBasicList);

    int saveQyxxBaxxDO(List<QyxxBaxxDO> qyxxBaxxList);

    int saveQyxxGdxxDO(List<QyxxGdxxDO> qyxxGdxxList);

    int saveQyxxZhuanliDO(List<QyxxZhuanliDO> qyxxZhuanliList);

    int saveRmfyggDO(List<RmfyggDO> rmfyggList);

    int saveZgcpwswDO(List<ZgcpwswDO> zgcpwswDOList);

    int saveZhixingDO(List<ZhixingDO> zhixingList);

    int saveRecruitIndexDO(List<RecruitIndexDO> recruitIndexList);

    int saveOfflineFinancialRecordDO(List<OfflineFinancialRecordDO> recordList);

    List<DatasharePullFileDO> getDatasharePullFileByTaskId(Integer taskId);

    List<QyxxBasicDO> getCompanyBasicInfoInNames(List<CompanyDO> CompanyList);

    @Select("select bbd_qyxx_id FROM qyxx_basic where company_name = #{name}  LIMIT 1 ")
    String getCompanyQyxxId(String name);

    @Select("SELECT file_name AS fileName,data_version AS dataVersion ,file_id AS fileId FROM datashare_pull_file WHERE is_pull = FALSE")
    List<Map<String, String>> noPullFileNameList();

    @Select("SELECT IFNULL(MAX(data_version),0) FROM datashare_pull_file")
    Integer maxDataVersion();

    Map<String, Object> wangdaiBaseInfo(@Param("companyName") String companyName);

    @Delete(" DELETE FROM qyxg_yuqing WHERE yuqing_id NOT IN (SELECT yuqing_id FROM(SELECT min(yuqing_id) AS yuqing_id FROM qyxg_yuqing GROUP BY abstract) rs) ")
    void deleteRepeatCompanyNews();

}
