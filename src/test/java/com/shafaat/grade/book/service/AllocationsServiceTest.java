package com.shafaat.grade.book.service;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.entity.Allocations;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllocationsServiceTest {

    AllocationsService allocationsService = new AllocationsService();

    @Test
    void addAllocationHappyCase() throws Exception {
        Allocations a = new Allocations();
        a.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        a.setAllocation(90.0);
        allocationsService.addAllocation(a);
        assertTrue(a.getAssessmentType().equals(AssessmentTypesEnum.ASSIGNMENT.toString()));
    }

    @Test
    void addInvalidAssessmentType() throws Exception{
        Allocations a = new Allocations();
        a.setAssessmentType("Unit Test");
        a.setAllocation(90.0);
        assertThrows(Exception.class, () -> allocationsService.addAllocation(a));
    }

    @Test
    void validateAllocationsHappyCase() throws Exception {

        List<Allocations> allocationsList = new ArrayList<Allocations>();

        Allocations exam = new Allocations();
        exam.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        exam.setAllocation(90.0);
        allocationsList.add(exam);

        Allocations assignment = new Allocations();
        assignment.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        assignment.setAllocation(10.0);
        allocationsList.add(assignment);

        allocationsService.validateAllocations(allocationsList);
    }

    @Test
    void validateAllocationsNegativeCase() throws Exception {

        List<Allocations> allocationsList = new ArrayList<Allocations>();

        Allocations exam = new Allocations();
        exam.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        exam.setAllocation(90.0);
        allocationsList.add(exam);

        Allocations assignment = new Allocations();
        assignment.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());
        assignment.setAllocation(11.0);
        allocationsList.add(assignment);

        assertThrows(Exception.class, () -> allocationsService.validateAllocations(allocationsList));

    }
}