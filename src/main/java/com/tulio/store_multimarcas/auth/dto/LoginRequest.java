package com.tulio.store_multimarcas.auth.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Builder
@Jacksonized
public record LoginRequest(String username, String password) implements Serializable {
}
