package com.khtm.test.springdataflow.uppercaseprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;


@EnableBinding(Processor.class)
@SpringBootApplication
public class UppercaseProcessorApplication {

    public static void main(String[] args) {
        SpringApplication.run(UppercaseProcessorApplication.class, args);
    }

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String process(String s){
        return s.toUpperCase();
    }

}
