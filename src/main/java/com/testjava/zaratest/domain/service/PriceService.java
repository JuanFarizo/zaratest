package com.testjava.zaratest.domain.service;

import com.testjava.zaratest.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceService {
    Price findPrice(LocalDateTime date, Long productId, Long brandId);
}
