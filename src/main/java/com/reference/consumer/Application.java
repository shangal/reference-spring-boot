package com.reference.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.Transformer;

/**
 * Created by sanemdeepak on 11/27/17.
 */
@EnableBinding(Processor.class)
@SpringBootApplication
@ComponentScan("com.reference.consumer")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Transformer(inputChannel = Processor.INPUT,
            outputChannel = Processor.OUTPUT)
    public Object transform(String data) {
        System.out.println(data);
        return data;
    }
}
