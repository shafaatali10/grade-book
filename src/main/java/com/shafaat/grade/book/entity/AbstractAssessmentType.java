package com.shafaat.grade.book.entity;

public abstract class AbstractAssessmentType {

    protected Double score;
    protected Double maxScore;

    public abstract String assessmentType();


    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Double maxScore) {
        this.maxScore = maxScore;
    }
}
