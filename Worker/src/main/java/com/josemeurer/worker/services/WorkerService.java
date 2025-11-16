package com.josemeurer.worker.services;

import com.josemeurer.worker.dtos.WorkerDto;
import com.josemeurer.worker.mappers.WorkerMapper;
import com.josemeurer.worker.repositories.WorkerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WorkerService {

    private final WorkerMapper workerMapper;
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository, WorkerMapper workerMapper) {
        this.workerMapper = workerMapper;
        this.workerRepository = workerRepository;
    }

    public List<WorkerDto> findAll(){
        var workers = workerRepository.findAll();
        return workers.stream()
            .map(workerMapper::entityToDto)
            .toList();
    }

    public WorkerDto findById(Long id){
        var worker = workerRepository.findById(id)
            .orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trabalhador não encontrado."));
        return workerMapper.entityToDto(worker);}
}
