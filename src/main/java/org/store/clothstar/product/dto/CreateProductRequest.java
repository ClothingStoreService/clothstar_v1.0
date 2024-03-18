package org.store.clothstar.product.dto;

import lombok.Builder;
import lombok.Getter;
import org.store.clothstar.product.domain.Product;
import org.store.clothstar.product.domain.type.ProductStatus;

@Getter
@Builder
public class CreateProductRequest {
    private String name;
    private int price;
    private int stock;
    private ProductStatus status;

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .price(price)
                .stock(stock)
                .status(status)
                .build();
    }
}