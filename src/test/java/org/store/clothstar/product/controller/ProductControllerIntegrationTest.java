package org.store.clothstar.product.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    final Long productId = 2L;

    @DisplayName("상품 상세 조회 테스트")
    @Test
    void givenProducts_whenGetProducsList_thenGetProductsWhereDeletedAtIsNull() throws Exception {
        // given
        final String url = "/v1/products/" + productId;

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(url)
                .accept(MediaType.APPLICATION_JSON));

        //then
        resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("\"오구키링\""))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(7900))
                .andExpect(MockMvcResultMatchers.jsonPath("$.stock").value(50))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productStatus").value("COMING_SOON"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").value("2024-03-21T06:56:05"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.modifiedAt").value(Matchers.nullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.deletedAt").value(Matchers.nullValue()));
    }
}
