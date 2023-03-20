package com.trigger.mail.triggerMailDemo.entity;

public class EmailCC {
    private String cc;

    public EmailCC(String cc) {
        this.cc = cc;
    }

    public EmailCC() {
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
