package com.practice.springboot.exceptions;

public class UncheckedException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public UncheckedException() {
    // Default constructor
  }

  public UncheckedException(String message) {
    super(message);
  }

  public UncheckedException(Throwable throwable) {
    super(throwable);
  }

  public UncheckedException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
