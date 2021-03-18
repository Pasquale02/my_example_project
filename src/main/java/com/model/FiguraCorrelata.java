package com.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({ "codiceClienteSorgenteFiguraCorrelata", "codiceFiscaleCorrente", "creationUser",
		"dataFineRelazione", "dataInizioRelazione", "dsTimestamp", "idClienteAucFiguraCorrelata",
		"idClienteBicFiguraCollegata", "idTipologiaRelazione", "dsTipologiaRelazione" })

public class FiguraCorrelata extends TechnicalFields implements TipologiaInterface {

	@JsonProperty("codiceClienteSorgenteFiguraCorrelata")
	private String codiceClienteSorgenteFiguraCorrelata;
	@JsonProperty("codiceFiscaleCorrente")
	private String codiceFiscaleCorrente;
	@JsonProperty("creationUser")
	private String creationUser;
	@JsonProperty("dataFineRelazione")
	private String dataFineRelazione;
	@JsonProperty("dataInizioRelazione")
	private String dataInizioRelazione;
	@JsonProperty("dsTimestamp")
	private String dsTimestamp;
	@JsonProperty("idClienteAucFiguraCorrelata")
	private String idClienteAucFiguraCorrelata;
	@JsonProperty("idClienteBicFiguraCollegata")
	private String idClienteBicFiguraCollegata;
	@JsonProperty("idTipologiaRelazione")
	private String idTipologiaRelazione;
	@JsonProperty("dsTipologiaRelazione")
	private String dsTipologiaRelazione;

	public String getCodiceClienteSorgenteFiguraCorrelata() {
		return codiceClienteSorgenteFiguraCorrelata;
	}

	public void setCodiceClienteSorgenteFiguraCorrelata(String codiceClienteSorgenteFiguraCorrelata) {
		this.codiceClienteSorgenteFiguraCorrelata = codiceClienteSorgenteFiguraCorrelata;
	}

	public String getCodiceFiscaleCorrente() {
		return codiceFiscaleCorrente;
	}

	public void setCodiceFiscaleCorrente(String codiceFiscaleCorrente) {
		this.codiceFiscaleCorrente = codiceFiscaleCorrente;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getDataFineRelazione() {
		return dataFineRelazione;
	}

	public void setDataFineRelazione(String dataFineRelazione) {
		this.dataFineRelazione = dataFineRelazione;
	}

	public String getDataInizioRelazione() {
		return dataInizioRelazione;
	}

	public void setDataInizioRelazione(String dataInizioRelazione) {
		this.dataInizioRelazione = dataInizioRelazione;
	}

	public String getDsTimestamp() {
		return dsTimestamp;
	}

	public void setDsTimestamp(String dsTimestamp) {
		this.dsTimestamp = dsTimestamp;
	}

	public String getIdClienteAucFiguraCorrelata() {
		return idClienteAucFiguraCorrelata;
	}

	public void setIdClienteAucFiguraCorrelata(String idClienteAucFiguraCorrelata) {
		this.idClienteAucFiguraCorrelata = idClienteAucFiguraCorrelata;
	}

	public String getIdClienteBicFiguraCollegata() {
		return idClienteBicFiguraCollegata;
	}

	public void setIdClienteBicFiguraCollegata(String idClienteBicFiguraCollegata) {
		this.idClienteBicFiguraCollegata = idClienteBicFiguraCollegata;
	}

	public String getIdTipologiaRelazione() {
		return idTipologiaRelazione;
	}

	public void setIdTipologiaRelazione(String idTipologiaRelazione) {
		this.idTipologiaRelazione = idTipologiaRelazione;
	}

	public String getDsTipologiaRelazione() {
		return dsTipologiaRelazione;
	}

	public void setDsTipologiaRelazione(String dsTipologiaRelazione) {
		this.dsTipologiaRelazione = dsTipologiaRelazione;
	}

	@Override
	public String getTipologia() {
		return this.getIdTipologiaRelazione();
	}

}
