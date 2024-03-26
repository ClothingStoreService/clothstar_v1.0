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
import org.store.clothstar.member.dto.CreateMemberRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class MemberControllerIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@DisplayName("회원가입 통합 테스트")
	@Test
	void signUpTest() throws Exception {
		//given
		CreateMemberRequest createMemberRequest = getCreateMemberRequest();
		final String url = "/v1/members";
		final String requestBody = objectMapper.writeValueAsString(createMemberRequest);

		//when
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.post(url)
			.contentType(MediaType.APPLICATION_JSON)
			.content(requestBody));

		//then
		actions.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.memberId").exists())
			.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test name"))
			.andDo(print());
	}

	@DisplayName("회원 조회 통합 테스트")
	@Test
	void getMemberTest() throws Exception {
		//given
		final Long memberId = 1L;
		final String url = "/v1/members/" + memberId;

		//when
		ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.get(url)
			.contentType(MediaType.APPLICATION_JSON));

		//then
		actions.andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(print());
	}

	private CreateMemberRequest getCreateMemberRequest() {
		String email = "test@test";
		String password = "test";
		String name = "test name";
		String telNo = "tel No";

		CreateMemberRequest createMemberRequest = new CreateMemberRequest(
			email, password, name, telNo
		);

		return createMemberRequest;
	}
}