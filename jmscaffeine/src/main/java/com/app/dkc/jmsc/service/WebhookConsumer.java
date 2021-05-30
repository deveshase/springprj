package com.app.dkc.jmsc.service;

import com.app.dkc.jmsc.model.Webhook;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WebhookConsumer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void recievedMessage(Webhook webhook) {
        System.out.println("Received Message From RabbitMQ: MessageID=" + webhook.getMessageId() +"" +
                "::"+webhook.getMessageText());
    }
}
