package com.fb.corebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Entity
public class User {

  @Id
  @SequenceGenerator(name = "USER_SEQ", sequenceName = "user_sequence")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SEQ")
  private Integer userId;
  @Column(name = "username", unique = true)
  private String username;

  public User() {
  }

  public User(String username) {
    this.username = username;
  }

  public Integer getId() {
    return userId;
  }

  public void setId(Integer userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
