package org.store.clothstar.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.order.dto.CreateOrderRequest;
import org.store.clothstar.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/v1/orders")
	public CreateOrderRequest saveOrder(CreateOrderRequest createOrderRequest) {
		return orderService.save(createOrderRequest);
	}

	@GetMapping("/v1/orders/{orderId}")
	public CreateOrderRequest getOrder(@PathVariable Long orderId) {
		return orderService.get(orderId);
	}
}


