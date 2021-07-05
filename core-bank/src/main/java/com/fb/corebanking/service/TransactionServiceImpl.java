package com.fb.corebanking.service;

import com.fb.corebanking.model.Transaction;
import com.fb.corebanking.repository.ITransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

  private final ITransactionRepository ITransactionRepository;

  public TransactionServiceImpl(ITransactionRepository ITransactionRepository) {
    this.ITransactionRepository = ITransactionRepository;
  }

  @Override
  public Iterable<Transaction> getAllTransactions() {
    return ITransactionRepository.findAll();
  }

  @Override
  public Transaction getTransaction(Integer transactionId) throws Exception {
    Transaction tx = ITransactionRepository.findBytxId(transactionId);
    if (tx != null) {
      return tx;
    } else {
      throw new Exception("No matching transaction for  = " + transactionId);
    }
  }

  @Override
  public Iterable<Transaction> getTransactionsByUserId(String userId) throws Exception {
    List<Transaction> txs = ITransactionRepository.findByuserId(userId);
    if (txs != null) {
      return txs;
    } else {
      throw new Exception("No matching transaction for user  = " + userId);
    }
  }

  @Override
  public Transaction save(Transaction transaction) {
    transaction.setTxStatus("PENDING_APPROVAL");
    return ITransactionRepository.save(transaction);
  }

  @Override
  public Transaction updateStatus(Transaction transaction) throws Exception {
    return null;
  }

  public Transaction approveTx(Integer transactionId) throws Exception {
    Transaction tx = ITransactionRepository.findBytxId(transactionId);
    tx.setTxStatus("APPROVED");
    return ITransactionRepository.save(tx);
  }

  @Override
  public void remove(int transactionId) throws Exception {
    try {
      ITransactionRepository.deleteById(transactionId);
    } catch (Exception e) {
      throw new Exception("Error in removing transaction = " + transactionId, e);
    }
  }

}
