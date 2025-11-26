package com.tulio.store_multimarcas.configuration.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageWithCallback(String topic, String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Message sent successfully to topic: {} | Offset: {}",
                        topic, result.getRecordMetadata().offset());
            } else {
                log.error("Failed to send message to topic: {}", topic, ex);
            }
        });
    }

    public boolean sendSync(String topic, String message) {
        try {
            SendResult<String, String> result = kafkaTemplate.send(topic, message)
                    .get(30, TimeUnit.SECONDS);

            log.info("Message confirmed. Offset: {}", result.getRecordMetadata().offset());
            return true;

        } catch (TimeoutException e) {
            log.error("Timeout while sending message", e);
            return false;

        } catch (InterruptedException | ExecutionException e) {
            log.error("Error sending message", e);
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
