package com.testjava.zaratest.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PriceDTO extends Serializable {
    long serialVersionUID = 7721555670692885637L;

    Long getProductId();

    Long getBrandId();

    Long getPriceListId();

    LocalDateTime getStartDate();

    LocalDateTime getEndDate();

    BigDecimal getPrice();

    Integer getPriority();

    void setProductId(Long productId);

    void setBrandId(Long brandId);

    void setPriceListId(Long priceListId);

    void setStartDate(LocalDateTime startDate);

    void setEndDate(LocalDateTime endDate);

    void setPrice(BigDecimal price);

    void setPriority(Integer priority);
}
