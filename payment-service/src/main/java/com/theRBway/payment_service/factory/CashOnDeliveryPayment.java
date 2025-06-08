package com.theRBway.payment_service.factory;

import com.theRBway.payment_service.entity.Payment;

public class CashOnDeliveryPayment implements PaymentMethod{
    @Override
    public Payment processPayment(double amount) {
        return Payment.builder().amount(amount)
                .cashback(0)
                .status("PAID")
                .paymentMethod("CASH_ON_DELIVERY")
                .build();
    }
}
