package com.crio.starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;




@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MemeNotFoundException extends RuntimeException {
    
  public MemeNotFoundException(String message) {
    super(message);
  }

}
