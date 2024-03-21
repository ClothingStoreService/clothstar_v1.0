package org.store.clothstar.order.service;

import org.springframework.stereotype.Service;
import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.dto.CreateOrderRequest;
import org.store.clothstar.order.dto.OrderResponse;
import org.store.clothstar.order.repository.OrderRepository;

@Service
public class OrderService {
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public OrderResponse getOrder(Long orderId) {
		Order order = orderRepository.getOrder(orderId);
		OrderResponse orderResponse = new OrderResponse(order.getOrderId(), order.getMemberId(),
			order.getDeliveryId(), order.getCreatedDt(), order.getCreatedAt(), order.getStatus(),
			order.getShippingAmt(),
			order.getProductsAmt(), order.getPaymentMethod(), order.getPaymentAmt());
		return orderResponse;
	}

	public CreateOrderRequest saveOrder(CreateOrderRequest createOrderRequest) {
		orderRepository.saveOrder(createOrderRequest);
		return createOrderRequest;
	}
}
