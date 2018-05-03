package com.dao;

import com.po.GradeType;

import java.util.List;

public interface GradeTypeDao {
    //增删改查
    public boolean addGradeType(GradeType gradeType);
    public boolean updateGradeType(GradeType gradeType);
    public List<GradeType> getGradeTypeData(String sql);
    public boolean delGradeType(GradeType gradeType);
}
