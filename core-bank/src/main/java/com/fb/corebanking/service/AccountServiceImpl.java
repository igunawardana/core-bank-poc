package com.fb.corebanking.service;

import com.fb.corebanking.model.Account;
import com.fb.corebanking.repository.IAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

  private final com.fb.corebanking.repository.IAccountRepository IAccountRepository;

  public AccountServiceImpl(IAccountRepository IAccountRepository) {
    this.IAccountRepository = IAccountRepository;
  }

  @Override
  public Account getAccount(String accountNo) throws Exception {
//    return new Account("primary", "34567890", "savings", 99.99);
    Account acc = IAccountRepository.findByaccountNo(accountNo);
    if (acc != null) {
      return acc;
    } else {
      throw new Exception("No matching Account for account no = " + accountNo);
    }
  }

  @Override
  public List<Account> getAccountsByUser(String userid) throws Exception {
    List<Account> accs = IAccountRepository.findByuserId(userid);
    if (accs != null) {
      return accs;
    } else {
      throw new Exception("No matching Account for account no = " + userid);
    }
  }

  @Override
  public Iterable<Account> getAllAccounts() {
//    List<Account> list = new ArrayList<>();
//    list.add(new Account("primary", "34567890", "savings", 99.99));
//    list.add(new Account("secondary", "9876576", "current", 8.88));
//    return list;
    return IAccountRepository.findAll();
  }

  @Override
  public Account save(Account account) {
//    return null;
    return IAccountRepository.save(account);
  }

  @Override
  public void remove(int accountId) throws Exception {
    try {
      IAccountRepository.deleteById(accountId);
    } catch (Exception e) {
      throw new Exception("Error in removing accoun with accountId = " + accountId, e);
    }
  }

  @Override
  public Account update(Account account) throws Exception {
    return null;
//    return IAccountRepository.save(account);
    //TODO use update implementation
    //TODO test Account not found exception
  }
}
