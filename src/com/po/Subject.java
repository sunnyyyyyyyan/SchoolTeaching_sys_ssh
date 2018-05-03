package com.po;

public class Subject {
    private Integer subjectId;
    private String subjectNo;
    private String subjectName;
    private String userId;
    private String changeUserId;

    private String username;
    private String gradeType;
    private String score;
    private String studentId;


    public Subject() {
    }

    public Subject(String subjectNo, String subjectName, String userId, String username) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.userId = userId;
        this.username = username;
    }

    public Subject(String subjectNo, String subjectName, String studentId, String gradeType, String score) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.studentId = studentId;
        this.gradeType = gradeType;
        this.score = score;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChangeUserId() {
        return changeUserId;
    }

    public void setChangeUserId(String changeUserId) {
        this.changeUserId = changeUserId;
    }


    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectNo='" + subjectNo + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
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
}
