# SpringBootRabbitExamples
RabbitMQ is a common messaging broker which allows applications to connect and communicate. 
It’s common for services in microservices-based systems to communicate asynchronously through messaging.
To exchange messages between different applications, we can use RabbitMQ as a message broker.
# Messaging In RabbitMQ involves:

A producer is a user application that sends messages to a RabbitMQ message broker. Messages are not directly sent to a queue. Here, the producer sends messages to an exchange. 
Exchanges are message routing agents that are responsible for routing the message to different queues.
A queue is a buffer that resides inside RabbitMQ to store messages that a producer sends and a receiver receives.
A consumer is a user application that receives messages from the RabbitMQ message broker and then processes them further.