package com.josemeurer.Payroll.feignclients;

import com.josemeurer.Payroll.dtos.WorkerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "Worker", url = "localhost:8000", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping("/{id}")
    ResponseEntity<WorkerDto> findById(@PathVariable Long id);
}
