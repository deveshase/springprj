package com.app.dkc.jmsc.service.impl;

import com.app.dkc.jmsc.model.Notification;
import com.app.dkc.jmsc.service.NotificationService;
import com.app.dkc.jmsc.service.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "subscriptions")
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    SubscriberRepository subscriberRepository;

    @Cacheable
    @Override
    public Optional<Notification> getSubscriptionById(int notification_id) {
        System.out.println("Fetching subscription by id:"+ notification_id);
        return subscriberRepository.findById(notification_id);
    }

    public List<Notification> getSubscriptionByLastName(String last_name){
        System.out.println("Fetching subscriptions by lastName:"+ last_name);
        return subscriberRepository.findAllByLastName(last_name.toLowerCase());


    }

    @CacheEvict(allEntries = true)
    public void deleteFromCache() {
        System.out.println("Deleting all subscriptions from cache");

    }



}
