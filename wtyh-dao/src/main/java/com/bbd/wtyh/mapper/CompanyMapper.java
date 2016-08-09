package com.bbd.wtyh.mapper;

import java.util.Date;
import java.util.List;

import com.bbd.wtyh.domain.query.CompanyQuery;
import org.apache.ibatis.annotations.Param;

import com.bbd.wtyh.domain.CompanyDO;
import com.bbd.wtyh.domain.CompanyTypeCountDO;
import com.bbd.wtyh.domain.InBusinessDO;

public interface CompanyMapper {

    CompanyDO selectByPrimaryKey(Integer companyId);

    int countByQuery(CompanyQuery query);

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

    List<Integer> searchCompany(@Param("companyType") Integer companyType, @Param("name") String keyword);
}