package com.tulio.store_multimarcas.product.jewelry.domain.entity;

import com.tulio.store_multimarcas.product.jewelry.domain.JewelryEnum;
import com.tulio.store_multimarcas.product.jewelry.domain.MetalEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelryEntity {
    private UUID id;
    private String name;
    private String size;
    private String value;
    private JewelryEnum type;
    private MetalEnum metalType;
}
