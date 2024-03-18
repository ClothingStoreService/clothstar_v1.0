package org.store.clothstar.order.domain;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
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

	@Builder
	public Order(Long orderId, Long memberId, Long deliveryId, String createdDt, LocalDateTime createdAt, String status,
		int shippingAmt, int productsAmt, PaymentMethod paymentMethod, int paymentAmt) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.deliveryId = deliveryId;
		this.createdDt = createdDt;
		this.createdAt = createdAt;
		this.status = status;
		this.shippingAmt = shippingAmt;
		this.productsAmt = productsAmt;
		this.paymentMethod = paymentMethod;
		this.paymentAmt = paymentAmt;
	}
}
