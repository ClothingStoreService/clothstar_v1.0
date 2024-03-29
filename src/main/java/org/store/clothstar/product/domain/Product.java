package org.store.clothstar.product.domain;

import lombok.*;
import org.store.clothstar.product.domain.type.ProductStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class Product {
    private Long productId;
    private Long sellerId;
    private Long categoryId;
    private String name;
    private int price;
    private int stock;
    private ProductStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private LocalDateTime deletedAt;
}