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
	private LocalDateTime createdDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdAt;

	private String status;

	@NotNull
	private int shippingAmt;

	@NotNull
	private int productsAmt;

	@NotNull
	private PaymentMethod paymentMethod;

	@NotNull
	private int paymentAmt;

	@Builder
	public CreateOrderRequest(
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

	public Order toOrder() {
		return Order.builder()
			.orderId(orderId)
			.memberId(memberId)
			.deliveryId(deliveryId)
			.createdDate(createdDate)
			.createdAt(createdAt)
			.status(status)
			.shippingAmt(shippingAmt)
			.productsAmt(productsAmt)
			.paymentMethod(paymentMethod)
			.paymentAmt(paymentAmt)
			.build();
	}
}
