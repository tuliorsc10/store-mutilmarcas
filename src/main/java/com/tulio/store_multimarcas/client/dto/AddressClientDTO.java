package com.tulio.store_multimarcas.client.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;

@Builder
@Jacksonized
public record AddressClientDTO(
        @NotBlank
        String street,
        @NotBlank
        String number,
        @NotBlank
        String district,
        @DefaultValue(value = "Taquaritinga do Norte")
        String city,
        @DefaultValue(value = "PE")
        String state,
        @DefaultValue(value = "BR")
        String country,
        String complement
) implements Serializable {
}
