package com.shafaat.grade.book.entity;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import org.springframework.beans.factory.annotation.Value;

public class Exam extends AbstractAssessmentType {



    public Exam(){
        this.weightage = this.defaultWeightage;
    }

    public Exam(Double weightage){
        this.weightage = weightage;
    }

    private Double weightage;

    @Value("${exams.weightage}")
    private Double defaultWeightage;

    @Override
    public String assessmentType() {
        return AssessmentTypesEnum.EXAM.toString();
    }

    @Override
    public Double weightage() {
        return this.weightage;
    }


}
