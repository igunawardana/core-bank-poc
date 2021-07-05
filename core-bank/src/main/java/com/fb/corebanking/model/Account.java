package com.fb.corebanking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Account {

  @Id
  @SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "account_sequence")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "ACCOUNT_SEQ")
  private Integer id;
  @Column(name = "accountNo", unique = true)
  private String accountNo;
  private String accountName;
  private String type;
  private double balance;
  private String userId;

  public Account() {
  }

  public Account(String accountName, String accountNo, String type, double balance, String userId) {
    this.accountName = accountName;
    this.accountNo = accountNo;
    this.type = type;
    this.balance = balance;
    this.userId = userId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}
