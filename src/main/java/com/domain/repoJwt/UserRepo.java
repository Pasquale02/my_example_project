package com.domain.repoJwt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domainJwt.Utente;

/**
 * 
 * @author FLORIOP
 * @implNote first parameter class to manage, second parameter type of index
 */
public interface UserRepo extends JpaRepository<Utente, Long> {

	Utente findByUsername(String username);
}
