package com.madaless.email_api.send_email_func;

public interface EmailSender {

  void sendEmail(String to, String subject, String content);
}
