package org.store.clothstar.member.controller;

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
import org.store.clothstar.member.dto.CreateAddressRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class AddressControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	final Long memberId = 101L;

	@DisplayName("회원 배송지 저장 통합 테스트")
	@Test
	void saveMemberAddrTest() throws Exception {
		//given
		final String url = "/v1/members/" + memberId + "/address";
		CreateAddressRequest createAddressRequest = getCreateAddressRequest();
		final String requestBody = objectMapper.writeValueAsString(createAddressRequest);

		//when
		ResultActions result = mockMvc.perform(
			MockMvcRequestBuilders.post(url)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
		);

		//then
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@DisplayName("회원 배송지 리스트 조회 테스트")
	@Test
	void getMemberAddrTest() throws Exception {
		//given
		final String url = "/v1/members/" + memberId + "/address";
		//when
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(url)
			.accept(MediaType.APPLICATION_JSON));

		//then
		resultActions
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(print())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].memberId").value(memberId));
	}

	private CreateAddressRequest getCreateAddressRequest() {
		final String receiverName = "receiverName";
		final String zipNo = "zipNo";
		final String addressBasic = "addressBasic";
		final String addressDetail = "addressDetail";
		final String telNo = "telNo";
		final String deliveryRequest = "deliveryRequest";
		final boolean defaultAddress = true;

		CreateAddressRequest createAddressRequest = new CreateAddressRequest(
			receiverName, zipNo, addressBasic, addressDetail, telNo, deliveryRequest, defaultAddress
		);
		return createAddressRequest;
	}
}