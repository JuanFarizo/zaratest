package com.testjava.zaratest.presentation.controller;

import com.testjava.zaratest.domain.model.FindPriceRequest;
import com.testjava.zaratest.domain.model.PriceDTO;
import com.testjava.zaratest.domain.service.PriceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/zaratest/price")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDTO> price(@Valid @RequestBody final FindPriceRequest request) {
        return ok(priceService.findPrice(request.getProductId(), request.getBrandId(), request.getApplicationDate()));
    }

}
