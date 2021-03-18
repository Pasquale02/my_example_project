package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "codRAE", "descRAE", "codSAE", "descSAE", "codCIAE", "descCIAE", "codATECO", "descATECO",
		"codFlagStato", "descFlagStato", "codRegimeAV", "descRegimeAV", "dsTimestamp" })
public class AnagAttrTipici {

	@JsonProperty("codRAE")
	private String codRAE;
	@JsonProperty("descRAE")
	private String descRAE;
	@JsonProperty("codSAE")
	private String codSAE;
	@JsonProperty("descSAE")
	private String descSAE;
	@JsonProperty("codCIAE")
	private String codCIAE;
	@JsonProperty("descCIAE")
	private String descCIAE;
	@JsonProperty("codATECO")
	private String codATECO;
	@JsonProperty("descATECO")
	private String descATECO;
	@JsonProperty("codFlagStato")
	private String codFlagStato;
	@JsonProperty("descFlagStato")
	private String descFlagStato;
	@JsonProperty("codRegimeAV")
	private String codRegimeAV;
	@JsonProperty("descRegimeAV")
	private String descRegimeAV;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;

	public String getCodRAE() {
		return codRAE;
	}

	public void setCodRAE(String codRAE) {
		this.codRAE = codRAE;
	}

	public String getDescRAE() {
		return descRAE;
	}

	public void setDescRAE(String descRAE) {
		this.descRAE = descRAE;
	}

	public String getCodSAE() {
		return codSAE;
	}

	public void setCodSAE(String codSAE) {
		this.codSAE = codSAE;
	}

	public String getDescSAE() {
		return descSAE;
	}

	public void setDescSAE(String descSAE) {
		this.descSAE = descSAE;
	}

	public String getCodCIAE() {
		return codCIAE;
	}

	public void setCodCIAE(String codCIAE) {
		this.codCIAE = codCIAE;
	}

	public String getDescCIAE() {
		return descCIAE;
	}

	public void setDescCIAE(String descCIAE) {
		this.descCIAE = descCIAE;
	}

	public String getCodATECO() {
		return codATECO;
	}

	public void setCodATECO(String codATECO) {
		this.codATECO = codATECO;
	}

	public String getDescATECO() {
		return descATECO;
	}

	public void setDescATECO(String descATECO) {
		this.descATECO = descATECO;
	}

	public String getCodFlagStato() {
		return codFlagStato;
	}

	public void setCodFlagStato(String codFlagStato) {
		this.codFlagStato = codFlagStato;
	}

	public String getDescFlagStato() {
		return descFlagStato;
	}

	public void setDescFlagStato(String descFlagStato) {
		this.descFlagStato = descFlagStato;
	}

	public String getCodRegimeAV() {
		return codRegimeAV;
	}

	public void setCodRegimeAV(String codRegimeAV) {
		this.codRegimeAV = codRegimeAV;
	}

	public String getDescRegimeAV() {
		return descRegimeAV;
	}

	public void setDescRegimeAV(String descRegimeAV) {
		this.descRegimeAV = descRegimeAV;
	}

	public String getDsTimestamp() {
		return dsTimestamp;
	}

	public void setDsTimestamp(String dsTimestamp) {
		this.dsTimestamp = dsTimestamp;
	}

}