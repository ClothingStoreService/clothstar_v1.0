package org.store.clothstar.order.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.order.dto.CreateOrderRequest;

@Mapper
public interface OrderRepository {
	int save(CreateOrderRequest createOrderRequest);

	CreateOrderRequest get(Long orderId);
}
