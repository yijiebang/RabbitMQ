package com.rabbitmq.topic;

import com.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * 消费者
 */
@Component
public class TopicConsumer {

    /**监听队列，队列名=topic.message1*/
    @RabbitListener(queues = "topic.message1")
    public void receive(String message) {

        System.out.println("消费者1收到消息：{}"+message);
    }

    /**监听队列，队列名=topic.message2*/
    @RabbitListener(queues = "topic.message2")
    public void receive2(String message) {

        System.out.println("消费者2收到消息：{}"+message);
    }

    /**监听队列，队列名=topic.message2*/
    @RabbitListener(queues = "topic.message2")
    public void receive3(User user) {
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }
}
