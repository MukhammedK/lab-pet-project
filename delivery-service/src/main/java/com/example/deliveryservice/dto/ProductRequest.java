package com.example.deliveryservice.dto;

import java.math.BigDecimal;

public class ProductRequest {

    private String name;
    private BigDecimal price;
    private String address;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
