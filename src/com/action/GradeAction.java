package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.Grade;
import com.po.PageShow;
import com.service.GradeService;

import java.util.List;

public class GradeAction {
    private String id;
    private String studentId;
    private String gradeType;
    private String score;
    private String changeScore;
    private GradeService gradeService;

    private int pageNow=1;//当前页
    private int pageSize=20;//总条数
    private int totalPage;//总页数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getChangeScore() {
        return changeScore;
    }

    public void setChangeScore(String changeScore) {
        this.changeScore = changeScore;
    }

    public GradeService getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String addGrade(){
        if (this.getStudentId()==null||this.getStudentId().equals("")||
                this.getScore()==null||this.getScore().equals("")){
            ActionContext.getContext().put("addGradeMess","学号和成绩不能为空！");
            return "addGradeError";
        }
        Grade grade = new Grade();
        grade.setStudentId(this.studentId);
        grade.setGradeType(this.gradeType);
        grade.setScore(this.score);
        String strMess = this.gradeService.addGrade(grade);
        if (strMess.equals("addGradeSuccess")) {
            ActionContext.getContext().put("addGradeMess","录入成功！");
            return "addGradeSuccess";
        }
        ActionContext.getContext().put("addGradeMess","录入失败！");
        return "addGradeError";
    }

    //查询所有成绩
    public String checkAllGrade(){
        List<Grade> list = this.gradeService.getAllGradeData(this.pageNow,this.pageSize);
        if (list.size()>0){
            ActionContext.getContext().put("checkAllGradeMess",list);
            PageShow page=new PageShow(pageNow, this.gradeService.findAllGradeSize(), pageSize);
            ActionContext.getContext().put("checkPage", page);
            return "checkAllGradeSuccess";
        }
        return "checkAllGradeError";
    }

    //删除单条成绩
    public String deleteScore(){
        String strMess = this.gradeService.deleteGrade(this.studentId);
        if (strMess.equals("deleteScoreSuccess")){
            ActionContext.getContext().put("deleteGradeMess","删除成功！");
            checkAllGrade();
            return "deleteScoreSuccess";
        }
        ActionContext.getContext().put("deleteGradeMess","删除失败！");
        return "deleteScoreSuccess";
    }

    //修改成绩
    public String changeScore(){
        if (this.getChangeScore()==null||this.getChangeScore().equals("")){
            ActionContext.getContext().put("changeScoreMess","不能为空！");
            checkAllGrade();
            return "changeScoreError";
        }
        Grade grade = new Grade();
        grade.setStudentId(this.studentId);
        grade.setGradeType(this.gradeType);
        grade.setChangeScore(this.changeScore);
        String strMess = this.gradeService.updateGrade(grade);
        if (strMess.equals("changeScoreSuccess")){
            ActionContext.getContext().put("changeScoreMess","修改成功！");
            checkAllGrade();
            return "changeScoreSuccess";
        }
        ActionContext.getContext().put("changeScoreMess","修改失败！");
        checkAllGrade();
        return "changeScoreError";
    }

}
