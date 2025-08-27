package com.tulio.store_multimarcas.client.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateClientResquestDTO implements Serializable {

    private String name;

    private String email;

    private String phone;
    @NotBlank
    private String documentCpf;

    private AddressClientDTO address;
}
