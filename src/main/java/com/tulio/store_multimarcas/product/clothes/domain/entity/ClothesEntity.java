package com.tulio.store_multimarcas.product.clothes.domain.entity;

import com.tulio.store_multimarcas.product.clothes.domain.ClothesCategoryEnum;
import com.tulio.store_multimarcas.product.clothes.domain.ClothesSubCategoryEnum;
import com.tulio.store_multimarcas.product.clothes.domain.ClothingSize;
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
@Entity(name = "ClothesEntity")
public class ClothesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String brand;

    private String gender;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    private Integer stockQuantity;

    @Column(nullable = false)
    private Boolean inStock = true;

    @Column(unique = true)
    private String sku;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClothesCategoryEnum category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClothesSubCategoryEnum subcategory;

    @Enumerated(EnumType.STRING)
    private ClothingSize size;
}
