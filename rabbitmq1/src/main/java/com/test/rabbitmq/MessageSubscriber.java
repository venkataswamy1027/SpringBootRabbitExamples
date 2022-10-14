package com.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageSubscriber {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection(CommonConfigs.AMQP_URL);
		Channel channel = connection.createChannel();

		DeliverCallback deliverCallback = new DeliverCallback() {
			public void handle(String s, Delivery delivery) throws IOException {
				System.out.println(new String(delivery.getBody(), "UTF-8"));
			}
		};

		CancelCallback cancelCallback = new CancelCallback() {
			public void handle(String s) throws IOException {
				System.out.println(s);
			}
		};
		channel.basicConsume(CommonConfigs.DEFAULT_QUEUE, true, deliverCallback, cancelCallback);
	}
}