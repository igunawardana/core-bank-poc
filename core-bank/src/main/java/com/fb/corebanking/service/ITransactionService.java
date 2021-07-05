package com.fb.corebanking.service;

import com.fb.corebanking.model.Transaction;

public interface ITransactionService {

  Transaction getTransaction(Integer transactionId) throws Exception;

  Iterable<Transaction> getAllTransactions();

  Iterable<Transaction> getTransactionsByUserId(String userId) throws Exception;

  Transaction save(Transaction transaction);

  Transaction updateStatus(Transaction transaction) throws Exception;

  Transaction approveTx(Integer transactionId) throws Exception;

  void remove(int transactionId) throws Exception;

}
