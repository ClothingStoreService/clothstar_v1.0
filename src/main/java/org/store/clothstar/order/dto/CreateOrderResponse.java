package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import org.store.clothstar.order.domain.PaymentMethod;
import org.store.clothstar.order.domain.Status;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateOrderResponse {
	private Long orderId;
	private Long memberId;
	private Long addressId;
	LocalDateTime createdAt;
	private Status status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	private PaymentMethod paymentMethod;
	private int totalPaymentPrice;

	public CreateOrderResponse(
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
}
