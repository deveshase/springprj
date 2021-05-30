package com.app.dkc.jmsc.model;

public class Webhook {
    private long trackingNumber;

    public Webhook() {
    }

    private String messageText;

    public Webhook(long trackingNumber, String messageText) {
        this.trackingNumber = trackingNumber;
        this.messageText = messageText;
    }

    public long getMessageId() {
        return trackingNumber;
    }

    public void setMessageId(long messageId) {
        this.trackingNumber = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
