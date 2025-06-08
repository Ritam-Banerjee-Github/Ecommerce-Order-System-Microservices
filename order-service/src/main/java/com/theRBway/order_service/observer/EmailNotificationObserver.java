package com.theRBway.order_service.observer;

public class EmailNotificationObserver implements OrderObserver{
    @Override
    public void notifyObservers() {
        System.out.println("Email Notification sent to user");
    }
}
