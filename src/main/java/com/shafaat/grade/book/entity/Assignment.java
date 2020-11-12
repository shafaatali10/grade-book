package com.shafaat.grade.book.entity;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import org.springframework.beans.factory.annotation.Value;

public class Assignment extends AbstractAssessmentType{

    private Double weightage;

    @Value("${assignments.weightage}")
    private Double defaultWeightage;

    public Assignment(){
        this.weightage = this.defaultWeightage;
    }

    public Assignment(Double weightage){
        this.weightage = weightage;
    }

    @Override
    public String assessmentType() {
        return AssessmentTypesEnum.ASSIGNMENT.toString();
    }

    @Override
    public Double weightage() {
        return this.weightage;
    }

}
