package com.tulio.store_multimarcas.mapper;

import com.tulio.store_multimarcas.domain.dto.Profile;
import com.tulio.store_multimarcas.domain.dto.UserDTO;
import com.tulio.store_multimarcas.domain.dto.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-23T16:27:02-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        String email = null;
        List<Profile> profiles = null;

        email = user.getEmail();
        List<Profile> list = user.getProfiles();
        if ( list != null ) {
            profiles = new ArrayList<Profile>( list );
        }

        UserDTO userDTO = new UserDTO( email, profiles );

        return userDTO;
    }
}
