package org.store.clothstar.order.domain;

import java.time.LocalDateTime;

import org.store.clothstar.order.dto.OrderResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Order {
	private Long orderId;
	private Long memberId;
	private Long deliveryId;
	private LocalDateTime createdAt;
	private String status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	private PaymentMethod paymentMethod;
	private int totalPaymentPrice;

	@Builder
	public Order(
		Long orderId,
		Long memberId,
		Long deliveryId,
		LocalDateTime createdAt,
		String status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPaymentPrice
	) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.deliveryId = deliveryId;
		this.createdAt = createdAt;
		this.status = status;
		this.totalShippingPrice = totalShippingPrice;
		this.totalProductsPrice = totalProductsPrice;
		this.paymentMethod = paymentMethod;
		this.totalPaymentPrice = totalPaymentPrice;
	}

	public OrderResponse toOrderResponse(
		Long orderId,
		Long memberId,
		Long deliveryId,
		LocalDateTime createdAt,
		String status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPaymentPrice
	) {
		return new OrderResponse(
			orderId = this.getOrderId(),
			memberId = this.getMemberId(),
			deliveryId = this.getDeliveryId(),
			createdAt = this.getCreatedAt(),
			status = this.getStatus(),
			totalShippingPrice = this.getTotalShippingPrice(),
			totalProductsPrice = this.getTotalProductsPrice(),
			paymentMethod = this.getPaymentMethod(),
			totalPaymentPrice = this.getTotalPaymentPrice()
		);
	}
}
