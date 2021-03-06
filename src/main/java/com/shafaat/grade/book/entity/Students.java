package com.shafaat.grade.book.entity;

import java.util.List;

public class Students {
    private Integer studentId;
    private String studentName;
    private List<AbstractAssessmentType> assessments;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<AbstractAssessmentType> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<AbstractAssessmentType> assessments) {
        this.assessments = assessments;
    }
}
