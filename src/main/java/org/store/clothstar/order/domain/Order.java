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
	private LocalDateTime createdDate;
	private LocalDateTime createdTime;
	private String status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	private PaymentMethod paymentMethod;
	private int totalPrice;

	@Builder
	public Order(
		Long orderId,
		Long memberId,
		Long deliveryId,
		LocalDateTime createdDate,
		LocalDateTime createdTime,
		String status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPrice
	) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.deliveryId = deliveryId;
		this.createdDate = createdDate;
		this.createdTime = createdTime;
		this.status = status;
		this.totalShippingPrice = totalShippingPrice;
		this.totalProductsPrice = totalProductsPrice;
		this.paymentMethod = paymentMethod;
		this.totalPrice = totalPrice;
	}

	public OrderResponse toOrderResponse(
		Long orderId,
		Long memberId,
		Long deliveryId,
		LocalDateTime createdDate,
		LocalDateTime createdTime,
		String status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPrice
	) {
		return new OrderResponse(
			orderId = this.getOrderId(),
			memberId = this.getMemberId(),
			deliveryId = this.getDeliveryId(),
			createdDate = this.getCreatedDate(),
			createdTime = this.getCreatedTime(),
			status = this.getStatus(),
			totalShippingPrice = this.getTotalShippingPrice(),
			totalProductsPrice = this.getTotalProductsPrice(),
			paymentMethod = this.getPaymentMethod(),
			totalPrice = this.getTotalPrice()
		);
	}
}
