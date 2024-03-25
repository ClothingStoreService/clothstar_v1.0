package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import org.store.clothstar.order.domain.PaymentMethod;
import org.store.clothstar.order.domain.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResponse {
	private Long orderId;
	private Long memberId;
	private Long deliveryId;
	private LocalDateTime createdAt;
	private Status status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	private PaymentMethod paymentMethod;
	private int totalPaymentPrice;
}
