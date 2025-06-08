package com.theRBway.payment_service.strategy;

public class UPICashBackStrategy implements CashBackStrategy{
    @Override
    public double processCashBack(double amount) {
        //20% cashback
        return amount*0.2;
    }
}
