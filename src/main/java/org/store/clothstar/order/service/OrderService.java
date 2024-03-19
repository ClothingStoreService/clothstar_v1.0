package org.store.clothstar.order.service;

import org.springframework.stereotype.Service;
import org.store.clothstar.order.dto.CreateOrderRequest;
import org.store.clothstar.order.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public CreateOrderRequest save(CreateOrderRequest createOrderRequest) {
		orderRepository.save(createOrderRequest);
		return createOrderRequest;
	}

	public CreateOrderRequest get(Long orderId) {
		return orderRepository.get(orderId);
	}
}
