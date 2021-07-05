package com.fb.corebanking.repository;

import com.fb.corebanking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
  User findByusername(String username);
}
