package org.store.clothstar.product.domain;

import lombok.*;
import org.store.clothstar.product.domain.type.ProductStatus;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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

    @Builder
    public Product(String name, int price, int stock, ProductStatus status) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }

}