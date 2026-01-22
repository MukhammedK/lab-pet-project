package kz.lab.petproject.service;

import kz.lab.petproject.entity.Product;
import kz.lab.petproject.repository.ProductRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import kz.lab.petproject.dto.ProductRequest;
import kz.lab.petproject.dto.ProductResponse;
import kz.lab.petproject.mapper.ProductMapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = ProductMapper.toEntity(request);
        Product saved = productRepository.save(product);
        return ProductMapper.toResponse(saved);
    }


    @Async
    public CompletableFuture<List<ProductResponse>> findAll() {
        List<ProductResponse> result = productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();

        return CompletableFuture.completedFuture(result);
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

        return ProductMapper.toResponse(productRepository.save(product));
    }


    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
