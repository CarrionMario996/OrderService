package com.order.service.service;

import com.order.service.client.IPaymentClient;
import com.order.service.client.ProductClient;
import com.order.service.model.dto.DetailOrderDto;
import com.order.service.model.dto.OrderDto;
import com.order.service.repository.OrderDetailRepository;
import com.order.service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderDetailRepository repositoryDetail;

    @Autowired
    private ProductClient client;

    @Autowired
    private IPaymentClient paymentClient;

    @Override
    public List<OrderDto> findAllOrders() {
        List<OrderDto>resultado= repository.findAllOrders();
        for(OrderDto order:resultado) {
            order.setPayments(paymentClient.findByOrderId(order.getOrderId()));
        }
        return resultado;
    }

    @Override
    public List<DetailOrderDto> findByOrderIdDetails(Long id) {

        List<DetailOrderDto>resultado=  repositoryDetail.findByOrderIdDetails(id);
        if(!resultado.isEmpty()){

            for(DetailOrderDto detail : resultado){
               detail.setProducts(client.findByIdProduct(detail.getProductId()));
            }

        }
        return resultado;
    }


    @Override
    public List<DetailOrderDto> findAllOrderDetails() {
        List<DetailOrderDto>resultado=repositoryDetail.findAllDetails();
        if(!resultado.isEmpty()){

            for(DetailOrderDto detail : resultado){
                detail.setProducts(client.findByIdProduct(detail.getProductId()));

            }

        }
        return resultado;
    }

    @Override
    public List<OrderDto>findByClientId(Long clientId){
        List<OrderDto>resultado=repository.findByClientId(clientId);
        for(OrderDto order:resultado) {
            order.setPayments(paymentClient.findByOrderId(order.getOrderId()));
        }
        return resultado;
    }
}
