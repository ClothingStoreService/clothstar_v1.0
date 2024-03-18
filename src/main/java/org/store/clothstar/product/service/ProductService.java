package org.store.clothstar.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.store.clothstar.product.domain.Product;
import org.store.clothstar.product.dto.CreateProductRequest;
import org.store.clothstar.product.dto.CreateProductResponse;
import org.store.clothstar.product.dto.ProductDetailResponse;
import org.store.clothstar.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public CreateProductResponse saveProduct(CreateProductRequest createProductRequest) {
        Product product = createProductRequest.toProduct();
        productRepository.save(product);
        return CreateProductResponse.from(product);
    }

    public ProductDetailResponse getProduct(Long productId) {
        Product product = productRepository.selectByProductId(productId);
        return ProductDetailResponse.from(product);
    }
}