package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "codiceContattoSorgente", "dsTimestamp", "dtCessazione", "flagCessazione", "idTipoRiferimento",
		"dsTipoRiferimento", "riferimento", "prefisso", "idNazione", "descNazione" })
public class Contatto extends TechnicalFields {

	@JsonProperty("codiceContattoSorgente")
	private String codiceContattoSorgente;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;
	@JsonProperty("dtCessazione")
	private String dtCessazione;
	@JsonProperty("flagCessazione")
	private String flagCessazione;
	@JsonProperty("idTipoRiferimento")
	private String idTipoRiferimento;
	@JsonProperty("dsTipoRiferimento")
	private String dsTipoRiferimento;
	@JsonProperty("riferimento")
	private String riferimento;
	@JsonProperty("prefisso")
	private String prefisso;
	@JsonProperty("idNazione")
	private String idNazione;
	@JsonProperty("descNazione")
	private String descNazione;

	public String getCodiceContattoSorgente() {
		return codiceContattoSorgente;
	}

	public void setCodiceContattoSorgente(String codiceContattoSorgente) {
		this.codiceContattoSorgente = codiceContattoSorgente;
	}

	public String getDsTimestamp() {
		return dsTimestamp;
	}

	public void setDsTimestamp(String dsTimestamp) {
		this.dsTimestamp = dsTimestamp;
	}

	public String getDtCessazione() {
		return dtCessazione;
	}

	public void setDtCessazione(String dtCessazione) {
		this.dtCessazione = dtCessazione;
	}

	public String getFlagCessazione() {
		return flagCessazione;
	}

	public void setFlagCessazione(String flagCessazione) {
		this.flagCessazione = flagCessazione;
	}

	public String getIdTipoRiferimento() {
		return idTipoRiferimento;
	}

	public void setIdTipoRiferimento(String idTipoRiferimento) {
		this.idTipoRiferimento = idTipoRiferimento;
	}

	public String getDsTipoRiferimento() {
		return dsTipoRiferimento;
	}

	public void setDsTipoRiferimento(String dsTipoRiferimento) {
		this.dsTipoRiferimento = dsTipoRiferimento;
	}

	public String getRiferimento() {
		return riferimento;
	}

	public void setRiferimento(String riferimento) {
		this.riferimento = riferimento;
	}

	public String getPrefisso() {
		return prefisso;
	}

	public void setPrefisso(String prefisso) {
		this.prefisso = prefisso;
	}

	public String getIdNazione() {
		return idNazione;
	}

	public void setIdNazione(String idNazione) {
		this.idNazione = idNazione;
	}

	public String getDescNazione() {
		return descNazione;
	}

	public void setDescNazione(String descNazione) {
		this.descNazione = descNazione;
	}

}
