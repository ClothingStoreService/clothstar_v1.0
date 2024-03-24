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
import org.store.clothstar.member.dto.CreateSellerRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class SellerControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	Long memberId = 1L;

	@DisplayName("판매자 신청 통합 테스트")
	@Test
	void sellerRegisterTest() throws Exception {
		//given
		final String url = "/v1/sellers/" + memberId;
		CreateSellerRequest createSellerRequest = getCreateSellerRequest(memberId);
		final String requestBody = objectMapper.writeValueAsString(createSellerRequest);
		//when
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(url)
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody));
		//then
		actions.andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.brandName").value("test brand name"));
	}

	@DisplayName("판매자 조회 통합 테스트")
	@Test
	void getSellerTest() throws Exception {
		//given
		final String url = "/v1/sellers/" + memberId;
		//when
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(url)
			.contentType(MediaType.APPLICATION_JSON));

		//then
		actions.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(print());
	}

	private CreateSellerRequest getCreateSellerRequest(Long memberId) {
		String brandName = "test brand name";
		String bizNo = "test bizNo";

		CreateSellerRequest createSellerRequest = new CreateSellerRequest(
			brandName, bizNo
		);

		return createSellerRequest;
	}
}