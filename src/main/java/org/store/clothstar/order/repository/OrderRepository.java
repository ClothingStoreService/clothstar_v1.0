package org.store.clothstar.order.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.dto.CreateOrderRequest;

@Mapper
public interface OrderRepository {
	int saveOrder(CreateOrderRequest createOrderRequest);

	Order getOrder(Long orderId);
}
