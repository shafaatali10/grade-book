package com.shafaat.grade.book.controller;


import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.dto.AssessmentsDTO;
import com.shafaat.grade.book.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping("{studentId}")
    public AssessmentsDTO addAssessment(@PathVariable("studentId") Integer studentId,
                                        @RequestBody AssessmentsDTO assessmentsDTO) throws Exception {
        return assessmentService.addAssessment(studentId, assessmentsDTO);
    }

    @DeleteMapping("/{assessmentId}")
    public String removeAssessment(@PathVariable("assessmentId") Integer assessmentId){
        return "Success";
    }

    @PutMapping("/{assessmentId}")
    public AssessmentsDTO updateAssessment(@RequestBody AssessmentsDTO assessmentsDTO){
        return assessmentsDTO;
    }

    @GetMapping("/{assessmentId}")
    public AssessmentsDTO getAssessment(@PathVariable("assessmentId") Integer assessmentId){
        AssessmentsDTO dto = new AssessmentsDTO();
        dto.setAssessmentId(new Random().nextInt(999999999));
        dto.setAssessmentType(AssessmentTypesEnum.EXAM.toString());
        dto.setScore(90.0);
        dto.setMaxScore(100.0);
        return dto;
    }

    @GetMapping()
    public List<AssessmentsDTO> getAssessments(){

        AssessmentsDTO dto = new AssessmentsDTO();
        dto.setAssessmentId(new Random().nextInt(999999999));
        dto.setAssessmentType(AssessmentTypesEnum.EXAM.toString());
        dto.setScore(90.0);
        dto.setMaxScore(100.0);

        AssessmentsDTO dto2 = new AssessmentsDTO();
        dto.setAssessmentId(new Random().nextInt(999999999));
        dto.setAssessmentType(AssessmentTypesEnum.EXAM.toString());
        dto.setScore(90.0);
        dto.setMaxScore(100.0);

        List<AssessmentsDTO> list = new ArrayList<AssessmentsDTO>();
        list.add(dto);
        list.add(dto2);
        return list;
    }

}
