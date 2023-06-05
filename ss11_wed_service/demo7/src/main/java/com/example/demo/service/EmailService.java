package com.example.demo.service;

import com.example.demo.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("heeyeon09082002@gmail.com");
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getMessage());
        javaMailSender.send(message);
    }
}
