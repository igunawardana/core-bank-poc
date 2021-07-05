package com.fb.corebanking.exception;

public class UserNotFoundException extends RuntimeException {

  private static final String ERROR_CODE = "PROFILE_SERVICE_ERR_001";

  public UserNotFoundException() {
  }

  public UserNotFoundException(String message) {
    super(message);
  }

  public UserNotFoundException(Throwable cause) {
    super(cause);
  }

  public UserNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public String getErrorCode() {
    return ERROR_CODE;
  }

}
