package com.rabbitmq.controller;

import com.rabbitmq.topic.CallBackSender;
import com.rabbitmq.topic.TopicProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class RabbitTopicController {

    @Autowired
    private TopicProvider sender1;

    @Autowired
    CallBackSender callBackSender;

    @PostMapping("/hello")
    public void hello() {
        sender1.send();
    }
    @PostMapping("/hello2")
    public void hello2() {
        sender1.send1();
    }

    /**
     * 有回调的队列
     */
    @PostMapping("/hello3")
    public void hello3() {
        callBackSender.send();
    }
}
