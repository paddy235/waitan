package com.bbd.wtyh.mapper;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.GuaranteedInfoDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GuaranteedInfoMapper {
    GuaranteedInfoDO selectByPrimaryKey(Integer id);

    List<GuaranteedInfoDO> listLargeGuarantee(@Param("pagination") Pagination pagination, @Param("orderByField") Integer orderByField, @Param("descAsc") String descAsc);

    int countLargeGuarantee();

    void updateG (GuaranteedInfoDO guaranteedInfoDO);

}