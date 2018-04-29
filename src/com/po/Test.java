package com.po;

public class Test {
    private Integer testId;
    private String testName;
    private String subName;
    private String subNo;
    private String questionType;
    private String questionId;
    private String questionContent;
    private String answer;
    private String setGrade;

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                ", subName='" + subName + '\'' +
                ", subNo='" + subNo + '\'' +
                ", questionType='" + questionType + '\'' +
                ", questionId='" + questionId + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", answer='" + answer + '\'' +
                ", setGrade='" + setGrade + '\'' +
                '}';
    }

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
}
