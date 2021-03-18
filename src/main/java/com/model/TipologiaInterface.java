package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface TipologiaInterface {
	@JsonIgnore
	public String getTipologia();
	public String getDsTimestamp();
}
