package org.store.clothstar.product.dto;

import lombok.Builder;
import lombok.Getter;
import org.store.clothstar.product.domain.Product;
import org.store.clothstar.product.domain.type.ProductStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Builder
public class CreateProductRequest {

    @NotBlank(message = "상품 이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "상품 가격을 입력해주세요.")
    @Positive(message = "상품 가격은 0보다 커야 합니다.")
    private int price;

    @PositiveOrZero(message = "재고는 음수가 될 수 없습니다.")
    private int stock;

    @Builder.Default
    private ProductStatus status = ProductStatus.COMING_SOON;


    public Product toProduct() {
        return Product.builder()
                .name(name)
                .price(price)
                .stock(stock)
                .status(status)
                .build();
    }
}