package com.tulio.store_multimarcas.configuration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public class KafkaConsumerService {

    @KafkaListener(
            topics = "meu-topico",
            groupId = "my-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(@Payload String message,
                       @Header(KafkaHeaders.RECEIVED_KEY) String key,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

        System.out.println("Mensagem recebida: " + message);
        System.out.println("Key: " + key + ", Tópico: " + topic + ", Partição: " + partition);
    }

    // Listener para múltiplos tópicos
    @KafkaListener(topics = {"topico-1", "topico-2"})
    public void listenMultipleTopics(String message) {
        System.out.println("Mensagem de múltiplos tópicos: " + message);
    }
}
