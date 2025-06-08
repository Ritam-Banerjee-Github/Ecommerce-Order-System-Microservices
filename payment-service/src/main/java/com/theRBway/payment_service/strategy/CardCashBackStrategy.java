package com.theRBway.payment_service.strategy;

public class CardCashBackStrategy implements CashBackStrategy{
    @Override
    public double processCashBack(double amount) {
        //10% cashback
        return amount*0.1;
    }
}
