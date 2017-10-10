package com.bbd.wtyh.mapper.third.yuqing;

import com.bbd.wtyh.core.mybatis.annotation.ResultIntercept;
import com.bbd.wtyh.domain.third.yuqing.ImportRecordDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 第三方舆情 Mapper
 *
 * @author Created by LiYao on 2017-10-09 11:01.
 */
@ResultIntercept
public interface ThirdYuQingMapper {

    List<ImportRecordDO> findImportRecord(@Param("param") Map<String, String> param);
}
