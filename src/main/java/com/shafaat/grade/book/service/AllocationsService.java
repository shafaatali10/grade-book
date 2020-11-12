package com.shafaat.grade.book.service;

import com.shafaat.grade.book.common.AssessmentTypesEnum;
import com.shafaat.grade.book.entity.Allocations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationsService {

    public Allocations addAllocation(Allocations allocations) throws Exception {
        try{
            AssessmentTypesEnum.valueOf(allocations.getAssessmentType());
        }catch (Exception e){
            throw new Exception("Invalid Assessment Type");
        }
        return allocations;
    }

    public String validateAllocations(List<Allocations> allocations) throws Exception {
        Double total = 0.0;
        for(Allocations a: allocations){
            total = total + a.getAllocation();
        }

        if(total == 100.0){
            return "Success";
        }
        throw new Exception("Invalid Allocation");
    }
}
