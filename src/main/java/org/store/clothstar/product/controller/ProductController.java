package org.store.clothstar.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.store.clothstar.product.dto.CreateProductRequest;
import org.store.clothstar.product.dto.CreateProductResponse;
import org.store.clothstar.product.dto.ProductDetailResponse;
import org.store.clothstar.product.dto.ProductResponse;
import org.store.clothstar.product.service.ProductService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        List<ProductResponse> productResponses = productService.getAllProduct();
        return ResponseEntity.ok().body(productResponses);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailResponse> findProduct(@PathVariable Long productId){
        ProductDetailResponse productDetailResponse = productService.getProduct(productId);
        return ResponseEntity.ok().body(productDetailResponse);
    }

    @PostMapping
    public ResponseEntity<Long> createProduct(@Validated @RequestBody CreateProductRequest createProductRequest){
        Long productId = productService.createProduct(createProductRequest);
        return ResponseEntity.created(URI.create("/v1/products/" + productId)).build();
    }
}