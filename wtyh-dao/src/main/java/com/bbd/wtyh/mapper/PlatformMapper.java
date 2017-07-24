package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.CompanyInfoModify.CompanyInfo;
import com.bbd.wtyh.domain.CompanyInfoModify.WangdaiModify;
import com.bbd.wtyh.domain.PlatformDO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lixudong on 2017/7/12.
 */
public interface PlatformMapper {

    void save(PlatformDO platListDO);

    void deleteByPlatName(@Param("platName")String platName);

    void recordWangdai(WangdaiModify companyInfo);
}
