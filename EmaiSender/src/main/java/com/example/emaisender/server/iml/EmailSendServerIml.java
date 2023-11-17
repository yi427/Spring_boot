package com.example.emaisender.server.iml;

import com.example.emaisender.server.EmailSendServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSendServerIml implements EmailSendServer {
    @Autowired
    private JavaMailSender sender;
    @Override
    public boolean send(String from, String to, String subject, String context) {
        var simpleMess = setSimpleMess(from, to, subject, context);
        sender.send(simpleMess);
        return true;
    }
    private SimpleMailMessage setSimpleMess(String from, String to, String subject, String context) {
        var simpleMess = new SimpleMailMessage();
        simpleMess.setFrom(from);
        simpleMess.setTo(to);
        simpleMess.setSubject(subject);
        simpleMess.setText(context);
        return simpleMess;
    }
}
