package com.order.service.client;

import com.order.service.model.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="${product-api.path}",name="ProducApi")
public interface ProductClient {

    @GetMapping("/api/v1.0.0/product/{id}")
    ProductDto findByIdProduct(@PathVariable String id);
}
