package com.shafaat.grade.book.entity;

public abstract class AbstractAssessmentType {

    protected Double score;
    protected Integer maxScore=100;

    public abstract String assessmentType();

    public abstract Double weightage();

    protected Double getScore() {
        return score;
    }

    protected void setScore(Double score) {
        this.score = score;
    }
}
