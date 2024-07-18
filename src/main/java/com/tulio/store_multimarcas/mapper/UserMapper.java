package com.tulio.store_multimarcas.mapper;

import com.tulio.store_multimarcas.domain.dto.UserDTO;
import com.tulio.store_multimarcas.domain.dto.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "profiles", target = "profiles")
    UserDTO toDTO(UserEntity user);
}
