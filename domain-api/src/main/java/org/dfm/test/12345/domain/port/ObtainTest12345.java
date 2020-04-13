package org.dfm.test.12345.domain.port;

import java.util.List;
import org.dfm.test.12345.domain.model.Test12345;

public interface ObtainTest12345 {

  default List<Test12345> getAllTest12345 S() {
    Test12345 test12345 = Test12345.builder().id(1L).description("If you could read a leaf or tree\r\nyoud have no need of books.\r\n-- Alistair Cockburn (1987)").build();
    return List.of(test12345);
  }
}
