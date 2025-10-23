package com.tulio.store_multimarcas.product.makeup.domain.dto;

import com.tulio.store_multimarcas.product.dto.ResponseSearchProductDTO;
import com.tulio.store_multimarcas.product.makeup.domain.MakeUpCategoryEnum;
import com.tulio.store_multimarcas.product.makeup.domain.MakeUpSubCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseSearchMakeUpDTO extends ResponseSearchProductDTO implements Serializable {
    private MakeUpCategoryEnum category;
    private MakeUpSubCategoryEnum subcategory;
    private String size;
}
