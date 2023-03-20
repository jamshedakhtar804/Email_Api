package com.trigger.mail.triggerMailDemo.service;

import com.trigger.mail.triggerMailDemo.entity.EmailBcc;
import com.trigger.mail.triggerMailDemo.entity.EmailCC;
import com.trigger.mail.triggerMailDemo.entity.RootEmailTemplate;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger AppLog= Logger.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;




    /*@Override
    public String sendSimpleMail(EmailTemplate details) {
        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendMailWithAttachment(EmailTemplate details) {
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
*/
    @Override
    public JSONObject sendMailWithComplexPostRequest(RootEmailTemplate newDetails){
        JSONObject res_obj=new JSONObject();
        try {
            AppLog.info("Entered in sendMailWithComplexPostRequest...........");
            if(newDetails.getEmailTemplate().getEmailFrom()!=null &&
                    !newDetails.getEmailTemplate().getEmailFrom().equalsIgnoreCase("")
                && newDetails.getEmailTemplate().getEmailTo()!=null &&
                    !newDetails.getEmailTemplate().getEmailTo().equalsIgnoreCase("")) {
                // Creating a simple mail message
                SimpleMailMessage mailMessage = new SimpleMailMessage();

                // Setting up necessary details
                mailMessage.setFrom(sender);
                AppLog.info("sender=  "+sender);

                mailMessage.setTo(newDetails.getEmailTemplate().getEmailTo());
                AppLog.info("emailTo=  "+newDetails.getEmailTemplate().getEmailTo());

                mailMessage.setText(newDetails.getEmailTemplate().getEmailBody());
                AppLog.info("emailBody=  "+newDetails.getEmailTemplate().getEmailBody());

                mailMessage.setSubject(newDetails.getEmailTemplate().getEmailSubject());
                AppLog.info("emailSubject=  "+newDetails.getEmailTemplate().getEmailSubject());

                for(EmailCC cc: newDetails.getEmailTemplate().getEmailCC()){
                    mailMessage.setCc(cc.getCc());

                }
                AppLog.info("EmailCC=  "+newDetails.getEmailTemplate().getEmailCC());
                for(EmailBcc bcc: newDetails.getEmailTemplate().getEmailBcc()){
                    mailMessage.setBcc(bcc.getBcc());

                }
                AppLog.info("EmailBcc=  "+newDetails.getEmailTemplate().getEmailBcc());
                // Sending the mail
                javaMailSender.send(mailMessage);
                AppLog.info("Mail sent successfully.......");
                res_obj.put("status","success");
                AppLog.info("res_obj=    "+res_obj);
            }else{
                res_obj.put("Status", "Failed");
                res_obj.put("Reason", "emailTo or emailFrom tag is empty in the request");
            }
            return res_obj;
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            AppLog.error("Exception Occured"+e);
            res_obj.put("exception", e);
            res_obj.put("status", "failed");
            AppLog.info("res_obj=    "+res_obj);
            return res_obj;
        }
    }
}
