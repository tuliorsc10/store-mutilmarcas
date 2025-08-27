package com.tulio.store_multimarcas.client.mapper;

import com.tulio.store_multimarcas.client.dto.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientEntity toClientEntity(CreateClientRequestDTO request);

    CreateClientReponseDTO toCreateClientResponse(ClientEntity entity);

    RetrieveClientDTO toRetrieveClient(ClientEntity entity);

    UpdateClientResponseDTO toUpdateClientResponse(ClientEntity entity);
}
