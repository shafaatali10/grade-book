package com.shafaat.grade.book.controller;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.dto.StudentsDTO;
import com.shafaat.grade.book.entity.Allocations;
import com.shafaat.grade.book.service.AllocationsService;
import com.shafaat.grade.book.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("allocations")
public class AllocationController {

    @Autowired
    private AllocationsService allocationsService;

    @PostMapping
    public Allocations addAllocation(@RequestBody Allocations allocations) throws Exception {
        return allocationsService.addAllocation(allocations);
    }

    @DeleteMapping("/{assessmentType}")
    public String removeAllocation(@PathVariable("assessmentType") String assessmentType){
        return "Success";
    }

    @PutMapping("/{assessmentType}")
    public Allocations updateAllocation(@RequestBody Allocations allocations){
        return allocations;
    }

    @GetMapping("/{assessmentType}")
    public Allocations getAllocations(@PathVariable("assessmentType") String assessmentType){
        Allocations dto = new Allocations();
        dto.setAllocation(80.1);
        dto.setAssessmentType(AssessmentTypesEnum.valueOf(assessmentType).toString());
        return dto;
    }

    @GetMapping
    public List<Allocations> getAllocations(){

        Allocations dto = new Allocations();
        dto.setAllocation(80.1);
        dto.setAssessmentType(AssessmentTypesEnum.EXAM.toString());

        Allocations dto2 = new Allocations();
        dto2.setAllocation(19.9);
        dto2.setAssessmentType(AssessmentTypesEnum.ASSIGNMENT.toString());

        List<Allocations> list = new ArrayList<Allocations>();
        list.add(dto);
        list.add(dto2);
        return list;
    }
}
