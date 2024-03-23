package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import org.store.clothstar.order.domain.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResponse {
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
}
