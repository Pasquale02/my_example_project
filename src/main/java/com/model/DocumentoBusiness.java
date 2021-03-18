package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "cciaa", "dsTimestamp", "dtIscrizioneCCIAA", "dtIscrizioneREA", "provinciaCCIAA",
		"descProvinciaCCIAA", "rea", "idTipoDocumento", "dsTipoDocumento" })
public class DocumentoBusiness extends TechnicalFields implements TipologiaInterface {

	@JsonProperty("cciaa")
	private String cciaa;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;
	@JsonProperty("dtIscrizioneCCIAA")
	private String dtIscrizioneCCIAA;
	@JsonProperty("dtIscrizioneREA")
	private String dtIscrizioneREA;
	@JsonProperty("provinciaCCIAA")
	private String provinciaCCIAA;
	@JsonProperty("descProvinciaCCIAA")
	private String descProvinciaCCIAA;
	@JsonProperty("rea")
	private String rea;
	@JsonProperty("idTipoDocumento")
	private String idTipoDocumento;
	@JsonProperty("dsTipoDocumento")
	private String dsTipoDocumento;

	public String getCciaa() {
		return cciaa;
	}

	public void setCciaa(String cciaa) {
		this.cciaa = cciaa;
	}

	public String getDsTimestamp() {
		return dsTimestamp;
	}

	public void setDsTimestamp(String dsTimestamp) {
		this.dsTimestamp = dsTimestamp;
	}

	public String getDtIscrizioneCCIAA() {
		return dtIscrizioneCCIAA;
	}

	public void setDtIscrizioneCCIAA(String dtIscrizioneCCIAA) {
		this.dtIscrizioneCCIAA = dtIscrizioneCCIAA;
	}

	public String getDtIscrizioneREA() {
		return dtIscrizioneREA;
	}

	public void setDtIscrizioneREA(String dtIscrizioneREA) {
		this.dtIscrizioneREA = dtIscrizioneREA;
	}

	public String getProvinciaCCIAA() {
		return provinciaCCIAA;
	}

	public void setProvinciaCCIAA(String provinciaCCIAA) {
		this.provinciaCCIAA = provinciaCCIAA;
	}

	public String getRea() {
		return rea;
	}

	public void setRea(String rea) {
		this.rea = rea;
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

	public String getDescProvinciaCCIAA() {
		return descProvinciaCCIAA;
	}

	public void setDescProvinciaCCIAA(String descProvinciaCCIAA) {
		this.descProvinciaCCIAA = descProvinciaCCIAA;
	}

	@Override
	public String getTipologia() {
		return this.getIdTipoDocumento();
	}

}
