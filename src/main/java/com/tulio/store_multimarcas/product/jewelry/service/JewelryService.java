package com.tulio.store_multimarcas.product.jewelry.service;

import com.tulio.store_multimarcas.product.jewelry.domain.dto.ResponseSearchJewelryDTO;
import com.tulio.store_multimarcas.user.dto.PageRequestDTO;

import java.util.List;

public interface JewelryService {

    public List<ResponseSearchJewelryDTO> getAllJewelry(PageRequestDTO pageRequestDTO);
}
