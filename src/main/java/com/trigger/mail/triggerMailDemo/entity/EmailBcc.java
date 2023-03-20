package com.trigger.mail.triggerMailDemo.entity;

public class EmailBcc {
    private String bcc;

    public EmailBcc(String bcc) {
        this.bcc = bcc;
    }

    public EmailBcc() {
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }
}
