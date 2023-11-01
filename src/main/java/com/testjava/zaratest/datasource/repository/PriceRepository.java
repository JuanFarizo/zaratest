package com.testjava.zaratest.datasource.repository;

import com.testjava.zaratest.domain.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {

}
