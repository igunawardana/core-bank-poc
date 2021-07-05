package com.fb.corebanking.repository;

import com.fb.corebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
  Account findByaccountNo(String accountNo);

  List<Account> findByuserId(String userId);
}
