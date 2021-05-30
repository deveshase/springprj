package com.app.dkc.jmsc.service;

import com.app.dkc.jmsc.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {

    Optional<Notification> getSubscriptionById(int notification_id);

    public List<Notification> getSubscriptionByLastName(String last_name);
}
