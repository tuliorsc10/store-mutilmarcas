package com.tulio.store_multimarcas.service.impl;

import com.tulio.store_multimarcas.domain.dto.PageRequestDTO;
import com.tulio.store_multimarcas.domain.dto.UserDTO;
import com.tulio.store_multimarcas.domain.dto.UserEntity;
import com.tulio.store_multimarcas.mapper.UserMapper;
import com.tulio.store_multimarcas.repository.UserRepository;
import com.tulio.store_multimarcas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers(PageRequestDTO pageRequest) {
        Page<UserEntity> usersPage = userRepository.findAll(PageRequest.of(pageRequest.pageNumber(), pageRequest.pageSize()));
        List<UserDTO> userDTOList = new ArrayList<>();
        usersPage.forEach(user -> userDTOList.add(userMapper.toDTO(user)));
        return userDTOList;
    }

    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDTO).orElseThrow();
    }
}
