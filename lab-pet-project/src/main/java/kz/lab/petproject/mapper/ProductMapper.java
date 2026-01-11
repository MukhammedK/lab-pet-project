package kz.lab.petproject.mapper;

import kz.lab.petproject.dto.ProductRequest;
import kz.lab.petproject.dto.ProductResponse;
import kz.lab.petproject.entity.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return product;
    }

    public static ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
