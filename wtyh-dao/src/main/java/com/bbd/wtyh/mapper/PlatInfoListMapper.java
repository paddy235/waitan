package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.dto.PlatInfoDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
* 区域mapper
* @author YanWenyuan
* @since 2016年8月21日 下午1:52:45
*/
public interface PlatInfoListMapper {

	List<PlatInfoDTO> getPlatInfoList(@Param(value = "platName") String platName,
									  @Param(value = "companyName")String companyName,
									  @Param(value = "orderByField")String orderByField,
									  @Param(value = "descAsc")String descAsc,
									  @Param(value = "areaName")String areaName);

	List<PlatInfoDTO> getPlatMoreThanOne(@Param(value = "platName") String platName,
									  @Param(value = "companyName")String companyName);

}
