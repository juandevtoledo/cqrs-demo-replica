package com.diplomado.queuelistener.infrastructure.entrypoint.queue;

import com.diplomado.queuelistener.application.usecase.MessageBrokerUseCase;
import com.diplomado.queuelistener.infrastructure.utils.ConversionUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaMessage {

    private final MessageBrokerUseCase messageBrokerUseCase;

    @KafkaListener(topicPattern = "my_topic_prefix.public.transaction", groupId = "group1")
    public void consumeEvent(@Payload(required = false) String eventMsg) {
        if (eventMsg == null) return;
        log.info("message received: {}", eventMsg);

        Map<String, Object> event = ConversionUtils.jsonString2Map(eventMsg);

        Map<String, Object> payload = (Map<String, Object>) event.get("payload");
        String operation = (String) payload.get("op");

        if (operation.equals("c")) {
            messageBrokerUseCase.create((Map<String, Object>) payload.get("after"));
        }
    }

}
