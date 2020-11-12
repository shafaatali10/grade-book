package com.shafaat.grade.book.entity;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import org.springframework.beans.factory.annotation.Value;

public class Assignment extends AbstractAssessmentType{

    @Override
    public String assessmentType() {
        return AssessmentTypesEnum.ASSIGNMENT.toString();
    }

}
