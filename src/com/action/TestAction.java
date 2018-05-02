package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.po.Test;
import com.service.TestService;

import java.util.List;

public class TestAction {
    private Integer testId;
    private String testAdder;
    private String testName;
    private String subName;
    private String subjectNo;
    private String questionType;
    private String questionId;
    private String questionContent;
    private String answer;
    private String setGrade;
    private TestService testService;

    private Integer selectId;
    private String selectA;
    private String selectB;
    private String selectC;
    private String selectD;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestAdder() {
        return testAdder;
    }

    public void setTestAdder(String testAdder) {
        this.testAdder = testAdder;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSetGrade() {
        return setGrade;
    }

    public void setSetGrade(String setGrade) {
        this.setGrade = setGrade;
    }

    public TestService getTestService() {
        return testService;
    }

    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public Integer getSelectId() {
        return selectId;
    }

    public void setSelectId(Integer selectId) {
        this.selectId = selectId;
    }

    public String getSelectA() {
        return selectA;
    }

    public void setSelectA(String selectA) {
        this.selectA = selectA;
    }

    public String getSelectB() {
        return selectB;
    }

    public void setSelectB(String selectB) {
        this.selectB = selectB;
    }

    public String getSelectC() {
        return selectC;
    }

    public void setSelectC(String selectC) {
        this.selectC = selectC;
    }

    public String getSelectD() {
        return selectD;
    }

    public void setSelectD(String selectD) {
        this.selectD = selectD;
    }

    //添加试题
    public String addQuestion(){
        String user = (String)ActionContext.getContext().getSession().get("userId");
        if (this.getTestName()==null||this.getTestName().equals("")||
                this.getSubName()==null||this.getSubName().equals("")||
                this.getQuestionId()==null||this.getQuestionId().equals("")||
                this.getQuestionType()==null||this.getQuestionType().equals("")||
                this.getQuestionContent()==null||this.getQuestionContent().equals("")||
                this.getAnswer()==null||this.getAnswer().equals("")||
                this.getSetGrade()==null||this.getSetGrade().equals("")){
            ActionContext.getContext().put("addQuestionMess","不能为空！");
            return "addQuestionError";
        }
        String subNo = new String();
        if(subName.equals("软件工程")){subNo="00";}
        else if(subName.equals("Web")){subNo="01";}
        else if(subName.equals("java")){subNo="02";}
        Test test = new Test();
        test.setTestAdder(user);
        test.setTestName(this.testName);        //试题ming
        test.setSubName(this.subName);          //课程
        test.setSubjectNo(subNo);                  //课程编号
        test.setQuestionId(this.questionId);    //题号
        test.setQuestionContent(this.questionContent);  //题目
        test.setQuestionType(this.questionType);    //题型
        test.setAnswer(this.answer);            //答案
        test.setSetGrade(this.setGrade);        //分值

        if (this.questionType.equals("选择")){
            if (this.getSelectA()==null||this.getSelectA().equals("")||
                    this.getSelectB()==null||this.getSelectB().equals("")||
                    this.getSelectC()==null||this.getSelectC().equals("")||
                    this.getSelectD()==null||this.getSelectD().equals("")){
                ActionContext.getContext().put("addQuestionMess","选项不能为空！");
                return "addQuestionError";
            }
            test.setSelectA(this.selectA);
            test.setSelectB(this.selectB);
            test.setSelectC(this.selectC);
            test.setSelectD(this.selectD);
            String strMess = this.testService.addTest(test);
            if (strMess.equals("addQuestionSuccess")){
                    return "addQuestionSuccess";
            }
            return "addQuestionError";
        }
        if (this.questionType.equals("判断")){
            String strMess = this.testService.addTest(test);
            if (strMess.equals("addQuestionSuccess")){
                return "addQuestionSuccess";
            }
            return "addQuestionError";
        }
        ActionContext.getContext().put("addQuestionMess","添加失败！");
        return "addQuestionError";
    }


    //试题列表
    public String questionList(){
        List<Test> list = this.testService.showTest();
        ActionContext.getContext().put("questionList",list);
        return "questionListSuccess";
    }

    //获取考试试题
    public String startTesting(){
        List<Test> list = this.testService.showTest(this.subjectNo);
        ActionContext.getContext().put("startTesting", list);
        return "startTestingSuccess";
    }

}
