package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.EasyExport.WangdaiData;
import com.bbd.wtyh.domain.PlatCoreDataDO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lixudong on 2017/7/12.
 */
public interface PlatCoreDataMapper {

    void save(PlatCoreDataDO platCoreDataDO);

    void deleteByPlatName(@Param("platName")String platName);

    List<WangdaiData> getWangdai(ExportCondition exportCondition);
}
