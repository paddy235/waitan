package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyCreditRawInfoDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

/**
 * Created by cgj on 2017/5/4.
 */

public interface CompanyCreditRawInfoMapper {



	int saveCompanyCreditRawInfo(CompanyCreditRawInfoDO companyCreditRawInfoDo);

	@Delete( "DELETE FROM `company_credit_raw_info` WHERE `company_name` =#{companyName}" )
	int removeCompanyCreditRawInfoByCompanyName( String companyName );

    @Delete( "DELETE FROM `company_credit_raw_info` WHERE `company_id` =#{companyId}" )
    int removeCompanyCreditRawInfoByCompanyId( String companyId );

}