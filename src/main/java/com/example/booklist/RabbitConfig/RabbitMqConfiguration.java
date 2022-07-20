package com.example.booklist.RabbitConfig;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("192.168.50.232");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue queueRequest() {
        return new Queue("request");
    }

    @Bean
    public Queue queueGet() {
        return new Queue("get");
    }

  /*  @Bean
    public Queue queuePost() {
        return new Queue("post");
    }*/


/*    @Bean
    public SimpleMessageListenerContainer messageListenerContainer1(ConnectionFactory connectionFactory, Queue queueGet) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueues(queueGet);
        container.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                System.out.println("received from request : " + new String(message.getBody()));
            }
        });
        return container;
    }*/
}

