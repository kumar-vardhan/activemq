package com.example.ActiveMq.publisher.controller;


import com.example.ActiveMq.model.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/publish-message")
    public ResponseEntity<String> publicMessage(@RequestBody SystemMessage systemMessage){
        try {
            jmsTemplate.convertAndSend("demo-queue",systemMessage);

            return new ResponseEntity<>("sent", HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
