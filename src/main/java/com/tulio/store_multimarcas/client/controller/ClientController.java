package com.tulio.store_multimarcas.client.controller;

import com.tulio.store_multimarcas.client.dto.CreateClientReponseDTO;
import com.tulio.store_multimarcas.client.dto.CreateClientRequestDTO;
import com.tulio.store_multimarcas.client.service.ClientService;
import com.tulio.store_multimarcas.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("create/client")
    public ResponseEntity<CreateClientReponseDTO> createUser(@RequestBody @Valid CreateClientRequestDTO request) {
        return ResponseEntity.ok(clientService.createClient(request));
    }
}

