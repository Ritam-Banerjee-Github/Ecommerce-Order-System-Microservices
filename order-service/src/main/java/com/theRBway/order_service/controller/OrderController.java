package com.theRBway.order_service.controller;

import com.theRBway.order_service.dto.OrderRequestDto;
import com.theRBway.order_service.entity.Order;
import com.theRBway.order_service.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @PostMapping("/api/order/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
        return ResponseEntity.ok(orderServiceImpl.placeOrder(orderRequestDto));
    }

    @GetMapping("/api/order")
    public ResponseEntity<Order> findOrderById(@RequestParam Long id){
      return ResponseEntity.ok(orderServiceImpl.getOrderById(id));
    }
}
