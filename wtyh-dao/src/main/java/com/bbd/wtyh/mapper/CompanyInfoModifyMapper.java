package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by YanWenyuan on 2017/7/14.
 */
public interface CompanyInfoModifyMapper {

    List<String> autoComplete(@Param("q") String q);

    CompanyInfo queryCompany(@Param("name") String name);

    List<String> queryModifyCompany(@Param("name")String name);
}
