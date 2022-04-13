package com.config;

public final class APITCostant {

	private APITCostant() {
	}

	// API BASE
	public static final String API_CONTROLLER_PATH = "/users";
	public static final String API_BODY_DESCRIPTION = "Payload della richiesta contenente il post json da aggiungere";

	// SWAGGER VARIABLE
	public static final String API_TAG_NAME = "ov-ws-json-placeholder";
	public static final String API_OPERATION_DESCRIPTION = "Anagrafica cribis";

	// HEADER
	public static final String HEADER_REQUESTER = "requester";
	public static final String HEADER_REQUESTER_DESCRIPTION = "Acronimo di chi chiama il servizio";
	public static final String HEADER_REQUESTER_EXAMPLE = "requester";

	public static final String HEADER_REQUESTID = "requestId";
	public static final String HEADER_REQUESTID_DESCRIPTION = "Header per tracciamento jaeger";
	public static final String HEADER_REQUESTID_EXAMPLE = "";

	public static final String HEADER_UBERTRACEID = "uber-trace-id";
	public static final String HEADER_UBERTRACEID_DESCRIPTION = "Header per tracciamento jaeger";
	public static final String HEADER_UBERTRACEID_EXAMPLE = "";

	public static final String HEADER_XIBMCLIENTID = "X-IBM-Client-Id";
	public static final String HEADER_XIBMCLIENTID_DESCRIPTION = "Header ID Ibm di servizio";
	public static final String HEADER_XIBMCLIENTID_EXAMPLE = "";

	public static final String HEADER_XIBMCLIENTSECRET = "X-IBM-Client-Secret";
	public static final String HEADER_XIBMCLIENTSECRET_DESCRIPTION = "Header Secrect Ibm di servizio";
	public static final String HEADER_XIBMCLIENTSECRET_EXAMPLE = "";

	// HTTP MESSAGE
	public static final String SUCCESS = "Success";
	public static final String FORBIDDEN = "Forbidden";
	public static final String NOTFOUND = "Not found";
	public static final String INTERNAL_ERROR = "Internal Server Error";
	public static final String INVALID_PAYLOAD = "Invalid Payload";
	public static final String BAD_REQUEST = "Bad request";
	
	public static final String errorInCall = "Errore nella chiamata al servizio: ";


}
