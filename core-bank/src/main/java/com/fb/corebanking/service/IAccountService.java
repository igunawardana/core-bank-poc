package com.fb.corebanking.service;

import com.fb.corebanking.model.Account;

import java.util.List;

public interface IAccountService {

  Account getAccount(String accountNo) throws Exception;

  Iterable<Account> getAllAccounts();

  Account save(Account account);

  Account update(Account account) throws Exception;

  void remove(int accountId) throws Exception;

  List<Account> getAccountsByUser(String userid) throws Exception;
}
