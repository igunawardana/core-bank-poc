package com.fb.corebanking.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Entity
@DynamicUpdate
public class Transaction {

  @Id
  @SequenceGenerator(name = "TRX_SEQ", sequenceName = "trx_sequence")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "TRX_SEQ")
  private Integer txId;
  private long timestamp;
  private String userId;
  private String sourceAccountId;
  private String destinationAccountId;
  private double transactionAmount;
  private String txStatus;

  public Transaction() {
    this.timestamp = new Date().getTime();
  }

  public Transaction(String userId, String sourceAccountId, String destinationAccountId, double transactionAmount) {
    this.timestamp = new Date().getTime();
    this.userId = userId;
    this.sourceAccountId = sourceAccountId;
    this.destinationAccountId = destinationAccountId;
    this.transactionAmount = transactionAmount;
  }

  public Integer getTxId() {
    return txId;
  }

  public void setTxId(Integer txId) {
    this.txId = txId;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = new Date().getTime();
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getSourceAccountId() {
    return sourceAccountId;
  }

  public void setSourceAccountId(String sourceAccountId) {
    this.sourceAccountId = sourceAccountId;
  }

  public String getDestinationAccountId() {
    return destinationAccountId;
  }

  public void setDestinationAccountId(String destinationAccountId) {
    this.destinationAccountId = destinationAccountId;
  }

  public double getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(double transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  public String getTxStatus() {
    return txStatus;
  }

  public void setTxStatus(String txStatus) {
    this.txStatus = txStatus;
  }
}
