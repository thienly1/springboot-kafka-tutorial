package net.javamicro.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}") //if you add topicName field here as in KafkaTopicConfig, it won't work, because this is a key value
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
