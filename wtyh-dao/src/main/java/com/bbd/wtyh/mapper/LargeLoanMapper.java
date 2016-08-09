package com.bbd.wtyh.mapper;

import com.bbd.wtyh.common.Pagination;
import com.bbd.wtyh.domain.LargeLoanDO;
import com.bbd.wtyh.domain.dto.LargeLoanDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LargeLoanMapper {
    LargeLoanDO selectByPrimaryKey(Integer id);

    List<LargeLoanDTO> listLargeLoan(@Param("pagination") Pagination pagination, @Param("orderByField") Integer orderByField, @Param("descAsc") String descAsc);
}