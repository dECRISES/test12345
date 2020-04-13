package org.dfm.test.12345;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.dfm.test.12345.domain.Test12345Domain;
import org.dfm.test.12345.domain.model.Test12345;
import org.dfm.test.12345.domain.model.Test12345Info;
import org.dfm.test.12345.domain.port.ObtainTest12345;
import org.dfm.test.12345.domain.port.RequestTest12345;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AcceptanceTest {

  @Test
  @DisplayName("should be able to get test12345s when asked for test12345s from hard coded test12345s")
  public void getTest12345 SFromHardCoded() {
  /*
      RequestTest12345    - left side port
      Test12345Domain     - hexagon (domain)
      ObtainTest12345     - right side port
   */
    RequestTest12345 requestTest12345 = new Test12345Domain(); // the poem is hard coded
    Test12345Info test12345Info = requestTest12345.getTest12345 S();
    assertThat(test12345Info).isNotNull();
    assertThat(test12345Info.getTest12345 S()).isNotEmpty().extracting("description")
        .contains("If you could read a leaf or tree\r\nyoud have no need of books.\r\n-- Alistair Cockburn (1987)");
  }

  @Test
  @DisplayName("should be able to get test12345s when asked for test12345s from stub")
  public void getTest12345 SFromMockedStub(@Mock ObtainTest12345 obtainTest12345) {
    // Stub
    Test12345 test12345 = Test12345.builder().id(1L).description("I want to sleep\r\nSwat the flies\r\nSoftly, please.\r\n\r\n-- Masaoka Shiki (1867-1902)").build();
    Mockito.lenient().when(obtainTest12345.getAllTest12345 S()).thenReturn(List.of(test12345));
    // hexagon
    RequestTest12345 requestTest12345 = new Test12345Domain(obtainTest12345);
    Test12345Info test12345Info = requestTest12345.getTest12345 S();
    assertThat(test12345Info).isNotNull();
    assertThat(test12345Info.getTest12345 S()).isNotEmpty().extracting("description")
        .contains("I want to sleep\r\nSwat the flies\r\nSoftly, please.\r\n\r\n-- Masaoka Shiki (1867-1902)");
  }
}
