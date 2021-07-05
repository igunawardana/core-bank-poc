package com.fb.corebanking.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IAccountRepositoryTests {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private IAccountRepository repository;

  @Test
  void testAddUser() throws Exception {
//    this.entityManager.persist(new User("TestUser", "test@test.com", Role.BUYER));
//    Optional<User> user = this.repository.findById(1);
//    assertThat(user.get().getName()).isEqualTo("TestUser");
//    assertThat(user.get().getEmail()).isEqualTo("test@test.com");
  }
}