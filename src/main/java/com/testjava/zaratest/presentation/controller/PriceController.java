package com.testjava.zaratest.presentation.controller;

import com.testjava.zaratest.domain.model.FindPriceRequest;
import com.testjava.zaratest.domain.model.Price;
import com.testjava.zaratest.domain.service.PriceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/zara/price")
public class PriceController {

    private final PriceService priceService;

    PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Price> price(@Valid @RequestBody FindPriceRequest request) {
        return ok(priceService.findPrice(request.getApplicationDate(), request.getProductId(), request.getBrandId()));
    }

}
