package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.dto.PlatInfoDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
* 区域mapper
* @author YanWenyuan
* @since 2016年8月21日 下午1:52:45
*/
public interface PlatInfoListMapper {

	@Select("SELECT a.plat_name as platName,a.company_name as companyName, c.legal_person as legalPerson,c.registered_date as registeredDate,c.registered_capital as registereCapital,c.address as address,a.create_date as createDate\n" +
			" FROM(SELECT * FROM(SELECT * FROM plat_list ORDER BY create_date DESC LIMIT 99999999999999) T GROUP BY T.plat_name) a LEFT JOIN company c ON a.company_name = c.`name` ORDER BY a.create_date DESC , a.plat_name ASC")
	List<PlatInfoDTO> getPlatInfoList();
}
