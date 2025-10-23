package com.tulio.store_multimarcas.product.clothes.domain.dto;

import com.tulio.store_multimarcas.product.clothes.domain.ClothesCategoryEnum;
import com.tulio.store_multimarcas.product.clothes.domain.ClothesSubCategoryEnum;
import com.tulio.store_multimarcas.product.clothes.domain.ClothingSize;
import com.tulio.store_multimarcas.product.dto.ResponseSearchProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResponseSearchClothesDTO extends ResponseSearchProductDTO implements Serializable {
    private ClothesCategoryEnum type;
    ClothesSubCategoryEnum subcategory;
    private ClothingSize size;
}
