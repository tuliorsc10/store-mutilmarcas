package com.tulio.store_multimarcas.user.service.impl;

import com.tulio.store_multimarcas.user.dto.PageRequestDTO;
import com.tulio.store_multimarcas.user.dto.UserDTO;
import com.tulio.store_multimarcas.user.dto.UserEntity;
import com.tulio.store_multimarcas.user.mapper.UserMapper;
import com.tulio.store_multimarcas.user.repository.UserRepository;
import com.tulio.store_multimarcas.user.service.UserService;
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

    @Override
    public UserDTO getUserByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDTO).orElseThrow();
    }
}
