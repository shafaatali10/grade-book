package com.shafaat.grade.book.dto;

import com.shafaat.grade.book.entity.AbstractAssessmentType;

import java.util.List;

public class StudentsDTO {
    private Integer studentId;
    private String studentName;
    private List<AssessmentsDTO> assessments;

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

    public List<AssessmentsDTO> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<AssessmentsDTO> assessments) {
        this.assessments = assessments;
    }
}
