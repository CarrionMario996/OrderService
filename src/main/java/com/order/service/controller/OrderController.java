package com.order.service.controller;

import com.order.service.exception.RequestException;
import com.order.service.model.dto.DetailOrderDto;
import com.order.service.model.dto.OrderDto;
import com.order.service.model.entity.DetailOrder;
import com.order.service.model.entity.Order;
import com.order.service.service.IOrderService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> findAllDetail() {
        List<DetailOrderDto>resultado;
        try {
            resultado=service.findAllOrderDetails();
        }catch (FeignException ex) {
            throw new RequestException(ex.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/all")
    public  ResponseEntity<?>findAll() {
        List<OrderDto> resultado;
        try {
            resultado= service.findAllOrders();
        }catch (Exception e){
            throw  new RequestException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/details/{orderId}")
    public  ResponseEntity<?>findByOrderId(@PathVariable Long orderId) {
        List<DetailOrderDto> resultado;
        try {
            resultado=service.findByOrderIdDetails(orderId);
        }catch (Exception e){
            throw  new RequestException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(resultado);

    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<?>findByClientId(@PathVariable Long clientId){
        List<OrderDto>resultado;
        try {
            resultado=service.findByClientId(clientId);
        }catch (Exception e){
            throw  new RequestException(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(resultado);
    }
}
