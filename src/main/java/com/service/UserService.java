package com.service;

import java.util.List;

import com.domainJwt.Ruolo;
import com.domainJwt.Utente;

public interface UserService {

	Utente saveUser(Utente user);

	Ruolo saveRole(Ruolo role);

	void addRoleToUser(String username, String rolename);

	// potrei passare anche l'id
	Utente getUser(String username);

	List<Utente> getUsers();
	
	void removeAllUsers();
	
	void removeAllRoles();

	void removeAll();
	}
