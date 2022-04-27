package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.domain.repoJwt.RoleRepo;
import com.domain.repoJwt.UserRepo;
import com.domainJwt.Ruolo;
import com.domainJwt.Utente;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
/**
 * 
 * @author FLORIOP RequiredArgsConstructor per la dependency injection di
 *         userRepo e RoleRepo
 */
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;
	private final RoleRepo roleRepo;

	@Override
	public Utente saveUser(Utente user) {
		log.info("Saving new user {} in db", user.getName());
		return userRepo.save(user);
	}

	@Override
	public Ruolo saveRole(Ruolo role) {
		log.info("Saving new role {} in db", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		log.info("Adding role {} to user {}", rolename, username);
		Utente user = userRepo.findByUsername(username);
		Ruolo role = roleRepo.findByName(rolename);
		user.getRoles().add(role);
	}

	@Override
	public Utente getUser(String username) {
		log.info("Fetching user {} from db", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<Utente> getUsers() {
		log.info("Fetching users from db");
		return userRepo.findAll();
	}
}
