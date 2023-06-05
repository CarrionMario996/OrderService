package com.order.service.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class OrderDto {
    private String orderId;
    private String country;
    private String total;
    private String status;
    private Long clientId;
    Optional<PaymentDto> payments;

    public OrderDto(String orderId, String country, String total, String status, Long clientId) {
        this.orderId = orderId;
        this.country = country;
        this.total = total;
        this.status = status;
        this.clientId = clientId;
    }
}
