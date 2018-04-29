package com.dao;

import com.po.Test;

import java.util.List;

public interface TestDao {
    public List<Test> getData(String sql);
    public boolean addTest(Test test);
    public boolean delTest(Test test);
    public boolean updateTest(Test test);
}
