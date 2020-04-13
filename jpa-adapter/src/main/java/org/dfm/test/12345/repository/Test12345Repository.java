package org.dfm.test.12345.repository;

import java.util.List;
import java.util.stream.Collectors;
import org.dfm.test.12345.domain.model.Test12345;
import org.dfm.test.12345.domain.port.ObtainTest12345;
import org.dfm.test.12345.repository.dao.Test12345Dao;
import org.dfm.test.12345.repository.entity.Test12345Entity;

public class Test12345Repository implements ObtainTest12345 {

  private Test12345Dao test12345Dao;

  public Test12345Repository(Test12345Dao test12345Dao) {
    this.test12345Dao = test12345Dao;
  }

  @Override
  public List<Test12345> getAllTest12345 S() {
    return test12345Dao.findAll().stream().map(Test12345Entity::toModel).collect(Collectors.toList());
  }
}
