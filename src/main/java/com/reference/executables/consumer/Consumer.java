package com.reference.executables.consumer;

import com.reference.messaging.CustomSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by sanemdeepak on 11/27/17.
 */
@EnableBinding(CustomSink.class)
@SpringBootApplication
@ComponentScan("com.reference.executables.consumer")
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public static void main(String[] args) {
        SpringApplication.run(Consumer.class, args);
    }

//    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "test", durable = "true"),
//            exchange = @Exchange(value = "testexcg", type = "topic", durable = "true")))
//    @SendTo(Source.SAMPLE)

    @StreamListener(CustomSink.INPUT)
    public void receive(String data) {
        //Perform jdbc call or a REST call here, for now just logging it
        logger.info("Received Data from stream as :- {}", data);
    }
}
