package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "cap", "civicoaltro", "codComuneMinFin", "codNazioneCli", "codiceIndirizzoSorgente",
		"desNazioneCli", "descComuneCli", "descProvinciaCli", "dsTimestamp", "fabbricato", "flagNormalizzazione",
		"frazione", "idIndirizzo", "idTipoRiferimentoIndirizzo", "dsTipoIndirizzo", "dsIndirizzoCompleto", "nomeStrada",
		"numeroCivico", "presso", "siglaProvinciaCli", "tipoStrada", "idCivico" })
public class Indirizzo extends TechnicalFields implements TipologiaInterface {

	@JsonProperty("cap")
	private String cap;
	@JsonProperty("civicoaltro")
	private String civicoaltro;
	@JsonProperty("codComuneMinFin")
	private String codComuneMinFin;
	@JsonProperty("codNazioneCli")
	private String codNazioneCli;
	@JsonProperty("codiceIndirizzoSorgente")
	private String codiceIndirizzoSorgente;
	@JsonProperty("desNazioneCli")
	private String desNazioneCli;
	@JsonProperty("descComuneCli")
	private String descComuneCli;
	@JsonProperty("descProvinciaCli")
	private String descProvinciaCli;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;
	@JsonProperty("fabbricato")
	private String fabbricato;
	@JsonProperty("flagNormalizzazione")
	private String flagNormalizzazione;
	@JsonProperty("frazione")
	private String frazione;
	@JsonProperty("idIndirizzo")
	private String idIndirizzo;
	@JsonProperty("idTipoRiferimentoIndirizzo")
	private String idTipoRiferimentoIndirizzo;
	@JsonProperty("dsTipoIndirizzo")
	private String dsTipoIndirizzo;
	@JsonProperty("dsIndirizzoCompleto")
	private String dsIndirizzoCompleto;
	@JsonProperty("nomeStrada")
	private String nomeStrada;
	@JsonProperty("numeroCivico")
	private String numeroCivico;
	@JsonProperty("presso")
	private String presso;
	@JsonProperty("siglaProvinciaCli")
	private String siglaProvinciaCli;
	@JsonProperty("tipoStrada")
	private String tipoStrada;
	@JsonProperty("idCivico")
	private String idCivico;

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCivicoaltro() {
		return civicoaltro;
	}

	public void setCivicoaltro(String civicoaltro) {
		this.civicoaltro = civicoaltro;
	}

	public String getCodComuneMinFin() {
		return codComuneMinFin;
	}

	public void setCodComuneMinFin(String codComuneMinFin) {
		this.codComuneMinFin = codComuneMinFin;
	}

	public String getCodNazioneCli() {
		return codNazioneCli;
	}

	public void setCodNazioneCli(String codNazioneCli) {
		this.codNazioneCli = codNazioneCli;
	}

	public String getCodiceIndirizzoSorgente() {
		return codiceIndirizzoSorgente;
	}

	public void setCodiceIndirizzoSorgente(String codiceIndirizzoSorgente) {
		this.codiceIndirizzoSorgente = codiceIndirizzoSorgente;
	}

	public String getDesNazioneCli() {
		return desNazioneCli;
	}

	public void setDesNazioneCli(String desNazioneCli) {
		this.desNazioneCli = desNazioneCli;
	}

	public String getDescComuneCli() {
		return descComuneCli;
	}

	public void setDescComuneCli(String descComuneCli) {
		this.descComuneCli = descComuneCli;
	}

	public String getDescProvinciaCli() {
		return descProvinciaCli;
	}

	public void setDescProvinciaCli(String descProvinciaCli) {
		this.descProvinciaCli = descProvinciaCli;
	}

	public String getDsTimestamp() {
		return dsTimestamp;
	}

	public void setDsTimestamp(String dsTimestamp) {
		this.dsTimestamp = dsTimestamp;
	}

	public String getFabbricato() {
		return fabbricato;
	}

	public void setFabbricato(String fabbricato) {
		this.fabbricato = fabbricato;
	}

	public String getFlagNormalizzazione() {
		return flagNormalizzazione;
	}

	public void setFlagNormalizzazione(String flagNormalizzazione) {
		this.flagNormalizzazione = flagNormalizzazione;
	}

	public String getFrazione() {
		return frazione;
	}

	public void setFrazione(String frazione) {
		this.frazione = frazione;
	}

	public String getIdIndirizzo() {
		return idIndirizzo;
	}

	public void setIdIndirizzo(String idIndirizzo) {
		this.idIndirizzo = idIndirizzo;
	}

	public String getIdTipoRiferimentoIndirizzo() {
		return idTipoRiferimentoIndirizzo;
	}

	public void setIdTipoRiferimentoIndirizzo(String idTipoRiferimentoIndirizzo) {
		this.idTipoRiferimentoIndirizzo = idTipoRiferimentoIndirizzo;
	}

	public String getDsTipoIndirizzo() {
		return dsTipoIndirizzo;
	}

	public void setDsTipoIndirizzo(String dsTipoIndirizzo) {
		this.dsTipoIndirizzo = dsTipoIndirizzo;
	}

	public String getDsIndirizzoCompleto() {
		return dsIndirizzoCompleto;
	}

	public void setDsIndirizzoCompleto(String dsIndirizzoCompleto) {
		this.dsIndirizzoCompleto = dsIndirizzoCompleto;
	}

	public String getNomeStrada() {
		return nomeStrada;
	}

	public void setNomeStrada(String nomeStrada) {
		this.nomeStrada = nomeStrada;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getPresso() {
		return presso;
	}

	public void setPresso(String presso) {
		this.presso = presso;
	}

	public String getSiglaProvinciaCli() {
		return siglaProvinciaCli;
	}

	public void setSiglaProvinciaCli(String siglaProvinciaCli) {
		this.siglaProvinciaCli = siglaProvinciaCli;
	}

	public String getTipoStrada() {
		return tipoStrada;
	}

	public void setTipoStrada(String tipoStrada) {
		this.tipoStrada = tipoStrada;
	}

	public String getIdCivico() {
		return idCivico;
	}

	public void setIdCivico(String idCivico) {
		this.idCivico = idCivico;
	}

	@Override
	public String getTipologia() {
		return this.getIdTipoRiferimentoIndirizzo();
	}

}
