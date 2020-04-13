package org.dfm.test.12345;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.dfm.test.12345.domain.Test12345Domain;
import org.dfm.test.12345.domain.port.ObtainTest12345;
import org.dfm.test.12345.domain.port.RequestTest12345;
import org.dfm.test.12345.repository.config.JpaAdapterConfig;

@SpringBootApplication
public class Test12345E2EApplication {

  public static void main(String[] args) {
    SpringApplication.run(Test12345E2EApplication.class);
  }

  @TestConfiguration
  @Import(JpaAdapterConfig.class)
  static class Test12345Config {

    @Bean
    public RequestTest12345 getRequestTest12345(final ObtainTest12345 obtainTest12345) {
      return new Test12345Domain(obtainTest12345);
    }
  }
}
