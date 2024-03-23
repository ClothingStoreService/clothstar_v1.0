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
	private LocalDateTime createdTime;
	private String status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	private PaymentMethod paymentMethod;
	private int totalPrice;

	// @Builder
	// public OrderResponse(
	// 	Long orderId,
	// 	Long memberId,
	// 	Long deliveryId,
	// 	LocalDateTime createdDate,
	// 	LocalDateTime createdTime,
	// 	String status,
	// 	int totalShippingPrice,
	// 	int totalProductsPrice,
	// 	PaymentMethod paymentMethod,
	// 	int totalPrice
	// ) {
	// 	this.orderId = orderId;
	// 	this.memberId = memberId;
	// 	this.deliveryId = deliveryId;
	// 	this.createdDate = createdDate;
	// 	this.createdTime = createdTime;
	// 	this.status = status;
	// 	this.totalShippingPrice = totalShippingPrice;
	// 	this.totalProductsPrice = totalProductsPrice;
	// 	this.paymentMethod = paymentMethod;
	// 	this.totalPrice = totalPrice;
	// }
}
