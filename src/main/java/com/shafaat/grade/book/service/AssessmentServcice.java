package com.shafaat.grade.book.service;


import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.dto.AssessmentsDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AssessmentServcice {

    public AssessmentsDTO addAssessment(AssessmentsDTO assessmentsDTO) throws Exception {

        AssessmentTypesEnum type;
        try{
            type = AssessmentTypesEnum.valueOf(assessmentsDTO.getAssessmentType());
        }catch (Exception e){
            throw new Exception("Invalid Assessment Submitted");
        }

        if(assessmentsDTO.getScore() == null || assessmentsDTO.getMaxScore() == null){
            throw new Exception("Submit the valid scores");
        }

        assessmentsDTO.setAssessmentId(new Random().nextInt(999999999));

        return assessmentsDTO;
    }
}
