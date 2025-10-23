package com.tulio.store_multimarcas.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseSearchProductDTO implements Serializable {
    private String name;
    private String brand;
    private String gender;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private Boolean inStock;
}
