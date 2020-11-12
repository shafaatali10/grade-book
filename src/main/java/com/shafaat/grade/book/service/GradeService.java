package com.shafaat.grade.book.service;


import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.dto.AssessmentsDTO;
import com.shafaat.grade.book.entity.AbstractAssessmentType;
import com.shafaat.grade.book.entity.Allocations;
import com.shafaat.grade.book.entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GradeService {

    public String getGradeForStudent(Integer studentId) {
        return "Grade for Student " + studentId +" is:: 89%";
    }

    public Double calculateGrade(List<AssessmentsDTO> assessments, Map<String, Allocations> allocationsMap) throws Exception {
        List<AbstractAssessmentType> entityList = _convertDtoToEntity(assessments);

        AssessmentFactory factory = new AssessmentFactory(entityList);

        List<AbstractAssessmentType> assignments = factory.getAssessments(AssessmentTypesEnum.ASSIGNMENT);
        List<AbstractAssessmentType> extraCredits = factory.getAssessments(AssessmentTypesEnum.EXTRA_CREDIT);
        List<AbstractAssessmentType> exams = factory.getAssessments(AssessmentTypesEnum.EXAM);

        boolean ignoreAllocation = exams.size() == 0;

        Double assignmentsAvg = assignments.size() > 0 ?
                _calculateIndividualTypeAverage(assignments)
                : 0.0;

        Double addExtraCredits = extraCredits.size() > 0 ?
                extraCredits.size() * allocationsMap.get(AssessmentTypesEnum.EXTRA_CREDIT.toString()).getAllocation()
                : 0.0;

        Double examsAvg = exams.size() > 0 ?
                _calculateIndividualTypeAverage(exams)
                : 0.0;

        return _weightedAverage((assignmentsAvg + addExtraCredits), examsAvg, allocationsMap, ignoreAllocation );

    }

    private Double _weightedAverage(Double assignmentsAvg,
                                    Double examsAvg,
                                    Map<String, Allocations> allocationsMap,
                                    boolean ignoreAllocation) {
        Double assignmentsWeightage = allocationsMap.get(AssessmentTypesEnum.ASSIGNMENT.toString()).getAllocation() / 100;


        Double examsWeightage = allocationsMap.get(AssessmentTypesEnum.EXAM.toString()).getAllocation() / 100;

        if(ignoreAllocation){
            return assignmentsAvg;
        }else{
            return (assignmentsWeightage * assignmentsAvg)  + (examsWeightage * examsAvg);
        }

    }

    private List<AbstractAssessmentType> _convertDtoToEntity(List<AssessmentsDTO> assessments) throws Exception {
        List<AbstractAssessmentType> entityList=new ArrayList<AbstractAssessmentType>();
        if(assessments!=null && assessments.size()>0){
              for(AssessmentsDTO dto: assessments){
                  AssessmentFactory factory = new AssessmentFactory();
                  AbstractAssessmentType entity = factory.getAssessmentEntity(dto.getAssessmentType());
                  entity.setScore(dto.getScore());
                  entity.setMaxScore(dto.getMaxScore());
                  entityList.add(entity);
              }
          }
        return entityList;
    }

    private Double _calculateIndividualTypeAverage(List<AbstractAssessmentType> assessmentTypeList){

        Double score = 0.0;
        for(AbstractAssessmentType a: assessmentTypeList){
            score = score + a.getScore();
        }


        return score/assessmentTypeList.size();

    }
}
