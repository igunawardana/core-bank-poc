package com.fb.corebanking.controller;

import com.fb.corebanking.model.Transaction;
import com.fb.corebanking.service.ITransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

  private final ITransactionService service;

  private static final Logger log = LogManager.getLogger(AdminController.class);

  public AdminController(ITransactionService service) {
    this.service = service;
  }


  @GetMapping(path = "/transaction")
  public @ResponseBody
  ResponseEntity<Iterable<Transaction>> getAllTransactions() {
    log.debug("Getting all the transaction");
    try {
      return new ResponseEntity(service.getAllTransactions(), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in retrieving the transactions list. ", e);
      return new ResponseEntity("Error in retrieving the transactions list.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/transaction/{transactionId}")
  public @ResponseBody
  ResponseEntity<Iterable<Transaction>> getTransactionById(@PathVariable("transactionId") Integer transactionId) {
    log.debug("Getting the transaction: " + transactionId);
    try {
      return new ResponseEntity(service.getTransaction(transactionId), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in retrieving the transactions. ", e);
      return new ResponseEntity("Error in retrieving the transactions .", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/transaction/user/{userid}")
  public @ResponseBody
  ResponseEntity<List<Transaction>> getTransactionsByUser(@PathVariable("userid") String userid) {
    log.debug("Getting the transaction list for user: " + userid);
    try {
      return new ResponseEntity(service.getTransactionsByUserId(userid), HttpStatus.OK);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping(path = "/transaction/approve/{transactionId}")
  public @ResponseBody
  ResponseEntity<Transaction> updateTransaction(@PathVariable("transactionId") int transactionId) {
    try {
      log.debug("Updating the transaction for transactionId: " + transactionId);
      return new ResponseEntity<Transaction>(service.approveTx(transactionId), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in updating the transaction. ", e);
      return new ResponseEntity("Error in updating the Transaction.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping(path = "/transaction/{transactionId}")
  public @ResponseBody
  ResponseEntity deleteTransaction(@PathVariable("transactionId") int transactionId) {
    log.debug("Deleting the transaction for id: " + transactionId);
    try {
      service.remove(transactionId);
      return new ResponseEntity("Transaction Deleted Successfully.", HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in deleting the transaction. ", e);
      return new ResponseEntity("Error in deleting the transaction.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
