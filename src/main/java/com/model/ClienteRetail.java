package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "clienteProspect", "codComuneNascita", "codFiscale", "codFiscaleCert", "codProvinciaNascita",
		"codSesso", "descSesso", "cognome", "comuneStatoEsteroNascita", "creationUser", "descComuneNascita",
		"descNazioneNascita", "descProvinciaNascita", "dsTimestamp", "dtDecesso", "dtNascita", "flagAffidabilita",
		"flagCertificazione", "flagDecesso", "flagIdentitaDigitale", "flagRiconoscimentoForte", "idNazioneNascita",
		"nome", "idProfessione", "professione", "idTitoloDiStudio", "titoloDiStudio", "uid" })
public class ClienteRetail extends TechnicalFields {

	@JsonProperty("clienteProspect")
	private String clienteProspect;
	@JsonProperty("codComuneNascita")
	private String codComuneNascita;
	@JsonProperty("codFiscale")
	private String codFiscale;
	@JsonProperty("codFiscaleCert")
	private String codFiscaleCert;
	@JsonProperty("codProvinciaNascita")
	private String codProvinciaNascita;
	@JsonProperty("codSesso")
	private String codSesso;
	@JsonProperty("descSesso")
	private String descSesso;
	@JsonProperty("cognome")
	private String cognome;
	@JsonProperty("comuneStatoEsteroNascita")
	private String comuneStatoEsteroNascita;
	@JsonProperty("creationUser")
	private String creationUser;
	@JsonProperty("descComuneNascita")
	private String descComuneNascita;
	@JsonProperty("descNazioneNascita")
	private String descNazioneNascita;
	@JsonProperty("descProvinciaNascita")
	private String descProvinciaNascita;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;
	@JsonProperty("dtDecesso")
	private String dtDecesso;
	@JsonProperty("dtNascita")
	private String dtNascita;
	@JsonProperty("flagAffidabilita")
	private String flagAffidabilita;
	@JsonProperty("flagCertificazione")
	private String flagCertificazione;
	@JsonProperty("flagDecesso")
	private String flagDecesso;
	@JsonProperty("flagIdentitaDigitale")
	private String flagIdentitaDigitale;
	@JsonProperty("flagRiconoscimentoForte")
	private String flagRiconoscimentoForte;
	@JsonProperty("idNazioneNascita")
	private String idNazioneNascita;
	@JsonProperty("nome")
	private String nome;
	@JsonProperty("idProfessione")
	private String idProfessione;
	@JsonProperty("professione")
	private String professione;
	@JsonProperty("idTitoloDiStudio")
	private String idTitoloDiStudio;
	@JsonProperty("titoloDiStudio")
	private String titoloDiStudio;
	@JsonProperty("uid")
	private String uid;

	public String getClienteProspect() {
		return clienteProspect;
	}

	public void setClienteProspect(String clienteProspect) {
		this.clienteProspect = clienteProspect;
	}

	public String getCodComuneNascita() {
		return codComuneNascita;
	}

	public void setCodComuneNascita(String codComuneNascita) {
		this.codComuneNascita = codComuneNascita;
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

	public String getCodProvinciaNascita() {
		return codProvinciaNascita;
	}

	public void setCodProvinciaNascita(String codProvinciaNascita) {
		this.codProvinciaNascita = codProvinciaNascita;
	}

	public String getCodSesso() {
		return codSesso;
	}

	public void setCodSesso(String codSesso) {
		this.codSesso = codSesso;
	}

	public String getDescSesso() {
		return descSesso;
	}

	public void setDescSesso(String descSesso) {
		this.descSesso = descSesso;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getComuneStatoEsteroNascita() {
		return comuneStatoEsteroNascita;
	}

	public void setComuneStatoEsteroNascita(String comuneStatoEsteroNascita) {
		this.comuneStatoEsteroNascita = comuneStatoEsteroNascita;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getDescComuneNascita() {
		return descComuneNascita;
	}

	public void setDescComuneNascita(String descComuneNascita) {
		this.descComuneNascita = descComuneNascita;
	}

	public String getDescNazioneNascita() {
		return descNazioneNascita;
	}

	public void setDescNazioneNascita(String descNazioneNascita) {
		this.descNazioneNascita = descNazioneNascita;
	}

	public String getDescProvinciaNascita() {
		return descProvinciaNascita;
	}

	public void setDescProvinciaNascita(String descProvinciaNascita) {
		this.descProvinciaNascita = descProvinciaNascita;
	}

	public String getDsTimestamp() {
		return dsTimestamp;
	}

	public void setDsTimestamp(String dsTimestamp) {
		this.dsTimestamp = dsTimestamp;
	}

	public String getDtDecesso() {
		return dtDecesso;
	}

	public void setDtDecesso(String dtDecesso) {
		this.dtDecesso = dtDecesso;
	}

	public String getDtNascita() {
		return dtNascita;
	}

	public void setDtNascita(String dtNascita) {
		this.dtNascita = dtNascita;
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

	public String getFlagDecesso() {
		return flagDecesso;
	}

	public void setFlagDecesso(String flagDecesso) {
		this.flagDecesso = flagDecesso;
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

	public String getIdNazioneNascita() {
		return idNazioneNascita;
	}

	public void setIdNazioneNascita(String idNazioneNascita) {
		this.idNazioneNascita = idNazioneNascita;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdProfessione() {
		return idProfessione;
	}

	public void setIdProfessione(String idProfessione) {
		this.idProfessione = idProfessione;
	}

	public String getProfessione() {
		return professione;
	}

	public void setProfessione(String professione) {
		this.professione = professione;
	}

	public String getIdTitoloDiStudio() {
		return idTitoloDiStudio;
	}

	public void setIdTitoloDiStudio(String idTitoloDiStudio) {
		this.idTitoloDiStudio = idTitoloDiStudio;
	}

	public String getTitoloDiStudio() {
		return titoloDiStudio;
	}

	public void setTitoloDiStudio(String titoloDiStudio) {
		this.titoloDiStudio = titoloDiStudio;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
