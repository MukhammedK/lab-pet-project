package com.example.deliveryservice.client;

import com.example.deliveryservice.client.dto.DeliveryRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "delivery-service",
        url = "http://localhost:8081"
)
public interface DeliveryClient {

    @PostMapping("/delivery")
    void createDelivery(@RequestBody DeliveryRequest request);
}
