package com.example.ActiveMq.consumer.component;

import com.example.ActiveMq.model.SystemMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.sound.midi.SysexMessage;

@Component
public class MessageConsumer {

    private static final Logger LOGGER  = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "demo-queue")
    public void messageListener(SystemMessage systemMessage){
        LOGGER.info("message received. {}",systemMessage);
    }

}
