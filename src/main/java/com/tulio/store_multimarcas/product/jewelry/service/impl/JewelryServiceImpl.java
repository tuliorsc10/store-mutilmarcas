package com.tulio.store_multimarcas.product.jewelry.service.impl;

import com.tulio.store_multimarcas.product.jewelry.domain.dto.ResponseJewelry;
import com.tulio.store_multimarcas.product.jewelry.domain.entity.JewelryEntity;
import com.tulio.store_multimarcas.product.jewelry.mapper.JewelryMapper;
import com.tulio.store_multimarcas.product.jewelry.repository.JewelryRepository;
import com.tulio.store_multimarcas.product.jewelry.service.JewelryService;
import com.tulio.store_multimarcas.user.dto.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JewelryServiceImpl implements JewelryService {

    private final JewelryRepository jewelryRepository;
    private final JewelryMapper mapper;

    @Override
    public List<ResponseJewelry> getAllJewelry(PageRequestDTO pageRequestDTO) {
        Page<JewelryEntity> page = jewelryRepository.findAll(PageRequest.of(pageRequestDTO.pageNumber(), pageRequestDTO.pageSize()));
        List<ResponseJewelry> jewelryList = new ArrayList<>();
        page.forEach(jewelry -> jewelryList.add(mapper.toResponseJewelry(jewelry)));
        return jewelryList;
    }
}
