package com.crio.starter.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExcepHandler {
    
  @ExceptionHandler(MemeNotFoundException.class)
  public ResponseEntity<String> handleMemeInput1(MemeNotFoundException newMemeException) {
    return new ResponseEntity<String>("Meme Not Found For The Given Id", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MemeAlreadyExistsException.class)
  public ResponseEntity<String> handleMemeInput2(MemeAlreadyExistsException 
      newmemeAlreadyExistsException) {
    return new ResponseEntity<String>("meme already exists for the given data", 
    HttpStatus.CONFLICT);
  }

  @ExceptionHandler(NullRequestException.class)
  public ResponseEntity<String> handleMemeInput3(NullRequestException newNullRequestException) {
    return new ResponseEntity<String>("Bad Request / Null request", HttpStatus.BAD_REQUEST);
  }

}
