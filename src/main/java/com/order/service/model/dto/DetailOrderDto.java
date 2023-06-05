package com.order.service.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailOrderDto {
    private String productId;
    private Long quantity;
    private ProductDto products;
    private String discounts;
    private Long orderId;

    public DetailOrderDto(String productId, Long quantity, String discounts,Long orderId) {
        this.productId = productId;
        this.quantity = quantity;
        this.discounts = discounts;
        this.orderId=orderId;
    }
}
