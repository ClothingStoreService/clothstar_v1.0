package org.store.clothstar.product.domain.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductStatus {
    COMING_SOON("준비중"),
    FOR_SALE("판매중"),
    ON_SALE("할인중"),
    SOLD_OUT("품절"),
    HIDDEN("숨김"),
    DISCOUNTED("단종");
    private final String description;

}