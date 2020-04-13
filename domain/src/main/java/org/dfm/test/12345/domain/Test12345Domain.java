package org.dfm.test.12345.domain;

import org.dfm.test.12345.domain.model.Test12345Info;
import org.dfm.test.12345.domain.port.ObtainTest12345;
import org.dfm.test.12345.domain.port.RequestTest12345;

public class Test12345Domain implements RequestTest12345 {

  private ObtainTest12345 obtainTest12345;

  public Test12345Domain() {
    this(new ObtainTest12345() {
    });
  }

  public Test12345Domain(ObtainTest12345 obtainTest12345) {
    this.obtainTest12345 = obtainTest12345;
  }

  @Override
  public Test12345Info getTest12345 S() {
    return Test12345Info.builder().test12345s(obtainTest12345.getAllTest12345 S()).build();
  }
}
