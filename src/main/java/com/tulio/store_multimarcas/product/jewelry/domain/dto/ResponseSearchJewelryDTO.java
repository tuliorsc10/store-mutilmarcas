package com.tulio.store_multimarcas.product.jewelry.domain.dto;

import com.tulio.store_multimarcas.product.dto.ResponseSearchProductDTO;
import com.tulio.store_multimarcas.product.jewelry.domain.JewelryEnum;
import com.tulio.store_multimarcas.product.jewelry.domain.MetalEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseSearchJewelryDTO extends ResponseSearchProductDTO implements Serializable {
    private JewelryEnum type;
    private MetalEnum metalType;
}
