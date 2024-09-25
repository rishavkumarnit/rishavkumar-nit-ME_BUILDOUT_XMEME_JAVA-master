package com.crio.starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.CONFLICT)
public class MemeAlreadyExistsException extends RuntimeException {
    
  public MemeAlreadyExistsException(String message) {
    super(message);
  }

}