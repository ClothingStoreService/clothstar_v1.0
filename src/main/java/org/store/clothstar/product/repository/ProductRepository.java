package org.store.clothstar.product.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.product.domain.Product;

import java.util.List;

@Mapper
public interface ProductRepository {
    List<Product> selectAllProductsNotDeleted();
    Product selectByProductId(Long productId);
    int save(Product product);
}