package com.madaless.email_api.controllers;

import com.madaless.email_api.Form.NumberMessage;
import com.madaless.email_api.entities.Message;
import com.madaless.email_api.send_email_func.EmailSender;
import com.madaless.email_api.services.MessageService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MessageController {

  private final MessageService messageService;
  private final EmailSender emailSender;

  public MessageController(final MessageService messageService, EmailSender emailSender) {
    this.messageService = messageService;
    this.emailSender = emailSender;
  }

  @PostMapping("/api/message")
  public ResponseEntity<Message> addMessage(@Valid @RequestBody final Message message) {
    return new ResponseEntity<>(messageService.save(message), HttpStatus.CREATED);
  }

  @PostMapping("/api/send")
  public ResponseEntity<Message> sendMessage(
      @Valid @RequestBody final NumberMessage numberMessage) {
    final List<Message> messages = messageService
        .findAllByMagicNumber(numberMessage.getMagic_number());
    messageService.deleteAll(messages);
    HttpHeaders headers = new HttpHeaders();
    // send email

    messages.forEach(message -> {
      emailSender
          .sendEmail(message.getEmail(), message.getTitle(), message.getContent());
      headers.add("email send to", message.getEmail());

    });
    return new ResponseEntity<>(headers, HttpStatus.OK);
  }

  @GetMapping("/api/messages/{emailValue}")
  public ResponseEntity<List<Message>> getAllByEmailValue(
      @PathVariable final String emailValue) {
    return new ResponseEntity<>(messageService.findAllByEmail(emailValue), HttpStatus.OK);
  }

}
