package com.josemeurer.payroll.integrations.worker;

import com.josemeurer.payroll.dtos.WorkerDto;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkerFallbackFactory implements FallbackFactory<WorkerFeignClient> {

    @Override
    public WorkerFeignClient create(Throwable cause) {
        return new WorkerFeignClient() {
            @Override
            public ResponseEntity<WorkerDto> findById(Long id) {
                var fallback = new WorkerDto();
                fallback.setId(id);
                fallback.setName("ERROR");
                fallback.setDailyIncome(0.0);
                return ResponseEntity.ok(fallback);
            }
        };
    }
}
