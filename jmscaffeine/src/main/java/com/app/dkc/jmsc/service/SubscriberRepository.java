package com.app.dkc.jmsc.service;

import com.app.dkc.jmsc.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<Notification, Integer> {

    @Query(value="SELECT notification_id, channel, contact, first_name, last_name, priority, subscriber_id FROM notification WHERE LOWER(last_name) =  :last_name ", nativeQuery = true)
    List<Notification> findAllByLastName(@Param("last_name") String last_name);


}
