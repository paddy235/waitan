package com.bbd.wtyh.mapper;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyTagDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/9/5 0005.
 */
public interface CompanyTagMapper {

    void saveCompanyTag(List<CompanyTagDO> list);

    void deleteAllByQyxxTag();

    int countQyxxTag();

    List<CompanyTagDO> selectFromQyxxTag(@Param("pagination") Pagination pagination);

    int getMaxDtFromQyxxTag();

    int getMaxDtFromCompanyTag();


    //新增企业-包含外滩线下理财企业标签
    int countCompanyHaveOfflineType();
    List<CompanyDO> queryCompanyHaveOfflineType(@Param("pagination") Pagination pagination);
    //新增企业-仅有一个标签且不是线下理财
    int countCompanyHaveOneTagExceptOfflineType();
    List<CompanyDO> queryCompanyHaveOneTagExceptOfflineType(@Param("pagination") Pagination pagination);
    //新增企业-有多个标签且不是线下理财
    int countCompanyHaveMoreTagExceptOfflineType();
    List<CompanyDO> queryCompanyHaveMoreTagExceptOfflineType(@Param("pagination") Pagination pagination);

    //更新company中的company_type,company的type is null 或者 是线下理财 且当TAG仅有一个标签且不是线下理财
    void updateCompanyTypeFromQyxxTag();
    //更新company中的company_type,company的type is null 且包含外滩线下理财企业标签
    void updateTypeWhenTypeIsNullAndHaveOffLine();



}
