package com.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "datiCliente", "clienteBusiness", "clienteRetail", "cointestatario", "documentoBusiness",
		"documentoRetail", "figuraCorrelata", "indirizzo", "contatto", "anagAttrTipici" })
public class AnagraficaUnicaCliente extends TechnicalFields {

	@JsonProperty("datiCliente")
	private DatiCliente datiCliente;
	@JsonProperty("clienteBusiness")
	private ClienteBusiness clienteBusiness;
	@JsonProperty("documentoBusiness")
	private List<DocumentoBusiness> documentoBusiness;
	@JsonProperty("figuraCorrelata")
	private List<FiguraCorrelata> figuraCorrelata;
	@JsonProperty("clienteRetail")
	private ClienteRetail clienteRetail;
	@JsonProperty("documentoRetail")
	private List<DocumentoRetail> documentoRetail;
	@JsonProperty("cointestatario")
	private Cointestatario cointestatario;
	@JsonProperty("indirizzo")
	private List<Indirizzo> indirizzo = null;
	@JsonProperty("contatto")
	private List<Contatto> contatto = null;
	@JsonProperty("anagAttrTipici")
	private AnagAttrTipici anagAttrTipici;

	public DatiCliente getDatiCliente() {
		return datiCliente;
	}

	public void setDatiCliente(DatiCliente datiCliente) {
		this.datiCliente = datiCliente;
	}

	public ClienteBusiness getClienteBusiness() {
		return clienteBusiness;
	}

	public void setClienteBusiness(ClienteBusiness clienteBusiness) {
		this.clienteBusiness = clienteBusiness;
	}

	public List<DocumentoBusiness> getDocumentoBusiness() {
		return documentoBusiness;
	}

	public void setDocumentoBusiness(List<DocumentoBusiness> documentoBusiness) {
		this.documentoBusiness = documentoBusiness;
	}

	public List<FiguraCorrelata> getFiguraCorrelata() {
		return figuraCorrelata;
	}

	public void setFiguraCorrelata(List<FiguraCorrelata> figuraCorrelata) {
		this.figuraCorrelata = figuraCorrelata;
	}

	public ClienteRetail getClienteRetail() {
		return clienteRetail;
	}

	public void setClienteRetail(ClienteRetail clienteRetail) {
		this.clienteRetail = clienteRetail;
	}

	public List<DocumentoRetail> getDocumentoRetail() {
		return documentoRetail;
	}

	public void setDocumentoRetail(List<DocumentoRetail> documentoRetail) {
		this.documentoRetail = documentoRetail;
	}

	public Cointestatario getCointestatario() {
		return cointestatario;
	}

	public void setCointestatario(Cointestatario cointestatario) {
		this.cointestatario = cointestatario;
	}

	public List<Indirizzo> getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(List<Indirizzo> indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Contatto> getContatto() {
		return contatto;
	}

	public void setContatto(List<Contatto> contatto) {
		this.contatto = contatto;
	}

	public AnagAttrTipici getAnagAttrTipici() {
		return anagAttrTipici;
	}

	public void setAnagAttrTipici(AnagAttrTipici anagAttrTipici) {
		this.anagAttrTipici = anagAttrTipici;
	}

}
