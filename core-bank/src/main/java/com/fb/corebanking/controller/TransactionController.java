package com.fb.corebanking.controller;

import com.fb.corebanking.model.Account;
import com.fb.corebanking.model.Transaction;
import com.fb.corebanking.service.IAccountService;
import com.fb.corebanking.service.ITransactionService;
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

import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {

  private final ITransactionService service;

  private static final Logger log = LogManager.getLogger(TransactionController.class);

  public TransactionController(ITransactionService service) {
    this.service = service;
  }

  @GetMapping(path = "/{transactionId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<Account> getTransaction(@PathVariable("transactionId") Integer transactionId) {
    log.debug("Getting the transaction for id: " + transactionId);
    try {
      return new ResponseEntity(service.getTransaction(transactionId), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @GetMapping(path = "/user/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<List<Transaction>> getAccountsByUser(@PathVariable("userid") String userid) {
    log.debug("Getting the transaction list for user: " + userid);
    try {
      return new ResponseEntity(service.getTransactionsByUserId(userid), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody
  ResponseEntity<Transaction> addNewTransaction(@RequestBody Transaction transaction) {
    log.debug("Adding new transaction: " + transaction.getTxId());
    try {
      return new ResponseEntity<Transaction>(service.save(transaction), HttpStatus.CREATED);
    } catch (Exception e) {
      log.error("Error in creating the transaction. ", e);
      return new ResponseEntity("Error in creating the transaction.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
