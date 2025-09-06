package com.tulio.store_multimarcas.product.service;

import com.tulio.store_multimarcas.product.dto.ProductEnum;

public interface ProdutStrategy {

    boolean getStrategy(ProductEnum productEnum);
}
