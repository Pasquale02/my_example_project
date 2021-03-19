package com.exception;

import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ApplicationException extends Exception {
  private static final long serialVersionUID = 1L;

  private HttpStatus httpStatus;
  private String detail;

  public ApplicationException(HttpStatus httpStatus, String detail) {
    this.httpStatus = httpStatus;
    this.detail = detail;
  }
}
