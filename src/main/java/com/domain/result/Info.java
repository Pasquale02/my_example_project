package com.domain.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.GsonBuilder;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resultCode", "resultMessage", "details", "executionTime" })
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Info implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("resultCode")
	private String resultCode;

	@JsonProperty("resultMessage")
	private String resultMessage;

	@JsonProperty("details")
	private List<ErrorInfo> details;

	@JsonProperty("executionTime")
	private Date executionTime;

	@Override
	public String toString() {
		return new GsonBuilder().create().toJson(this);
	}

}
