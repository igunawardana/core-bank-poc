package com.fb.corebanking.service;

import com.fb.corebanking.model.Account;
import com.fb.corebanking.model.User;
import com.fb.corebanking.repository.IAccountRepository;
import com.fb.corebanking.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final IUserRepository IUserRepository;

  public UserServiceImpl(IUserRepository IUserRepository) {
    this.IUserRepository = IUserRepository;
  }


  @Override
  public User getUser(String userName) throws Exception {
//    return new Account("primary", "34567890", "savings", 99.99);
    User user = IUserRepository.findByusername(userName);
    if (user != null) {
      return user;
    } else {
      throw new Exception("No matching Account for username = " + userName);
    }
  }

  @Override
  public User save(User user) {
//    return null;
    return IUserRepository.save(user);
  }

  @Override
  public Iterable<User> getAllUsers() {
    return IUserRepository.findAll();
  }

  @Override
  public User update(User user) throws Exception {
    return null;
  }

  @Override
  public void remove(int username) throws Exception {
    try {
      IUserRepository.deleteById(username);
    } catch (Exception e) {
      throw new Exception("Error in removing user with username = " + username, e);
    }
  }

}
