package org.dfm.test.12345.cucumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import io.cucumber.java8.HookNoArgsBody;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.dfm.test.12345.Test12345E2EApplication;
import org.dfm.test.12345.domain.model.Test12345;
import org.dfm.test.12345.domain.model.Test12345Info;
import org.dfm.test.12345.repository.dao.Test12345Dao;
import org.dfm.test.12345.repository.entity.Test12345Entity;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Test12345E2EApplication.class, webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = Test12345E2EApplication.class, loader = SpringBootContextLoader.class)
public class Test12345StepDef implements En {

  private static final String LOCALHOST = "http://localhost:";
  private static final String API_URI = "/api/v1/test12345s";
  @LocalServerPort
  private int port;
  private ResponseEntity<Test12345Info> responseEntity;

  public Test12345StepDef(TestRestTemplate restTemplate, Test12345Dao poetryDao) {

    DataTableType((Map<String, String> row) -> Test12345.builder().description(row.get("description")).build());
    DataTableType((Map<String, String> row) -> Test12345Entity.builder().description(row.get("description")).build());

    Before((HookNoArgsBody) poetryDao::deleteAll);
    After((HookNoArgsBody) poetryDao::deleteAll);

    Given("the following test12345s exists in the library", (DataTable dataTable) -> {
      List<Test12345Entity> poems = dataTable.asList(Test12345Entity.class);
      poetryDao.saveAll(poems);
    });

    When("user requests for all test12345s", () -> {
      String url = LOCALHOST + port + API_URI;
      responseEntity = restTemplate.getForEntity(url, Test12345Info.class);
    });

    Then("the user gets the following test12345s", (DataTable dataTable) -> {
      List<Test12345> expectedTest12345Info = dataTable.asList(Test12345.class);
      assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
      assertThat(responseEntity.getBody()).isNotNull();
      assertThat(responseEntity.getBody().getTest12345 S()).isNotEmpty().extracting("description")
          .contains(expectedTest12345Info.stream().map(Test12345::getDescription).toArray());
    });
  }
}


