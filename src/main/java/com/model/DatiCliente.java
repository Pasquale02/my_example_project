package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "codClienteSorgente", "codSistemaSorgente", "idClienteAuc", "idTransazione", "requestID",
		"tipoElaborazione", "tsAucService", "tipoEntita" })
public class DatiCliente extends TechnicalFields {

	@JsonProperty("codClienteSorgente")
	private String codClienteSorgente;
	@JsonProperty("codSistemaSorgente")
	private String codSistemaSorgente;
	@JsonProperty("idClienteAuc")
	private String idClienteAuc;
	@JsonProperty("idTransazione")
	private String idTransazione;
	@JsonProperty("requestID")
	private String requestID;
	@JsonProperty("tipoElaborazione")
	private String tipoElaborazione;
	@JsonProperty("tsAucService")
	private String tsAucService;
	@JsonProperty("tipoEntita")
	private String tipoEntita;

	public String getCodClienteSorgente() {
		return codClienteSorgente;
	}

	public void setCodClienteSorgente(String codClienteSorgente) {
		this.codClienteSorgente = codClienteSorgente;
	}

	public String getCodSistemaSorgente() {
		return codSistemaSorgente;
	}

	public void setCodSistemaSorgente(String codSistemaSorgente) {
		this.codSistemaSorgente = codSistemaSorgente;
	}

	public String getIdClienteAuc() {
		return idClienteAuc;
	}

	public void setIdClienteAuc(String idClienteAuc) {
		this.idClienteAuc = idClienteAuc;
	}

	public String getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(String idTransazione) {
		this.idTransazione = idTransazione;
	}

	public String getTipoElaborazione() {
		return tipoElaborazione;
	}

	public void setTipoElaborazione(String tipoElaborazione) {
		this.tipoElaborazione = tipoElaborazione;
	}

	public String getTsAucService() {
		return tsAucService;
	}

	public void setTsAucService(String tsAucService) {
		this.tsAucService = tsAucService;
	}

	public String getTipoEntita() {
		return tipoEntita;
	}

	public void setTipoEntita(String tipoEntita) {
		this.tipoEntita = tipoEntita;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
}
