package com.test.rabbitmq_exchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class DefaultExchangeSubscriber {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection("amqp://guest:guest@localhost:5672/");
		Channel channel = connection.createChannel();
		DeliverCallback deliverCallback = (s, delivery) -> {
			System.out.println(new String(delivery.getBody(), "UTF-8"));
		};
		CancelCallback cancelCallback = s -> {
			System.out.println(s);
		};
		channel.basicConsume("SportsQ", true, deliverCallback, cancelCallback);
	}
}
