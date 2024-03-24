package org.store.clothstar.product.domain.type;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductStatus {
    COMING_SOON,
    FOR_SALE,
    ON_SALE,
    SOLD_OUT,
    HIDDEN,
    DISCOUNTED;
}