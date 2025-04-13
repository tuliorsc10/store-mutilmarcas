package com.tulio.store_multimarcas.product.jewelry.controller;

import com.tulio.store_multimarcas.product.jewelry.domain.dto.ResponseJewelry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JewelryController {

    @GetMapping
    public ResponseEntity<List<ResponseJewelry>> getAllJewelry(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return ResponseEntity.ok(userService.getAllUsers(pageRequestDTO));
    }
}
