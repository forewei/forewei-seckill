package com.forewei.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@Configuration
public class RabbitMQConfig {


    public static final String QUEUE = "queue";

    public static final String TOPIC_QUEUE_TEST = "topic.queue.test";

    public static final String TOPIC_QUEUE_ONE = "topic.queue.one";

    public static final String TOPIC_QUEUE_TWO = "topic.queue.two";

    public static final String TOPIC_EXCHANGE = "topicExchage";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue topicQueueOne() {
        return new Queue(TOPIC_QUEUE_ONE, true);
    }

    @Bean
    public Queue topicQueueTwo() {
        return new Queue(TOPIC_QUEUE_TWO, true);
    }

    @Bean
    public Queue topicQueueTest() {
        return new Queue(TOPIC_QUEUE_TEST, true);
    }

    @Bean
    public Binding topicBindingOne() {
        return BindingBuilder.bind(topicQueueOne()).to(topicExchange()).with("topic.forewei.*");
    }

    @Bean
    public Binding topicBindingTwo() {
        return BindingBuilder.bind(topicQueueTwo()).to(topicExchange()).with("topic.forewei.#");
    }

    @Bean
    public Binding topicBindingTest() {
        return BindingBuilder.bind(topicQueueTest()).to(topicExchange()).with("topic.#");
    }
}
