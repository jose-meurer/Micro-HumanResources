package com.josemeurer.payroll.controllers;

import com.josemeurer.payroll.dtos.PaymentDto;
import com.josemeurer.payroll.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<PaymentDto> getPayment(@PathVariable long workerId, @PathVariable int days) {
        var payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }
}
