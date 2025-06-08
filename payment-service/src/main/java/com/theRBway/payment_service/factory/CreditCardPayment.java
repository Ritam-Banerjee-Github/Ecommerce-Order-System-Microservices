package com.theRBway.payment_service.factory;

import com.theRBway.payment_service.entity.Payment;
import com.theRBway.payment_service.strategy.CashBackStrategy;

public class CreditCardPayment implements PaymentMethod {
    private CashBackStrategy cashBackStrategy;

    public CreditCardPayment(CashBackStrategy cashBackStrategy) {
        this.cashBackStrategy = cashBackStrategy;
    }
    @Override
    public Payment processPayment(double amount) {
        return Payment.builder()
                .paymentMethod("CREDIT_CARD")
                .amount(amount)
                .status("PAID")
                .cashback(this.cashBackStrategy.processCashBack(amount))
                .build();
    }
}
