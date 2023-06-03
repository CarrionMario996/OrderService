package com.order.service.service;

import com.order.service.model.dto.DetailOrderDto;
import com.order.service.model.dto.OrderDto;
import com.order.service.model.entity.DetailOrder;
import com.order.service.model.entity.Order;

import java.util.List;

public interface IOrderService {
    List<OrderDto> findAllOrders();
    List<DetailOrderDto> findAllOrderDetails();
    List<DetailOrder> findByOrderIdDetails(Long id);
    List<Order>findByClientId(Long clientId);
}
