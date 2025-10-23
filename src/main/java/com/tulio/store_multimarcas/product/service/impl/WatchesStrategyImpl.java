package com.tulio.store_multimarcas.product.service.impl;

import com.tulio.store_multimarcas.product.dto.ProductEnum;
import com.tulio.store_multimarcas.product.dto.ResponseCreateProductDTO;
import com.tulio.store_multimarcas.product.dto.ResponseSearchProductDTO;
import com.tulio.store_multimarcas.product.dto.ResponseUpdateProductDTO;
import com.tulio.store_multimarcas.product.service.ProdutStrategy;

import java.util.UUID;

public class WatchesStrategyImpl implements ProdutStrategy {
    @Override
    public ResponseSearchProductDTO getProduct(UUID id) {
        return null;
    }

    @Override
    public ResponseCreateProductDTO createProduct() {
        return null;
    }

    @Override
    public ResponseUpdateProductDTO updateProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public boolean getStrategy(ProductEnum productEnum) {
        return ProductEnum.WATCHES.equals(productEnum);
    }
}
