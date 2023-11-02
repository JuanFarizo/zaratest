package com.testjava.zaratest.domain.service.impl;

import com.testjava.zaratest.domain.model.PriceDTO;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static java.time.LocalDateTime.now;
import static java.time.LocalDateTime.of;
import static java.time.Month.JUNE;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.ANY;

@SpringBootTest
@AutoConfigureTestDatabase(replace = ANY)
class PriceServiceImplIntegrationTest {
    private static final Long PRODUCT_ID = 35455L;
    private static final Long BRAND_ID = 1L;

    private static Stream<Arguments> argumentSource() {
        return Stream.of(
                arguments(PRODUCT_ID, BRAND_ID, of(2020, JUNE, 14, 10, 0)),
                arguments(PRODUCT_ID, BRAND_ID, of(2020, JUNE, 14, 16, 0)),
                arguments(PRODUCT_ID, BRAND_ID, of(2020, JUNE, 14, 21, 0)),
                arguments(PRODUCT_ID, BRAND_ID, of(2020, JUNE, 15, 10, 0)),
                arguments(PRODUCT_ID, BRAND_ID, of(2020, JUNE, 16, 21, 0))
        );
    }

    @Autowired
    private PriceServiceImpl priceService;

    @Test
    void givenNonExistingPriceWhenFindPriceThenThrowException() {
        assertThrows(EntityNotFoundException.class, () -> priceService.findPrice(1L, 1L, now()));
    }

    @ParameterizedTest(name = "{index} => productId=''{0}'', brandId=''{1}'', applicationDate=''{2}''")
    @MethodSource("argumentSource")
    void givenExistingPriceWhenFindPriceThenReturnPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        PriceDTO price = priceService.findPrice(productId, brandId, applicationDate);
        assertNotNull(price);
        assertEquals(productId, price.getProductId());
        assertEquals(brandId, price.getBrandId());
        assertTrue(applicationDate.isEqual(price.getStartDate()) || applicationDate.isAfter(price.getStartDate()));
        assertTrue(applicationDate.isEqual(price.getEndDate()) || applicationDate.isBefore(price.getEndDate()));
    }

}