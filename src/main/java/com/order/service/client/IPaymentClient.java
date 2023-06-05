package com.order.service.client;

import com.order.service.model.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(url="${payment-api.path}",name="PaymentApi")
public interface IPaymentClient {

     @GetMapping("/api/v1.0.0/payment/{id}")
     Optional<PaymentDto> findByIdClient(@PathVariable Long id);
}
