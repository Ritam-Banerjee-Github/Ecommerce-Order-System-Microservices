package com.theRBway.order_service.serviceImpl;

import com.theRBway.order_service.dto.OrderRequestDto;
import com.theRBway.order_service.dto.PaymentDto;
import com.theRBway.order_service.entity.Order;
import com.theRBway.order_service.feignClient.InventoryClient;
import com.theRBway.order_service.feignClient.PaymentClient;
import com.theRBway.order_service.observer.EmailNotificationObserver;
import com.theRBway.order_service.observer.OrderEventPublisher;
import com.theRBway.order_service.observer.OrderObservable;
import com.theRBway.order_service.observer.SmsNotificationObserver;
import com.theRBway.order_service.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderEventPublisher orderEventPublisher;
    @Autowired
    private InventoryClient inventoryClient;
    @Autowired
    private PaymentClient paymentClient;

    @CircuitBreaker(name = "paymentServiceCB", fallbackMethod = "paymentFallback")
    public String placeOrder(OrderRequestDto orderRequestDto) {
        boolean checkInventory=this.inventoryClient.checkStock(orderRequestDto.getSkuCode());

        if(!checkInventory){
            return "Product is out of stock";
        }

        PaymentDto paymentDto=this.paymentClient.makePayment(orderRequestDto.getPaymentMethod(),orderRequestDto.getAmount());

        Order newOrder=Order.builder()
                .quantity(orderRequestDto.getQuantity())
                .status("PLACED")
                .paymentMethod(orderRequestDto.getPaymentMethod())
                .amount(orderRequestDto.getAmount())
                .skUCode(orderRequestDto.getSkuCode())
                .build();

        Order orderPlaced = this.orderRepository.save(newOrder);

        this.orderEventPublisher.addObserver(new EmailNotificationObserver());
        this.orderEventPublisher.addObserver(new SmsNotificationObserver());
        this.orderEventPublisher.notifyObservers();

        return "Order placed Successfully with ID - "+orderPlaced.getId();
    }

    private String paymentFallback(OrderRequestDto orderRequestDto, Throwable throwable) {
        return "Payment failed";
    }

    public Order getOrderById(Long id){
        Optional<Order> optionalOrder   = this.orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

}
