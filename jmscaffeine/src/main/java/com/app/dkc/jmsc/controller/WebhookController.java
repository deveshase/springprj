package com.app.dkc.jmsc.controller;

import com.app.dkc.jmsc.model.Webhook;
import com.app.dkc.jmsc.service.WebhookProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/webhooks")
public class WebhookController {

    @Autowired
    private WebhookProducer producer;

    @RequestMapping(method = RequestMethod.POST, value = "/send-message")
    public void sendMessage(){
//@RequestParam("message") String message,
//                            @RequestParam("msgId") int msgId
        System.out.println("Start at: "+new Date());
        for (int i = 3456000; i < 3766899; i++) {
            int msgId = i;
            String message = "This is message# "+i;
            Webhook wh = new Webhook();
            wh.setMessageId (msgId);
            wh.setMessageText(message);
            producer.send(wh);
        }

        System.out.println("End at: "+new Date());
    }
}
