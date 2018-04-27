package com.service;

import com.po.Grade;

import java.util.List;

public interface GradeService {
    public List<Grade> getGradeData();  //查询成绩
    public String addGrade(Grade grade);    //录入成绩
    public String updateGrade(String grade);    //修改成绩
    public String deleteGrade(String studentId);  //根据studentId删除单条成绩
}
