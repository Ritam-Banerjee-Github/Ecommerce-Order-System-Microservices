package com.theRBway.payment_service.factory;

import com.theRBway.payment_service.entity.Payment;
import com.theRBway.payment_service.strategy.CashBackStrategy;

public class GPayPayment implements PaymentMethod {
    private CashBackStrategy cashBackStrategy;

    public GPayPayment(CashBackStrategy cashBackStrategy) {
        this.cashBackStrategy = cashBackStrategy;
    }
    @Override
    public Payment processPayment(double amount) {
        return Payment.builder()
                .paymentMethod("GPAY")
                .amount(amount)
                .cashback(this.cashBackStrategy.processCashBack(amount))
                .status("PAID")
                .build();
    }
}
