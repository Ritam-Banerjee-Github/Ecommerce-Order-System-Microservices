package com.theRBway.order_service.feignClient;

import com.theRBway.order_service.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "payment-service")
public interface PaymentClient {

    @PostMapping("/api/payment")
    public PaymentDto makePayment(@RequestParam String method, @RequestParam double amount);
}
