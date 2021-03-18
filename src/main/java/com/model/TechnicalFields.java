package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "monitoring", "sourceName", "numRetry" })

public class TechnicalFields {

	@JsonProperty("monitoring")
	private Monitoring monitoring;

	@JsonProperty("sourceName")
	private String sourceName;

	@JsonProperty("numRetry")
	private Integer numRetry;

	public Monitoring getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(Monitoring monitoring) {
		this.monitoring = monitoring;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Integer getNumRetry() {
		return numRetry;
	}

	public void setNumRetry(Integer numRetry) {
		this.numRetry = numRetry;
	}

}
