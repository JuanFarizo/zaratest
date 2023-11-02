package com.testjava.zaratest.datasource.repository;

import com.testjava.zaratest.domain.model.Price;
import com.testjava.zaratest.domain.model.PriceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = """
            SELECT p.product_id as productid, p.brand_id as brandid,
             p.price, p.priority, p.price_list_id as pricelistid,
             p.start_date as startdate, p.end_date as enddate
            FROM price AS p
            WHERE p.product_id = :productId AND p.brand_id = :brandId
            AND p.start_date <= :applicationDate AND p.end_date >= :applicationDate
            """,
    nativeQuery = true)
    List<PriceDTO> findAllByProductIdAndBrandIdAndDate(
            @Param("productId") Long productId,
            @Param("brandId") Long brandId,
            @Param("applicationDate") LocalDateTime applicationDate
    );
}
