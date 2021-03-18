package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "clienteProspect", "codFiscale", "codFiscaleCert", "codNazionePiva", "descNazionePiva",
		"codPartitaIva", "codPartitiaIvaCert", "codiceAteco", "creationUser", "dsTimestamp", "dtCessazione", "dtInizio",
		"flagAffidabilita", "flagCertificazione", "flagCessazione", "flagIdentitaDigitale", "flagRiconoscimentoForte",
		"idFormaGiuridica", "dsFormaGiuridica", "idSettore1", "idSettore2", "idSettore3", "ragioneSociale" })
public class ClienteBusiness extends TechnicalFields {

	@JsonProperty("clienteProspect")
	private String clienteProspect;
	@JsonProperty("codFiscale")
	private String codFiscale;
	@JsonProperty("codFiscaleCert")
	private String codFiscaleCert;
	@JsonProperty("codNazionePiva")
	private String codNazionePiva;
	@JsonProperty("descNazionePiva")
	private String descNazionePiva;
	@JsonProperty("codPartitaIva")
	private String codPartitaIva;
	@JsonProperty("codPartitiaIvaCert")
	private String codPartitiaIvaCert;
	@JsonProperty("codiceAteco")
	private String codiceAteco;
	@JsonProperty("creationUser")
	private String creationUser;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;
	@JsonProperty("dtCessazione")
	private String dtCessazione;
	@JsonProperty("dtInizio")
	private String dtInizio;
	@JsonProperty("flagAffidabilita")
	private String flagAffidabilita;
	@JsonProperty("flagCertificazione")
	private String flagCertificazione;
	@JsonProperty("flagCessazione")
	private String flagCessazione;
	@JsonProperty("flagIdentitaDigitale")
	private String flagIdentitaDigitale;
	@JsonProperty("flagRiconoscimentoForte")
	private String flagRiconoscimentoForte;
	@JsonProperty("idFormaGiuridica")
	private String idFormaGiuridica;
	@JsonProperty("dsFormaGiuridica")
	private String dsFormaGiuridica;
	@JsonProperty("idSettore1")
	private String idSettore1;
	@JsonProperty("idSettore2")
	private String idSettore2;
	@JsonProperty("idSettore3")
	private String idSettore3;
	@JsonProperty("ragioneSociale")
	private String ragioneSociale;

	public String getClienteProspect() {
		return clienteProspect;
	}

	public void setClienteProspect(String clienteProspect) {
		this.clienteProspect = clienteProspect;
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public void setCodFiscale(String codFiscale) {
		this.codFiscale = codFiscale;
	}

	public String getCodFiscaleCert() {
		return codFiscaleCert;
	}

	public void setCodFiscaleCert(String codFiscaleCert) {
		this.codFiscaleCert = codFiscaleCert;
	}

	public String getCodNazionePiva() {
		return codNazionePiva;
	}

	public void setCodNazionePiva(String codNazionePiva) {
		this.codNazionePiva = codNazionePiva;
	}

	public String getCodPartitaIva() {
		return codPartitaIva;
	}

	public void setCodPartitaIva(String codPartitaIva) {
		this.codPartitaIva = codPartitaIva;
	}

	public String getCodPartitiaIvaCert() {
		return codPartitiaIvaCert;
	}

	public void setCodPartitiaIvaCert(String codPartitiaIvaCert) {
		this.codPartitiaIvaCert = codPartitiaIvaCert;
	}

	public String getCodiceAteco() {
		return codiceAteco;
	}

	public void setCodiceAteco(String codiceAteco) {
		this.codiceAteco = codiceAteco;
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

	public String getDtCessazione() {
		return dtCessazione;
	}

	public void setDtCessazione(String dtCessazione) {
		this.dtCessazione = dtCessazione;
	}

	public String getDtInizio() {
		return dtInizio;
	}

	public void setDtInizio(String dtInizio) {
		this.dtInizio = dtInizio;
	}

	public String getFlagAffidabilita() {
		return flagAffidabilita;
	}

	public void setFlagAffidabilita(String flagAffidabilita) {
		this.flagAffidabilita = flagAffidabilita;
	}

	public String getFlagCertificazione() {
		return flagCertificazione;
	}

	public void setFlagCertificazione(String flagCertificazione) {
		this.flagCertificazione = flagCertificazione;
	}

	public String getFlagCessazione() {
		return flagCessazione;
	}

	public void setFlagCessazione(String flagCessazione) {
		this.flagCessazione = flagCessazione;
	}

	public String getFlagIdentitaDigitale() {
		return flagIdentitaDigitale;
	}

	public void setFlagIdentitaDigitale(String flagIdentitaDigitale) {
		this.flagIdentitaDigitale = flagIdentitaDigitale;
	}

	public String getFlagRiconoscimentoForte() {
		return flagRiconoscimentoForte;
	}

	public void setFlagRiconoscimentoForte(String flagRiconoscimentoForte) {
		this.flagRiconoscimentoForte = flagRiconoscimentoForte;
	}

	public String getIdFormaGiuridica() {
		return idFormaGiuridica;
	}

	public void setIdFormaGiuridica(String idFormaGiuridica) {
		this.idFormaGiuridica = idFormaGiuridica;
	}

	public String getDsFormaGiuridica() {
		return dsFormaGiuridica;
	}

	public void setDsFormaGiuridica(String dsFormaGiuridica) {
		this.dsFormaGiuridica = dsFormaGiuridica;
	}

	public String getIdSettore1() {
		return idSettore1;
	}

	public void setIdSettore1(String idSettore1) {
		this.idSettore1 = idSettore1;
	}

	public String getIdSettore2() {
		return idSettore2;
	}

	public void setIdSettore2(String idSettore2) {
		this.idSettore2 = idSettore2;
	}

	public String getIdSettore3() {
		return idSettore3;
	}

	public void setIdSettore3(String idSettore3) {
		this.idSettore3 = idSettore3;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getDescNazionePiva() {
		return descNazionePiva;
	}

	public void setDescNazionePiva(String descNazionePiva) {
		this.descNazionePiva = descNazionePiva;
	}

}
