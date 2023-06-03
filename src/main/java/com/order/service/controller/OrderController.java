package com.order.service.controller;

import com.order.service.client.IPaymentClient;
import com.order.service.client.ProductClient;
import com.order.service.model.dto.DetailOrderDto;
import com.order.service.model.dto.OrderDto;
import com.order.service.model.entity.DetailOrder;
import com.order.service.model.entity.Order;
import com.order.service.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0.0/order")
public class OrderController {

    @Autowired
    private IOrderService service;

    @GetMapping("/details")
    public List<DetailOrderDto> findAllDetail() {

        return service.findAllOrderDetails();
    }

    @GetMapping()
    public List<OrderDto> findAll() {
        return service.findAllOrders();
    }

    @GetMapping("/details/{orderId}")
    public List<DetailOrder> findByOrderId(@PathVariable Long orderId) {
        return service.findByOrderIdDetails(orderId);
    }

    @GetMapping("/client/{clientId}")
    public List<Order>findByClientId(@PathVariable Long clientId){
        return service.findByClientId(clientId);
    }
}
