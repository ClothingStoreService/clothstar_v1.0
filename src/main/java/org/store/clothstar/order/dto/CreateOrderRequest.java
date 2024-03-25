package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.store.clothstar.order.domain.Order;
import org.store.clothstar.order.domain.PaymentMethod;
import org.store.clothstar.order.domain.Status;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateOrderRequest {

	private Long orderId;
	private Long memberId;
	private Long addressId;
	private Status status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	@NotNull
	private PaymentMethod paymentMethod;
	private int totalPaymentPrice;

	public CreateOrderRequest(
		Long orderId,
		Long memberId,
		Long addressId,
		Status status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPaymentPrice
	) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.addressId = addressId;
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
			.addressId(addressId)
			.createdAt(LocalDateTime.now())
			.status(status)
			.totalShippingPrice(totalShippingPrice)
			.totalProductsPrice(totalProductsPrice)
			.paymentMethod(paymentMethod)
			.totalPaymentPrice(totalPaymentPrice)
			.build();
	}
}
