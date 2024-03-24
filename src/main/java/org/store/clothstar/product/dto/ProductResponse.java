package org.store.clothstar.product.dto;

import lombok.Builder;
import lombok.Getter;
import org.store.clothstar.product.domain.Product;
import org.store.clothstar.product.domain.type.ProductStatus;

@Getter
@Builder
public class ProductResponse {
    private String name;
    private int price;
    private int stock;
    private ProductStatus productStatus;

    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .productStatus(product.getStatus())
                .build();
    }
}
