package com.trigger.mail.triggerMailDemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trigger.mail.triggerMailDemo.TriggerMailDemoApplication;
import com.trigger.mail.triggerMailDemo.entity.EmailTemplate;
import com.trigger.mail.triggerMailDemo.entity.RootEmailTemplate;
import com.trigger.mail.triggerMailDemo.service.EmailService;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class EmailController {

    private static final Logger AppLog=Logger.getLogger(EmailController.class);
    @Autowired
    private EmailService emailService;

 /*   // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailTemplate details)
    {
        String status = emailService.sendSimpleMail(details);

        return status;
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailTemplate details)
    {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }*/

    @PostMapping("/hitmail")
    public String sendComplexPost(@Valid @RequestBody RootEmailTemplate newDetails) throws JsonProcessingException {
        AppLog.info("Inside sendComplexPost method.....");
        ObjectMapper mapper=new ObjectMapper();
        String json_req = mapper.writeValueAsString(newDetails);
        AppLog.info("newDetails== "+json_req);
        JSONObject status = emailService.sendMailWithComplexPostRequest(newDetails);
        AppLog.info("status= "+status);

        return status.toString();
    }

    @GetMapping("/")
    public String hello(){
        return "Hello, world!!";
    }

    @GetMapping("/user")
    public String userDetails(){
        return "Hi, User";
    }

    @GetMapping("/admin")
    public String adminDetails(){
        return "Hi, Admin";
    }
}
