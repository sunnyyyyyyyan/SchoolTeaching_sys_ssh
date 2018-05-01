package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.ChooseSubject;
import com.po.Subject;
import com.service.SubjectService;

import java.util.List;

public class SubjectAction {
    private Integer subjectId;
    private String subjectNo;
    private String subjectName;
    private String userId;
    private SubjectService subjectService;
    private String changeUserId;

    public String getChangeUserId() {
        return changeUserId;
    }

    public void setChangeUserId(String changeUserId) {
        this.changeUserId = changeUserId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SubjectService getSubjectService() {
        return subjectService;
    }

    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public String addSubjectData(){
        String user = (String)ActionContext.getContext().getSession().get("userId");
        if (this.getSubjectNo()==null||this.getSubjectNo().equals("")||
                this.getSubjectName()==null||this.getSubjectName().equals("")){
            ActionContext.getContext().put("addSubjectMess","课程编号和名称均不能为空！");
            return "addSubjectError";
        }
        Subject subject = new Subject();
        subject.setSubjectId(this.subjectId);
        subject.setSubjectNo(this.subjectNo);
        subject.setSubjectName(this.subjectName);
        subject.setUserId(user);
        String strMess = this.subjectService.addSubject(subject);
        if (strMess.equals("addSubjectSuccess")) {
            return "addSubjectSuccess";
        }
        return "addSubjectError";
    }

    //查看所有课程
    public String checkSubjectData(){
        List<Subject> list = this.subjectService.showAllSubject();
        ActionContext.getContext().put("checkSubject",list);
        return "checkSubjectSuccess";
    }

    //修改授课教师
    public String changeUserSubjectData(){
        if (this.getChangeUserId()==null||this.getChangeUserId().equals("")){
            ActionContext.getContext().put("changeUserSubjectMess","更改内容不能为空！");
            checkSubjectData();
            return "changeUserSubjectError";
        }
        Subject subject = new Subject();
        subject.setSubjectNo(this.subjectNo);
        subject.setChangeUserId(this.changeUserId);
        String strMess = this.subjectService.updateSubject(subject);
        if (strMess.equals("changeUserSubjectSuccess")) {
            ActionContext.getContext().put("changeUserSubjectMess","更改成功！");
            checkSubjectData();
            return "changeUserSubjectSuccess";
        }
        ActionContext.getContext().put("changeUserSubjectMess","更改失败！");
        checkSubjectData();
        return "changeUserSubjectError";
    }

    //学生选课
    public String chooseSubject(){
        String user = (String)ActionContext.getContext().getSession().get("userId");
        ChooseSubject chooseSubject = new ChooseSubject();
        chooseSubject.setSubjectNo(this.subjectNo);
        chooseSubject.setSubjectName(this.subjectName);
        chooseSubject.setChooseUserId(user);
        String strMess = this.subjectService.addChooseSubject(chooseSubject);
        if (strMess.equals("chooseSubjectSuccess")) {
            checkSubjectData();
            return "chooseSubjectSuccess";
        }
        checkSubjectData();
        return "chooseSubjectError";
    }

    //查看已选课程的所有学生
    public String showAllStudentBySubject(){
        List<ChooseSubject> list = this.subjectService.showAllChooseSubjectUserId(this.subjectNo);
        if (list.size()>0) {
            ActionContext.getContext().put("showAllStudentBySubject",list);
            return "showAllStudentBySubjectSuccess";
        }
        ActionContext.getContext().put("showAllStudentBySubjectMess","暂无学生选课！");
        checkSubjectData();
        return "showAllStudentBySubjectError";
    }
}
