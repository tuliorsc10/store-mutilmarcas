package com.tulio.store_multimarcas.controller;

import com.tulio.store_multimarcas.domain.dto.PageRequestDTO;
import com.tulio.store_multimarcas.domain.dto.UserDTO;
import com.tulio.store_multimarcas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers(@RequestParam int pageNumber, @RequestParam int pageSize) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO(pageNumber, pageSize);
        return ResponseEntity.ok(userService.getAllUsers(pageRequestDTO));
    }

    @GetMapping
    public ResponseEntity<UserDTO> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
}
