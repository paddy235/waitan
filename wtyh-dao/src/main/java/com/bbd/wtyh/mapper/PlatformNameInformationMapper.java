package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.PlatformNameInformationDO;
import org.apache.ibatis.annotations.Param;


/**
* 区域mapper
* @author YanWenyuan
* @since 2016年8月21日 下午1:52:45
*/
public interface PlatformNameInformationMapper {
	PlatformNameInformationDO hasOrNotCompany(@Param(value = "plat_name") String plat_name);
}