package com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.domain.User;

@Service
public class UserService {

	public List<User> getUsers(String headerRequestId) {

		User[] users = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<User[]> userArray = restTemplate.exchange("http://jsonplaceholder.typicode.com/users",
					HttpMethod.GET, null, User[].class);
			users = userArray.getBody();

		} catch (Exception e) {

		}

		return Arrays.asList(users);
	}
}
