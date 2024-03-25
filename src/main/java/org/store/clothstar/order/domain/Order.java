package org.store.clothstar.order.domain;

import java.time.LocalDateTime;

import org.store.clothstar.order.dto.CreateOrderResponse;
import org.store.clothstar.order.dto.OrderResponse;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Order {
	private Long orderId;
	private Long memberId;
	private Long addressId;
	private LocalDateTime createdAt;
	private Status status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	private PaymentMethod paymentMethod;
	private int totalPaymentPrice;

	public Order(
		Long orderId,
		Long memberId,
		Long addressId,
		LocalDateTime createdAt,
		Status status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPaymentPrice
	) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.addressId = addressId;
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
		Long addressId,
		LocalDateTime createdAt,
		Status status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPaymentPrice
	) {
		return new OrderResponse(
			orderId = this.getOrderId(),
			memberId = this.getMemberId(),
			addressId = this.getAddressId(),
			createdAt = this.getCreatedAt(),
			status = this.getStatus(),
			totalShippingPrice = this.getTotalShippingPrice(),
			totalProductsPrice = this.getTotalProductsPrice(),
			paymentMethod = this.getPaymentMethod(),
			totalPaymentPrice = this.getTotalPaymentPrice()
		);
	}

	public CreateOrderResponse toCreateOrderResponse(
		Long orderId,
		Long memberId,
		Long addressId,
		LocalDateTime createdAt,
		Status status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPaymentPrice
	) {
		return new CreateOrderResponse(
			orderId = this.getOrderId(),
			memberId = this.getMemberId(),
			addressId = this.getAddressId(),
			createdAt = this.getCreatedAt(),
			status = this.getStatus(),
			totalShippingPrice = this.getTotalShippingPrice(),
			totalProductsPrice = this.getTotalProductsPrice(),
			paymentMethod = this.getPaymentMethod(),
			totalPaymentPrice = this.getTotalPaymentPrice()
		);
	}
}
