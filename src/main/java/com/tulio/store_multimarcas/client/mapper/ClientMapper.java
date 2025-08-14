package com.tulio.store_multimarcas.client.mapper;

import com.tulio.store_multimarcas.client.dto.ClientEntity;
import com.tulio.store_multimarcas.client.dto.CreateClientReponseDTO;
import com.tulio.store_multimarcas.client.dto.CreateClientRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientEntity toClientEntity(CreateClientRequestDTO request);
    CreateClientReponseDTO toCreateClientResponse(ClientEntity entity);
}
