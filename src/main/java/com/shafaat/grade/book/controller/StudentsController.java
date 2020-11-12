package com.shafaat.grade.book.controller;

import com.shafaat.grade.book.dto.StudentsDTO;
import com.shafaat.grade.book.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController("students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @PostMapping
    public StudentsDTO addStudent(@RequestBody StudentsDTO dto) throws Exception {
        return studentsService.addStudent(dto);
    }

    @DeleteMapping("/{studentId}")
    public String removeStudent(@PathVariable("studentId") Integer studentId){
        return "Success";
    }

    @PutMapping("/{studentId}")
    public StudentsDTO updateStudent(@RequestBody StudentsDTO dto){
        return dto;
    }

    @GetMapping("/{studentId}")
    public StudentsDTO getAssessment(@PathVariable("studentId") Integer studentId){
        StudentsDTO dto = new StudentsDTO();
        dto.setStudentId(new Random().nextInt(999999999));
        dto.setStudentName("Shafaat Khan");
        return dto;
    }

    @GetMapping()
    public List<StudentsDTO> getStudents(){

        StudentsDTO dto = new StudentsDTO();
        dto.setStudentId(new Random().nextInt(999999999));
        dto.setStudentName("Shafaat Khan");

        StudentsDTO dto2 = new StudentsDTO();
        dto.setStudentId(new Random().nextInt(999999999));
        dto.setStudentName("Joe Biden");

        List<StudentsDTO> list = new ArrayList<StudentsDTO>();
        list.add(dto);
        list.add(dto2);
        return list;
    }
}
