package com.service.impl;

import com.dao.GradeDao;
import com.dao.GradeTypeDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Grade;
import com.po.GradeType;
import com.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    private GradeDao gradeDao;
    private GradeTypeDao gradeTypeDao;

    public GradeTypeDao getGradeTypeDao() {
        return gradeTypeDao;
    }

    public void setGradeTypeDao(GradeTypeDao gradeTypeDao) {
        this.gradeTypeDao = gradeTypeDao;
    }

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
        String sql = "from Grade where studentId='"+grade.getStudentId()+"'";
        List<Grade> list = this.gradeDao.getGrade(sql);
        Grade grade1 = list.get(0);
        grade1.setScore(grade.getChangeScore());
        if (this.gradeDao.updateGrade(grade1)){
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
    public List<Grade> getGradeByStudentIdData(String userId) {
        String sql = "select new Grade(g.gradeType, g.score, u.userId) from Grade g,User u where g.studentId=u.userId and userId='"+userId+"'";
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

    @Override
    public String addGradeTypeData(GradeType gradeType) {
        String sql = "from GradeType where gradeTypeName='"+gradeType.getGradeTypeName()+"'";
        List<GradeType> list = this.gradeTypeDao.getGradeTypeData(sql);
        if (list.size()>0){
            ActionContext.getContext().put("addGradeTypeMess","该考试类型已存在！");
            return "addGradeTypeError";
        }
        if (this.gradeTypeDao.addGradeType(gradeType)){
            ActionContext.getContext().put("addGradeTypeMess","添加成功！");
            return "addGradeTypeSuccess";
        }
        ActionContext.getContext().put("addGradeTypeMess","添加失败！");
        return "addGradeTypeError";
    }
}
