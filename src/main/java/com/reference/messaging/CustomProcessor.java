package com.reference.messaging;

import org.springframework.stereotype.Component;

@Component
public interface CustomProcessor extends CustomSource, CustomSink {
}
