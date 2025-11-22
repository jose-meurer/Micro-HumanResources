package com.josemeurer.payroll.services;

import com.josemeurer.payroll.dtos.PaymentDto;
import com.josemeurer.payroll.entities.Payment;
import com.josemeurer.payroll.integrations.worker.WorkerFeignClient;
import com.josemeurer.payroll.mappers.PaymentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PaymentService {

    private final PaymentMapper paymentMapper;
    private final WorkerFeignClient workerFeignClient;

    public PaymentService(WorkerFeignClient workerFeignClient, PaymentMapper paymentMapper) {
        this.workerFeignClient = workerFeignClient;
        this.paymentMapper = paymentMapper;
    }

    public PaymentDto getPayment(long workerId, int days) {

        var worker = workerFeignClient.findById(workerId).getBody();

        if (worker == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trabalhador não encontrado.");

        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);
        PaymentDto dto = paymentMapper.entityToDto(payment);
        dto.setTotal(payment.getTotal());

        return dto;
    }
}
