package com.theRBway.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {

    private String skuCode;
    private Integer quantity;
    private Double amount;
    private String paymentMethod;

}
