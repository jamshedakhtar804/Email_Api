package com.trigger.mail.triggerMailDemo.service;

import com.trigger.mail.triggerMailDemo.entity.RootEmailTemplate;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public interface EmailService {

     Logger AppLog= Logger.getLogger(EmailService.class);
    // Method
    // To send a simple email
   /* String sendSimpleMail(EmailTemplate details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailTemplate details);
*/
    default JSONObject sendMailWithComplexPostRequest(RootEmailTemplate newDetails){
        AppLog.info("Nothing");
        return null;
    }
}
