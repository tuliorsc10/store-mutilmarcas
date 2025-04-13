package com.tulio.store_multimarcas.product.jewelry.service;

import com.tulio.store_multimarcas.product.jewelry.domain.dto.ResponseJewelry;
import com.tulio.store_multimarcas.user.dto.PageRequestDTO;

import java.util.List;

public interface JewelryService {

    public List<ResponseJewelry> getAllJewelry(PageRequestDTO pageRequestDTO);
}
