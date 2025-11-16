package com.josemeurer.worker.controllers;

import com.josemeurer.worker.dtos.WorkerDto;
import com.josemeurer.worker.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private static final Logger logger = LoggerFactory.getLogger(WorkerController.class);
    private final Environment environment;
    private final WorkerService workerService;

    public WorkerController(WorkerService workerService, Environment environment) {
        this.workerService = workerService;
        this.environment = environment;
    }

    @GetMapping
    public ResponseEntity<List<WorkerDto>> findAll(){
        var workers = workerService.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDto> findById(@PathVariable Long id){
        logger.info("PORT= " + environment.getProperty("server.port"));

        var worker = workerService.findById(id);
        return ResponseEntity.ok(worker);
    }
}
