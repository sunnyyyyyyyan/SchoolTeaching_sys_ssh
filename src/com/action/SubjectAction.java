package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.ChooseSubject;
import com.po.PageShow;
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

    private int pageNow=1;//当前页
    private int pageSize=10;//总条数
    private int totalPage;//总页数

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
        List<Subject> list = this.subjectService.showAllSubjectData(this.pageNow,this.pageSize);
        if (list.size()>0) {
            ActionContext.getContext().put("checkSubject", list);
            PageShow page = new PageShow(pageNow, this.subjectService.findAllSubjectSize(), pageSize);
            ActionContext.getContext().put("checkSubjectPage", page);
            return "checkSubjectSuccess";
        }
        return "checkSubjectError";
    }

    //添加学评里的课程信息
    public String selectAllSubject(){
        List<Subject> list = this.subjectService.showAllSubject();
        ActionContext.getContext().put("selectAllSubject", list);
        return "selectAllSubjectSuccess";
    }

    //修改授课教师
    public String changeUserSubjectData(){
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

    //根据教师编号获取课程、成绩信息
    public String getAllGradeByTeacherId(){
        List<Subject> list = this.subjectService.showAllGradeByTeacherId(this.userId);
        if (list.size()>0) {
            ActionContext.getContext().put("getAllGradeByTeacherId",list);
            return "getAllGradeByTeacherIdSuccess";
        }
        ActionContext.getContext().put("getAllGradeByTeacherIdMess","查询失败！");
        return "getAllGradeByTeacherIdError";
    }

    //根据userId获取课程信息进行考试
    public String getSubjectByUserId(){
        List<ChooseSubject> list = this.subjectService.showSubjectByUserId(this.userId);
        ActionContext.getContext().put("showSubjectByUserId", list);
        return "getSubjectByUserIdSuccess";
    }

    //根据当前userId获取课程、教师信息进行评教
    public String getMessInChoose(){
        List<ChooseSubject> list = this.subjectService.showChooseUser(this.userId);
        if (list.size()>0) {
            ActionContext.getContext().put("getMessInChoose", list);
            return "getMessInChooseSuccess";
        }
        ActionContext.getContext().put("getMessInChooseMess", "暂无可评价课程！");
        return "getMessInChooseError";
    }
}
