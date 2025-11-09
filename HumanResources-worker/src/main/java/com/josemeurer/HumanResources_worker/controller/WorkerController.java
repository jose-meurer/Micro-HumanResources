package com.josemeurer.HumanResources_worker.controller;

import com.josemeurer.HumanResources_worker.entities.Worker;

import com.josemeurer.HumanResources_worker.repositories.WokerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WokerRepository wokerRepository;

    public WorkerController(WokerRepository wokerRepository) {
        this.wokerRepository = wokerRepository;
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        var workers = wokerRepository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        var worker = wokerRepository.findById(id).orElse(null);
        return ResponseEntity.ok(worker);
    }
}
