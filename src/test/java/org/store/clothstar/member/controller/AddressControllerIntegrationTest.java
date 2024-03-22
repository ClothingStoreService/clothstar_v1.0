package org.store.clothstar.member.controller;

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
import org.store.clothstar.member.dto.CreateAddressRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class AddressControllerIntegrationTest {
	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	protected ObjectMapper objectMapper;

	@DisplayName("회원 배송지 저장 통합 테스트")
	@Test
	void addrSaveTest() throws Exception {
		//given
		final String url = "/v1/members/2/address";
		final Long memberId = 1L;
		final String receiverNm = "receiverNm";
		final String zipNo = "zipNo";
		final String address1 = "address1";
		final String address2 = "address2";
		final String telNo = "telNo";
		final String deliveryReq = "deliveryReq";
		final int isDefault = 0;

		CreateAddressRequest createAddressRequest = new CreateAddressRequest(memberId, receiverNm, zipNo, address1,
			address2, telNo, deliveryReq,
			isDefault);

		final String requestBody = objectMapper.writeValueAsString(createAddressRequest);

		//when
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post(url)
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody));

		//then
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}
}