package org.store.clothstar.order.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.store.clothstar.order.domain.PaymentMethod;
import org.store.clothstar.order.domain.Status;
import org.store.clothstar.order.dto.CreateOrderRequest;
import org.store.clothstar.order.dto.CreateOrderResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class OrderIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@DisplayName("주문생성 통합 테스트")
	@Test
	void saveOrderTest() throws Exception {
		//given
		CreateOrderRequest createOrderRequest = getCreateOrderRequest();
		CreateOrderResponse createOrderResponse = getCreateOrderResponse();
		final String url = "/v1/orders";
		final String requestBody = objectMapper.writeValueAsString(createOrderRequest);

		//when
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(url)
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody));

		//then
		actions.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.orderId").value(createOrderResponse.getOrderId()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.memberId").value(createOrderResponse.getMemberId()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.addressId").value(createOrderResponse.getAddressId()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").isNotEmpty())
			.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("APPROVE"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.totalShippingPrice")
				.value(createOrderResponse.getTotalShippingPrice()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.totalProductsPrice")
				.value(createOrderResponse.getTotalProductsPrice()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMethod").value("CARD"))
			.andExpect(
				MockMvcResultMatchers.jsonPath("$.totalPaymentPrice").value(createOrderResponse.getTotalPaymentPrice()))
			.andDo(print());
	}

	private CreateOrderResponse getCreateOrderResponse() {
		Long orderId = 105L; //추후 고유 아이디 만드는 메서드 generateUniqueOrderId() 생성하여 테스트하기
		Long memberId = 2L;
		Long addressId = 3L;
		LocalDateTime createdAt = LocalDateTime.now();
		Status status = Status.APPROVE;
		int totalShippingPrice = 3000;
		int totalProductsPrice = 50000;
		PaymentMethod paymentMethod = PaymentMethod.CARD;
		int totalPaymentPrice = 53000;

		CreateOrderResponse createOrderResponse = new CreateOrderResponse(
			orderId, memberId, addressId, createdAt, status, totalShippingPrice, totalProductsPrice, paymentMethod,
			totalPaymentPrice
		);
		return createOrderResponse;
	}

	private CreateOrderRequest getCreateOrderRequest() {
		Long orderId = 105L;
		Long memberId = 2L;
		Long addressId = 3L;
		Status status = Status.APPROVE;
		int totalShippingPrice = 3000;
		int totalProductsPrice = 50000;
		PaymentMethod paymentMethod = PaymentMethod.CARD;
		int totalPaymentPrice = 53000;

		CreateOrderRequest createOrderRequest = new CreateOrderRequest(
			orderId, memberId, addressId, status, totalShippingPrice, totalProductsPrice, paymentMethod,
			totalPaymentPrice
		);
		return createOrderRequest;
	}
}
