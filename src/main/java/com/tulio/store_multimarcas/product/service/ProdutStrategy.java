package com.tulio.store_multimarcas.product.service;

import com.tulio.store_multimarcas.product.dto.ProductEnum;
import com.tulio.store_multimarcas.product.dto.ResponseCreateProductDTO;
import com.tulio.store_multimarcas.product.dto.ResponseSearchProductDTO;
import com.tulio.store_multimarcas.product.dto.ResponseUpdateProductDTO;

import java.util.UUID;

public interface ProdutStrategy {

    ResponseSearchProductDTO getProduct(UUID id);
    ResponseCreateProductDTO createProduct();
    ResponseUpdateProductDTO updateProduct();
    void deleteProduct();

    boolean getStrategy(ProductEnum productEnum);
}
