package com.service;

import com.po.Grade;

import java.util.List;

public interface GradeService {
    public List<Grade> getGradeByStudentIdData(String userId);  //根据编号查询成绩
    public String addGrade(Grade grade);    //录入成绩
    public String updateGrade(Grade grade);    //修改成绩
    public String deleteGrade(String studentId);  //根据studentId删除单条成绩

    public List<Grade> getAllGradeData(int pageNow, int pageSize);
    public int findAllGradeSize();
}
