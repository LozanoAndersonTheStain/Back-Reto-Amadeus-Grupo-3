package com.eafit.nodo.backamadeusgrupo3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(String to, String subject, String text) {
        String personalizedSubject = getPersonalizedSubject(subject);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(personalizedSubject);
        message.setText(text);
        emailSender.send(message);
    }

    private String getPersonalizedSubject(String baseSubject) {
        LocalTime now = LocalTime.now();
        String greeting;
        if (now.isAfter(LocalTime.of(6, 0)) && now.isBefore(LocalTime.of(12, 0))) {
            greeting = "Buenos días";
        } else if (now.isAfter(LocalTime.of(12, 0)) && now.isBefore(LocalTime.of(18, 0))) {
            greeting = "Buenas tardes";
        } else {
            greeting = "Buenas noches";
        }
        return greeting + ": Estimado cliente, se le hace envío de la datos del destino que ha seleccionado en nuestra plataforma - " + baseSubject;
    }
}