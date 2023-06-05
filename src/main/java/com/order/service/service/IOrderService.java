package com.order.service.service;

import com.order.service.model.dto.DetailOrderDto;
import com.order.service.model.dto.OrderDto;


import java.util.List;

public interface IOrderService {
    List<OrderDto> findAllOrders();
    List<DetailOrderDto> findAllOrderDetails();
    List<DetailOrderDto> findByOrderIdDetails(Long id);
    List<OrderDto>findByClientId(Long clientId);
}
