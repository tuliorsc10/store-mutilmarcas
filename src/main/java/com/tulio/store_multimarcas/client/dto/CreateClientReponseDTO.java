package com.tulio.store_multimarcas.client.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Builder
@Jacksonized
public record CreateClientReponseDTO(
        String name,
        String email,
        String phone,
        AddressClientDTO address
) implements Serializable {
}
