package com.service;

import java.util.List;

import com.domainJwt.Role;
import com.domainJwt.User;

public interface UserService {

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String rolename);

	// potrei passare anche l'id
	User getUser(String username);

	List<User> getUsers();
}
