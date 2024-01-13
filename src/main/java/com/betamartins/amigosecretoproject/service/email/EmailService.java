package com.betamartins.amigosecretoproject.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public void sendEmail(String mailTo, String mailSubject, String mailText){
        var mail = new SimpleMailMessage();
        mail.setFrom(this.emailFrom);
        mail.setTo(mailTo);
        mail.setSubject(mailSubject);
        mail.setText(mailText);
        mailSender.send(mail);
    }

}
