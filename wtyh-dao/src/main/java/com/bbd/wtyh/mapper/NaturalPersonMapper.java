package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.NaturalPersonDO;
import com.bbd.wtyh.domain.query.NaturalPersonQuery;
import com.bbd.wtyh.domain.vo.NaturalPersonVO;

import java.util.List;

/**
 * Created by Barney on 2017/7/4.
 */
public interface NaturalPersonMapper {

    /*
     * 数据的批量新增
     */
    int batchInsertNaturalPerson(List<NaturalPersonDO> list);

    /*
     * 将当前有效数据置为无效
     */
    int updateNaturalPersonInvalid();

    /*
     * 删除当前的无效数据
     */
    int deleteNaturalPersonInvalid();

    /*
     * 数量查询
     */
    int queryNaturalPersonCount(NaturalPersonQuery query);

    /*
     * 检索
     */
    List<NaturalPersonVO> queryNaturalPerson(NaturalPersonQuery query);

}
