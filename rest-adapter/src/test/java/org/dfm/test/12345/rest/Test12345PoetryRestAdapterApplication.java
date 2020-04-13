package org.dfm.test.12345.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.dfm.test.12345.domain.port.RequestTest12345;

@SpringBootApplication
@ComponentScan(basePackages = "org.dfm.test.12345")
public class Test12345PoetryRestAdapterApplication {

  @MockBean
  private RequestTest12345 requestTest12345;

  public static void main(String[] args) {
    SpringApplication.run(Test12345PoetryRestAdapterApplication.class, args);
  }
}
