package com.example.emaisender.controller;

import com.example.emaisender.server.EmailSendServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendEmailController {
    @Autowired
    private EmailSendServer emailSendServer;
    @RequestMapping("send")
    public String send() {
        String from = "1241316193@qq.com";
        String to = "2476471505@qq.com";
        String subject = "test";
        // String text = "This is the test file";
        String context = "This is the" + " test files";
        emailSendServer.send(from, to, subject, context);
        return "index";
    }
}
