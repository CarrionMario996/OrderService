package com.order.service.repository;

import com.order.service.model.dto.DetailOrderDto;
import com.order.service.model.entity.DetailOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends CrudRepository<DetailOrder,Long> {

    @Query(value="select new com.order.service.model.dto.DetailOrderDto(d.productId,d.quantity,d.discounts,d.orderId) from DetailOrder d")
    public List<DetailOrderDto>findAllDetails();

    @Query(value="select new com.order.service.model.dto.DetailOrderDto(d.productId,d.quantity,d.discounts,d.orderId) from DetailOrder d where d.orderId=?1")
    public List<DetailOrderDto> findByOrderIdDetails(Long id);


}
