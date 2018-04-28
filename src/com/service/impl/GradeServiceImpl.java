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



    //添加成绩
    @Override
    public String addGrade(Grade grade) {
        if (this.gradeDao.addGrade(grade)){
            return "addGradeSuccess";
        }
        return "addGradeError";
    }

    //修改成绩
    @Override
    public String updateGrade(Grade grade) {
        if (this.gradeDao.updateGrade(grade)){
            return "changeScoreSuccess";
        }
        return "changeScoreError";
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

    //根据studentId获取成绩
    @Override
    public List<Grade> getGradeByIdData(String studentId) {
        String sql = "from Grade where studentId='"+studentId+"'";
        List<Grade> list = this.gradeDao.getGrade(sql);
        return list;
    }

    //获取所有成绩
    @Override
    public List<Grade> getAllGradeData(int pageNow, int pageSize) {
        List<Grade> list = this.gradeDao.getAllGradeData(pageNow,pageSize);
        return list;
    }

    @Override
    public int findAllGradeSize() {
        return this.gradeDao.findAllGradeSize();
    }
}
