package org.store.clothstar.product.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.product.domain.Product;

@Mapper
public interface ProductRepository {
    int save(Product product);
    Product selectByProductId(Long productId);
}