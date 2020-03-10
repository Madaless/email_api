package com.madaless.email_api.repository;

import com.madaless.email_api.entities.Message;
import java.util.List;
import java.util.UUID;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MessageRepository extends CassandraRepository<Message, UUID> {

  @AllowFiltering
  List<Message> findAllByMagicNumber(Long magicNumber);
  @AllowFiltering
  List<Message> findAllByEmail(String email);

}
