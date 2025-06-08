package com.theRBway.order_service.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.*;

@Component
public class OrderEventPublisher implements OrderObservable {
    List<OrderObserver> orderObserverList=new ArrayList<>();

    @Override
    public void addObserver(OrderObserver observer) {
        orderObserverList.add(observer);
    }

    @Override
    public void notifyObservers() {
         for(OrderObserver observer:orderObserverList){
             observer.notifyObservers();
         }
    }
}
