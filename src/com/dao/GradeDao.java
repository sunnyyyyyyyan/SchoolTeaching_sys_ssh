package com.dao;

import com.po.Grade;

import java.util.List;

public interface GradeDao {
    //增删改查
    public boolean addGrade(Grade grade);
    public boolean updateGrade(Grade grade);
    public List<Grade> getGrade(String sql);
    public boolean delGrade(Grade grade);

    //查询所有成绩列表
    public List<Grade> getAllGradeData(int pageNow, int pageSize);
    public int findAllGradeSize();
}
