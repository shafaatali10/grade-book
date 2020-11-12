package com.shafaat.grade.book.service;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.entity.AbstractAssessmentType;
import com.shafaat.grade.book.entity.Assignment;
import com.shafaat.grade.book.entity.Exam;
import com.shafaat.grade.book.entity.ExtraCredit;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AssessmentFactory {

    private List<AbstractAssessmentType> assessmentTypesList;
//    private String assessmentType;

    public AssessmentFactory(){
    }

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

    public AbstractAssessmentType getAssessmentEntity(String assessmentType) throws Exception {
        AssessmentTypesEnum typesEnum;
        try {
            typesEnum = AssessmentTypesEnum.valueOf(assessmentType);
        }catch (Exception e){
            throw new Exception("Invalid Exception Type");
        }

        switch (typesEnum){
            case ASSIGNMENT:
                return new Assignment();
            case EXAM:
                return new Exam();
            case EXTRA_CREDIT:
                return new ExtraCredit();
            default:
                return null;
        }
    }

    // todo get average

}
