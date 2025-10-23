package com.tulio.store_multimarcas.kafka.domain;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Builder
@Jacksonized
public record MessageRequest(String topic, String message) implements Serializable {
}
