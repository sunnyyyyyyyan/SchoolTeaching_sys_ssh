package com.dao;

import com.po.ChooseSubject;

import java.util.List;

public interface ChooseSubjectDao {
    public List<ChooseSubject> getData(String sql);
    public boolean addChooseSubject(ChooseSubject chooseSubject);
    public boolean delChooseSubject(ChooseSubject chooseSubject);
    public boolean updateChooseSubject(ChooseSubject chooseSubject);
}
