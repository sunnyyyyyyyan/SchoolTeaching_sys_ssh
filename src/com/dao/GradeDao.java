package com.dao;

import com.po.Grade;

import java.util.List;

public interface GradeDao {
    public boolean addGrade(Grade grade);
    public boolean updateGrade(Grade grade);
    public List<Grade> getGrade(String sql);
}
