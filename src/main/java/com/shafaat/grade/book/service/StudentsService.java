package com.shafaat.grade.book.service;


import com.shafaat.grade.book.dto.StudentsDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentsService {

    // For simplicity not adding any logic
    public StudentsDTO addStudent(StudentsDTO dto) {
        dto.setStudentId(new Random().nextInt(999999999));
        return dto;
    }
}
