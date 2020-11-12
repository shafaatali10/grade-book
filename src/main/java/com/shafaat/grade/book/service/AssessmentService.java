package com.shafaat.grade.book.service;


import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.dto.AssessmentsDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AssessmentService {

    public AssessmentsDTO addAssessment(Integer studentId, AssessmentsDTO assessmentsDTO) throws Exception {

        if(studentId == null){
            throw new Exception("Student can't be empty");
        }

        AssessmentTypesEnum type;
        try{
            type = AssessmentTypesEnum.valueOf(assessmentsDTO.getAssessmentType());
        }catch (Exception e){
            throw new Exception("Invalid Assessment Submitted");
        }

        if( ! AssessmentTypesEnum.EXTRA_CREDIT.toString().equals(assessmentsDTO.getAssessmentType()) ) {

            if(assessmentsDTO.getScore() == null || assessmentsDTO.getMaxScore() == null){
                throw new Exception("Scores can't be empty");
            }

            if(assessmentsDTO.getScore()  > assessmentsDTO.getMaxScore()){
                throw new Exception("Submit the valid scores");
            }

        }


        assessmentsDTO.setAssessmentId(new Random().nextInt(999999999));

        return assessmentsDTO;
    }
}
