package com.bbd.wtyh.mapper;

import com.bbd.wtyh.web.relationVO.LineVO;
import com.bbd.wtyh.web.relationVO.PointVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public interface OfflineFinanceMapper {

    /**
     * 查询关联方点信息
     * @return
     */
    List<PointVO> queryPointByName(@Param("companyName") String companyName, @Param("degree") Integer degree);

    /**
     * 查询关联方线信息
     * @return
     */
    List<LineVO> queryLineByName(@Param("companyName")String companyName, @Param("degree") Integer degree);

}
