package com.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.GsonBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "logAnagraficaUnicaCliente", "anagraficaUnicaCliente" })
public class Anagrafica extends TechnicalFields {

	@JsonProperty("logAnagraficaUnicaCliente")
	private AnagraficaUnicaCliente logAnagraficaUnicaCliente;

	@JsonProperty("anagraficaUnicaCliente")
	private AnagraficaUnicaCliente anagraficaUnicaCliente;

	public AnagraficaUnicaCliente getLogAnagraficaUnicaCliente() {
		return logAnagraficaUnicaCliente;
	}

	public void setLogAnagraficaUnicaCliente(AnagraficaUnicaCliente logAnagraficaUnicaCliente) {
		this.logAnagraficaUnicaCliente = logAnagraficaUnicaCliente;
	}

	public AnagraficaUnicaCliente getAnagraficaUnicaCliente() {
		return anagraficaUnicaCliente;
	}

	public void setAnagraficaUnicaCliente(AnagraficaUnicaCliente anagraficaUnicaCliente) {
		this.anagraficaUnicaCliente = anagraficaUnicaCliente;
	}

	@Override
	public String toString() {
		 return new GsonBuilder().create().newBuilder().setPrettyPrinting().create().toJson(this);
//		return ReflectionToStringBuilder.toString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

}