package com.forewei.rabbitmq;

import com.forewei.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

/**
 * @Date: Create By on 2019/8/7
 * @Author: forewei
 * @Email: forewei2015@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, "topic.freowei.test", "snedMQ");
    }

    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE_TEST)
    public void consumeOne(String message) {
        System.out.println("Queuetest:" + message);
        assertEquals("snedMQ", message);
    }



}
