package com.orange.config;
 
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
/**
 * @Author:linyuanhuang
 * @Description:Topic Exchange配置类
 * @Date:2017/12/11 17:13
 */
@Configuration
public class RabbitMqConfig{
	
    //只接一个topic
    final static String message = "topic.message";
    //接收多个topic
    final static String messages = "topic.messages";
    final static String message1 = "topic.message1";
 
    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitMqConfig.message);
    }
 
    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitMqConfig.messages);
    }
    
    @Bean
    public Queue queueMessage1() {
        return new Queue(RabbitMqConfig.message1);
    }
 
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }
 
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
 
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        //这里的#表示零个或多个词。
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
    
    @Bean
    Binding bindingExchangeMessage1(Queue queueMessage1, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.#");
    }
}