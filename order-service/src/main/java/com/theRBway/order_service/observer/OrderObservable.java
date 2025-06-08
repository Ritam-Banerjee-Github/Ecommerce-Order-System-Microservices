package com.theRBway.order_service.observer;

public interface OrderObservable {
 void addObserver(OrderObserver observer);
 void notifyObservers();
}
