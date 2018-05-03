package com.po;

public class Grade {
    private Integer id;
    private String studentId;
    private String subjectNo;
    private String gradeType;
    private String score;
    private String changeScore;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Grade() {
    }

    public Grade(String gradeType, String score, String userId) {
        this.gradeType = gradeType;
        this.score = score;
        this.userId = userId;
    }

    public String getSubjectNo() {
        return subjectNo;
    }

    public void setSubjectNo(String subjectName) {
        this.subjectNo = subjectName;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", gradeType='" + gradeType + '\'' +
                ", score='" + score + '\'' +
                ", changeScore='" + changeScore + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getChangeScore() {
        return changeScore;
    }

    public void setChangeScore(String changeScore) {
        this.changeScore = changeScore;
    }
}
