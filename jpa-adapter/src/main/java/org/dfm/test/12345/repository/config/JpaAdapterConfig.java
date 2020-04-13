package org.dfm.test.12345.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.dfm.test.12345.domain.port.ObtainTest12345;
import org.dfm.test.12345.repository.Test12345Repository;
import org.dfm.test.12345.repository.dao.Test12345Dao;

@Configuration
@EntityScan("org.dfm.test.12345.repository.entity")
@EnableJpaRepositories("org.dfm.test.12345.repository.dao")
public class JpaAdapterConfig {

  @Bean
  public ObtainTest12345 getTest12345Repository(Test12345Dao test12345Dao) {
    return new Test12345Repository(test12345Dao);
  }
}
