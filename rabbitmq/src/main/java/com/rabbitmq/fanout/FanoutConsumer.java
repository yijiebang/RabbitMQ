package com.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * 消费者
 */
@Component
public class FanoutConsumer {

    /**监听队列，队列名=topic.message1*/
    @RabbitListener(queues = "fanout.message1")
    public void receive(String message) {

        System.out.println("消费者1收到消息：{}"+message);
    }

    /**监听队列，队列名=topic.message2*/
    @RabbitListener(queues = "fanout.message2")
    public void receive2(String message) {

        System.out.println("消费者2收到消息：{}"+message);
    }
 }
