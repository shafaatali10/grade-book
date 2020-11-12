package com.shafaat.grade.book.controller;


import com.shafaat.grade.book.dto.AssessmentsDTO;
import com.shafaat.grade.book.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("grades")
public class GradesController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/{studentId}")
    public String getGradeForStudent(@PathVariable("studentId") Integer studentId){
        return gradeService.getGradeForStudent(studentId);
    }

    @GetMapping("/calculate")
    public Double calculateGrade(@RequestBody ArrayList<AssessmentsDTO> assessments) throws Exception {
        return gradeService.calculateGrade(assessments, new HashMap<>());
    }

}
