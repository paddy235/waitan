package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PrivateFundExtraDO;
import com.bbd.wtyh.domain.dto.PrivateFundCompanyDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Marco on 2016/9/9.
 */
public interface PrivateFundExtraMapper {

    PrivateFundExtraDO selectByPrimaryKey(Integer companyId);

    List<PrivateFundCompanyDTO> selectAll(@Param("orderByField") Integer orderByField, @Param("descAsc") String descAsc,@Param("recordStatus") Integer recordStatus);

}
