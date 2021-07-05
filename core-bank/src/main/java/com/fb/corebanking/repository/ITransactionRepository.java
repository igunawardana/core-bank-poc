package com.fb.corebanking.repository;

import com.fb.corebanking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
  Transaction findBytxId(Integer transactionId);

  List<Transaction> findByuserId(String userId);
}
