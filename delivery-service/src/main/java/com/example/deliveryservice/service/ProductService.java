package com.example.deliveryservice.service;

import com.example.deliveryservice.client.DeliveryClient;
import com.example.deliveryservice.client.dto.DeliveryRequest;
import com.example.deliveryservice.dto.ProductRequest;
import com.example.deliveryservice.dto.ProductResponse;
import com.example.deliveryservice.entity.Product;
import com.example.deliveryservice.mapper.ProductMapper;
import com.example.deliveryservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final DeliveryClient deliveryClient;

    public ProductService(ProductRepository productRepository,
                          DeliveryClient deliveryClient) {
        this.productRepository = productRepository;
        this.deliveryClient = deliveryClient;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        Product saved = productRepository.save(product);

        deliveryClient.createDelivery(
                new DeliveryRequest(saved.getId(), saved.getAddress())
        );

        return ProductMapper.toResponse(saved);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toResponse(product);
    }

    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setAddress(request.getAddress());

        return ProductMapper.toResponse(productRepository.save(product));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
