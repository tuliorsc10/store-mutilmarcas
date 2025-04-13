package com.tulio.store_multimarcas.user.mapper;


import com.tulio.store_multimarcas.user.dto.UserDTO;
import com.tulio.store_multimarcas.user.dto.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "profiles", target = "profiles")
    UserDTO toDTO(UserEntity user);
}
