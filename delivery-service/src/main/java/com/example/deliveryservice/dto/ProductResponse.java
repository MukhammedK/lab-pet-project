package com.example.deliveryservice.dto;

import java.math.BigDecimal;

public class ProductResponse {

    private Long id;
    private String name;
    private BigDecimal price;
    private String address;

    public ProductResponse(Long id, String name, BigDecimal price, String address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }
}
