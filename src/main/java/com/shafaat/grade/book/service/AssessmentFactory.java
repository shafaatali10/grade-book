package com.shafaat.grade.book.service;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.entity.AbstractAssessmentType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AssessmentFactory {

    private List<AbstractAssessmentType> assessmentTypesList;

    public AssessmentFactory(List<AbstractAssessmentType> assessmentTypeList){
        this.assessmentTypesList = assessmentTypeList;
    }

    public List<AbstractAssessmentType> getAssessments(AssessmentTypesEnum assessmentTypesEnum){
        switch (assessmentTypesEnum){
            case ASSIGNMENT:
                return assessmentTypesList.stream()
                        .filter( a ->
                                a.assessmentType().equals(AssessmentTypesEnum.ASSIGNMENT.toString())
                        ).collect(Collectors.toList());
            case EXAM:
                return assessmentTypesList.stream()
                        .filter( a ->
                                a.assessmentType().equals(AssessmentTypesEnum.EXAM.toString())
                        ).collect(Collectors.toList());
            case EXTRA_CREDIT:
                return assessmentTypesList.stream()
                        .filter( a ->
                                a.assessmentType().equals(AssessmentTypesEnum.EXTRA_CREDIT.toString())
                        ).collect(Collectors.toList());
            default:
                return new ArrayList<>();
        }
    }

    // todo get average

}
