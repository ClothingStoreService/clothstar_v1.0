package org.store.clothstar.order.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.clothstar.order.dto.CreateOrderRequest;
import org.store.clothstar.order.dto.CreateOrderResponse;
import org.store.clothstar.order.dto.OrderResponse;
import org.store.clothstar.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@GetMapping("/v1/orders/{orderId}")
	public OrderResponse getOrder(@PathVariable Long orderId) {
		return orderService.getOrder(orderId);
	}

	@PostMapping("/v1/orders")
	public CreateOrderResponse saveOrder(@RequestBody @Validated CreateOrderRequest createOrderRequest) {
		return orderService.saveOrder(createOrderRequest);
	}
}


