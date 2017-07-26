package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.NaturalPersonDO;
import com.bbd.wtyh.domain.query.NaturalPersonQuery;
import com.bbd.wtyh.domain.vo.NaturalPersonVO;

import java.util.List;
import java.util.Map;

/**
 * Created by Barney on 2017/7/5.
 */
public interface NaturalPersonService {

    //判断导出文件是否能被下载（次数是否超限），每返回一次true就会扣除一次下载次数
    boolean allowDownFile();

    int batchInsertNaturalPerson(List<NaturalPersonDO> list);

    int updateNaturalPersonInvalid();

    int deleteNaturalPersonInvalid();

    int queryNaturalPersonCount(NaturalPersonQuery query);

    List<NaturalPersonVO> queryNaturalPerson(NaturalPersonQuery query);

    List<String> queryCompanyByPerson(String person);

    /**
     *
     * @param nalName
     * @param type all：检索所有的，baxx：检索企业董监高， gdxx：检索企业法人，股东
     * @param isProvince 是否只检索省内范围
     * @param companyKeyword
     * @param pageSize
     * @param page
     * @return
     */
    Map<String, Object> queryNaturalPerson2(
            String nalName, String type, Boolean isProvince, String companyKeyword, Integer pageSize, Integer page );

}
