package com.theRBway.payment_service.controller;

import com.theRBway.payment_service.entity.Payment;
import com.theRBway.payment_service.serviceImpl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentServiceImpl;

    @PostMapping("/api/payment")
    public ResponseEntity<Payment> payment(@RequestParam String method, @RequestParam double amount) {
        return ResponseEntity.ok(this.paymentServiceImpl.makePayment(method.toUpperCase(),amount));
    }
}
