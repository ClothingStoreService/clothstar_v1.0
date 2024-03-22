package org.store.clothstar.order.repository;

import org.apache.ibatis.annotations.Mapper;
import org.store.clothstar.order.domain.Order;

@Mapper
public interface OrderRepository {
	Order getOrder(Long orderId);

	int saveOrder(Order order);
}
