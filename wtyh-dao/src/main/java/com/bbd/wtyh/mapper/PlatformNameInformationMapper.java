package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PlatformNameInformationDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* 区域mapper
* @author YanWenyuan
* @since 2016年8月21日 下午1:52:45
*/
public interface PlatformNameInformationMapper {
	PlatformNameInformationDO hasOrNotCompany(@Param(value = "plat_name") String plat_name);

	List<PlatformNameInformationDO> associatedPlatName(@Param(value = "plat_name")String platName);

	List<PlatformNameInformationDO> associatedCompanyName(@Param(value = "company_name") String platName,
														  @Param(value = "limit_size")Integer limit_size);

	String getPlatName(@Param(value = "company_name")String company);

	int addPlat(List<PlatformNameInformationDO> platList);

	int addPlatOne(PlatformNameInformationDO plat);

	int deleteRepeatPlat();
}
