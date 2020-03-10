package com.madaless.email_api.entities;


import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("messages")
public class Message {

  @PrimaryKey
  private UUID id = UUIDs.timeBased();
  private String email;
  private String title;
  private String content;
  //private Date date = new Date();
  @Column("magic_number")
  private Long magicNumber;

  public Message() {
  }

  public Message(UUID id, String email, String title, String content, Long magicNumber) {
    this.id = id;
    this.email = email;
    this.title = title;
    this.content = content;
    this.magicNumber = magicNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getMagicNumber() {
    return magicNumber;
  }

  public void setMagicNumber(Long magicNumber) {
    this.magicNumber = magicNumber;
  }

  @Override
  public String toString() {
    return "Message{" +
        "email='" + email + '\'' +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", magicNumber=" + magicNumber +
        '}';
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

}
