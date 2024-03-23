package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.domain.PaymentMethod;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateOrderRequest {
	@NotNull
	private Long orderId;

	@NotNull
	private Long memberId;

	@NotNull
	private Long deliveryId;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdAt;

	private String status;

	@NotNull
	private int totalShippingPrice;

	@NotNull
	private int totalProductsPrice;

	@NotNull
	private PaymentMethod paymentMethod;

	@NotNull
	private int totalPaymentPrice;

	@Builder
	public CreateOrderRequest(
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

	public Order toOrder() {
		return Order.builder()
			.orderId(orderId)
			.memberId(memberId)
			.deliveryId(deliveryId)
			.createdAt(createdAt)
			.status(status)
			.totalShippingPrice(totalShippingPrice)
			.totalProductsPrice(totalProductsPrice)
			.paymentMethod(paymentMethod)
			.totalPaymentPrice(totalPaymentPrice)
			.build();
	}
}
