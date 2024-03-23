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
	private LocalDateTime createdAt;
	private String status;
	private int shippingAmt;
	private int productsAmt;
	private PaymentMethod paymentMethod;
	private int paymentAmt;

	@Builder
	public Order(
		Long orderId,
		Long memberId,
		Long deliveryId,
		LocalDateTime createdDate,
		LocalDateTime createdAt,
		String status,
		int shippingAmt,
		int productsAmt,
		PaymentMethod paymentMethod,
		int paymentAmt
	) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.deliveryId = deliveryId;
		this.createdDate = createdDate;
		this.createdAt = createdAt;
		this.status = status;
		this.shippingAmt = shippingAmt;
		this.productsAmt = productsAmt;
		this.paymentMethod = paymentMethod;
		this.paymentAmt = paymentAmt;
	}

	public OrderResponse toOrderResponse(
		Long orderId,
		Long memberId,
		Long deliveryId,
		LocalDateTime createdDate,
		LocalDateTime createdAt,
		String status,
		int shippingAmt,
		int productsAmt,
		PaymentMethod paymentMethod,
		int paymentAmt
	) {
		return new OrderResponse(
			orderId = this.getOrderId(),
			memberId = this.getMemberId(),
			deliveryId = this.getDeliveryId(),
			createdDate = this.getCreatedDate(),
			createdAt = this.getCreatedAt(),
			status = this.getStatus(),
			shippingAmt = this.getShippingAmt(),
			productsAmt = this.getProductsAmt(),
			paymentMethod = this.getPaymentMethod(),
			paymentAmt = this.getPaymentAmt()
		);
	}
}
