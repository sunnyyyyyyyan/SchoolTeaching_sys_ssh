package com.po;

public class DoEvaluate {

    private Integer doEvaluateId;
    private String subjectNo;
    private String evaluateQuestionId;
    private String evaluateContent;
    private String answer;
    private String advise;
    private String userId;

    public String getAdvise() {
        return advise;
    }

    public void setAdvise(String advise) {
        this.advise = advise;
    }

    public Integer getDoEvaluateId() {
        return doEvaluateId;
    }

    public void setDoEvaluateId(Integer doEvaluateId) {
        this.doEvaluateId = doEvaluateId;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getEvaluateQuestionId() {
        return evaluateQuestionId;
    }

    public void setEvaluateQuestionId(String evaluateQuestionId) {
        this.evaluateQuestionId = evaluateQuestionId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
