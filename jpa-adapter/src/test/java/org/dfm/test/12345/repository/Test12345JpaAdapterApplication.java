package org.dfm.test.12345.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.dfm.test.12345.domain.port.ObtainTest12345;
import org.dfm.test.12345.repository.dao.Test12345Dao;

@SpringBootApplication
public class Test12345JpaAdapterApplication {

  public static void main(String[] args) {
    SpringApplication.run(Test12345JpaAdapterApplication.class, args);
  }

  @TestConfiguration
  static class Test12345JpaTestConfig {

    @Bean
    public ObtainTest12345 getObtainTest12345Repository(Test12345Dao test12345Dao) {
      return new Test12345Repository(test12345Dao);
    }
  }
}
