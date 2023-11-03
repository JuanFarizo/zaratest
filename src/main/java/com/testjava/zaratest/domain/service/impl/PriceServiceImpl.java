package com.testjava.zaratest.domain.service.impl;

import com.testjava.zaratest.datasource.repository.PriceRepository;
import com.testjava.zaratest.domain.model.PriceDTO;
import com.testjava.zaratest.domain.service.PriceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceDTO findPrice(Long productId, Long brandId, LocalDateTime applicationDate) {
        List<PriceDTO> prices = priceRepository.findAllByProductIdAndBrandIdAndDate(productId, brandId, applicationDate);
        return prices.stream()
                .max(Comparator.comparingInt(PriceDTO::getPriority))
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Entity not found with parameters product id: %s, brandId: %s, date: %s ", productId, brandId, applicationDate)));
    }

}
