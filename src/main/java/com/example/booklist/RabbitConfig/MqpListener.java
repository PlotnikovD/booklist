package com.example.booklist.RabbitConfig;

import com.example.booklist.controller.dto.BooksRequestDto;
import com.example.booklist.service.BooksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MqpListener {

    BooksService booksService;
    RabbitTemplate rabbitTemplate;
    ObjectMapper objectMapper;

    public MqpListener(BooksService booksService, RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
        this.booksService = booksService;
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = mapper;
    }


    @RabbitListener(queues = "get")
    public void receiveMessageFromGet(String message) throws JsonProcessingException {
        System.out.println("Received fanout 1 message: " + message);
        rabbitTemplate.convertAndSend("response", objectMapper.writeValueAsString(booksService.getAll()));
    }

    @RabbitListener(queues = "post")
    public void receiveMessageFromPost(BooksRequestDto message) throws JsonProcessingException {
        rabbitTemplate.convertAndSend("response", objectMapper.writeValueAsString(booksService.createBook(message)));
    }

}
