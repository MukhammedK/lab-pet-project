package com.example.deliveryservice.mapper;

import com.example.deliveryservice.dto.ProductRequest;
import com.example.deliveryservice.dto.ProductResponse;
import com.example.deliveryservice.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setAddress(request.getAddress());
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAddress()
        );
    }
}
