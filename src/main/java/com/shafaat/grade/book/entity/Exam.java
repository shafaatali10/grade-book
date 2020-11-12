package com.shafaat.grade.book.entity;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import org.springframework.beans.factory.annotation.Value;

public class Exam extends AbstractAssessmentType {

    @Override
    public String assessmentType() {
        return AssessmentTypesEnum.EXAM.toString();
    }

}
