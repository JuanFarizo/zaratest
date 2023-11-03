package com.testjava.zaratest.presentation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.testjava.zaratest.domain.ModelFactory;
import com.testjava.zaratest.domain.model.FindPriceRequest;
import com.testjava.zaratest.domain.service.impl.PriceServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import static java.time.LocalDateTime.now;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    private static final String PRICE_URI = "/zaratest/price/";
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(WRITE_DATES_AS_TIMESTAMPS);
    @MockBean
    private PriceServiceImpl priceService;

    @Autowired
    private MockMvc mvc;

    @Test
    void givenPriceDTOWhenPriceThenReturnSuccessfulAndResponseStructure() throws Exception {
        given(priceService.findPrice(anyLong(), anyLong(), any())).willReturn(ModelFactory.createPriceDTO());
        FindPriceRequest findPriceRequest = FindPriceRequest.createFindPriceRequest(1L, 1L, now());
        mvc.perform(MockMvcRequestBuilders.get(PRICE_URI)
                        .content(objectMapper.writeValueAsString(findPriceRequest))
                        .contentType("application/json"))
                .andExpectAll(
                        status().is2xxSuccessful(),
                        MockMvcResultMatchers.jsonPath("$.product_id").exists(),
                        MockMvcResultMatchers.jsonPath("$.brand_id").exists(),
                        MockMvcResultMatchers.jsonPath("$.price_list_id").exists(),
                        MockMvcResultMatchers.jsonPath("$.start_date").exists(),
                        MockMvcResultMatchers.jsonPath("$.end_date").exists(),
                        MockMvcResultMatchers.jsonPath("$.priority").exists()
                );
    }

    @Test
    void givenExceptionWhenPriceThenReturnClientError() throws Exception {
        given(priceService.findPrice(anyLong(), anyLong(), any())).willThrow(EntityNotFoundException.class);
        FindPriceRequest findPriceRequest = FindPriceRequest.createFindPriceRequest(1L, 1L, now());
        mvc.perform(MockMvcRequestBuilders.get(PRICE_URI)
                        .content(objectMapper.writeValueAsString(findPriceRequest))
                        .contentType("application/json"))
                .andExpect(status().is4xxClientError());
    }
}