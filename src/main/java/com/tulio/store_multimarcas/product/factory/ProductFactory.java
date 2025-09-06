package com.tulio.store_multimarcas.product.factory;

import com.tulio.store_multimarcas.product.dto.ProductEnum;
import com.tulio.store_multimarcas.product.service.ProdutStrategy;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductFactory {
    private final List<ProdutStrategy> produtStrategy;

    public ProdutStrategy getProdutStrategy(ProductEnum productEnum) {
        return produtStrategy.stream().filter(strategy -> strategy.getStrategy(productEnum)).findFirst().orElseThrow();
    }
}
