package com.service;

import com.po.Grade;

import java.util.List;

public interface GradeService {
    public List<Grade> getGradeData();
    public String addGrade(Grade grade);
    public String updateGrade(String grade);
}
