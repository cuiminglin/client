package com.cui.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cuiminglin on 2018/6/15.
 */
@RestController
public class RabbitMqTestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @GetMapping("/rabbittest")
    public ResponseEntity<String> rabbitTest(String test) {
        rabbitTemplate.convertAndSend("test1117exchange","test1117router",test);
        return ResponseEntity.ok("ok");
    }
}
