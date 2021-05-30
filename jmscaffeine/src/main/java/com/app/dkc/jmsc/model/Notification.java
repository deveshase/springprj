package com.app.dkc.jmsc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notification_id;

    @Column
    private String first_name;

    @Column (nullable = false)
    private String last_name;

    @Column (nullable = false)
    private String channel; //email, sms, pager

    @Column (nullable = false)
    private String contact;

    @Column
    private String priority;
}
