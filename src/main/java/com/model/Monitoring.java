package com.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tsCaricamento", "nrCampiNotNull", "statoAcquisizione", "cdErrore", "dsErrore" })

public class Monitoring {

	@JsonProperty("tsCaricamento")
	private Timestamp tsCaricamento;
	@JsonProperty("nrCampiNotNull")
	private int nrCampiNotNull;
	@JsonProperty("statoAcquisizione")
	private String statoAcquisizione;
	@JsonProperty("cdErrore")
	private String cdErrore;
	@JsonProperty("dsErrore")
	private String dsErrore;

	public String getStatoAcquisizione() {
		return statoAcquisizione;
	}

	public void setStatoAcquisizione(String statoAcquisizione) {
		this.statoAcquisizione = statoAcquisizione;
	}

	public String getCdErrore() {
		return cdErrore;
	}

	public void setCdErrore(String cdErrore) {
		this.cdErrore = cdErrore;
	}

	public String getDsErrore() {
		return dsErrore;
	}

	public void setDsErrore(String dsErrore) {
		this.dsErrore = dsErrore;
	}

	public Timestamp getTsCaricamento() {
		return tsCaricamento;
	}

	public void setTsCaricamento(Timestamp tsCaricamento) {
		this.tsCaricamento = tsCaricamento;
	}

	public int getNrCampiNotNull() {
		return nrCampiNotNull;
	}

	public void setNrCampiNotNull(int nrCampiNotNull) {
		this.nrCampiNotNull = nrCampiNotNull;
	}

	public Monitoring(Timestamp tsCaricamento, int nrCampiNotNull, String statoAcquisizione, String cdErrore,
			String dsErrore, String requestID) {
		super();
		this.tsCaricamento = tsCaricamento;
		this.nrCampiNotNull = nrCampiNotNull;
		this.statoAcquisizione = statoAcquisizione;
		this.cdErrore = cdErrore;
		this.dsErrore = dsErrore;
	}

	public Monitoring() {
		super();
	}

}
