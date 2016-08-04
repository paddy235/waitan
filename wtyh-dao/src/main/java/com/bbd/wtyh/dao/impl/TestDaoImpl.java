package com.bbd.wtyh.dao.impl;

import com.bbd.wtyh.dao.TestDAO;
import com.bbd.wtyh.entity.Test;
import com.bbd.wtyh.mapper.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * Created by root on 6/4/16.
 */
@Repository("testDAO")
public class TestDaoImpl implements TestDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDaoImpl.class);

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> list() {
        return testMapper.list();
    }
}

