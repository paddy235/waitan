package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyCreditRawInfoDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * Created by cgj on 2017/5/4.
 */

public interface CompanyCreditRawInfoMapper {

	@Insert("INSERT INTO company_credit_raw_info(" +
			"`company_id`,`company_name`, `organization_code`, `credit_code`, `cxbh`, `resources`, `resource_name`, `resource_code`," +
			"`xxssdw_code`, `xxssdw`, `xxlb`, `content`, `create_by`, `create_date` ) VALUES(" +
			"#{companyId},#{companyName}, #{organizationCode}, #{creditCode}, #{cxbh}, #{resources}, #{resourceName}, #{resourceCode}," +
			"#{xxssdwCode}, #{xxssdw}, #{xxlb}, #{content}, 'system', NOW() )")
	@Options(useGeneratedKeys =true, keyProperty = "id")
	int saveCompanyCreditRawInfo(CompanyCreditRawInfoDO companyCreditRawInfoDo);

	@Delete( "DELETE FROM `company_credit_raw_info` WHERE `company_name` =#{companyName}" )
	int removeCompanyCreditRawInfoByCompanyName( String companyName );

    @Delete( "DELETE FROM `company_credit_raw_info` WHERE `company_id` =#{companyId}" )
    int removeCompanyCreditRawInfoByCompanyId( String companyId );

}