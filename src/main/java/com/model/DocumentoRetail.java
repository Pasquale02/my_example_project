package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "certificazioneOracolo", "cognome", "dataNascita", "desEnteRilascio", "dsTimestamp",
		"dtRilascioDocumento", "dtScadenzaDocumento", "flagRinnovo", "idCittadinanza", "idEnteRilascio",
		"idTipoDocumento", "dsTipoDocumento", "indirizzoDocumento", "luogoNascita", "luogoRilascioDocumento", "nome",
		"numeroDocumento", "provRilascioDocumento", "statoCivile", "dsStatoCivile", "dCittadinanza" })
public class DocumentoRetail extends TechnicalFields implements TipologiaInterface {

	@JsonProperty("certificazioneOracolo")
	private String certificazioneOracolo;
	@JsonProperty("cognome")
	private String cognome;
	@JsonProperty("dataNascita")
	private String dataNascita;
	@JsonProperty("desEnteRilascio")
	private String desEnteRilascio;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;
	@JsonProperty("dtRilascioDocumento")
	private String dtRilascioDocumento;
	@JsonProperty("dtScadenzaDocumento")
	private String dtScadenzaDocumento;
	@JsonProperty("flagRinnovo")
	private String flagRinnovo;
	@JsonProperty("idCittadinanza")
	private String idCittadinanza;
	@JsonProperty("idEnteRilascio")
	private String idEnteRilascio;
	@JsonProperty("idTipoDocumento")
	private String idTipoDocumento;
	@JsonProperty("dsTipoDocumento")
	private String dsTipoDocumento;
	@JsonProperty("indirizzoDocumento")
	private String indirizzoDocumento;
	@JsonProperty("luogoNascita")
	private String luogoNascita;
	@JsonProperty("luogoRilascioDocumento")
	private String luogoRilascioDocumento;
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("numeroDocumento")
	private String numeroDocumento;
	@JsonProperty("provRilascioDocumento")
	private String provRilascioDocumento;
	@JsonProperty("statoCivile")
	private String statoCivile;
	@JsonProperty("dsStatoCivile")
	private String dsStatoCivile;
	@JsonProperty("dCittadinanza")
	private String dCittadinanza;

	public String getCertificazioneOracolo() {
		return certificazioneOracolo;
	}

	public void setCertificazioneOracolo(String certificazioneOracolo) {
		this.certificazioneOracolo = certificazioneOracolo;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getDesEnteRilascio() {
		return desEnteRilascio;
	}

	public void setDesEnteRilascio(String desEnteRilascio) {
		this.desEnteRilascio = desEnteRilascio;
	}

	public String getDsTimestamp() {
		return dsTimestamp;
	}

	public void setDsTimestamp(String dsTimestamp) {
		this.dsTimestamp = dsTimestamp;
	}

	public String getDtRilascioDocumento() {
		return dtRilascioDocumento;
	}

	public void setDtRilascioDocumento(String dtRilascioDocumento) {
		this.dtRilascioDocumento = dtRilascioDocumento;
	}

	public String getDtScadenzaDocumento() {
		return dtScadenzaDocumento;
	}

	public void setDtScadenzaDocumento(String dtScadenzaDocumento) {
		this.dtScadenzaDocumento = dtScadenzaDocumento;
	}

	public String getFlagRinnovo() {
		return flagRinnovo;
	}

	public void setFlagRinnovo(String flagRinnovo) {
		this.flagRinnovo = flagRinnovo;
	}

	public String getIdCittadinanza() {
		return idCittadinanza;
	}

	public void setIdCittadinanza(String idCittadinanza) {
		this.idCittadinanza = idCittadinanza;
	}

	public String getIdEnteRilascio() {
		return idEnteRilascio;
	}

	public void setIdEnteRilascio(String idEnteRilascio) {
		this.idEnteRilascio = idEnteRilascio;
	}

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDsTipoDocumento() {
		return dsTipoDocumento;
	}

	public void setDsTipoDocumento(String dsTipoDocumento) {
		this.dsTipoDocumento = dsTipoDocumento;
	}

	public String getIndirizzoDocumento() {
		return indirizzoDocumento;
	}

	public void setIndirizzoDocumento(String indirizzoDocumento) {
		this.indirizzoDocumento = indirizzoDocumento;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getLuogoRilascioDocumento() {
		return luogoRilascioDocumento;
	}

	public void setLuogoRilascioDocumento(String luogoRilascioDocumento) {
		this.luogoRilascioDocumento = luogoRilascioDocumento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getProvRilascioDocumento() {
		return provRilascioDocumento;
	}

	public void setProvRilascioDocumento(String provRilascioDocumento) {
		this.provRilascioDocumento = provRilascioDocumento;
	}

	public String getStatoCivile() {
		return statoCivile;
	}

	public void setStatoCivile(String statoCivile) {
		this.statoCivile = statoCivile;
	}

	public String getDsStatoCivile() {
		return dsStatoCivile;
	}

	public void setDsStatoCivile(String dsStatoCivile) {
		this.dsStatoCivile = dsStatoCivile;
	}

	public String getdCittadinanza() {
		return dCittadinanza;
	}

	public void setdCittadinanza(String dCittadinanza) {
		this.dCittadinanza = dCittadinanza;
	}

	@Override
	public String getTipologia() {
		return this.getIdTipoDocumento();
	}

}
