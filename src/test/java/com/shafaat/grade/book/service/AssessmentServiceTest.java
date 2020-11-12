package com.shafaat.grade.book.service;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.dto.AssessmentsDTO;
import com.shafaat.grade.book.dto.StudentsDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AssessmentServiceTest {


    // Objects
    static StudentsDTO student;

    // Services
    static StudentsService studentsService;
    static AssessmentService assessmentService;

    // IDs
    static Integer studentId = new Random().nextInt(999999);

    @BeforeAll
    public static void initialize(){
        student = new StudentsDTO();
        student.setStudentId(studentId);
        student.setStudentName("Sally");

        studentsService = new StudentsService();

        student = studentsService.addStudent(student);


        assessmentService = new AssessmentService();

    }

    @Test
    void addAssessmentHappyCase() throws Exception {
        AssessmentsDTO assessmentsDTO = new AssessmentsDTO();
        assessmentsDTO.setScore(90.0);
        assessmentsDTO.setMaxScore(100.0);
        assessmentsDTO.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        AssessmentsDTO returnAssessment = assessmentService.addAssessment(studentId, assessmentsDTO);
        assertTrue(returnAssessment.getAssessmentType().equals(AssessmentTypesEnum.ASSIGNMENT.toString()));
    }

    @Test
    void addAssessmentWithoutStudent() throws Exception {
        AssessmentsDTO assessmentsDTO = new AssessmentsDTO();
        assessmentsDTO.setScore(90.0);
        assessmentsDTO.setMaxScore(100.0);
        assessmentsDTO.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        Exception thrown = assertThrows(Exception.class, () -> assessmentService.addAssessment(null, assessmentsDTO));

        assertTrue(thrown.getMessage().equals("Student can't be empty"));
    }

    @Test
    void addAssessmentNullScores() throws Exception {
        AssessmentsDTO assessmentsDTO = new AssessmentsDTO();
        //assessmentsDTO.setScore(90.0);
        assessmentsDTO.setMaxScore(100.0);
        assessmentsDTO.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        Exception thrown = assertThrows(Exception.class, () -> assessmentService.addAssessment(studentId, assessmentsDTO));

        assertTrue(thrown.getMessage().equals("Scores can't be empty"));
    }

    @Test
    void addAssessmentExceedsMaxScore() throws Exception {
        AssessmentsDTO assessmentsDTO = new AssessmentsDTO();
        assessmentsDTO.setScore(101.0);
        assessmentsDTO.setMaxScore(100.0);
        assessmentsDTO.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        Exception thrown = assertThrows(Exception.class, () -> assessmentService.addAssessment(studentId, assessmentsDTO));

        assertTrue(thrown.getMessage().equals("Submit the valid scores"));
    }
}