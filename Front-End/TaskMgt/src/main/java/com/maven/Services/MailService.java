package com.maven.Services;

import com.maven.Model.Mail;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    void sendMail(Mail mail);
}
