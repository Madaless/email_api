package com.madaless.email_api.services;

import com.madaless.email_api.entities.Message;
import com.madaless.email_api.repository.MessageRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  final
  MessageRepository messageRepository;

  public MessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  public Message save(Message message) {
    return messageRepository.save(message);
  }

  public void delete(UUID messageID) {
    messageRepository
        .delete(messageRepository.findById(messageID).orElseThrow(() -> new RuntimeException()));
  }

  public Message findByID(UUID id) {
    return messageRepository.findById(id).orElseThrow(() -> new RuntimeException());
  }

  public List<Message> findAllByMagicNumber(Long magicNumber) {
    return messageRepository.findAllByMagicNumber(magicNumber);
  }

  public void deleteAll(List<Message> messages) {
    messageRepository.deleteAll(messages);
  }

  public List<Message> findAllByEmail(String emailValue) {
    return messageRepository.findAllByEmail(emailValue);
  }
}
