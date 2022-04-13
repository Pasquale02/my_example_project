package com.domain.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.GsonBuilder;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "scope", "code", "message", "timestamp", "detail" })
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ErrorInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("scope")
	private String scope;

	@JsonProperty("code")
	private String code;

	@JsonProperty("message")
	private String message;

	@JsonProperty("timestamp")
	private Date timestamp;

	@JsonProperty("detail")
	private String detail;

	@Override
	public String toString() {
		return new GsonBuilder().create().toJson(this);
	}

}
