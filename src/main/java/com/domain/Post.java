package com.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userId", "id", "title", "body" })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("id")
	private String id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("body")
	private String body;

	@Override
	public String toString() {
		return new GsonBuilder().create().newBuilder().setPrettyPrinting().create().toJson(this);
	}
}
