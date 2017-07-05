package com.bbd.wtyh.service;

import com.bbd.wtyh.domain.NaturalPersonDO;
import com.bbd.wtyh.domain.query.NaturalPersonQuery;
import com.bbd.wtyh.domain.vo.NaturalPersonVO;

import java.util.List;

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

}
