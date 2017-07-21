package com.bbd.wtyh.mapper;

import com.bbd.wtyh.domain.MiscParameterDO;
import com.bbd.wtyh.domain.NaturalPersonDO;
import com.bbd.wtyh.domain.query.NaturalPersonQuery;
import com.bbd.wtyh.domain.vo.NaturalPersonVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Barney on 2017/7/5.
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

    /*
     * 根据自然人检索企业
     */
    List<String> queryCompanyByPerson(String person);


    /**
     * 获取naturalPersonTimeNum参数
     * @return value1：剩余次数，value2：“当天”，value3：每天总的下载次数
     */
    @Select( "SELECT `value1`, `value2`, `value3` FROM `user_misc_parameter` WHERE `name` ='naturalPersonTimeNum' LIMIT 1;" )
    MiscParameterDO queryParameterDoByName( ); //@Param("name") String name

    /**
     * 更新剩余次数
     * @param timeNum 新的剩余次数
     */
    @Update("UPDATE `user_misc_parameter` SET `value1` =#{timeNum} WHERE `name` ='naturalPersonTimeNum';")
    void updateDownTimeNum( @Param("timeNum") Integer timeNum );

    /**
     * 更新当前的日期
     * @param curDay  仅“天”
     */
    @Update("UPDATE `user_misc_parameter` SET `value2` =#{currDay} WHERE `name` ='naturalPersonTimeNum';")
    void updateDownCurrDay( @Param("currDay") Integer curDay );

}
