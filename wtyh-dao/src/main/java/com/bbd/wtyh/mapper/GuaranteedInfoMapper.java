package com.bbd.wtyh.mapper;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.GuaranteedInfoDO;
import com.bbd.wtyh.domain.dto.LargeGuaranteeDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GuaranteedInfoMapper {
    GuaranteedInfoDO selectByPrimaryKey(Integer id);

    List<LargeGuaranteeDTO> listLargeGuarantee(@Param("pagination") Pagination pagination, @Param("orderByField") Integer orderByField, @Param("descAsc") String descAsc);
}