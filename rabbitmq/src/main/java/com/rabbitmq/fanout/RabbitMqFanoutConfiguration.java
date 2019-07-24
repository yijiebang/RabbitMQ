package com.rabbitmq.fanout;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置類
 * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息。
 * Exchange Type=Fanout
 */
@Configuration
class RabbitMqFanoutConfiguration {




    //===============以下是验证Fanout Exchange的队列==========
    /**
     * 声明一个名为Fanout.message1的队列
     */
    @Bean
    public Queue fanoutQueue() {
        return new Queue("fanout.message1");
    }

    /**
     * 声明一个名为Fanout.message2的队列
     */
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.message2");
    }

    //===============以上是验证topic Exchange的队列==========
    /**
     * 声明一个名为fanoutexchange的交换机
     */
    @Bean
    public FanoutExchange fanoutexchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将fanout.message1的队列绑定到fanoutexchange交换机，Binding方法不能重复
     */
    @Bean
    public Binding bindfanoutMessage1() {
        return BindingBuilder.bind(fanoutQueue()).to(fanoutexchange());
    }
    /*
     将队列fanout.message2与fanoutexchange绑定，两个队列绑定同一个交换机，不管消息发往哪个交换机，所有队列都能接受
    * */
    @Bean
    public Binding bindfanoutMessage2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutexchange());
    }


}
