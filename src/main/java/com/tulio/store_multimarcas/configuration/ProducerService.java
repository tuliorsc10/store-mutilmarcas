package com.tulio.store_multimarcas.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        log.info("Enviando mensagem para tópico: {}, Mensagem: {}", topic, message);

        // Use CompletableFuture em vez de ListenableFuture
        CompletableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(topic, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Mensagem enviada com sucesso! Tópico: {}, Partição: {}, Offset: {}",
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            } else {
                log.error("Falha ao enviar mensagem: {}", ex.getMessage(), ex);
            }
        });
    }
}
