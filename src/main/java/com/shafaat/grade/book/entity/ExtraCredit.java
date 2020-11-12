package com.shafaat.grade.book.entity;

import com.shafaat.grade.book.common.AssessmentTypesEnum;

public class ExtraCredit extends Assignment {

    @Override
    public String assessmentType() {
        return AssessmentTypesEnum.EXTRA_CREDIT.toString();
    }
}
