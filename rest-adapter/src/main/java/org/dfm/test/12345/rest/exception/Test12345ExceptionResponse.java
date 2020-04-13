package org.dfm.test.12345.rest.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Test12345ExceptionResponse {

  private String message;

  private String path;
}
