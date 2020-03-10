package com.madaless.email_api.delete_emails_func;

import com.madaless.email_api.entities.Message;
import com.madaless.email_api.repository.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeleteMessage {

  @Autowired
  MessageRepository mr;

  @Scheduled(fixedDelay = 432000000, initialDelay = 43200000) // after 5 days of app running
  public void deleteMessageMethod() {
    if (mr.findAll().size() > 0) { // if there are messages
      List<Message> list = mr.findAll();
      Long minimum = list.get(0).getId()
          .timestamp(); // I operate on UUID couse it is based on time we could also store date field in data base
      for (Message message : list) {
        if (message.getId().timestamp() <= minimum) {
          minimum = message.getId().timestamp();
        }
      }
      for (Message message : list) {
        if (message.getId().timestamp() == minimum) {
          mr.delete(message);
        }
      }
    }
  }
}