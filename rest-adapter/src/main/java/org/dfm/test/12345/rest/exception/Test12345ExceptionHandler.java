package org.dfm.test.12345.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.dfm.test.12345.domain.exception.Test12345NotFoundException;

@RestControllerAdvice(basePackages = {"org.dfm.test.12345"})
public class Test12345ExceptionHandler {

  @ExceptionHandler(value = Test12345NotFoundException.class)
  public final ResponseEntity<Test12345ExceptionResponse> handleTest12345NotFoundException(final WebRequest request) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Test12345ExceptionResponse.builder().message("Test12345 not found").path(((ServletWebRequest) request).getRequest().getRequestURI()).build());
  }
}
