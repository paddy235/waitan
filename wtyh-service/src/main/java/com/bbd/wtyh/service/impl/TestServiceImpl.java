package com.bbd.wtyh.service.impl;

import com.bbd.wtyh.dao.TestDAO;
import com.bbd.wtyh.entity.Test;
import com.bbd.wtyh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDAO testDAO;

    @Override
    public List<Test> list() {
        return testDAO.list();
    }
}
