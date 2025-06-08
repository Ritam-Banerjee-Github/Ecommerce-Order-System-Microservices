package com.theRBway.payment_service.factory;

import com.theRBway.payment_service.entity.Payment;

public interface PaymentMethod {

    Payment processPayment(double amount);
}
