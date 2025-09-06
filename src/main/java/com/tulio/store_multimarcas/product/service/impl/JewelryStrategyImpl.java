package com.tulio.store_multimarcas.product.service.impl;

import com.tulio.store_multimarcas.product.dto.ProductEnum;
import com.tulio.store_multimarcas.product.service.ProdutStrategy;

public class JewelryStrategyImpl implements ProdutStrategy {
    @Override
    public boolean getStrategy(ProductEnum productEnum) {
        return ProductEnum.JEWELRY.equals(productEnum);
    }
}
