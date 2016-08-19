package com.bbd.wtyh.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bbd.wtyh.domain.query.CompanyQuery;
import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;

public interface CompanyMapper {

    CompanyDO selectByPrimaryKey(Integer companyId);

    int countByQuery(CompanyQuery query);

    List<CompanyDO> queryCompany(CompanyQuery query);

    public InBusinessDO countByDate(@Param(value = "areaId") Integer areaId,
                                    @Param(value = "start") Date start,
                                    @Param(value = "end") Date end);

    public CompanyTypeCountDO countByType(@Param(value = "areaId") Integer areaId,
                                          @Param(value = "type") Byte type);

    public List<CompanyDO> buildingCompany(@Param(value = "buildingId") Integer buildingId,
                                           @Param(value = "orderField") Integer orderField,
                                           @Param(value = "descAsc") String descAsc);

    public CompanyTypeCountDO countTypeByBuild(@Param(value = "buildingId") Integer buildingId,
                                               @Param(value = "type") Byte type);

    public CompanyTypeCountDO buildingBackground(@Param(value = "buildingId") Integer buildingId,
                                                 @Param(value = "background") byte background);

    List<CompanyDO> searchCompany(@Param("companyType") Integer companyType, @Param("name") String keyword, @Param("size") Integer size);

    List<CompanyDO> searchCompanyName(Map<String, Object> params);
    
    int searchCompanyNameCount(String keyword);

    CompanyDO selectByName(String companyName);
    
    String queryCompanyNames(@Param("areaId") Integer areaId,
    		                 @Param("buildingId") Integer buildingId);

    List<Map<Integer, String>> companyInfo(String companyName);
}