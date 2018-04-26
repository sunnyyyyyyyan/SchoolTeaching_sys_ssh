package com.po;

public class Grade {
    private Integer id;
    private String studentId;
    private String gradeType;
    private String score;

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", gradeType='" + gradeType + '\'' +
                ", score='" + score + '\'' +
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
}
