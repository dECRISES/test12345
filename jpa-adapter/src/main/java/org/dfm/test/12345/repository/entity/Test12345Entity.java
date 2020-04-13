package org.dfm.test.12345.repository.entity;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dfm.test.12345.domain.model.Test12345;

@Table(name = "T_TEST_12345")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Test12345Entity {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long id;

  @Column(name = "DESCRIPTION")
  private String description;

  public Test12345 toModel() {
    return Test12345.builder().id(id).description(description).build();
  }
}
