package com.example.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.model.User;

@Component
public class RabbitMqReceiver {
	
	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receivedMessage(User user) {

		System.out.println("User Details Received is.. " + user);
	}
}
