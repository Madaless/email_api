package com.madaless.email_api.send_email_func;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  public void sendEmail(String to, String title, String content) {
    MimeMessage mail = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(mail, true);
      helper.setTo(to);
      helper.setSubject(title);
      helper.setText(content, true);
    } catch (MessagingException e) {
      e.printStackTrace();
    }
    javaMailSender.send(mail);
  }
}