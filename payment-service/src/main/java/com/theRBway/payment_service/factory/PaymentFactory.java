package com.theRBway.payment_service.factory;

import com.theRBway.payment_service.entity.Payment;
import com.theRBway.payment_service.strategy.CardCashBackStrategy;
import com.theRBway.payment_service.strategy.UPICashBackStrategy;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {
    public PaymentMethod getPaymentMethod(String method) {
        switch(method){
            case "CREDIT_CARD" : return new CreditCardPayment(new CardCashBackStrategy());
            case "CASH_ON_DELIVERY" : return new CashOnDeliveryPayment();
            case "GPAY" : return new GPayPayment(new UPICashBackStrategy());
            case "PHONEPE" : return new PhonePePayment(new UPICashBackStrategy());
            default: throw new IllegalArgumentException("Invalid_Payment_Method");
        }
    }
}
