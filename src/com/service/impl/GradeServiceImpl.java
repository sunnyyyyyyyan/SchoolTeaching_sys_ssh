package com.service.impl;

import com.dao.GradeDao;
import com.po.Grade;
import com.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    private GradeDao gradeDao;

    public GradeDao getGradeDao() {
        return gradeDao;
    }

    public void setGradeDao(GradeDao gradeDao) {
        this.gradeDao = gradeDao;
    }

    @Override
    public List<Grade> getGradeData() {
        return null;
    }

    @Override
    public String addGrade(Grade grade) {
        if (this.gradeDao.addGrade(grade)){
            return "addGradeSuccess";
        }
        return "addGradeError";
    }

    @Override
    public String updateGrade(String grade) {
        return null;
    }
}
