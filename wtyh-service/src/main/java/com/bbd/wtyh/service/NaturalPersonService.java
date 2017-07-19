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
     * @param companyKeyword
     * @param pageSize
     * @param page
     * @return
     */
    Map<String, Object> queryNaturalPerson2(
            String nalName, String type, String companyKeyword, Integer pageSize, Integer page );

}
