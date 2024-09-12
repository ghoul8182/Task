package com.example.sms_app.controller;

import com.example.sms_app.model.Message;
import com.example.sms_app.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sms")
public class SmsController {
    @Autowired
    private SmsService smsService;
    @PostMapping("/send")
    public String sendSms(@RequestBody String messageContent) {
        smsService.sendSms(messageContent);
        smsService.saveMessage(messageContent);
        return "SMS sent!";
    }
    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return smsService.getAllMessages();
    }
}
