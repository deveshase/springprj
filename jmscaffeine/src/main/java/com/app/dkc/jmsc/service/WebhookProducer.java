package com.app.dkc.jmsc.service;

import com.app.dkc.jmsc.model.Webhook;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebhookProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //private final Receiver receiver;

    /*public Producer(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(JmsdemoApplication.queueName,
                "in_ivy_ln", "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }*/

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;


    public void send(Webhook webhook) {
        rabbitTemplate.convertAndSend(exchange, routingkey, webhook);
        System.out.println("Sent msgID "+webhook.getMessageId());

    }

}