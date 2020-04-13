package org.dfm.test.12345.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.dfm.test.12345.domain.model.Test12345;
import org.dfm.test.12345.domain.model.Test12345Info;
import org.dfm.test.12345.domain.port.RequestTest12345;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = Test12345PoetryRestAdapterApplication.class, webEnvironment = RANDOM_PORT)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Test12345ResourceTest {

  private static final String LOCALHOST = "http://localhost:";
  private static final String API_URI = "/api/v1/test12345s";
  @LocalServerPort
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;
  @Autowired
  private RequestTest12345 requestTest12345;

  @Test
  @DisplayName("should start the rest adapter application")
  public void startup() {
    assertThat(Boolean.TRUE).isTrue();
  }

  @Test
  @DisplayName("should give test12345s when asked for test12345s with the support of domain stub")
  public void obtainTest12345 SFromDomainStub() {
    // Given
    Test12345 test12345 = Test12345.builder().id(1L).description("Johnny Johnny Yes Papa !!").build();
    Mockito.lenient().when(requestTest12345.getTest12345 S()).thenReturn(Test12345Info.builder().test12345s(List.of(test12345)).build());
    // When
    String url = LOCALHOST + port + API_URI;
    ResponseEntity<Test12345Info> responseEntity = restTemplate.getForEntity(url, Test12345Info.class);
    // Then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isNotNull();
    assertThat(responseEntity.getBody().getTest12345 S()).isNotEmpty().extracting("description")
        .contains("Johnny Johnny Yes Papa !!");
  }
}
