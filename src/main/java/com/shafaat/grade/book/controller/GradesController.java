package com.shafaat.grade.book.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("grades")
public class GradesController {

    @GetMapping("/{studentId}")
    public String getGradeForStudent(@PathVariable("studentId") Integer studentId){
        return "Grade for Student " + studentId +" is:: 89%";
    }

}
