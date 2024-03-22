package org.store.clothstar.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.store.clothstar.product.domain.Product;
import org.store.clothstar.product.dto.CreateProductRequest;
import org.store.clothstar.product.dto.CreateProductResponse;
import org.store.clothstar.product.dto.ProductDetailResponse;
import org.store.clothstar.product.dto.ProductResponse;
import org.store.clothstar.product.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductListResponse> getAllProduct() {
    public List<ProductResponse> getAllProduct() {
        return productRepository.selectAllProductsNotDeleted().stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

            productResponses.add(productListResponse);
    public ProductDetailResponse getProduct(Long productId) {
        Product product = productRepository.selectByProductId(productId);
        return ProductDetailResponse.from(product);
    }

    public CreateProductResponse saveProduct(CreateProductRequest createProductRequest) {
    public CreateProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = createProductRequest.toProduct();
        productRepository.save(product);
        return CreateProductResponse.from(product);
    }
}