package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.service.TestService;

public class TestAction {
    private Integer testId;
    private String testName;
    private String subName;
    private String subNo;
    private String questionType;
    private String questionId;
    private String questionContent;
    private String answer;
    private String setGrade;
    private TestService testService;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
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

    public String getSubNo() {
        return subNo;
    }

    public void setSubNo(String subNo) {
        this.subNo = subNo;
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

    //添加试题
    public String addQuestion(){
        if (this.getTestName()==null||this.getTestName().equals("")){
            ActionContext.getContext().put("addQuestionMess","添加失败！");
            return "addQuestionError";
        }
        return "addQuestionSuccess";
    }

}
