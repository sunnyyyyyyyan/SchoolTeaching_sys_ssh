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
        String sql = "from Grade";
        List<Grade> list = this.gradeDao.getGrade(sql);
        return list;
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

    //根据studentId删除单条成绩
    @Override
    public String deleteGrade(String studentId) {
        String sql = "from Grade where studentId='"+studentId+"'";
        List<Grade> list = this.gradeDao.getGrade(sql);
        Grade grade = list.get(0);
        if (this.gradeDao.delGrade(grade)){
            return "deleteScoreSuccess";
        }
        return "deleteScoreError";
    }
}
