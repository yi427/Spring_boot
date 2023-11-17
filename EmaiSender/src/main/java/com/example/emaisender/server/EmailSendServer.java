package com.example.emaisender.server;

public interface EmailSendServer {
    public boolean send(String from, String to, String subject, String context);
}
