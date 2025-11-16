package com.josemeurer.worker.mappers;

import com.josemeurer.worker.dtos.WorkerDto;
import com.josemeurer.worker.entities.Worker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkerMapper {

    WorkerDto entityToDto(Worker entity);
    Worker dtoToEntity(WorkerDto dto);
}
