package com.tulio.store_multimarcas.user.service;



import com.tulio.store_multimarcas.user.dto.PageRequestDTO;
import com.tulio.store_multimarcas.user.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers(PageRequestDTO pageRequest);
    UserDTO getUserByEmail(String email);
}
