package com.shafaat.grade.book.service;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.dto.AssessmentsDTO;
import com.shafaat.grade.book.dto.StudentsDTO;
import com.shafaat.grade.book.entity.Allocations;
import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GradeServiceTest {

    // Objects
    static StudentsDTO student;
//    static AssessmentsDTO assessments;
    static List<AssessmentsDTO> assessmentList = new ArrayList<AssessmentsDTO>();;

    // Services
    static StudentsService studentsService;
    static AssessmentService assessmentService;
    static GradeService gradeService;
    static AllocationsService allocationsService;

    // IDs
    static Integer studentId = new Random().nextInt(999999);


    // Allocations Map
    static Map<String, Allocations> allocationsMap = new HashMap<String, Allocations>();


    @BeforeAll
    public static void initialize() throws Exception {

        allocationsService = new AllocationsService();


        // ********************************************
        // Allocating Percentages
        Allocations assignments = new Allocations();
        assignments.setAllocation(10.1);
        assignments.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        assignments = allocationsService.addAllocation(assignments);
        allocationsMap.put(AssessmentTypesEnum.ASSIGNMENT.toString(), assignments);

        Allocations exams = new Allocations();
        exams.setAllocation(89.9);
        exams.setAssessmentType(AssessmentTypesEnum.EXAM.toString());
        exams = allocationsService.addAllocation(exams);
        allocationsMap.put(AssessmentTypesEnum.EXAM.toString(), exams);


        Allocations extra = new Allocations();
        extra.setAllocation(2.0);
        extra.setAssessmentType(AssessmentTypesEnum.EXTRA_CREDIT.toString());
        extra = allocationsService.addAllocation(extra);
        allocationsMap.put(AssessmentTypesEnum.EXTRA_CREDIT.toString(), extra);


        // ********************************************
        // Adding Student
        student = new StudentsDTO();
        student.setStudentId(studentId);
        student.setStudentName("Sally");

        studentsService = new StudentsService();
        student = studentsService.addStudent(student);
        assessmentService = new AssessmentService();


        // ********************************************
        // Initialize GradeService
        gradeService = new GradeService();
    }


    @Test
    @Order(1)
    void getGradeAfterAssignment1() throws Exception {
        AssessmentsDTO assignment1 = new AssessmentsDTO();
        assignment1.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        assignment1.setMaxScore(100.0);
        assignment1.setScore(85.0);

        assignment1 = assessmentService.addAssessment(studentId, assignment1);
        assessmentList.add(assignment1);

        Double grade = gradeService.calculateGrade(assessmentList, allocationsMap);

        Double rounded = _roundTo2Decimals(grade);

        assertTrue(rounded == 85.0);

    }


    @Test
    @Order(2)
    void getGradeAfterAssignment2() throws Exception {
        AssessmentsDTO assignment = new AssessmentsDTO();
        assignment.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        assignment.setMaxScore(100.0);
        assignment.setScore(88.0);

        assignment = assessmentService.addAssessment(studentId, assignment);
        assessmentList.add(assignment);

        Double grade = gradeService.calculateGrade(assessmentList, allocationsMap);
        Double rounded = _roundTo2Decimals(grade);

        assertTrue(rounded == 86.5);
    }


    @Test
    @Order(3)
    void getGradeAfterExtraCredit() throws Exception {
        AssessmentsDTO assignment = new AssessmentsDTO();
        assignment.setAssessmentType(AssessmentTypesEnum.EXTRA_CREDIT.toString());


        assignment = assessmentService.addAssessment(studentId, assignment);
        assessmentList.add(assignment);

        Double grade = gradeService.calculateGrade(assessmentList, allocationsMap);
        Double rounded = _roundTo2Decimals(grade);

        assertTrue(rounded == 88.5);
    }


    @Test
    @Order(4)
    void getGradeAfterAssignment3() throws Exception {
        AssessmentsDTO assignment = new AssessmentsDTO();
        assignment.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        assignment.setMaxScore(100.0);
        assignment.setScore(92.0);

        assignment = assessmentService.addAssessment(studentId, assignment);
        assessmentList.add(assignment);

        Double grade = gradeService.calculateGrade(assessmentList, allocationsMap);
        Double rounded = _roundTo2Decimals(grade);

        assertTrue(rounded == 90.33);
    }


    @Test
    @Order(5)
    void getGradeAfterExam() throws Exception {
        AssessmentsDTO assignment = new AssessmentsDTO();
        assignment.setAssessmentType(AssessmentTypesEnum.EXAM.toString());
        assignment.setMaxScore(100.0);
        assignment.setScore(91.0);

        assignment = assessmentService.addAssessment(studentId, assignment);
        assessmentList.add(assignment);

        Double grade = gradeService.calculateGrade(assessmentList, allocationsMap);

        Double rounded = _roundTo2Decimals(grade);

        assertTrue(rounded == 90.93);

    }

    private Double _roundTo2Decimals(Double target){
        long factor = (long) Math.pow(10, 2);
        target = target * factor;
        long tmp = Math.round(target);
        return (double) tmp / factor;
    }


}