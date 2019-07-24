package com.rabbitmq.topic;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置類
 * Exchange Type=Topic
 */
@Configuration
class RabbitMqTopicConfiguration {



    //===============以下是验证topic Exchange的队列==========
    /**
     * 声明一个名为topic.message1的队列
     */
    @Bean
    public Queue topicQueue() {
        return new Queue("topic.message1");
    }

    /**
     * 声明一个名为topic.message2的队列
     */
    @Bean
    public Queue topicQueue2() {
        return new Queue("topic.message2");
    }

    //===============以上是验证topic Exchange的队列==========
    /**
     * 声明一个名为exchange的交换机
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    /**
     * 将topic.message1的队列绑定到exchange交换机
     */
    @Bean
    public Binding bindtopicMessage1() {
        return BindingBuilder.bind(topicQueue()).to(exchange()).with("topic.message1");
    }
    /* 将队列topic.message2与exchange绑定，binding_key为topic.#,模糊匹配 */
    @Bean
    public Binding bindtopicMessage2() {
        return BindingBuilder.bind(topicQueue2()).to(exchange()).with("topic.#");
    }


}
