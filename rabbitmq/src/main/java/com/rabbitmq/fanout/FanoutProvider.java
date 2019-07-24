package com.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/***
 *  fanout类型的交换机，当两个队列和同一个交换机绑定，
 *  不管生产者往那个队列发消息，只要交换机一样，
 *  所有队列都能接收消息
 *
 * ###生产者###
 */
@Component
public class FanoutProvider {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    /**
     * 交换机，队列名，消息
     */
    public void send(String message) {

        this.rabbitTemplate.convertAndSend("fanoutExchange","font.message1", message);
       // this.rabbitTemplate.convertAndSend("fanoutExchange","font.message2", message);
      // 不管生产者往那个队列发消息，只要交换机一样， 所有队列都能接收一样的消息

    }

}
