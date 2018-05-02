package com.po;

public class Test {
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

    private Integer selectId;
    private String selectA;
    private String selectB;
    private String selectC;
    private String selectD;

    public Test() {
    }

    public Test(String testAdder, String testName, String subName, String subjectNo, String questionType, String questionId, String questionContent, String answer, String setGrade, String selectA, String selectB, String selectC, String selectD) {
        this.testAdder = testAdder;
        this.testName = testName;
        this.subName = subName;
        this.subjectNo = subjectNo;
        this.questionType = questionType;
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.answer = answer;
        this.setGrade = setGrade;
        this.selectId = selectId;
        this.selectA = selectA;
        this.selectB = selectB;
        this.selectC = selectC;
        this.selectD = selectD;
    }

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
}
