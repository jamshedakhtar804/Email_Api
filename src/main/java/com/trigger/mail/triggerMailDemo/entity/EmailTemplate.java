package com.trigger.mail.triggerMailDemo.entity;

// Class


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmailTemplate {

    // Class data members
    @NotNull
    @Email
    private String emailFrom;
    @NotNull
    @Email
    private String emailTo;
    private String emailBody;
    @NotNull
    private String emailSubject;
    private String emailAttachment;
    private EmailCC[] emailCC;
    private EmailBcc[] emailBcc;

    public EmailTemplate() {
    }

    public EmailTemplate(String emailFrom, String emailTo, String emailBody, String emailSubject, String emailAttachment, EmailCC[] emailCC, EmailBcc[] emailBcc) {
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.emailBody = emailBody;
        this.emailSubject = emailSubject;
        this.emailAttachment = emailAttachment;
        this.emailCC = emailCC;
        this.emailBcc = emailBcc;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailAttachment() {
        return emailAttachment;
    }

    public void setEmailAttachment(String emailAttachment) {
        this.emailAttachment = emailAttachment;
    }

    public EmailCC[] getEmailCC() {
        return emailCC;
    }

    public void setEmailCC(EmailCC[] emailCC) {
        this.emailCC = emailCC;
    }

    public EmailBcc[] getEmailBcc() {
        return emailBcc;
    }

    public void setEmailBcc(EmailBcc[] emailBcc) {
        this.emailBcc = emailBcc;
    }
}
