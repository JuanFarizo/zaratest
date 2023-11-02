package com.testjava.zaratest.domain.service.impl;

import com.testjava.zaratest.datasource.repository.PriceRepository;
import com.testjava.zaratest.domain.model.PriceDTO;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.testjava.zaratest.domain.ModelFactory.createPriceDTO;
import static java.time.LocalDateTime.now;
import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void givenEmptyListWhenFindPriceThenThrowException() {
        given(priceRepository.findAllByProductIdAndBrandIdAndDate(any(), any(), any())).willReturn(EMPTY_LIST);
        assertThrows(EntityNotFoundException.class, () -> priceService.findPrice(1L, 1L, now()));
    }

    @Test
    void givenPriceDTOWhenFindPriceThenNotThrowException() {
        given(priceRepository.findAllByProductIdAndBrandIdAndDate(any(), any(), any())).willReturn(List.of(createPriceDTO()));
        assertDoesNotThrow(() -> priceService.findPrice(1L, 1L, now()));
    }

    @Test
    void givenListPriceDTOWhenFindPriceThenReturnPriceDTOHigherPriority() {
        PriceDTO priceDTO = createPriceDTO();
        PriceDTO priceDTOHighPriority = createPriceDTO();
        priceDTOHighPriority.setPriority(2);

        given(priceRepository.findAllByProductIdAndBrandIdAndDate(any(), any(), any()))
                .willReturn(List.of(priceDTO, priceDTOHighPriority));

        PriceDTO price = priceService.findPrice(1L, 1L, now());

        assertNotNull(price);
        assertEquals(priceDTOHighPriority.getPriority(), price.getPriority());
    }
}