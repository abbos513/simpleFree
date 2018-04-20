package com.freelance.dal.Utils;

import com.freelance.dal.Entity.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailService {

    JavaMailSender mailSender = new JavaMailSenderImpl();

    @Autowired
    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public MailService() { }

    public void sendEmail(SignUp signUp) throws MailException, MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo("test@host.com");
        helper.setFrom("forwadcw@gmail.com");
        helper.setTo(signUp.getEmail());
        helper.setSubject("Email conformation from Abbos");

        helper.setText("<html><body>" +
                            "Please, verify your email by clicking " +
                            "<a href='" + "http://localhost:8080/auth/hash/" + signUp.getHashCode() + "'>here.</a>" +
                            "</body></html>", true);

//        mailSender.send(message);
    }
}