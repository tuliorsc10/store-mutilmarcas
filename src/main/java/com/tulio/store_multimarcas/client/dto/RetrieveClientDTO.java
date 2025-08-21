package com.tulio.store_multimarcas.client.dto;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Builder
@Jacksonized
public record RetrieveClientDTO(
        String name,
        String email,
        String phone,
        AddressClientDTO addressClientDTO
) implements Serializable {
}
