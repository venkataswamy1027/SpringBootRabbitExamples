package com.example.sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sender {
	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private Binding binding;
	
	@GetMapping(value = "/send/{msg}")
	@ResponseStatus(code = HttpStatus.OK)
	public String send(@PathVariable("msg") final String message) {
		LOGGER.info("Sending message to the queue.");
		rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), message);
		LOGGER.info("Message sent successfully to the queue.");
		return "Great! your message is sent";
	}
}
