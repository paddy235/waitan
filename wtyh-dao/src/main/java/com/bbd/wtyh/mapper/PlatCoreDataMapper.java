package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.EasyExport.WaiTanData;
import com.bbd.wtyh.domain.EasyExport.WangdaiData;
import com.bbd.wtyh.domain.PlatCoreDataDO;
import com.bbd.wtyh.web.EasyExportExcel.ExportCondition;
import com.bbd.wtyh.web.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lixudong on 2017/7/12.
 */
public interface PlatCoreDataMapper {

    void save(PlatCoreDataDO platCoreDataDO);

    void deleteByPlatName(@Param("platName")String platName);

    List<WangdaiData> getWangdai(@Param("exportCondition")ExportCondition exportCondition,
                                 @Param("pageBean")PageBean pageBean);

    Long countWangdai(@Param("exportCondition")ExportCondition exportCondition);

    List<WaiTanData> getWaiTanOther(@Param("exportCondition")ExportCondition exportCondition,
                                      @Param("pageBean")PageBean pageBean);

    Long countWaiTanOther(@Param("exportCondition")ExportCondition exportCondition);
}
