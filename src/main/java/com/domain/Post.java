package com.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;
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

	@ApiModelProperty(notes = "user id")
	@JsonProperty("userId")
	private String userId;
	
	@ApiModelProperty(notes = "id del post")
	@JsonProperty("id")
	private String id;
	
	@ApiModelProperty(notes = "titolo del post")
	@JsonProperty("title")
	private String title;
	
	@ApiModelProperty(notes = "body del post")
	@JsonProperty("body")
	private String body;

	@Override
	public String toString() {
		return this.toString();
	}
}
