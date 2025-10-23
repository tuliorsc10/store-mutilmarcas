package com.tulio.store_multimarcas.product.perfume.domain.dto;

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
public class ResponseSearchPerfumeDTO extends ResponseSearchProductDTO implements Serializable {
    private String size;
}
