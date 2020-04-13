package org.dfm.test.12345.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.dfm.test.12345")
public class Test12345Application {

  public static void main(String[] args) {
    SpringApplication.run(Test12345Application.class, args);
  }
}
