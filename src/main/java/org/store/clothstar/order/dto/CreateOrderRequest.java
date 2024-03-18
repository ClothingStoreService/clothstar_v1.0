package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.domain.PaymentMethod;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class CreateOrderRequest {
	private Long orderId;
	private Long memberId;
	private Long deliveryId;
	private String createdDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdAt;
	private String status;
	private int shippingAmt;
	private int productsAmt;
	private PaymentMethod paymentMethod;
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
