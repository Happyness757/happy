package com.happy.CRUD_HAPPY.controller;

import com.happy.CRUD_HAPPY.entity.MilestoneEntity;
import com.happy.CRUD_HAPPY.exception.MilestoneNotFoundException;
import com.happy.CRUD_HAPPY.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/milestone_info")
public class MilestoneController {

    @Autowired
    private MilestoneRepository milestoneRepository;

    //code for getting all milestone
    @GetMapping
    public List<MilestoneEntity> getAllMilestone(MilestoneEntity milestoneEntity){
       return milestoneRepository.findAll();
    }

    //code for adding/create milestone
    @PostMapping
    public MilestoneEntity createMilestone(@RequestBody MilestoneEntity milestoneEntity){
       return milestoneRepository.save(milestoneEntity);
    }

    //Code for reading or getting milestone
    @GetMapping("{id}")
    public ResponseEntity<MilestoneEntity> getMilestoneById(@PathVariable long id){
        MilestoneEntity milestoneEntity = milestoneRepository.findById(id)
                .orElseThrow(()->new MilestoneNotFoundException("Milestone not found"));
        return ResponseEntity.ok(milestoneEntity);
    }

    //Code for updating milestone
    @PutMapping("{id}")
    public ResponseEntity<MilestoneEntity> updateMilestone(@PathVariable long id,@RequestBody MilestoneEntity milestoneEntityDetails){
        MilestoneEntity milestoneEntity = milestoneRepository.findById(id)
                .orElseThrow(()->new MilestoneNotFoundException("Milestone not found"));

        milestoneEntity.setMilestoneName(milestoneEntityDetails.getMilestoneName());
        milestoneEntity.setMilestoneDescription(milestoneEntityDetails.getMilestoneDescription());
        milestoneEntity.setStartDate(milestoneEntityDetails.getStartDate());
        milestoneEntity.setEndDate(milestoneEntityDetails.getEndDate());
        milestoneEntity.setStatus(milestoneEntityDetails.getStatus());

        milestoneRepository.save(milestoneEntity);
        return ResponseEntity.ok(milestoneEntity);
    }

    //Code for deleting milestone
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteMilestone(@PathVariable long id){
        MilestoneEntity deleteMile = milestoneRepository.findById(id)
                .orElseThrow(()->new MilestoneNotFoundException("Milestone Not found"));

        milestoneRepository.delete(deleteMile);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
