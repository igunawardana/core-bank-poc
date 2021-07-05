package com.fb.corebanking.controller;

import com.fb.corebanking.model.Account;
import com.fb.corebanking.model.User;
import com.fb.corebanking.service.IAccountService;
import com.fb.corebanking.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  private final IUserService service;

  private static final Logger log = LogManager.getLogger(UserController.class);

  public UserController(IUserService service) {
    this.service = service;
  }

  @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<Account> getUser(@PathVariable("userId") String userId) {
    log.debug("Getting the user for id: " + userId);
    try {
      return new ResponseEntity(service.getUser(userId), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<Iterable<User>> getAllUsers() {
    log.debug("Getting all the users");
    try {
      return new ResponseEntity(service.getAllUsers(), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in retrieving the user list. ", e);
      return new ResponseEntity("Error in retrieving the user list.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<User> addNewUser(@RequestBody User user) {
    log.debug("Adding new user: " + user.getUsername());
    try {
      return new ResponseEntity<User>(service.save(user), HttpStatus.CREATED);
    } catch (Exception e) {
      log.error("Error in creating the Account. ", e);
      return new ResponseEntity("Error in creating the user.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<User> updateUser(@RequestBody User user) {
    try {
      log.debug("Updating the Account for AccountId: " + user.getId());
      return new ResponseEntity<User>(service.update(user), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in updating the user. ", e);
      return new ResponseEntity("Error in updating the user.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity deleteUser(@PathVariable("userId") int userId) {
    log.debug("Deleting the Account for id: " + userId);
    try {
      service.remove(userId);
      return new ResponseEntity("Account Deleted Successfully.", HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in deleting the user. ", e);
      return new ResponseEntity("Error in deleting the user.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
