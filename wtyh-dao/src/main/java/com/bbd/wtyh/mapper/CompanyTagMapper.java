package com.bbd.wtyh.mapper;

import com.bbd.wtyh.common.Pagination;
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

}
