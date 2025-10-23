package com.tulio.store_multimarcas.product.makeup.domain.entity;

import com.tulio.store_multimarcas.product.makeup.domain.MakeUpCategoryEnum;
import com.tulio.store_multimarcas.product.makeup.domain.MakeUpSubCategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "MakeUpEntity")
public class MakeUpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    private String gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MakeUpCategoryEnum category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MakeUpSubCategoryEnum subcategory;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(unique = true)
    private String sku;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean inStock = true;

    private Integer stockQuantity;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
