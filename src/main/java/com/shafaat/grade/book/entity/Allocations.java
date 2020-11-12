package com.shafaat.grade.book.entity;

import java.util.Map;

public class Allocations {

    private String assessmentType;
    private Double allocation;

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public Double getAllocation() {
        return allocation;
    }

    public void setAllocation(Double allocation) {
        this.allocation = allocation;
    }
}
