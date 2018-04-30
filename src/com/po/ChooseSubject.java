package com.po;

public class ChooseSubject {
    private Integer chooseId;
    private String subjectNo;
    private String subjectName;
    private String chooseUserId;

    @Override
    public String toString() {
        return "ChooseSubject{" +
                "chooseId=" + chooseId +
                ", subjectNo='" + subjectNo + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", chooseUserId='" + chooseUserId + '\'' +
                '}';
    }

    public Integer getChooseId() {
        return chooseId;
    }

    public void setChooseId(Integer chooseId) {
        this.chooseId = chooseId;
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

    public String getChooseUserId() {
        return chooseUserId;
    }

    public void setChooseUserId(String chooseUserId) {
        this.chooseUserId = chooseUserId;
    }
}
