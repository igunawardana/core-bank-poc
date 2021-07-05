package com.fb.corebanking.service;

import com.fb.corebanking.model.User;
import com.fb.corebanking.model.Account;

public interface IUserService {

  User getUser(String userName) throws Exception;

  Iterable<User> getAllUsers();

  User save(User user);

  User update(User user) throws Exception;

  void remove(int userId) throws Exception;

}
