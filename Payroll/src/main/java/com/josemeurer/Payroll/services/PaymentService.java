package com.josemeurer.Payroll.services;

import com.josemeurer.Payroll.dtos.PaymentDto;
import com.josemeurer.Payroll.dtos.WorkerDto;
import com.josemeurer.Payroll.entities.Payment;
import com.josemeurer.Payroll.mappers.PaymentMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;
    private final PaymentMapper paymentMapper;

    private final RestTemplate restTemplate;

    public PaymentService(RestTemplate restTemplate, PaymentMapper paymentMapper) {
        this.restTemplate = restTemplate;
        this.paymentMapper = paymentMapper;
    }

    public PaymentDto getPayment(long workerId, int days) {
        Map<String, String> uriVariables = Map.of("id", String.valueOf(workerId));

        WorkerDto worker = restTemplate.getForObject(
                workerHost + "/workers/{id}",
                WorkerDto.class,
                uriVariables
        );

        if (worker == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trabalhador não encontrado.");

        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);
        PaymentDto dto = paymentMapper.entityToDto(payment);
        dto.setTotal(payment.getTotal());

        return dto;
    }
}
