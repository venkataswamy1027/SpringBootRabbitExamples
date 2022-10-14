package com.test.rabbitmq_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DefaultExchangePublisher {
	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection("amqp://guest:guest@localhost:5672/");
		Channel channel = connection.createChannel();
		for (int i = 0; i < 2; i++) {
			String message = "Default Exchange Example " + i;
			// publish - (exchange, routingKey, properties, message)
			channel.basicPublish("", "SportsQ", null, message.getBytes());
		}
		channel.close();
		connection.close();
	}
}
