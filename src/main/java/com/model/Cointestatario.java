package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "ragioneSociale", "codClienteProspect", "descClienteProspect", "naturaGiuridica", "creationUser",
		"dsTimestamp" })
public class Cointestatario extends TechnicalFields {

	@JsonProperty("ragioneSociale")
	private String ragioneSociale;
	@JsonProperty("codClienteProspect")
	private String codClienteProspect;
	@JsonProperty("descClienteProspect")
	private String descClienteProspect;
	@JsonProperty("naturaGiuridica")
	private String naturaGiuridica;
	@JsonProperty("creationUser")
	private String creationUser;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getDsTimestamp() {
		return dsTimestamp;
	}

	public void setDsTimestamp(String dsTimestamp) {
		this.dsTimestamp = dsTimestamp;
	}

	public String getCodClienteProspect() {
		return codClienteProspect;
	}

	public void setCodClienteProspect(String codClienteProspect) {
		this.codClienteProspect = codClienteProspect;
	}

	public String getDescClienteProspect() {
		return descClienteProspect;
	}

	public void setDescClienteProspect(String descClienteProspect) {
		this.descClienteProspect = descClienteProspect;
	}

	public String getNaturaGiuridica() {
		return naturaGiuridica;
	}

	public void setNaturaGiuridica(String naturaGiuridica) {
		this.naturaGiuridica = naturaGiuridica;
	}

}