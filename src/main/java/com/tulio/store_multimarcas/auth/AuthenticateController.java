package com.tulio.store_multimarcas.auth;

import com.tulio.store_multimarcas.auth.dto.LoginRequest;
import com.tulio.store_multimarcas.user.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticateController {

    private final AuthenticationService authenticationService;

    @PostMapping("authenticate")
    public String authenticate(@RequestBody LoginRequest loginRequest) {
        return authenticationService.authenticate(loginRequest.username(), loginRequest.password());
    }
}
