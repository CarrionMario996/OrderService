package com.order.service.repository;

import com.order.service.model.dto.OrderDto;
import com.order.service.model.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository  extends CrudRepository<Order,Long> {

    @Query(nativeQuery = true,value="select d.* from orders d where client_id=?1")
    public List<Order> findByClientId(Long clientId);

    @Query(value="select new com.order.service.model.dto.OrderDto(o.orderId,o.country,o.total,o.status,o.clientId) from Order o")
    public List<OrderDto>findAllOrders();
}
