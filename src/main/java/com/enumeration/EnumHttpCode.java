package com.enumeration;

public enum EnumHttpCode {

	OK("200"), BAD_REQUEST("400"), NOT_FOUND_REQUEST("404"), INTERNAL_SERVER_ERROR("500");

	private final String code;

	private EnumHttpCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
