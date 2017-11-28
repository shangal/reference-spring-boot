package com.reference.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface CustomSource {
    String OUTPUT = "test";

    @Output(OUTPUT)
    MessageChannel output();
}
