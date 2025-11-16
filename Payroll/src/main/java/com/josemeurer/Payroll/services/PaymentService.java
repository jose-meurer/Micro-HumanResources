package com.josemeurer.Payroll.services;

import com.josemeurer.Payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days){
        var payment = new Payment("Maria", 130.0, days);
        return payment;
    }
}
