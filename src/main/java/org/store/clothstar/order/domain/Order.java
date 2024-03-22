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
	private String createdDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdTime;
	private String status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	private PaymentMethod paymentMethod;
	private int totalPrice;

	@Builder
	public Order(
		Long orderId,
		Long memberId,
		Long deliveryId,
		String createdDate,
		LocalDateTime createdTime,
		String status,
		int totalShippingPrice,
		int totalProductsPrice,
		PaymentMethod paymentMethod,
		int totalPrice
	) {
		this.orderId = orderId;
		this.memberId = memberId;
		this.deliveryId = deliveryId;
		this.createdDate = createdDate;
		this.createdTime = createdTime;
		this.status = status;
		this.totalShippingPrice = totalShippingPrice;
		this.totalProductsPrice = totalProductsPrice;
		this.paymentMethod = paymentMethod;
		this.totalPrice = totalPrice;
	}
}
