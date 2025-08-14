package com.tulio.store_multimarcas.client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Data
@Builder
@Jacksonized
public class CreateClientRequestDTO implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String documentCpf;
    @NotNull
    private AddressClientDTO address;
}
