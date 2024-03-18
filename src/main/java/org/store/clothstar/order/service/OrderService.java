package org.store.clothstar.order.service;

import org.springframework.stereotype.Service;
import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.dto.CreateOrderRequest;
import org.store.clothstar.order.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order save(CreateOrderRequest createOrderRequest) {
		Order order = createOrderRequest.toOrder();
		orderRepository.save(order);
		return order;
	}

	public Order get(Long orderId) {
		return orderRepository.get(orderId);
	}
}
