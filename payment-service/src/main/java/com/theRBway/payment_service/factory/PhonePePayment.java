package com.theRBway.payment_service.factory;

import com.theRBway.payment_service.entity.Payment;
import com.theRBway.payment_service.strategy.CashBackStrategy;

public class PhonePePayment implements PaymentMethod {
    private CashBackStrategy cashBackStrategystrategy;

    public PhonePePayment(CashBackStrategy cashBackStrategystrategy) {
        this.cashBackStrategystrategy = cashBackStrategystrategy;
    }

    @Override
    public Payment processPayment(double amount) {
        return Payment.builder()
                .paymentMethod("PHONEPE")
                .status("PAID")
                .amount(amount)
                .cashback(this.cashBackStrategystrategy.processCashBack(amount))
                .build();
    }
}
