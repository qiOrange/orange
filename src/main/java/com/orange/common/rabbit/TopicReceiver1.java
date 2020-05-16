package com.orange.common.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
@RabbitListener(queues = "topic.message1")
public class TopicReceiver1 {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("TopicReceiver1 :" + msg);
    }
 
}
