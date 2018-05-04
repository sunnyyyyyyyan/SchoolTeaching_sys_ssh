package com.po;

public class ChooseSubject {
    private Integer chooseId;
    private String subjectNo;
    private String subjectName;
    private String chooseUserId;

    private String username;


    public ChooseSubject() {
    }

    public ChooseSubject(String subjectNo, String subjectName, String chooseUserId, String username) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.chooseUserId = chooseUserId;
        this.username = username;
    }

    public ChooseSubject(String subjectNo, String subjectName, String username) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.username = username;
    }

    @Override
    public String toString() {
        return "ChooseSubject{" +
                "chooseId=" + chooseId +
                ", subjectNo='" + subjectNo + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", chooseUserId='" + chooseUserId + '\'' +
                '}';
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
