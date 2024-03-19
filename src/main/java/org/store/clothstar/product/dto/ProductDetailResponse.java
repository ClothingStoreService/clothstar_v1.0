package org.store.clothstar.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.store.clothstar.product.domain.Product;
import org.store.clothstar.product.domain.type.ProductStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class ProductDetailResponse {
    private String name;
    private int price;
    private int stock;
    private ProductStatus productStatus;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;

    public static ProductDetailResponse from(Product product) {
        return ProductDetailResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .productStatus(product.getStatus())
                .createdAt(product.getCreatedAt())
//                .modifiedAt(product.getModifiedAt())
//                .deletedAt(product.getDeletedAt())
                .build();
    }
}