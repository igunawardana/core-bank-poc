package com.fb.corebanking.controller;

import com.fb.corebanking.model.Account;
import com.fb.corebanking.service.IAccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/account")
public class AccountController {

  private final IAccountService service;

  private static final Logger log = LogManager.getLogger(AccountController.class);

  public AccountController(IAccountService service) {
    this.service = service;
  }

  @GetMapping(path = "/{accountNo}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<Account> getAccount(@PathVariable("accountNo") String accountNo) {
    log.debug("Getting the account for no: " + accountNo);
    try {
      return new ResponseEntity(service.getAccount(accountNo), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/user/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<List<Account>> getAccountsByUser(@PathVariable("userid") String userid) {
    log.debug("Getting the account list for user: " + userid);
    try {
      return new ResponseEntity(service.getAccountsByUser(userid), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<Iterable<Account>> getAllAccounts() {
    log.debug("Getting all the Accounts");
    try {
      return new ResponseEntity(service.getAllAccounts(), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in retrieving the Account list. ", e);
      return new ResponseEntity("Error in retrieving the Account list.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<Account> addNewAccount(@RequestBody Account account) {
    log.debug("Adding new Account: " + account.getAccountName());
    try {
      return new ResponseEntity<Account>(service.save(account), HttpStatus.CREATED);
    } catch (Exception e) {
      log.error("Error in creating the Account. ", e);
      return new ResponseEntity("Error in creating the Account.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<Account> updateAccount(@RequestBody Account account) {
    try {
      log.debug("Updating the Account for AccountId: " + account.getId());
      return new ResponseEntity<Account>(service.update(account), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in updating the Account. ", e);
      return new ResponseEntity("Error in updating the Account.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping(path = "/{AccountId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity deleteAccount(@PathVariable("AccountId") int accountId) {
    log.debug("Deleting the Account for id: " + accountId);
    try {
      service.remove(accountId);
      return new ResponseEntity("Account Deleted Successfully.", HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in deleting the Account. ", e);
      return new ResponseEntity("Error in deleting the Account.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
