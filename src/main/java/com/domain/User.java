package com.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.GsonBuilder;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "username", "email", "phone", "website" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@ApiModelProperty(notes = "nota id utente")
	@JsonProperty("id")
	private Integer id;

	@ApiModelProperty(notes = "nome utente")
	@JsonProperty("name")
	private String name;

	@ApiModelProperty(notes = "username utente")
	@JsonProperty("username")
	private String username;

	@ApiModelProperty(notes = "email utente")
	@JsonProperty("email")
	private String email;

	@ApiModelProperty(notes = "telefono utente")
	@JsonProperty("phone")
	private String phone;

	@Override
	public String toString() {
		return new GsonBuilder().create().newBuilder().setPrettyPrinting().create().toJson(this);
	}
}
