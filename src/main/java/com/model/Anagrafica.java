package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
		return "Anagrafica [logAnagraficaUnicaCliente=";
	}

}