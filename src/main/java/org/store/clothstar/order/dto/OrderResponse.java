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
	private String createdDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdAt;
	private String status;
	private int shippingAmt;
	private int productsAmt;
	private PaymentMethod paymentMethod;
	private int paymentAmt;
}
