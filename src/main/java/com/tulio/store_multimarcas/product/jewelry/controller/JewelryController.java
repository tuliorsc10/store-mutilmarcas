package com.tulio.store_multimarcas.product.jewelry.controller;

import com.tulio.store_multimarcas.product.jewelry.domain.dto.ResponseSearchJewelryDTO;
import com.tulio.store_multimarcas.product.jewelry.service.JewelryService;
import com.tulio.store_multimarcas.user.dto.PageRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JewelryController {

    private final JewelryService jewelryService;

    @GetMapping
    public ResponseEntity<List<ResponseSearchJewelryDTO>> getAllJewelry(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return ResponseEntity.ok(jewelryService.getAllJewelry(new PageRequestDTO(pageNumber, pageSize)));
    }
}
