package com.fb.corebanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHelper extends ResponseEntityExceptionHandler {

  private static final Logger LOG = LogManager.getLogger(ExceptionHelper.class);

  @ExceptionHandler(value = {UserNotFoundException.class})
  public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
    LOG.error(ex.getErrorCode() + ". Invalid user information provided.", ex.getMessage());
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
