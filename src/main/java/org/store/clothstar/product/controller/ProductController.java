package org.store.clothstar.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.store.clothstar.product.dto.CreateProductRequest;
import org.store.clothstar.product.dto.CreateProductResponse;
import org.store.clothstar.product.dto.ProductDetailResponse;
import org.store.clothstar.product.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public CreateProductResponse saveProduct(CreateProductRequest createProductRequest){
        return productService.saveProduct(createProductRequest);
    }


    @GetMapping("/{productId}")
    public ProductDetailResponse findProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

}
