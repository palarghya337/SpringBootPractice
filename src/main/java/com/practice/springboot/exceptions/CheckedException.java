package com.practice.springboot.exceptions;

public class CheckedException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public CheckedException() {
    // Default Constructor.
  }

  public CheckedException(String message) {
    super(message);
  }

  public CheckedException(Throwable throwable) {
    super(throwable);
  }

  public CheckedException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
