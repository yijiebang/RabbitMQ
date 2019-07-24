package com.rabbitmq.controller;

import com.rabbitmq.fanout.FanoutProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fanout")
public class RabbitFanoutController {

    @Autowired
    private FanoutProvider sender1;

    @PostMapping("/hello")
    public void hello(String message) {
        sender1.send(message);
    }

}
