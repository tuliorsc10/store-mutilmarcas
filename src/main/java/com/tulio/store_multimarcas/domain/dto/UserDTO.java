package com.tulio.store_multimarcas.domain.dto;

import java.util.List;

public record UserDTO(String email, List<Profile> profiles) {
}
