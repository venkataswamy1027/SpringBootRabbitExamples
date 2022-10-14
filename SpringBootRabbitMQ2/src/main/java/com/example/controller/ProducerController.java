package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.RabbitMqSender;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {

	@Autowired
    private RabbitMqSender rabbitMqSender;


    @PostMapping(value = "user")
    public String publishUserDetails(@RequestBody User user) {
    	String message= "Message has been sent Successfully.";
        rabbitMqSender.send(user);
        return message;
    }
}