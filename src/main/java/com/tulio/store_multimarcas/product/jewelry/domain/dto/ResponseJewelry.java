package com.tulio.store_multimarcas.product.jewelry.domain.dto;

import com.tulio.store_multimarcas.product.jewelry.domain.JewelryEnum;
import com.tulio.store_multimarcas.product.jewelry.domain.MetalEnum;

import java.io.Serializable;

public record ResponseJewelry(
        String name,
        String size,
        String value,
        JewelryEnum type,
        MetalEnum metalType) implements Serializable {
}
