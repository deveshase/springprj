package com.app.dkc.jmsc.controller;

import com.app.dkc.jmsc.config.CaffCacheConfig;
import com.app.dkc.jmsc.model.ErrorMessage;
import com.app.dkc.jmsc.model.Notification;
import com.app.dkc.jmsc.service.impl.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class NotificationController {

    @Autowired
    CaffCacheConfig cacheConfig;

    @Autowired
    NotificationServiceImpl notificationService;

    @GetMapping(path = "/id/{notificationid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSubscriberDetail(@PathVariable(name = "notificationid") int notification_id) {
        try {
            Notification notification = notificationService.getSubscriptionById(notification_id)
                    .orElseThrow(()->new RuntimeException("Subscriber does not exists"));

            return ResponseEntity.ok(notification);
        }catch(Exception ex) {
            return handleException(ex);
        }
    }

    @GetMapping(path = "/name/{lastName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSubscriberDetail(@PathVariable(name = "lastName") String last_name) {
        try {
            List<Notification> notification = notificationService.getSubscriptionByLastName(last_name);

            return ResponseEntity.ok(notification);
        }catch(Exception ex) {
            return handleException(ex);
        }
    }

    @GetMapping(path = "/clearcache")
    public ResponseEntity<?> clearCache() {
        try {
            notificationService.deleteFromCache();
            return ResponseEntity.ok("Cache cleared");
        } catch (Exception ex) {
            return handleException(ex);
        }
    }
    
    private ResponseEntity<ErrorMessage> handleException(Exception ex) {
        ex.printStackTrace();
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
