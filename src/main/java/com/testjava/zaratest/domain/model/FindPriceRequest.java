package com.testjava.zaratest.domain.model;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class FindPriceRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 8740545478528208487L;

    @NotNull(message = "ProductId must be provided.")
    private Long productId;
    @NotNull(message = "BrandId must be provided.")
    private Long brandId;
    @NotNull(message = "ApplicationDate must be provided.")
    private LocalDateTime applicationDate;

    public static FindPriceRequest createFindPriceRequest(
            Long productId,
            Long brandId,
            LocalDateTime applicationDate
    ) {
        FindPriceRequest findPriceRequest = new FindPriceRequest();
        findPriceRequest.setProductId(productId);
        findPriceRequest.setBrandId(brandId);
        findPriceRequest.setApplicationDate(applicationDate);
        return findPriceRequest;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }
}
