package com.tulio.store_multimarcas.user.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProfileType {

    ADMIN(1, "ADMIN"),CLIENT(2,"CLIENT");

    private long cod;
    private String description;
}
