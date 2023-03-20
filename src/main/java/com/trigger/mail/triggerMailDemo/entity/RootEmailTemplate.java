package com.trigger.mail.triggerMailDemo.entity;

public class RootEmailTemplate {
    private EmailTemplate emailTemplate;

    public RootEmailTemplate() {
    }

    public RootEmailTemplate(EmailTemplate emailTemplate) {
        this.emailTemplate = emailTemplate;
    }

    public EmailTemplate getEmailTemplate() {
        return emailTemplate;
    }

    public void setEmailTemplate(EmailTemplate emailTemplate) {
        this.emailTemplate = emailTemplate;
    }
}
