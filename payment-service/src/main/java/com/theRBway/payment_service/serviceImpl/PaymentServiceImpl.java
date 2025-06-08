package com.theRBway.payment_service.serviceImpl;

import com.theRBway.payment_service.dao.PaymentRepository;
import com.theRBway.payment_service.entity.Payment;
import com.theRBway.payment_service.factory.PaymentFactory;
import com.theRBway.payment_service.factory.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentFactory paymentFactory;

    public Payment makePayment(String method, double amount) {
        PaymentMethod paymentMethod=paymentFactory.getPaymentMethod(method);
        Payment payment=paymentMethod.processPayment(amount);
        return paymentRepository.save(payment);
    }
}
