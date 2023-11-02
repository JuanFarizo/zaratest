package com.testjava.zaratest.domain.service;

import com.testjava.zaratest.domain.model.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {
    PriceDTO findPrice(Long productId, Long brandId, LocalDateTime dateTime);
}
