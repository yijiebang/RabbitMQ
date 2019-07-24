package com.rabbitmq.topic;

import com.rabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 *topic 是RabbitMQ中最灵活的一种方式，可以根据binding_key自由的绑定不同的队列
 * ###生产者###
 */
@Component
public class TopicProvider {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    /**
     * 交换机，队列名，消息
     */
    public void send() {
        String message1 = "I am topic.message1";
        String message2 = "I am topic.message2";
        this.rabbitTemplate.convertAndSend("exchange", "topic.message1", message1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message2", message2);

    }

    /**
     * 交换机，队列名，消息
     */
    public void send1() {
        User user=new User();
        user.setName("hzb");
        user.setPass("123456789");
        System.out.println("user send : " + user.getName()+"/"+user.getPass());
        this.rabbitTemplate.convertAndSend("exchange","topic.message1", user);
    }
}
