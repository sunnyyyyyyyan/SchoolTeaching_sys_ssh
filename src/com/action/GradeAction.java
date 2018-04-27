package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.Grade;
import com.service.GradeService;

import java.util.List;

public class GradeAction {
    private String studentId;
    private String gradeType;
    private String score;
    private GradeService gradeService;

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

    public GradeService getGradeService() {
        return gradeService;
    }

    public void setGradeService(GradeService gradeService) {
        this.gradeService = gradeService;
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
    public String checkGrade(){
        List<Grade> list = this.gradeService.getGradeData();
        if (list.size()>0){
            ActionContext.getContext().put("checkGradeMess",list);
            return "checkGradeSuccess";
        }
        return "checkGradeError";
    }

    //删除单条成绩
    public String deleteScore(){
        String strMess = this.gradeService.deleteGrade(this.studentId);
        if (strMess.equals("deleteScoreSuccess")){
            ActionContext.getContext().put("deleteGradeMess","删除成功！");
            checkGrade();
            return "deleteScoreSuccess";
        }
        ActionContext.getContext().put("deleteGradeMess","删除失败！");
        return "deleteScoreSuccess";
    }

}
