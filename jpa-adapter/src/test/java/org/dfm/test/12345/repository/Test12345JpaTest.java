package org.dfm.test.12345.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.dfm.test.12345.domain.model.Test12345;
import org.dfm.test.12345.domain.port.ObtainTest12345;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class Test12345JpaTest {

  @Autowired
  private ObtainTest12345 obtainTest12345;

  @Test
  @DisplayName("should start the application")
  public void startup() {
    assertThat(Boolean.TRUE).isTrue();
  }

  @Sql(scripts = {"/sql/data.sql"})
  @Test
  @DisplayName("should give me test12345s when asked for test12345s from database")
  public void shouldGiveMeTest12345 SWhenAskedForTest12345 S() {
    // Given from @Sql
    // When
    List<Test12345> test12345s = obtainTest12345.getAllTest12345 S();
    // Then
    assertThat(test12345s).isNotNull().extracting("description").contains("Twinkle twinkle little star");
  }
}
