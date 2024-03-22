package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.domain.PaymentMethod;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateOrderRequest {
	@NotNull
	final private Long orderId;

	@NotNull
	final private Long memberId;

	@NotNull
	final private Long deliveryId;

	@NotNull
	final private String createdDate;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	final private LocalDateTime createdTime;

	@NotNull
	final private String status;

	@NotNull
	final private int totalShippingPrice;

	@NotNull
	final private int totalProductsPrice;

	@NotNull
	final private PaymentMethod paymentMethod;

	@NotNull
	final private int totalPrice;

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
