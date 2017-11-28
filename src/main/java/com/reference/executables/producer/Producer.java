package com.reference.executables.producer;

import com.reference.messaging.CustomSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;
import java.util.function.Supplier;

/**
 * Created by sanemdeepak on 11/27/17.
 */
@EnableBinding(CustomSource.class)
@SpringBootApplication
@ComponentScan("com.reference.executables.producer")
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    public static void main(String[] args) {
        SpringApplication.run(
                Producer.class, args);
    }

    @Bean
    @InboundChannelAdapter(
            value = CustomSource.OUTPUT,
            poller = @Poller(fixedDelay = "1000", maxMessagesPerPoll = "1")
    )
    public static MessageSource<String> publish() {
        String payload = String.join("Data", Producer.randomValueGenerator());
        logger.info("Publishing Data :- {}", payload);
        return () -> MessageBuilder.withPayload(payload).build();
    }

    public static String randomValueGenerator() {
        return UUID.randomUUID().toString();
    }
}
