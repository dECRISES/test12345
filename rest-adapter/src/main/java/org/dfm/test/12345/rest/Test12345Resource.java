package org.dfm.test.12345.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.dfm.test.12345.domain.model.Test12345Info;
import org.dfm.test.12345.domain.port.RequestTest12345;

@RestController
@RequestMapping("/api/v1/test12345s")
public class Test12345Resource {

  private RequestTest12345 requestTest12345;

  public Test12345Resource(RequestTest12345 requestTest12345) {
    this.requestTest12345 = requestTest12345;
  }

  @GetMapping
  public ResponseEntity<Test12345Info> getTest12345 S() {
    return ResponseEntity.ok(requestTest12345.getTest12345 S());
  }
}
