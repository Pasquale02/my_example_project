package com.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.domain.result.Info;
import com.enumeration.EnumHttpCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	private EnumHttpCode code;
	private String title;
	private String detail;
	private String scope;
	private List<ApplicationException> exceptions = new ArrayList<>();
	private Info info;

	public ApplicationException(HttpStatus httpStatus, EnumHttpCode code, String title, String detail, String scope) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.title = title;
		this.detail = detail;
		this.scope = scope;
	}

	public void setNewApplicationException(HttpStatus httpStatus, EnumHttpCode code, String title, String detail,
			String scope) {
		ApplicationException applicationException = new ApplicationException(httpStatus, code, title, detail, scope);
		if (this.exceptions == null)
			this.exceptions = new ArrayList<>();
		this.exceptions.add(applicationException);
	}
}
