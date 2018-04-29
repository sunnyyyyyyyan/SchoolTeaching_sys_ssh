package com.service.impl;

import com.dao.SelectionDao;
import com.dao.TestDao;
import com.po.Test;
import com.service.TestService;

import java.util.List;

public class TestServiceImpl implements TestService {
    private TestDao testDao;
    private SelectionDao selectionDao;

    public TestDao getTestDao() {
        return testDao;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public String addTest(Test test) {
        return null;
    }

    @Override
    public List<Test> showTest() {
        return null;
    }
}
