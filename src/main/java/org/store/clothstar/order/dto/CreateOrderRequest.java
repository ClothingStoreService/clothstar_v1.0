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
	private String createdDt;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdAt;

	@NotNull
	private String status;

	@NotNull
	private int shippingAmt;

	@NotNull
	private int productsAmt;

	@NotNull
	private PaymentMethod paymentMethod;

	@NotNull
	private int paymentAmt;

	public Order toOrder() {
		return Order.builder()
			.orderId(orderId)
			.memberId(memberId)
			.deliveryId(deliveryId)
			.createdDt(createdDt)
			.createdAt(createdAt)
			.status(status)
			.shippingAmt(shippingAmt)
			.productsAmt(productsAmt)
			.paymentMethod(paymentMethod)
			.paymentAmt(paymentAmt)
			.build();
	}
}
