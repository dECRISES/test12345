package org.dfm.test.12345.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.dfm.test.12345.domain.Test12345Domain;
import org.dfm.test.12345.domain.port.ObtainTest12345;
import org.dfm.test.12345.domain.port.RequestTest12345;
import org.dfm.test.12345.repository.config.JpaAdapterConfig;

@Configuration
@Import(JpaAdapterConfig.class)
public class BootstrapConfig {

  @Bean
  public RequestTest12345 getRequestTest12345(ObtainTest12345 obtainTest12345) {
    return new Test12345Domain(obtainTest12345);
  }
}
