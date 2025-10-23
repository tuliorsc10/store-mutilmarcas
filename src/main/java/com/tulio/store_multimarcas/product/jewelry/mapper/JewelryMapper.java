package com.tulio.store_multimarcas.product.jewelry.mapper;

import com.tulio.store_multimarcas.product.jewelry.domain.dto.ResponseSearchJewelryDTO;
import com.tulio.store_multimarcas.product.jewelry.domain.entity.JewelryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface JewelryMapper {

    JewelryMapper INSTANCE = Mappers.getMapper(JewelryMapper.class);

    ResponseSearchJewelryDTO toResponseJewelry(JewelryEntity entity);
}
