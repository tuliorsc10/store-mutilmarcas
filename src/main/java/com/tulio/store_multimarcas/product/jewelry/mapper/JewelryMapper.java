package com.tulio.store_multimarcas.product.jewelry.mapper;

import com.tulio.store_multimarcas.product.jewelry.domain.dto.ResponseJewelry;
import com.tulio.store_multimarcas.product.jewelry.domain.entity.JewelryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface JewelryMapper {

    JewelryMapper INSTANCE = Mappers.getMapper(JewelryMapper.class);

    ResponseJewelry toResponseJewelry(JewelryEntity entity);
}
