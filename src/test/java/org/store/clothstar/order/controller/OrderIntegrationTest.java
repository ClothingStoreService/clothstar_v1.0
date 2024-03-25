package org.store.clothstar.order.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

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
import org.store.clothstar.order.dto.CreateOrderRequest;

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
		final String url = "/v1/orders";
		final String requestBody = objectMapper.writeValueAsString(createOrderRequest);

		//when
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(url)
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody));

		//then
		actions.andExpect(MockMvcResultMatchers.status().isOk())
			// .andExpect(MockMvcResultMatchers.jsonPath("$.orderId").value())
			// .andExpect(MockMvcResultMatchers.jsonPath("$.memberId").value())
			// .andExpect(MockMvcResultMatchers.jsonPath("$.addressId").value())
			.andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").isNotEmpty())
			.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("APPROVE"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.totalShippingPrice")
				.value(createOrderRequest.getTotalShippingPrice()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.totalProductsPrice")
				.value(createOrderRequest.getTotalProductsPrice()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.paymentMethod").value("CARD"))
			.andExpect(
				MockMvcResultMatchers.jsonPath("$.totalPaymentPrice").value(createOrderRequest.getTotalPaymentPrice()))
			.andDo(print());
	}

	private CreateOrderRequest getCreateOrderRequest() {
		int totalShippingPrice = 3000;
		int totalProductsPrice = 50000;
		PaymentMethod paymentMethod = PaymentMethod.CARD;
		int totalPaymentPrice = 53000;

		return CreateOrderRequest.builder()
			.totalShippingPrice(totalShippingPrice)
			.totalProductsPrice(totalProductsPrice)
			.paymentMethod(paymentMethod)
			.totalPaymentPrice(totalPaymentPrice)
			.build();
	}
}
