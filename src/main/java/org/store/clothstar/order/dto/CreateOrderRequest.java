package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.domain.PaymentMethod;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequest {
	@NotNull
	private Long orderId;

	@NotNull
	private Long memberId;

	@NotNull
	private Long deliveryId;

	@NotNull
	private String createdDate;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdTime;

	@NotNull
	private String status;

	@NotNull
	private int totalShippingPrice;

	@NotNull
	private int totalProductsPrice;

	@NotNull
	private PaymentMethod paymentMethod;

	@NotNull
	private int totalPrice;

	public Order toOrder() {
		return Order.builder()
			.orderId(orderId)
			.memberId(memberId)
			.deliveryId(deliveryId)
			.createdDate(createdDate)
			.createdTime(createdTime)
			.status(status)
			.totalShippingPrice(totalShippingPrice)
			.totalProductsPrice(totalProductsPrice)
			.paymentMethod(paymentMethod)
			.totalPrice(totalPrice)
			.build();
	}
}