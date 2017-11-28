package com.reference.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface CustomSink {

    String INPUT = "test";

    @Input(INPUT)
    SubscribableChannel input();
}
