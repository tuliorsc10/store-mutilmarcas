package com.tulio.store_multimarcas.client.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "ClientEntity")
@Data
@RequiredArgsConstructor
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID clientId;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String documentCpf;
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String district;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String country;
    private String complement;
}
