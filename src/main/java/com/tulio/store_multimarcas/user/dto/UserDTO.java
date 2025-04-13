package com.tulio.store_multimarcas.user.dto;

import java.util.List;

public record UserDTO(String email, List<Profile> profiles) {
}
