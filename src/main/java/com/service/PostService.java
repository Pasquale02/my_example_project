package com.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.domain.Post;
import com.exception.ApplicationException;

import io.opentracing.Span;

@Service
public class PostService {
	
	public Post postPost(String headerRequestId, Post bodyRequest, Span span) throws ApplicationException{

		Post post = new Post();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = this.setHeaders(headerRequestId);
		HttpEntity<Post> entity = new HttpEntity<>(headers);
		
		span.log("RequestId: " + headerRequestId);
		try {
			// https://reqres.in/api/users
			ResponseEntity<Post> response = restTemplate.exchange("http://jsonplaceholder.typicode.com/posts",
					HttpMethod.POST, entity, Post.class);
			post = response.getBody();

		} catch (Exception e) {
			throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, "Errore post post");
		} finally {
			span.finish();
		}

		return post;
	}

	private HttpHeaders setHeaders(String requester) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-type", "application/json");
		headers.set("requester", requester);
		headers.set("Accept-Charset", "utf-8");
		return headers;
	}
}
