package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.EasyExport.PrivateOfferedFundData;
import com.bbd.wtyh.domain.PrivateFundExtraDO;
import com.bbd.wtyh.domain.dto.PrivateFundCompanyDTO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Marco on 2016/9/9.
 */
public interface PrivateFundExtraMapper {

    PrivateFundExtraDO selectByPrimaryKey(Integer companyId);

    List<PrivateFundCompanyDTO> selectAll(@Param("orderByField") Integer orderByField, @Param("descAsc") String descAsc, @Param("recordStatus") Integer recordStatus);

    /**
     * 获取总条数
     *
     * @return
     */
    int countAllCompany();

    /**
     * 分页获取私募基金企业信息
     *
     * @param params
     * @return
     */
    List<PrivateFundCompanyDTO> findByPage(Map<String, Object> params);


    List<PrivateOfferedFundData> getPrivateOfferedFund(ExportCondition exportCondition);
}
