package com.theRBway.order_service.observer;

public class SmsNotificationObserver implements OrderObserver{
    @Override
    public void notifyObservers() {
        System.out.println("SMS Notification sent to user");
    }
}
