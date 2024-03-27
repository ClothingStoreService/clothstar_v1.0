package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.domain.PaymentMethod;
import org.store.clothstar.order.domain.Status;
import org.store.clothstar.order.utils.CreateOrderId;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateOrderRequest {

	private int totalShippingPrice;
	private int totalProductsPrice;
	@NotNull
	private PaymentMethod paymentMethod;
	private int totalPaymentPrice;

	public static CreateOrderRequest from(Order order) {
		return CreateOrderRequest.builder().build();
	}

	public Order toOrder() {
		return Order.builder()
			.orderId(CreateOrderId.createOrderId())
			.memberId(1L)
			.addressId(1L)
			.createdAt(LocalDateTime.now())
			.status(Status.APPROVE)
			.totalShippingPrice(totalShippingPrice)
			.totalProductsPrice(totalProductsPrice)
			.paymentMethod(paymentMethod)
			.totalPaymentPrice(totalPaymentPrice)
			.build();
	}
}
