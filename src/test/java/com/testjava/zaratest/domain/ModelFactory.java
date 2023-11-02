package com.testjava.zaratest.domain;

import com.testjava.zaratest.domain.model.PriceDTO;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.math.BigDecimal;

import static java.time.LocalDateTime.now;

public class ModelFactory {
    public static PriceDTO createPriceDTO() {
        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        PriceDTO projection = factory.createProjection(PriceDTO.class);
        projection.setProductId(1L);
        projection.setBrandId(1L);
        projection.setPriceListId(1L);
        projection.setStartDate(now().minusDays(1));
        projection.setEndDate(now().plusDays(1));
        projection.setPrice(new BigDecimal("1.0"));
        projection.setPriority(1);
        return projection;
    }
}
