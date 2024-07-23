package com.tulio.store_multimarcas.service;

import com.tulio.store_multimarcas.domain.dto.PageRequestDTO;
import com.tulio.store_multimarcas.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers(PageRequestDTO pageRequest);
    UserDTO getUserByEmail(String email);
}
