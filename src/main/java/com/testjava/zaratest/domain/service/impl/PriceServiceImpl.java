package com.testjava.zaratest.domain.service.impl;

import com.testjava.zaratest.datasource.repository.PriceRepository;
import com.testjava.zaratest.domain.model.Price;
import com.testjava.zaratest.domain.service.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price findPrice(LocalDateTime dateTime, Long productId, Long brandId) {
        return null;
    }

}
