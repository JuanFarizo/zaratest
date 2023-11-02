package com.testjava.zaratest.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(
        name = Price.NAME,
        uniqueConstraints = @UniqueConstraint(
                name = "price_uk", columnNames = {"brand_id", "start_date", "end_date", "price_list_id", "priority", "curr"}
        )
)
public class Price implements Serializable {

    @Serial
    private static final long serialVersionUID = -1896863510838658560L;

    public static final String NAME = "price";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(
            nullable = false,
            name = "brand_id",
            foreignKey = @ForeignKey(name = "price_brand_fk")
    )
    private Brand brand;

    @Column(name = "start_date", columnDefinition = "datetime")
    private LocalDateTime startDate;

    @Column(name = "end_date", columnDefinition = "datetime")
    private LocalDateTime endDate;

    @Column(name = "price_list_id", nullable = false)
    private Long priceListId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(
            nullable = false,
            name = "product_id",
            foreignKey = @ForeignKey(name = "price_product_fk")
    )
    private Product product;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "curr", nullable = false, length = 4)
    @Enumerated(STRING)
    private Currency currency;

    @Column(name = "version", nullable = false, columnDefinition = "integer default 0")
    @Version
    @JsonIgnore
    private Integer version;

    @Column(name = "updated_at", columnDefinition = "datetime")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    enum Currency {
        USD,
        EUR,
        GBP
    }
}

