package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.domain.NaturalPersonDO;
import com.bbd.wtyh.domain.query.NaturalPersonQuery;
import com.bbd.wtyh.domain.vo.NaturalPersonVO;
import com.bbd.wtyh.mapper.NaturalPersonMapper;
import com.bbd.wtyh.service.NaturalPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Barney on 2017/7/5.
 */
@Service
public class NaturalPersonServiceImpl implements NaturalPersonService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private NaturalPersonMapper mapper;

    @Override
    public int batchInsertNaturalPerson(List<NaturalPersonDO> list) {
        return mapper.batchInsertNaturalPerson(list);
    }

    @Override
    public int updateNaturalPersonInvalid() {
        return mapper.updateNaturalPersonInvalid();
    }

    @Override
    public int deleteNaturalPersonInvalid() {
        return mapper.deleteNaturalPersonInvalid();
    }

    @Override
    public int queryNaturalPersonCount(NaturalPersonQuery query) {
        return mapper.queryNaturalPersonCount(query);
    }

    @Override
    public List<NaturalPersonVO> queryNaturalPerson(NaturalPersonQuery query) {
        return mapper.queryNaturalPerson(query);
    }
}
