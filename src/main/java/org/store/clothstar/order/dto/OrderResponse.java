package org.store.clothstar.order.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.store.clothstar.order.domain.PaymentMethod;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OrderResponse {
	private Long orderId;
	private Long memberId;
	private Long deliveryId;
	private LocalDateTime createdDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdTime;
	private String status;
	private int totalShippingPrice;
	private int totalProductsPrice;
	private PaymentMethod paymentMethod;
	private int totalPrice;
}
