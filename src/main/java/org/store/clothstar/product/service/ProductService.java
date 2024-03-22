package org.store.clothstar.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.store.clothstar.product.domain.Product;
import org.store.clothstar.product.dto.CreateProductRequest;
import org.store.clothstar.product.dto.CreateProductResponse;
import org.store.clothstar.product.dto.ProductDetailResponse;
import org.store.clothstar.product.dto.ProductListResponse;
import org.store.clothstar.product.repository.ProductRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductListResponse> getAllProduct() {
        List<Product> products = productRepository.selectAllProductsNotDeleted();

        List<ProductListResponse> productResponses = new ArrayList<>();

        for(Product product : products) {
            ProductListResponse productListResponse = ProductListResponse.from(product);
            productResponses.add(productListResponse);
        }

        return productResponses;
    }

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