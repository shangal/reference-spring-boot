package com.reference.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Created by sanemdeepak on 11/27/17.
 */
@EnableBinding(Source.class)
@SpringBootApplication
@ComponentScan("com.reference.producer")
public class SourceApp {

    public static void main(String[] args) {
        SpringApplication.run(
                SourceApp.class, args);
    }

    @Bean
    @InboundChannelAdapter(
            value = Source.OUTPUT,
            poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1")
    )
    public MessageSource<String> timeMessageSource() {
        return () -> MessageBuilder.withPayload("Data").build();
    }
}
